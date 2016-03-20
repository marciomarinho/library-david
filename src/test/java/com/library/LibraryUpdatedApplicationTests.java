package com.library;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

//import static org.hamcrest.Matchers.hasProperty;
//import static org.hamcrest.Matchers.nullValue;
//import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LibraryUpdatedApplication.class)
@WebAppConfiguration
public class LibraryUpdatedApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void showAddTodoForm() throws Exception {
        mockMvc.perform(get("/book"))
                .andExpect(status().isOk())
                .andExpect(view().name("book/book"));
//                .andExpect(model().attribute("books", hasProperty("id", nullValue())))
//                .andExpect(model().attribute("books", hasProperty("description", isEmptyOrNullString())))
//                .andExpect(model().attribute("books", hasProperty("title", isEmptyOrNullString())));
    }
}
