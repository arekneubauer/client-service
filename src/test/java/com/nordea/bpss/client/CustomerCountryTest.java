package com.nordea.bpss.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CustomerCountryTest {

    @Parameterized.Parameters
    public static Iterable<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {"PL", 1, CustomerCountry.PL},
                {"EE", 6, CustomerCountry.EE},
                {"LV", 4, CustomerCountry.LV},
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

}
