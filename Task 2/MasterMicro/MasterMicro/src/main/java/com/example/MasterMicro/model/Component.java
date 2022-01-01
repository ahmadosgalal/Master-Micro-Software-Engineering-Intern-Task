
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
    "type",
    "id",
    "resistance",
    "m(l)",
    "netlist"
})
@Generated("jsonschema2pojo")
public class Component implements Serializable
{

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("resistance")
    private Resistance resistance;

    @JsonProperty("m(l)")
    private ML mL;
    @JsonProperty("netlist")
    private Netlist netlist;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3962772775228614970L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Component() {
    }

    /**
     * 
     * @param netlist
     * @param id
     * @param type
     * @param resistance
     * @param mL
     */
    public Component(String type, String id, Resistance resistance, Netlist netlist) {
        super();
        this.type = type;
        this.id = id;
        this.resistance = resistance;
        this.netlist = netlist;
    }

    public Component(String type, String id,  ML mL, Netlist netlist) {
        super();
        this.type = type;
        this.id = id;
        this.mL = mL;
        this.netlist = netlist;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("resistance")
    public Resistance getResistance() {
        return resistance;
    }

    @JsonProperty("resistance")
    public void setResistance(Resistance resistance) {
        this.resistance = resistance;
    }

    @JsonProperty("netlist")
    public Netlist getNetlist() {
        return netlist;
    }

    @JsonProperty("netlist")
    public void setNetlist(Netlist netlist) {
        this.netlist = netlist;
    }

    @JsonProperty("m(l)")
    public ML getmL() {
        return mL;
    }

    @JsonProperty("m(l)")
    public void setmL(ML mL) {
        this.mL = mL;
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
