package com.ilkdeneme.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Food {
    @javax.persistence.Id
    private Long Id;
    private String name;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
