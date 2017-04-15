package org.borademir.passolig.faces;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.context.RequestContext;

public abstract class AbsFacesBean implements Serializable {

	public abstract void initializePage();
	
	public abstract void clearPageValues();

	private static final Logger log = Logger.getLogger(AbsFacesBean.class);
	
	public static final String PAGE_BLOCKER_WIDGET="blockUIWidget";
	
	public void invalidateSession(){
		getFacesContext().getExternalContext().invalidateSession();
	}
	
	public Integer getSessionTimeoutMinute(){
		return  (int) (getHTTPSession().getMaxInactiveInterval()/(float)60.0);
	}
	private static final Integer SESSION_DESTROYED_TIMEOUT=1; // SISTEMI KAPATIYORUM DEYIP, GERIYE SAYMA SURESI ..
	public Integer getSessionTimeTimerSecond(){
		return SESSION_DESTROYED_TIMEOUT*60;
	}
	public Integer getSessionTimeoutIdleTime(){
		Integer idleTime=getSessionTimeoutIdleMinute();
		idleTime=idleTime*1000*60;
		return idleTime;
	}
	public Integer getSessionTimeoutIdleMinute(){
		Integer sessionTimeOutMiniute=getSessionTimeoutMinute();
		Integer idleTime=sessionTimeOutMiniute-SESSION_DESTROYED_TIMEOUT;
		return idleTime;
	}
	
