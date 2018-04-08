package com.dwe.dealwitheat.transaction.model;

import java.util.List;

public class ChangeOrderStateRequest {

    private List<Long> idList;
    private String state;

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
