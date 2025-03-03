package account_block.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountBlockControllerIT { // IT stands for Integration Test

    @Autowired
    private MockMvc mvc;

    @Test
    void GivenHttpRequestForUpThenShouldBeUp() throws Exception {
        //@formatter:off
        mvc
                .perform(
                        get("/up")
                )
                .andDo(print())
                .andExpect( status().isOk() )
                .andExpect( content().string("yes, I am up"))
        ;
        //@formatter:on
    }
}