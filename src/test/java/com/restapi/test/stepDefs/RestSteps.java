package com.restapi.test.stepDefs;

import com.google.gson.Gson;
import com.restapi.test.common.EndPoint;
import com.restapi.test.common.RestAssuredConfiguration;
import com.restapi.test.models.CountryDetails;
import com.restapi.test.models.RootResponsDetails;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import java.util.List;

import static org.junit.Assert.*;

import static io.restassured.RestAssured.given;


public class RestSteps extends RestAssuredConfiguration {

    private  String url = null;
    private  Response rs = null;


    @Given("^I have rest api web service url with \"([^\"]*)\"$")
    public void i_have_rest_api_web_service_url_with(String countryCode){
        url = EndPoint.GET_STATES.replace("{countryCode}",countryCode);

    }

    @When("^I  call the rest api url$")
    public void i_call_the_rest_api_url()  {

        rs =  givenConfig().log().all().when().get(url).then().log().all()
                .spec(getResponseSpecBuilder()).extract().response();
    }

    @Then("^I should be able to get all territories information for the requested country$")
    public void i_should_be_able_to_get_all_territories_information_for_the_requested_country(){
        Gson gson = new Gson();
        RootResponsDetails responsDetails = gson.fromJson(rs.asString(),RootResponsDetails.class);
        List<CountryDetails> result = responsDetails.getRestResponse().getResult();
         assertEquals(36,result.size());
         assertEquals("Andhra Pradesh",result.get(0).getName());
        //assertEquals("IND",result.get(0).getCountry());

    }
}
