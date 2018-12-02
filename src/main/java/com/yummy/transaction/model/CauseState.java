package com.yummy.transaction.model;

public enum CauseState {
    TIMEOUT,
    BANK_USER_ERROR,
    BANK_RESTAURANT_ERROR,
    USER_CANCELLATION,
    RESTAURANT_CANCELLATION
}