package com.vmw.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cab {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String carNo;
    private String cabType;
    private int xCoordinate;
    private int yCoordinate;
    private boolean available;

    @OneToOne(cascade = CascadeType.ALL)
    private Driver driver;
}
