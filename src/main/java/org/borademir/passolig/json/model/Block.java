
package org.borademir.passolig.json.model;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Block {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Seated")
    @Expose
    private Boolean seated;
    @SerializedName("Svg")
    @Expose
    private String svg;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The Id
     */
    public void setId(String id) {
        this.id = id;
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
     *     The seated
     */
    public Boolean getSeated() {
        return seated;
    }

    /**
     * 
     * @param seated
     *     The Seated
     */
    public void setSeated(Boolean seated) {
        this.seated = seated;
    }

    /**
     * 
     * @return
     *     The svg
     */
    public String getSvg() {
        return svg;
    }

    /**
     * 
     * @param svg
     *     The Svg
     */
    public void setSvg(String svg) {
        this.svg = svg;
    }

}
