package com.app.hms.covid19live;

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
public class Covid19CaseUsState implements Serializable {

    private String state;

    private int cases;

    private int todayCases;

    private int deaths;

    private int todayDeaths;

    private int active;
}
