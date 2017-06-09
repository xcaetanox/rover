package br.com.curiosity.contaazul;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestComunicationWithRover {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/rest/mars/");
	}

	@Test
	public void test1() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post(base.toString() + "MMRMMRMM").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo("(2, 0, S)")));

	}

	@Test
	public void test2() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post(base.toString() + "MML").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo("(0, 2, W)")));

	}

	@Test
	public void test3() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post(base.toString() + "MML").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo("(0, 2, W)")));

	}

	@Test
	public void test4() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post(base.toString() + "AAA").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}

	@Test
	public void test5() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post(base.toString() + "MMMMMMMMMMMMMMMMMMMMMMMM")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

	}
}
