package com.example.MasterMicro.controller;

import com.example.MasterMicro.model.Topology;
import com.example.MasterMicro.service.TopologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/topologies")
@RestController
public class TopologyController {


    private TopologyService topologyService;

    @Autowired
    public TopologyController(TopologyService topologyService) {
        this.topologyService = topologyService;
    }

    @GetMapping("/readjson/{FileName}")
    public List<Topology> readJSON(@PathVariable("FileName") String fileName)
    {
        return topologyService.readJSON(fileName);
    }

    @GetMapping("/writejson/{topologyID}")
    public List<Topology> writeJSON(@PathVariable("topologyID") String topologyID) throws IOException {

        return topologyService.writeJSON(topologyID);
    }

    @GetMapping("/list")
    public List<Topology> getTopologies()
    {
        return topologyService.getAllTopologies();
    }

}
