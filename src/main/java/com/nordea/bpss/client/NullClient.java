package com.nordea.bpss.client;

public class NullClient extends AbstractClient {

    @Override
    public boolean isNull() {
        return true;
    }
}
