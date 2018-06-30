package com.yummy.mock.model;

import com.yummy.commons.Response;
import com.yummy.commons.Response;
import com.yummy.commons.Response;

import java.util.List;
import java.util.Map;

public class UserMockResponse extends Response {

    public UserMockResponse(String message, int code, List<Map<String, String>> userResponses) {
        super(message, code);
        this.userResponses = userResponses;
    }

    private List<Map<String, String>> userResponses;

    public List<Map<String, String>> getUserResponses() {
        return userResponses;
    }

    public void setUserResponses(List<Map<String, String>> userResponses) {
        this.userResponses = userResponses;
    }
}
