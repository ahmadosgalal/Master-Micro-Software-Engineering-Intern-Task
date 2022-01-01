package com.example.MasterMicro;

import com.example.MasterMicro.model.*;
import com.example.MasterMicro.service.TopologyService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TopologyApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(TopologyApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(TopologyService topologyService){
		return args -> {

		};
	}

}
