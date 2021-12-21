//package com.eswar.demo;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.assertj.core.util.Arrays;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//
//
//
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class BookControllerTest {
//	private MockMvc mockMvc;
//	ObjectMapper objectMapper = new ObjectMapper();
//	ObjectWriter objectWriter = objectMapper.writer();
//	
//	@Mock
//	private BookRepository bookRepository;
//	
//	@InjectMocks
//	private BookController bookController;
//	
//	Book RECORD_1 = new Book(1L, "Java", "Java Tutorial" , "5");
//	Book RECORD_2 = new Book(2L, "JavaEE", "JavaEE Tutorial" , "4");
//	
//	@Before
//	public void setup()
//	{
//		MockitoAnnotations.initMocks(testClass.this);
//		this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
//		
//	}
//	
//	@Test
//	public void getAllRecords_success() throws Exception
//	{
//		List<Book> records=new ArrayList<>(Arrays.asList(RECORD_1,RECORD_2));
//		
//		Mockito.when(bookRepository.findAll()).thenReturn(records);
//		mockMvc.perform(MockMvcRequestBuilders
//				.get(urlTemplate:"/book")
//				.contentType(MediaType.APPLICATION_JSON)
//				.andExpect(status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath( expression:"$", hasSize(2)))
//				.andExcept(jsonPath(expression:"$[1].name", is(value:"JavaEE")));
//		
//	}
//	
//}
//	
//
//
//
