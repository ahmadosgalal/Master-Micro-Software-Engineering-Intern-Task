package com.example.MasterMicro.service;

import com.example.MasterMicro.dbo.TopologyRepository;
import com.example.MasterMicro.model.Topology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TopologyService {
    @Autowired
    private TopologyRepository topologyDao;

    public List<Topology> addTopology(Topology topology) {
        topologyDao.save(topology);
        return topologyDao.findAll();
    }

    public List<Topology> getAllTopologies(){
        return topologyDao.findAll();
    }

    public List<Topology> removeTopology(Long id) {
        if(topologyDao.existsById(id))
            topologyDao.deleteById(id);
        return topologyDao.findAll();
    }

    public Topology updateTopology(Long id, Topology topology) {

        if(topologyDao.existsById(id)) {
            Topology updatedTask = topologyDao.findTopologyById(id);
            updatedTask.setState(topology.getState());
            return topologyDao.save(updatedTask);
        }
        return null;
    }

    public Optional<Topology> getTopologyByID(Long id) {
        Optional<Topology> task = topologyDao.findById(id);
        return task;
    }
}

