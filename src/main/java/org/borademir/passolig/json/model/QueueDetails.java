
package org.borademir.passolig.json.model;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class QueueDetails {

    @SerializedName("Enabled")
    @Expose
    private Boolean enabled;

    /**
     * 
     * @return
     *     The enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 
     * @param enabled
     *     The Enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
