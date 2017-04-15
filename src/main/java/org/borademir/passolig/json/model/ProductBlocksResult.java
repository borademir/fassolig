
package org.borademir.passolig.json.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ProductBlocksResult {

    @SerializedName("ProductBlocksResult")
    @Expose
    private List<ProductBlocksResult_> productBlocksResult = new ArrayList<ProductBlocksResult_>();

    /**
     * 
     * @return
     *     The productBlocksResult
     */
    public List<ProductBlocksResult_> getProductBlocksResult() {
        return productBlocksResult;
    }

    /**
     * 
     * @param productBlocksResult
     *     The ProductBlocksResult
     */
    public void setProductBlocksResult(List<ProductBlocksResult_> productBlocksResult) {
        this.productBlocksResult = productBlocksResult;
    }

}
