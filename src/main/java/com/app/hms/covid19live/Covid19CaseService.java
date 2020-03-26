package com.app.hms.covid19live;

import java.util.List;

/**
 * @author Anish Panthi
 */
public interface Covid19CaseService {

    /**
     * Returns all total cases, recovery and deaths.
     * @return Single JSON String
     */
    Covid19Case getAllStatus();

    /**
     * Returns data of all countries that has COVID-19 cases
     * @return List of JSON Strings
     */
    String getAllCountries();

    /**
     * Returns data of a specific country. If an exact name match is desired, pass <code>?strict=true</code> in the query string
     * @param countryName String value
     * @return JSON String
     */
    Covid19Case getByCountryName(String countryName);

    /**
     * Returns all United States of America and their Corona data by States
     * @return List of JSON String
     */
    String getAllUsStatesCases();
}
