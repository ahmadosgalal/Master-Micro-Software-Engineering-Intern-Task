package com.example.MasterMicro.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "topologies")
public class Topology {

    @Id
    @Column(name = "id")
    private String id;

    @Embedded
    private Component  component;

    public Topology(String id, Component component)
    {
        this.id = id;
        this.component = component;
    }
}
