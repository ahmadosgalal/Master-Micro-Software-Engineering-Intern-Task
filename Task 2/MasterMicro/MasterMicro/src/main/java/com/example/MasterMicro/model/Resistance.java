
package com.example.MasterMicro.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "default",
    "min",
    "max"
})
@Generated("jsonschema2pojo")
public class Resistance implements Serializable
{

    @JsonProperty("default")
    private Double _default;
    @JsonProperty("min")
    private Double min;
    @JsonProperty("max")
    private Double max;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6202798201614184048L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Resistance() {
    }

    /**
     * 
     * @param _default
     * @param min
     * @param max
     */
    public Resistance(Double _default, Double min, Double max) {
        super();
        this._default = _default;
        this.min = min;
        this.max = max;
    }

    @JsonProperty("default")
    public Double getDefault() {
        return _default;
    }

    @JsonProperty("default")
    public void setDefault(Double _default) {
        this._default = _default;
    }

    @JsonProperty("min")
    public Double getMin() {
        return min;
    }

    @JsonProperty("min")
    public void setMin(Double min) {
        this.min = min;
    }

    @JsonProperty("max")
    public Double getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(Double max) {
        this.max = max;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
