package com.app.hms.covid19live;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@Api(value = "Live COVID19 Update")
@RestController
public class Covid19Controller {

    private final Covid19CaseService covid19CaseService;

    @ApiOperation(value = "Returns all total cases, recovery and deaths")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(covid19CaseService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Returns data of all countries that has COVID-19 cases")
    @GetMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCountries() {
        return new ResponseEntity<>(covid19CaseService.getAllCountries(), HttpStatus.OK);
    }

    @ApiOperation(value = "Returns data of a specific country")
    @GetMapping(value = "/countries/{countryName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByCountryName(
            @ApiParam(value = "Country Name for which COVID19 Status needs to be displayed", required = true) @PathVariable("countryName") String countryName) {
        return new ResponseEntity<>(covid19CaseService.getByCountryName(countryName), HttpStatus.OK);
    }

    @ApiOperation(value = "Returns all United States of America and their Corona data by States")
    @GetMapping(value = "/all/us/states", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUsStatesCases() {
        return new ResponseEntity<>(covid19CaseService.getAllUsStatesCases(), HttpStatus.OK);
    }

    @Autowired
    public Covid19Controller(Covid19CaseService covid19CaseService) {
        this.covid19CaseService = covid19CaseService;
    }
}
