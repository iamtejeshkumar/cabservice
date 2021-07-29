package com.vmw.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Driver {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private boolean available;

    @OneToOne(cascade = CascadeType.ALL)
    private Cab cab;
}
