package com.neuedu.office.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class OfficeControllerDemoTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/department/1").contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
	}

}
