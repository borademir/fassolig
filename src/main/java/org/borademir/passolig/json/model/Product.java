
package org.borademir.passolig.json.model;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Product {

    @SerializedName("AllocateSeats")
    @Expose
    private Boolean allocateSeats;
    @SerializedName("Capacity")
    @Expose
    private Integer capacity;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Duration")
    @Expose
    private Integer duration;
    @SerializedName("HasMandatoryVariants")
    @Expose
    private Boolean hasMandatoryVariants;
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("IsAnonymous")
    @Expose
    private Boolean isAnonymous;
    @SerializedName("IsMembership")
    @Expose
    private Boolean isMembership;
    @SerializedName("MaxPrice")
    @Expose
    private Double maxPrice;
    @SerializedName("MembershipDuration")
    @Expose
    private Integer membershipDuration;
    @SerializedName("MinPrice")
    @Expose
    private Double minPrice;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("SeriesId")
    @Expose
    private String seriesId;
    @SerializedName("VisaPaymentStrategy")
    @Expose
    private Integer visaPaymentStrategy;

    /**
     * 
     * @return
     *     The allocateSeats
     */
    public Boolean getAllocateSeats() {
        return allocateSeats;
    }

    /**
     * 
     * @param allocateSeats
     *     The AllocateSeats
     */
    public void setAllocateSeats(Boolean allocateSeats) {
        this.allocateSeats = allocateSeats;
    }

    /**
     * 
     * @return
     *     The capacity
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * 
     * @param capacity
     *     The Capacity
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * 
     * @return
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The Code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The Description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *     The Duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * 
     * @return
     *     The hasMandatoryVariants
     */
    public Boolean getHasMandatoryVariants() {
        return hasMandatoryVariants;
    }

    /**
     * 
     * @param hasMandatoryVariants
     *     The HasMandatoryVariants
     */
    public void setHasMandatoryVariants(Boolean hasMandatoryVariants) {
        this.hasMandatoryVariants = hasMandatoryVariants;
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
     *     The isAnonymous
     */
    public Boolean getIsAnonymous() {
        return isAnonymous;
    }

    /**
     * 
     * @param isAnonymous
     *     The IsAnonymous
     */
    public void setIsAnonymous(Boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    /**
     * 
     * @return
     *     The isMembership
     */
    public Boolean getIsMembership() {
        return isMembership;
    }

    /**
     * 
     * @param isMembership
     *     The IsMembership
     */
    public void setIsMembership(Boolean isMembership) {
        this.isMembership = isMembership;
    }

    /**
     * 
     * @return
     *     The maxPrice
     */
    public Double getMaxPrice() {
        return maxPrice;
    }

    /**
     * 
     * @param maxPrice
     *     The MaxPrice
     */
    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * 
     * @return
     *     The membershipDuration
     */
    public Integer getMembershipDuration() {
        return membershipDuration;
    }

    /**
     * 
     * @param membershipDuration
     *     The MembershipDuration
     */
    public void setMembershipDuration(Integer membershipDuration) {
        this.membershipDuration = membershipDuration;
    }

    /**
     * 
     * @return
     *     The minPrice
     */
    public Double getMinPrice() {
        return minPrice;
    }

    /**
     * 
     * @param minPrice
     *     The MinPrice
     */
    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
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
     *     The seriesId
     */
    public String getSeriesId() {
        return seriesId;
    }

    /**
     * 
     * @param seriesId
     *     The SeriesId
     */
    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    /**
     * 
     * @return
     *     The visaPaymentStrategy
     */
    public Integer getVisaPaymentStrategy() {
        return visaPaymentStrategy;
    }

    /**
     * 
     * @param visaPaymentStrategy
     *     The VisaPaymentStrategy
     */
    public void setVisaPaymentStrategy(Integer visaPaymentStrategy) {
        this.visaPaymentStrategy = visaPaymentStrategy;
    }

}
