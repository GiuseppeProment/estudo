package account_block;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(Cucumber.class)
@SpringBootTest()
@CucumberOptions(features = "src/test/resources")
@CucumberContextConfiguration
public class StepDefinitionsIntegrationTest {

    @Autowired
    private WebApplicationContext ctx;
    private MockMvc mvc;
    private ResultActions result;

    @Given("an call to url up")
    public void anCallToUrlUp() throws Throwable {
        result = mvc.perform(get("/up"));
    }

    @When("receive http status OK")
    public void receiveHttpStatusOK() throws Throwable {
        result.andExpect(status().isOk());
    }

    @Then("should get correct response")
    public void shouldGetCorrectResponse() throws Throwable {
        result.andExpect(content().string("yes, I am up"));
    }

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }
}
