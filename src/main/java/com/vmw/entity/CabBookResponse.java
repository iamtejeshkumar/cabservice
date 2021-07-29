package com.vmw.entity;

import lombok.Data;

@Data
public class CabBookResponse {

    private long otp;
    private String cabType;
    private String carNo;
    private String driverName;

}
