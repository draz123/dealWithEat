package com.dwe.dealwitheat.transaction.model;

import com.dwe.dealwitheat.commons.Response;
import com.dwe.dealwitheat.transaction.model.CurrentOrder;

import java.util.List;

public class CurrentOrdersResponse extends Response {

    private List<CurrentOrder> currentOrderList;
    private int pageSize;
    private boolean isLastPage;
    private int page;

    public CurrentOrdersResponse(String message, int code, List<CurrentOrder> currentOrderList, int pageSize, boolean isLastPage, int page) {
        super(message, code);
        this.currentOrderList = currentOrderList;
        this.pageSize = pageSize;
        this.isLastPage = isLastPage;
        this.page = page;
    }

    public CurrentOrdersResponse() {
    }

    public List<CurrentOrder> getCurrentOrderList() {
        return currentOrderList;
    }

    public void setCurrentOrderList(List<CurrentOrder> currentOrderList) {
        this.currentOrderList = currentOrderList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
