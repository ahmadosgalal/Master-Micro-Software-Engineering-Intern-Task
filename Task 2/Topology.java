package com.example.MasterMicro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
@Entity
@Table(name = "topologies")
public class Topology {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "componentType")
    private String  componentType;
    @Column(name = "componentId")
    private String  componentId;

    @Column(name = "resistorDefault")
    @Nullable
    private double  resistorDefault;
    @Column(name = "resistorMin")
    @Nullable
    private double  resistorMin;
    @Column(name = "resistorMax")
    @Nullable
    private double  resistorMax;

    @Column(name = "mlDefault")
    @Nullable
    private double  mlDefault;
    @Column(name = "mlMin")
    @Nullable
    private double  mlMin;
    @Column(name = "mlMax")
    @Nullable
    private double  mlMax;

    @Column(name = "netlistT1")
    @Nullable
    private String netlistT1;
    @Column(name = "netlistT2")
    @Nullable
    private String netlistT2;

    @Column(name = "netlistDrain")
    @Nullable
    private String netlistDrain;
    @Column(name = "netlistGate")
    @Nullable
    private String netlistGate;
    @Column(name = "netlistSource")
    @Nullable
    private String netlistSource;

    public Topology(String id, String componentType, String componentId, double resistorDefault, double resistorMin, double resistorMax, String netlistT1, String netlistT2) {
        this.id = id;
        this.componentType = componentType;
        this.componentId = componentId;
        this.resistorDefault = resistorDefault;
        this.resistorMin = resistorMin;
        this.resistorMax = resistorMax;
        this.netlistT1 = netlistT1;
        this.netlistT2 = netlistT2;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("components")
    private void unpackNested(List<Map<String,Object>> componentss) {
        for (Map<String, Object> components : componentss) {
            this.componentId = (String) components.get("id");
            this.componentType = (String) components.get("type");

            Map<String, String> netlist = (Map<String, String>) components.get("netlist");
            if (netlist.get("t1") != null)
                this.netlistT1 = netlist.get("t1");
            if (netlist.get("t2") != null)
                this.netlistT2 = netlist.get("t2");
            if (netlist.get("drain") != null)
                this.netlistDrain = netlist.get("drain");
            if (netlist.get("gate") != null)
                this.netlistGate = netlist.get("gate");
            if (netlist.get("source") != null)
                this.netlistSource = netlist.get("source");

            if ((Map<String, Double>) components.get("resistance") != null) {
                Map<String, Double> resistance = (Map<String, Double>) components.get("resistance");
                this.resistorDefault = resistance.get("default");
                this.resistorMin = resistance.get("min");
                this.resistorMax = resistance.get("max");
            }

            if ((Map<String, Double>) components.get("m(l)") != null) {
                Map<String, Double> ml = (Map<String, Double>) components.get("m(l)");
                this.mlDefault = ml.get("deafult");
                this.mlMin = ml.get("min");
                this.mlMax = ml.get("max");
            }
        }
    }
}