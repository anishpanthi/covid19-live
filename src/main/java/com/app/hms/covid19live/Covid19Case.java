package com.app.hms.covid19live;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Anish Panthi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19Case implements Serializable {

    private String country;

    private CountryInfo countryInfo;

    private Integer cases;

    private Integer totalCases;

    private Integer deaths;

    private Integer totalDeaths;

    private Integer recovered;

    private Integer active;

    private Integer critical;

    private Double casesPerOneMillion;

    private Integer deathsPerOneMillion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "America/Chicago")
    private Date updated;

}
