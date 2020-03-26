package com.app.hms.covid19live;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Anish Panthi
 */
@Service
public class Covid19CaseServiceImpl implements Covid19CaseService {

    private final RestTemplate restTemplate;

    /**
     * Returns all total cases, recovery and deaths.
     *
     * @return Single JSON String
     */
    @Override
    public Covid19Case getAllStatus() {
        HttpHeaders requestHeaders = new HttpHeaders();
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);

        ResponseEntity<Covid19Case> responseEntity = restTemplate.exchange("https://corona.lmao.ninja/all",
                HttpMethod.GET,
                requestEntity,
                Covid19Case.class);
        return responseEntity.getBody();
    }

    /**
     * Returns data of all countries that has COVID-19 cases
     *
     * @return List of JSON Strings
     */
    @Override
    public String getAllCountries() {
        HttpHeaders requestHeaders = new HttpHeaders();
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange("https://corona.lmao.ninja/countries",
                HttpMethod.GET,
                requestEntity,
                String.class);
        return responseEntity.getBody();
    }

    /**
     * Returns data of a specific country. If an exact name match is desired, pass <code>?strict=true</code> in the query string
     *
     * @return JSON String
     */
    @Override
    public Covid19Case getByCountryName(String countryName) {
        // https://corona.lmao.ninja/countries/{country-name}
        HttpHeaders requestHeaders = new HttpHeaders();
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);

        ResponseEntity<Covid19Case> responseEntity = restTemplate.exchange("https://corona.lmao.ninja/countries/" + countryName,
                HttpMethod.GET,
                requestEntity,
                Covid19Case.class);
        return responseEntity.getBody();
    }

    /**
     * Returns all United States of America and their Corona data by States
     *
     * @return List of JSON String
     */
    @Override
    public String getAllUsStatesCases() {
        HttpHeaders requestHeaders = new HttpHeaders();
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange("https://corona.lmao.ninja/states",
                HttpMethod.GET,
                requestEntity,
                String.class);
        return responseEntity.getBody();
    }

    @Autowired
    public Covid19CaseServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
