package com.nordea.bpss.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CustomerCountryTest {

    @Parameterized.Parameters
    public static Iterable<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {"PL", 1, CustomerCountry.PL},
                {"EE", 4, CustomerCountry.EE},
                {"LV", 3, CustomerCountry.LV},
                {"LT", 2, CustomerCountry.LT}
        });
    }

    @Parameterized.Parameter(0)
    public String country;

    @Parameterized.Parameter(1)
    public Integer countryCode;

    @Parameterized.Parameter(2)
    public CustomerCountry countryEnum;

    @Test
    public void should_return_valid_country() {
        CustomerCountry pl = CustomerCountry.valueOf(country);

        assertThat(pl, is(equalTo(countryEnum)));
        assertThat(pl.countryCode(), is(equalTo(countryCode)));
    }

    @Test
    public void should_return_country_code() {
        assertThat(CustomerCountry.byCountryCode(countryCode), is(equalTo(countryEnum)));
    }

    @Test
    public void country_exists() {
        assertThat(CustomerCountry.countryExists(country), is(true));
    }

    @Test
    public void country_not_exists() {
        assertThat(CustomerCountry.countryExists("UA"), is(false));
    }



}
