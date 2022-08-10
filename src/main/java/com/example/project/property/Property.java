package com.example.project.property;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Property {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private long buying_price;
    private long current_value;

    public Property()
    {

    }
    public Property(String name, long buying_price, long current_value)
    {
        this.name = name;
        this.buying_price = buying_price;
        this.current_value = current_value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBuying_price() {
        return buying_price;
    }

    public void setBuying_price(long buying_price) {
        this.buying_price = buying_price;
    }

    public long getCurrent_value() {
        return current_value;
    }

    public void setCurrent_value(long current_value) {
        this.current_value = current_value;
    }



}