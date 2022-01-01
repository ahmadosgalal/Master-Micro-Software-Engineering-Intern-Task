package com.example.MasterMicro.controller;

import com.example.MasterMicro.model.Topology;
import com.example.MasterMicro.service.TopologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Optional;
import java.util.List;

@RequestMapping("/api/v1/topology")
@RestController
public class TopologyController {


    private TopologyService topologyService;

    @Autowired
    public TopologyController(TopologyService topologyService) {
        this.topologyService = topologyService;
    }

    @PostMapping
    public List<Topology> addTask(@RequestBody Topology topology)
    {
        return topologyService.addTopology(topology);
    }

    @GetMapping(path = "{id}")
    public Optional<Topology> getTaskById(@PathVariable("id") Long id)
    {
        return topologyService.getTopologyByID(id);
    }


    @DeleteMapping(path = "{id}")
    public List<Topology> removeTask(@PathVariable("id") Long id)
    {
        return topologyService.removeTopology(id);
    }

    @PutMapping(path = "{id}")
    public Topology updateTask(@PathVariable("id") Long id,@RequestBody Topology topology)
    {
        return topologyService.updateTopology(id, topology);
    }
}
