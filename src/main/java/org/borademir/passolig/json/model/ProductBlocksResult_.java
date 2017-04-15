
package org.borademir.passolig.json.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ProductBlocksResult_ {

    @SerializedName("Available")
    @Expose
    private Integer available;
    @SerializedName("Categories")
    @Expose
    private List<String> categories = new ArrayList<String>();
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
     *     The available
     */
    public Integer getAvailable() {
        return available;
    }

    /**
     * 
     * @param available
     *     The Available
     */
    public void setAvailable(Integer available) {
        this.available = available;
    }

    /**
     * 
     * @return
     *     The categories
     */
    public List<String> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The Categories
     */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

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
