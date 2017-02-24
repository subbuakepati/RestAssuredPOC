package com.restapi.test.models;

import com.restapi.test.models.CountryDetails;

import java.util.List;

/**
 * Created by subbu on 23/02/2017.
 */
public class RestResponse {

    private List<CountryDetails> result;

    public List<CountryDetails> getResult() {
        return result;
    }

    public void setResult(List<CountryDetails> result) {
        this.result = result;
    }
}
