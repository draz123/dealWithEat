package com.yummy.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationRequest {

    private int page;
    private int size;

}
