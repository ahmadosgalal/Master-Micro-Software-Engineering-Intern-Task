package com.example.MasterMicro.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "topologies")
public class Topology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        List availableStates = new ArrayList();
        availableStates = new ArrayList();
        availableStates.add("draft");
        availableStates.add("active");
        availableStates.add("done");
        availableStates.add("archived");
        if(!availableStates.contains(state))
            state = "draft"; //default

        if (this.state == null || state.equals("archived") || (state.equals("active") && this.state.equals("draft")) || (state.equals("done") && this.state.equals("active")))
            this.state = state;
    }
}
