
package org.borademir.passolig.json.model;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class BlockDataResultResponse {

    @SerializedName("BlockDataResult")
    @Expose
    private BlockDataResult blockDataResult;

    /**
     * 
     * @return
     *     The blockDataResult
     */
    public BlockDataResult getBlockDataResult() {
        return blockDataResult;
    }

    /**
     * 
     * @param blockDataResult
     *     The BlockDataResult
     */
    public void setBlockDataResult(BlockDataResult blockDataResult) {
        this.blockDataResult = blockDataResult;
    }

}
