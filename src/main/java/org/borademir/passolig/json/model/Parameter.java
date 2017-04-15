
package org.borademir.passolig.json.model;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Parameter {

    @SerializedName("Caption")
    @Expose
    private String caption;
    @SerializedName("Length")
    @Expose
    private String length;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Regex")
    @Expose
    private String regex;
    @SerializedName("UniqueId")
    @Expose
    private String uniqueId;

    /**
     * 
     * @return
     *     The caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * 
     * @param caption
     *     The Caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * 
     * @return
     *     The length
     */
    public String getLength() {
        return length;
    }

    /**
     * 
     * @param length
     *     The Length
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The regex
     */
    public String getRegex() {
        return regex;
    }

    /**
     * 
     * @param regex
     *     The Regex
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /**
     * 
     * @return
     *     The uniqueId
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * 
     * @param uniqueId
     *     The UniqueId
     */
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

}
