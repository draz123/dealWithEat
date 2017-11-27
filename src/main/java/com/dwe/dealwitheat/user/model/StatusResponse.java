package com.dwe.dealwitheat.user.model;

import com.dwe.dealwitheat.commons.Response;

public class StatusResponse extends Response {

    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
