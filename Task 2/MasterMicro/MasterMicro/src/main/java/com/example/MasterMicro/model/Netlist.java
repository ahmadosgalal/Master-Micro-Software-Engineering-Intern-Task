
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
    "t1",
    "t2",
    "drain",
    "gate",
    "source"
})
@Generated("jsonschema2pojo")
public class Netlist implements Serializable
{

    @JsonProperty("t1")
    private String t1;
    @JsonProperty("t2")
    private String t2;
    @JsonProperty("drain")
    private String drain;
    @JsonProperty("gate")
    private String gate;
    @JsonProperty("source")
    private String source;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7377115792213102264L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Netlist() {
    }

    /**
     * 
     * @param gate
     * @param source
     * @param t1
     * @param t2
     * @param drain
     */
    public Netlist(String t1, String t2) {
        super();
        this.t1 = t1;
        this.t2 = t2;

    }

    public Netlist( String drain, String gate, String source) {
        super();
        this.drain = drain;
        this.gate = gate;
        this.source = source;
    }

    @JsonProperty("t1")
    public String getT1() {
        return t1;
    }

    @JsonProperty("t1")
    public void setT1(String t1) {
        this.t1 = t1;
    }

    @JsonProperty("t2")
    public String getT2() {
        return t2;
    }

    @JsonProperty("t2")
    public void setT2(String t2) {
        this.t2 = t2;
    }

    @JsonProperty("drain")
    public String getDrain() {
        return drain;
    }

    @JsonProperty("drain")
    public void setDrain(String drain) {
        this.drain = drain;
    }

    @JsonProperty("gate")
    public String getGate() {
        return gate;
    }

    @JsonProperty("gate")
    public void setGate(String gate) {
        this.gate = gate;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
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
