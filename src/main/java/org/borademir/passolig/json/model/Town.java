
package org.borademir.passolig.json.model;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Town {

    @SerializedName("CityCode")
    @Expose
    private String cityCode;
    @SerializedName("CityID")
    @Expose
    private String cityID;
    @SerializedName("TownCode")
    @Expose
    private String townCode;
    @SerializedName("TownID")
    @Expose
    private String townID;
    @SerializedName("TownName")
    @Expose
    private String townName;

    /**
     * 
     * @return
     *     The cityCode
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 
     * @param cityCode
     *     The CityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * 
     * @return
     *     The cityID
     */
    public String getCityID() {
        return cityID;
    }

    /**
     * 
     * @param cityID
     *     The CityID
     */
    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    /**
     * 
     * @return
     *     The townCode
     */
    public String getTownCode() {
        return townCode;
    }

    /**
     * 
     * @param townCode
     *     The TownCode
     */
    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    /**
     * 
     * @return
     *     The townID
     */
    public String getTownID() {
        return townID;
    }

    /**
     * 
     * @param townID
     *     The TownID
     */
    public void setTownID(String townID) {
        this.townID = townID;
    }

    /**
     * 
     * @return
     *     The townName
     */
    public String getTownName() {
        return townName;
    }

    /**
     * 
     * @param townName
     *     The TownName
     */
    public void setTownName(String townName) {
        this.townName = townName;
    }

}
