
package org.borademir.passolig.json.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class GetFixtureResult {

    @SerializedName("AvailableFrom")
    @Expose
    private String availableFrom;
    @SerializedName("AvailableTo")
    @Expose
    private String availableTo;
    @SerializedName("AwayClub")
    @Expose
    private AwayClub awayClub;
    @SerializedName("Blocks")
    @Expose
    private List<Block> blocks = new ArrayList<Block>();
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Competition")
    @Expose
    private Competition competition;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("End")
    @Expose
    private String end;
    @SerializedName("EventType")
    @Expose
    private String eventType;
    @SerializedName("FacebookEventId")
    @Expose
    private String facebookEventId;
    @SerializedName("HomeClub")
    @Expose
    private HomeClub homeClub;
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Latitude")
    @Expose
    private Double latitude;
    @SerializedName("Longitude")
    @Expose
    private Double longitude;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Organisation")
    @Expose
    private String organisation;
    @SerializedName("PrioritySalesProvidersInfo")
    @Expose
    private List<PrioritySalesProvidersInfo> prioritySalesProvidersInfo = new ArrayList<PrioritySalesProvidersInfo>();
    @SerializedName("Products")
    @Expose
    private List<Product> products = new ArrayList<Product>();
    @SerializedName("QueueDetails")
    @Expose
    private QueueDetails queueDetails;
    @SerializedName("ResaleEnabled")
    @Expose
    private Boolean resaleEnabled;
    @SerializedName("ResalePercentage")
    @Expose
    private Integer resalePercentage;
    @SerializedName("SelectSeats")
    @Expose
    private Boolean selectSeats;
    @SerializedName("SeriesId")
    @Expose
    private String seriesId;
    @SerializedName("SeriesName")
    @Expose
    private Object seriesName;
    @SerializedName("Start")
    @Expose
    private String start;
    @SerializedName("Tickets")
    @Expose
    private Object tickets;
    @SerializedName("Town")
    @Expose
    private Object town;
    @SerializedName("ValidTransferDate")
    @Expose
    private Boolean validTransferDate;
    @SerializedName("VenueConfigurationId")
    @Expose
    private String venueConfigurationId;
    @SerializedName("VenueName")
    @Expose
    private String venueName;

    /**
     * 
     * @return
     *     The availableFrom
     */
    public String getAvailableFrom() {
        return availableFrom;
    }

    /**
     * 
     * @param availableFrom
     *     The AvailableFrom
     */
    public void setAvailableFrom(String availableFrom) {
        this.availableFrom = availableFrom;
    }

    /**
     * 
     * @return
     *     The availableTo
     */
    public String getAvailableTo() {
        return availableTo;
    }

    /**
     * 
     * @param availableTo
     *     The AvailableTo
     */
    public void setAvailableTo(String availableTo) {
        this.availableTo = availableTo;
    }

    /**
     * 
     * @return
     *     The awayClub
     */
    public AwayClub getAwayClub() {
        return awayClub;
    }

    /**
     * 
     * @param awayClub
     *     The AwayClub
     */
    public void setAwayClub(AwayClub awayClub) {
        this.awayClub = awayClub;
    }

    /**
     * 
     * @return
     *     The blocks
     */
    public List<Block> getBlocks() {
        return blocks;
    }

    /**
     * 
     * @param blocks
     *     The Blocks
     */
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
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
     *     The competition
     */
    public Competition getCompetition() {
        return competition;
    }

    /**
     * 
     * @param competition
     *     The Competition
     */
    public void setCompetition(Competition competition) {
        this.competition = competition;
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
     *     The end
     */
    public String getEnd() {
        return end;
    }

    /**
     * 
     * @param end
     *     The End
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * 
     * @return
     *     The eventType
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * 
     * @param eventType
     *     The EventType
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * 
     * @return
     *     The facebookEventId
     */
    public String getFacebookEventId() {
        return facebookEventId;
    }

    /**
     * 
     * @param facebookEventId
     *     The FacebookEventId
     */
    public void setFacebookEventId(String facebookEventId) {
        this.facebookEventId = facebookEventId;
    }

    /**
     * 
     * @return
     *     The homeClub
     */
    public HomeClub getHomeClub() {
        return homeClub;
    }

    /**
     * 
     * @param homeClub
     *     The HomeClub
     */
    public void setHomeClub(HomeClub homeClub) {
        this.homeClub = homeClub;
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
     *     The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The Latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The Longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
     *     The organisation
     */
    public String getOrganisation() {
        return organisation;
    }

    /**
     * 
     * @param organisation
     *     The Organisation
     */
    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    /**
     * 
     * @return
     *     The prioritySalesProvidersInfo
     */
    public List<PrioritySalesProvidersInfo> getPrioritySalesProvidersInfo() {
        return prioritySalesProvidersInfo;
    }

    /**
     * 
     * @param prioritySalesProvidersInfo
     *     The PrioritySalesProvidersInfo
     */
    public void setPrioritySalesProvidersInfo(List<PrioritySalesProvidersInfo> prioritySalesProvidersInfo) {
        this.prioritySalesProvidersInfo = prioritySalesProvidersInfo;
    }

    /**
     * 
     * @return
     *     The products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * 
     * @param products
     *     The Products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * 
     * @return
     *     The queueDetails
     */
    public QueueDetails getQueueDetails() {
        return queueDetails;
    }

    /**
     * 
     * @param queueDetails
     *     The QueueDetails
     */
    public void setQueueDetails(QueueDetails queueDetails) {
        this.queueDetails = queueDetails;
    }

    /**
     * 
     * @return
     *     The resaleEnabled
     */
    public Boolean getResaleEnabled() {
        return resaleEnabled;
    }

    /**
     * 
     * @param resaleEnabled
     *     The ResaleEnabled
     */
    public void setResaleEnabled(Boolean resaleEnabled) {
        this.resaleEnabled = resaleEnabled;
    }

    /**
     * 
     * @return
     *     The resalePercentage
     */
    public Integer getResalePercentage() {
        return resalePercentage;
    }

    /**
     * 
     * @param resalePercentage
     *     The ResalePercentage
     */
    public void setResalePercentage(Integer resalePercentage) {
        this.resalePercentage = resalePercentage;
    }

    /**
     * 
     * @return
     *     The selectSeats
     */
    public Boolean getSelectSeats() {
        return selectSeats;
    }

    /**
     * 
     * @param selectSeats
     *     The SelectSeats
     */
    public void setSelectSeats(Boolean selectSeats) {
        this.selectSeats = selectSeats;
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
     *     The seriesName
     */
    public Object getSeriesName() {
        return seriesName;
    }

    /**
     * 
     * @param seriesName
     *     The SeriesName
     */
    public void setSeriesName(Object seriesName) {
        this.seriesName = seriesName;
    }

    /**
     * 
     * @return
     *     The start
     */
    public String getStart() {
        return start;
    }

    /**
     * 
     * @param start
     *     The Start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * 
     * @return
     *     The tickets
     */
    public Object getTickets() {
        return tickets;
    }

    /**
     * 
     * @param tickets
     *     The Tickets
     */
    public void setTickets(Object tickets) {
        this.tickets = tickets;
    }

    /**
     * 
     * @return
     *     The town
     */
    public Object getTown() {
        return town;
    }

    /**
     * 
     * @param town
     *     The Town
     */
    public void setTown(Object town) {
        this.town = town;
    }

    /**
     * 
     * @return
     *     The validTransferDate
     */
    public Boolean getValidTransferDate() {
        return validTransferDate;
    }

    /**
     * 
     * @param validTransferDate
     *     The ValidTransferDate
     */
    public void setValidTransferDate(Boolean validTransferDate) {
        this.validTransferDate = validTransferDate;
    }

    /**
     * 
     * @return
     *     The venueConfigurationId
     */
    public String getVenueConfigurationId() {
        return venueConfigurationId;
    }

    /**
     * 
     * @param venueConfigurationId
     *     The VenueConfigurationId
     */
    public void setVenueConfigurationId(String venueConfigurationId) {
        this.venueConfigurationId = venueConfigurationId;
    }

    /**
     * 
     * @return
     *     The venueName
     */
    public String getVenueName() {
        return venueName;
    }

    /**
     * 
     * @param venueName
     *     The VenueName
     */
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

}
