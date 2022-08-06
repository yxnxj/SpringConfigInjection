package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void getRead() throws Exception {
		//given
		String url = "/data/search";

		MockHttpServletRequestBuilder noticeBuilder = get(url);
//		.param("id", String.valueOf(1));


		this.mockMvc.perform(noticeBuilder)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("vo"))
				.andExpect(view().name(url));
	}

}
