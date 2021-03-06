package com.example.MasterMicro.service;

import com.example.MasterMicro.dbo.TopologyRepository;
import com.example.MasterMicro.model.Component;
import com.example.MasterMicro.model.Netlist;
import com.example.MasterMicro.model.Topology;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopologyService {
    @Autowired
    private TopologyRepository topologyDao;

    public TopologyService(TopologyRepository topologyDao) {
        this.topologyDao = topologyDao;
    }

    public Iterable<Topology> list() {
        return topologyDao.findAll();
    }

    public Topology save(Topology topology) {
        return topologyDao.save(topology);
    }

    public List<Topology> queryTopologies() {
        return topologyDao.findAll();
    }

    public List<Topology> readJSON(String fileName) {
        // read JSON and load json
        String path = "/json/topology.json";
        //System.out.println("Working Directory = " + System.getProperty("user.dir"));
        //System.out.println("Path= "+ path);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TypeReference<Topology> typeReference = new TypeReference<Topology>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(path);
        //
        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (inputStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }

            Topology topology = new ObjectMapper()
                    .readerFor(Topology.class)
                    .readValue(String.valueOf(textBuilder));
            this.save(topology);
            System.out.println("Topology Saved!");
        } catch (IOException e) {
            System.out.println("Unable to save topologies: " + e.getMessage());
        }
        return this.queryTopologies();
    }

    public List<Topology> writeJSON(String topologyID) throws IOException {
        Topology topology = topologyDao.find(topologyID);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("src/main/resources/json/test.json"), topology);
        return queryTopologies();
    }


    public boolean deleteTopology(String topologyID) {
        return topologyDao.remove(topologyID);
    }

    public List<Component> queryDevices(String topologyID) {
        Topology topology = topologyDao.find(topologyID);
        if (topology != null)
            return topology.getComponents();
        else
            return null;
    }

    public List<Component> queryDevicesWithNetlistNode(String topologyID, String nodeID) {
        List<Component> connected = new ArrayList<>();
        Topology topology = topologyDao.find(topologyID);
        if (topology != null) {
            List<Component> components = topology.getComponents();
            for(Component component : components)
            {
                Netlist netlist = component.getNetlist();

                String t1 = netlist.getT1();
                String t2 = netlist.getT2();
                String gate = netlist.getGate();
                String drain = netlist.getDrain();
                String source = netlist.getSource();
                List<String> nodes = new ArrayList<>();
                nodes.add(t1);
                nodes.add(t2);
                nodes.add(gate);
                nodes.add(drain);
                nodes.add(source);
                if(nodes.contains(nodeID))
                    connected.add(component);
            }

        }
        return connected;
    }
}

