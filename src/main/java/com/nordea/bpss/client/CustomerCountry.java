package com.nordea.bpss.client;

public enum CustomerCountry {
    PL(1), EE(4), LV(3), LT(2);

    Integer countryCode;

    CustomerCountry(int i) {
        this.countryCode = i;
    }

    public Integer countryCode() {
        return countryCode;
    }

    public static CustomerCountry byCountryCode(Integer countryCode) {
        for (CustomerCountry c: values()) {
            if (c.countryCode() == countryCode) {
                return c;
            }
        }

        throw new IllegalArgumentException("Not such country code");
    }

    public static boolean countryExists(String country) {
        for (CustomerCountry c: values()) {
            if (c.name() == country) {
                return true;
            }
        }

        return false;
    }
}
