package com.vmw.entity;

import lombok.Data;

@Data
public class CabBookRequest {

    private int customerId;
    private int xCoordinate;
    private int yCoordinate;
    private String cabType;

}
