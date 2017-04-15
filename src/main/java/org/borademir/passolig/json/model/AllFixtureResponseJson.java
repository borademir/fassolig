
package org.borademir.passolig.json.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AllFixtureResponseJson {

    @SerializedName("GetAllFixturesForSeriesResult")
    @Expose
    private List<GetAllFixturesForSeriesResult> getAllFixturesForSeriesResult = new ArrayList<GetAllFixturesForSeriesResult>();

    /**
     * 
     * @return
     *     The getAllFixturesForSeriesResult
     */
    public List<GetAllFixturesForSeriesResult> getGetAllFixturesForSeriesResult() {
        return getAllFixturesForSeriesResult;
    }

    /**
     * 
     * @param getAllFixturesForSeriesResult
     *     The GetAllFixturesForSeriesResult
     */
    public void setGetAllFixturesForSeriesResult(List<GetAllFixturesForSeriesResult> getAllFixturesForSeriesResult) {
        this.getAllFixturesForSeriesResult = getAllFixturesForSeriesResult;
    }

}
