
package org.borademir.passolig.json.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class BlockDataResult {

    @SerializedName("classIndexes")
    @Expose
    private List<String> classIndexes = new ArrayList<String>();
    @SerializedName("classes")
    @Expose
    private List<List<Integer>> classes = new ArrayList<List<Integer>>();
    @SerializedName("firstSeat")
    @Expose
    private Integer firstSeat;
    @SerializedName("radius")
    @Expose
    private Integer radius;
    @SerializedName("rowLabels")
    @Expose
    private List<String> rowLabels = new ArrayList<String>();
    @SerializedName("rows")
    @Expose
    private Integer rows;
    @SerializedName("seatDirection")
    @Expose
    private Integer seatDirection;
    @SerializedName("seats")
    @Expose
    private Integer seats;
    @SerializedName("ignoreGaps")
    @Expose
    private Boolean ignoreGaps;
    @SerializedName("rowOffsets")
    @Expose
    private Object rowOffsets;
    @SerializedName("useRowOffsets")
    @Expose
    private Boolean useRowOffsets;
    @SerializedName("validSeatsPerRow")
    @Expose
    private List<Object> validSeatsPerRow = new ArrayList<Object>();
    @SerializedName("zigzagStart")
    @Expose
    private Integer zigzagStart;

    /**
     * 
     * @return
     *     The classIndexes
     */
    public List<String> getClassIndexes() {
        return classIndexes;
    }

    /**
     * 
     * @param classIndexes
     *     The classIndexes
     */
    public void setClassIndexes(List<String> classIndexes) {
        this.classIndexes = classIndexes;
    }

    /**
     * 
     * @return
     *     The classes
     */
    public List<List<Integer>> getClasses() {
        return classes;
    }

    /**
     * 
     * @param classes
     *     The classes
     */
    public void setClasses(List<List<Integer>> classes) {
        this.classes = classes;
    }

    /**
     * 
     * @return
     *     The firstSeat
     */
    public Integer getFirstSeat() {
        return firstSeat;
    }

    /**
     * 
     * @param firstSeat
     *     The firstSeat
     */
    public void setFirstSeat(Integer firstSeat) {
        this.firstSeat = firstSeat;
    }

    /**
     * 
     * @return
     *     The radius
     */
    public Integer getRadius() {
        return radius;
    }

    /**
     * 
     * @param radius
     *     The radius
     */
    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    /**
     * 
     * @return
     *     The rowLabels
     */
    public List<String> getRowLabels() {
        return rowLabels;
    }

    /**
     * 
     * @param rowLabels
     *     The rowLabels
     */
    public void setRowLabels(List<String> rowLabels) {
        this.rowLabels = rowLabels;
    }

    /**
     * 
     * @return
     *     The rows
     */
    public Integer getRows() {
        return rows;
    }

    /**
     * 
     * @param rows
     *     The rows
     */
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * 
     * @return
     *     The seatDirection
     */
    public Integer getSeatDirection() {
        return seatDirection;
    }

    /**
     * 
     * @param seatDirection
     *     The seatDirection
     */
    public void setSeatDirection(Integer seatDirection) {
        this.seatDirection = seatDirection;
    }

    /**
     * 
     * @return
     *     The seats
     */
    public Integer getSeats() {
        return seats;
    }

    /**
     * 
     * @param seats
     *     The seats
     */
    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    /**
     * 
     * @return
     *     The ignoreGaps
     */
    public Boolean getIgnoreGaps() {
        return ignoreGaps;
    }

    /**
     * 
     * @param ignoreGaps
     *     The ignoreGaps
     */
    public void setIgnoreGaps(Boolean ignoreGaps) {
        this.ignoreGaps = ignoreGaps;
    }

    /**
     * 
     * @return
     *     The rowOffsets
     */
    public Object getRowOffsets() {
        return rowOffsets;
    }

    /**
     * 
     * @param rowOffsets
     *     The rowOffsets
     */
    public void setRowOffsets(Object rowOffsets) {
        this.rowOffsets = rowOffsets;
    }

    /**
     * 
     * @return
     *     The useRowOffsets
     */
    public Boolean getUseRowOffsets() {
        return useRowOffsets;
    }

    /**
     * 
     * @param useRowOffsets
     *     The useRowOffsets
     */
    public void setUseRowOffsets(Boolean useRowOffsets) {
        this.useRowOffsets = useRowOffsets;
    }

    /**
     * 
     * @return
     *     The validSeatsPerRow
     */
    public List<Object> getValidSeatsPerRow() {
        return validSeatsPerRow;
    }

    /**
     * 
     * @param validSeatsPerRow
     *     The validSeatsPerRow
     */
    public void setValidSeatsPerRow(List<Object> validSeatsPerRow) {
        this.validSeatsPerRow = validSeatsPerRow;
    }

    /**
     * 
     * @return
     *     The zigzagStart
     */
    public Integer getZigzagStart() {
        return zigzagStart;
    }

    /**
     * 
     * @param zigzagStart
     *     The zigzagStart
     */
    public void setZigzagStart(Integer zigzagStart) {
        this.zigzagStart = zigzagStart;
    }

}