	public void addMessageToDialog(FacesMessage message){
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public void addInfoMessageToDialog(String header,String message){
		FacesMessage infoMessage = new javax.faces.application.FacesMessage(FacesMessage.SEVERITY_INFO, header,message);
		RequestContext.getCurrentInstance().showMessageInDialog(infoMessage);
	}
	 
	 
	private static final long serialVersionUID = -8749236314241841053L;
	private static final String CLIENT_IP_HEADER_NAME = "Client-IP";
	
	public static String getRealPath(String relPath) throws Exception{
		String path = relPath;
		try {
			URL url =	FacesContext.getCurrentInstance().getExternalContext().getResource(relPath);
			if (url != null) {
				path = url.getPath();
			}
		} catch (MalformedURLException e) {
			throw e;
		}
		return path;
	}
	
	protected void markComponent(String componentid){
		try{
			UIComponent comp = findComponentInRoot(componentid);
			if(comp instanceof UIInput){
				UIInput compInput=(UIInput)comp;
				compInput.setValid(false);;
			}
		}
		catch(Exception e){
			
		}
	}
	protected void markComponent(String ...components){
		if(components!=null && components.length>0){
			for (String compid : components) {
				markComponent(compid);
			}
		}
	}
	
	protected void unmarkComponent(String ...components){
		if(components!=null && components.length>0){
			for (String compid : components) {
				try{
					UIComponent comp = findComponentInRoot(compid);
					if(comp instanceof UIInput){
						UIInput compInput=(UIInput)comp;
						compInput.setValid(true);
					}
				}
				catch(Exception e){}
			}
		}
	}
	
	public static final String TEXT_ZORUNLU="-> Zorunlu Bilgidir.";
	protected void addRequireMessageForComponent(String componentid,String fieldName){
		markComponent(componentid);
		addErrorMessage(null, getStandartRequiredMessage(fieldName));
	}
	public String getStandartRequiredMessage(String message){
		return message+TEXT_ZORUNLU;
	}
	protected void addMessageForComponent(String componentid,String text){
		markComponent(componentid);
		addErrorMessage(null, text);
	}
	protected void addDateMustBeGreaterMessageForComponent(String componentid){
		markComponent(componentid);
		addErrorMessage(null, "Bitiş Tarihi Başlangıç Tarihinden Büyük Olmalıdır.");
	}
	
	protected void addSecondValMustBeGreaterMssgForComponent(String componentid, String message){
		markComponent(componentid);
		addErrorMessage(null, message + " Değerinden Büyük Olmalıdır.");
	}
	
	public String getRequestParam(String param){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String clipId = request.getParameter(param);
		return clipId;
	}
	public String getServerUrl(){
		return getRequest().getScheme()+"://"+ getRequest().getServerName()+":"+ getRequest().getServerPort()+"/"+getExternalContext().getContextName();
	}
	public String getServerRoot(){
		return getRequest().getScheme()+"://"+ getRequest().getServerName()+":"+ getRequest().getServerPort()+"/";
	}
	protected void updateComponent(String pId){
		RequestContext.getCurrentInstance().update(pId);
	}
	protected String getRequestContextPath(){
		return getExternalContext().getRequestContextPath();
	}
	protected void openDialog(String widgetvar){
		RequestContext.getCurrentInstance().execute("PF('"+widgetvar+"').show();");
	}
	protected void hideDialog(String widgetvar){
		RequestContext.getCurrentInstance().execute("PF('"+widgetvar+"').hide();");
	}
	protected void processUpdate(String updateList){
		if(updateList == null){
			return;
		}
		updateList = updateList.trim();
		String compIds[] = updateList.split(" ");
		ArrayList<String> compIdList = new ArrayList<String>();
		for(String compId : compIds){
			compIdList.add(compId);
		}
		RequestContext.getCurrentInstance().update(compIdList);
	}
	protected void redirect(String url) throws IOException{
		getExternalContext().redirect(getRequestContextPath()+url);
	}
	
	protected Object getManagedBean(String mgdBeanName) {
		String expression = "#{" + mgdBeanName + "}";
		return resolveExpression(expression);
	}

	@SuppressWarnings("deprecation")
	protected Object resolveExpression(String expression) {
		Object value = null;
		if ((expression.indexOf("#{") != -1)
				&& (expression.indexOf("#{") < expression.indexOf('}'))) {
			value = getFacesContext().getApplication()
					.createValueBinding(expression).getValue(getFacesContext());
		} else {
			value = expression;
		}
		return value;
	}


	protected FacesMessage createFacesMessage(String message, Severity severety) {
		return new javax.faces.application.FacesMessage(severety, message,message);
	}

	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	protected ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}
	public static String getIpAddress(){
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
			String remoteHost = request.getRemoteAddr();
			if(request.getHeader(CLIENT_IP_HEADER_NAME) != null){
				remoteHost = request.getHeader(CLIENT_IP_HEADER_NAME);
			}
			return remoteHost;
		} catch (Exception e) {
			log.error("Hata",e);
			return "ip_yok";
		}
	}
	 
	protected String getRequestStringWithKey(String p_parameterName){
		Object val = getRequestParamMap().get(p_parameterName);
		if(val != null){
			return (String) val;
		}
		
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public Map getRequestParamMap() {
		return getFacesContext().getExternalContext().getRequestParameterMap();
	}
	
	protected void addCallbackParam(String paramName,Object paramVal){
		RequestContext context = RequestContext.getCurrentInstance(); 
		context.addCallbackParam(paramName, paramVal);
	}
	
	public  String getSessionId(){
		try {
			HttpSession session = getSession();
			if(session == null){
				return "session_yok";
			}
			String sessionId = session.getId();
			return sessionId;
		} catch (Exception e) {
			log.error("Hata",e);
			return "session_yok";
		}
	}
	
	
	public static HttpSession getSession(){
		try {
			FacesContext fCtx = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
			return session;
		} catch (Exception e) {
			log.error("Hata",e);
			return null;
		}
	}
	public HttpSession getHTTPSession(){
		try {
			FacesContext fCtx = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
			return session;
		} catch (Exception e) {
			log.error("Hata",e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getManagedBean(String beanName , Class<T> clazz){
		return (T) getSession().getAttribute(beanName);
	}
	 
	protected void addGlobalInfoMessage(String message) {
		getFacesContext().addMessage(null,createFacesMessage(message,javax.faces.application.FacesMessage.SEVERITY_INFO));
	}
	protected void addInfoMessage(String compId,String message) {
		getFacesContext().addMessage(compId,createFacesMessage(message,javax.faces.application.FacesMessage.SEVERITY_INFO));
	}
	protected void addGlobalWarnMessage(String message) {
		getFacesContext().addMessage(null,createFacesMessage(message,javax.faces.application.FacesMessage. SEVERITY_WARN));
	}
	protected void addWarnMessage(String compId,String message) {
		getFacesContext().addMessage(compId,createFacesMessage(message,javax.faces.application.FacesMessage. SEVERITY_WARN));
	}
	protected void addGlobalErrorMessage(String message) {
		getFacesContext().addMessage(null,createFacesMessage(message,javax.faces.application.FacesMessage. SEVERITY_ERROR));
	}
	protected void addErrorMessage(String compId,String message) {
		getFacesContext().addMessage(compId,createFacesMessage(message,javax.faces.application.FacesMessage. SEVERITY_ERROR));
	}
	protected void addGlobalFatalMessage(String message) {
		getFacesContext().addMessage(null,createFacesMessage(message,javax.faces.application.FacesMessage. SEVERITY_FATAL));
	}
	
	protected void openErrorDialog(){
		RequestContext.getCurrentInstance().update("sistemErrorDialog");
		RequestContext.getCurrentInstance().execute("PF('sistemError').show();");
	}
	 
	 
	protected void addFatalMessage(String compId,String message) {
		getFacesContext().addMessage(compId,createFacesMessage(message,javax.faces.application.FacesMessage. SEVERITY_FATAL));
	}
	@SuppressWarnings("rawtypes")
	protected UIComponent findComponent(UIComponent base, String id) {
		if (id.equals(base.getId())) {
			return base;
		}
		UIComponent kid = null;
		UIComponent result = null;
		Iterator kids = base.getFacetsAndChildren();
		while (kids.hasNext() && (result == null)) {
			Object o = kids.next();
			kid = (UIComponent) o;
			if (id.equals(kid.getId())) {
				result = kid;
				break;
			}
			result = findComponent(kid, id);
			if (result != null) {
				break;
			}
		}
		return result;
	}

	protected UIComponent findComponentInRoot(String id) {
		UIComponent ret = null;

		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			UIComponent root = context.getViewRoot();
			ret = findComponent(root, id);
		}

		return ret;
	}
	protected void infoLog(String message){
		log.info(message);
	}
	protected void warnLog(String message){
		log.warn(message);
	}
	protected void errorLog(String message){
		log.error(message);
	}
	protected void errorLog(String message,Throwable t){
		log.error(message,t);
	}
 
	
	protected HttpServletRequest getRequest() {
		return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	} 
	
	 
	@SuppressWarnings("rawtypes")
	protected void changeDialogsLocation(UIComponent root,String dialogPosition) throws Exception {
		Iterator kids = root.getFacetsAndChildren();
		while (kids.hasNext()) {
			Object o = kids.next();
			
			if (o instanceof Dialog  ) {
				Dialog dialog=(Dialog)o;
				dialog.setPosition(dialogPosition);
				changeDialogsLocation((UIComponent) o,dialogPosition);
				
			}
			
			
		}
		
		return;
	}


}
