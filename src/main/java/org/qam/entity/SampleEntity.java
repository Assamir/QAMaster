package org.qam.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SampleEntity {

    @Id
    private int id;
    private String name;

    // getters, setters, constructors...
}

