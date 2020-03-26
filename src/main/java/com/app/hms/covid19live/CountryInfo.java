package com.app.hms.covid19live;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Anish Panthi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryInfo implements Serializable {

    @JsonAlias("_id")
    @JsonProperty("id")
    private Integer id;

    @JsonAlias("lat")
    @JsonProperty("latitude")
    private Integer latitude;

    @JsonAlias("long")
    @JsonProperty("longitude")
    private Integer longitude;

    private String flag;

    private String iso2;

    private String iso3;
}
