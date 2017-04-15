
package org.borademir.passolig.json.model;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class GetFixture {

    @SerializedName("GetFixtureResult")
    @Expose
    private GetFixtureResult getFixtureResult;

    /**
     * 
     * @return
     *     The getFixtureResult
     */
    public GetFixtureResult getGetFixtureResult() {
        return getFixtureResult;
    }

    /**
     * 
     * @param getFixtureResult
     *     The GetFixtureResult
     */
    public void setGetFixtureResult(GetFixtureResult getFixtureResult) {
        this.getFixtureResult = getFixtureResult;
    }

}
