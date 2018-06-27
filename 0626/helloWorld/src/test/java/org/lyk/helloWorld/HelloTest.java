package org.lyk.helloWorld;

import org.junit.Before;
import org.junit.Test;
import org.lyk.helloWorld.web.HelloWorldController;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by yuankliu on 26/06/2018.
 */

@SpringBootTest
public class HelloTest
{
    private MockMvc mockMvc;

    @Before
    public void setUp()
    {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void getHello() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=老牛").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
}
