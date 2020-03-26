package com.app.hms.covid19live;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Covid19Controller {

    private final Covid19CaseService covid19CaseService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(covid19CaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCountries(){
        return new ResponseEntity<>(covid19CaseService.getAllCountries(), HttpStatus.OK);
    }

    @GetMapping(value = "/countries/{countryName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByCountryName(@PathVariable("countryName") String countryName){
        return new ResponseEntity<>(covid19CaseService.getByCountryName(countryName), HttpStatus.OK);
    }

    @GetMapping(value = "/all/us/states", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUsStatesCases(){
        return new ResponseEntity<>(covid19CaseService.getAllUsStatesCases(), HttpStatus.OK);
    }

    @Autowired
    public Covid19Controller(Covid19CaseService covid19CaseService){
        this.covid19CaseService = covid19CaseService;
    }
}
