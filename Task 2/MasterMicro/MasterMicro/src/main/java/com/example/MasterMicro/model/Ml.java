
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
    "deafult",
    "min",
    "max"
})
@Generated("jsonschema2pojo")
public class ML implements Serializable
{

    @JsonProperty("deafult")
    private Double deafult;
    @JsonProperty("min")
    private Double min;
    @JsonProperty("max")
    private Double max;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -9178123163226132512L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ML() {
    }

    /**
     * 
     * @param min
     * @param max
     * @param deafult
     */
    public ML(Double deafult, Double min, Double max) {
        super();
        this.deafult = deafult;
        this.min = min;
        this.max = max;
    }

    @JsonProperty("deafult")
    public Double getDeafult() {
        return deafult;
    }

    @JsonProperty("deafult")
    public void setDeafult(Double deafult) {
        this.deafult = deafult;
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
