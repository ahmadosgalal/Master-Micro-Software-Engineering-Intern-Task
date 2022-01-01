package com.example.MasterMicro.dbo;

import com.example.MasterMicro.model.Topology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopologyRepository extends JpaRepository<Topology,Long> {
        public Topology findTopologyById(Long taskId);
}
