package com.example.MasterMicro.dbo;

import com.example.MasterMicro.model.Topology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class TopologyRepository {
        private static List<Topology> DB = new ArrayList<>();

        public List<Topology> findAll()
        {

                return DB;
        }

        public Topology save(Topology topology)
        {
                DB.add(topology);
                return  topology;
        }

        public Topology find(String topologyID) {
                for(Topology topology :DB)
                {
                        if((topology.getId()).equals(topologyID))
                                return topology;
                }
                return null;
        }

        public boolean remove(String topologyID) {
                return DB.removeIf(x->(x.getId()).equals(topologyID));
        }
}
