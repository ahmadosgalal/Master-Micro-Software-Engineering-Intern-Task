package com.example.MasterMicro;

import com.example.MasterMicro.model.*;
import com.example.MasterMicro.service.TopologyService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TopologyApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(TopologyApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(TopologyService topologyService){
		return args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			//objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//			Resistance resistance = new Resistance(100.0, 10.0, 1000.0);
//			Netlist netlist = new Netlist("vdd", "n1");
//			Component component1 = new Component("resistor", "res1", resistance, netlist);
//			Component [] components = new Component[1];
			//TopologyOld topology = new TopologyOld("top1", component1);
			//System.out.println("Working Directory = " + System.getProperty("user.dir"));
			Resistance resistance1 = new Resistance(100.0, 10.0 ,1000.0);
			Netlist netlist1 = new Netlist("vdd", "n1");
			ML ml2 = new ML(1.5, 1.0 ,2.0);
			Netlist netlist2 = new Netlist("n1", "vin","vss");
			List<Component> components = new ArrayList<Component>();
			components.add(new Component("resistor","res1", resistance1, netlist1));
			components.add(new Component("nmos","m1", ml2, netlist2));
			Topology topology = new Topology("top1", components);
			objectMapper.writeValue(new File("src/main/resources/json/test.json"), topology);
		};
	}

}
