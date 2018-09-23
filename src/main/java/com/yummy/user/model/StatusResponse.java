package com.yummy.user.model;

import com.yummy.commons.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StatusResponse extends Response {

    private boolean status;

}
