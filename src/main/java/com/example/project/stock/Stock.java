package com.example.project.stock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Stock {

    @Id
    @GeneratedValue
    private long stock_id;

    private String created_date;
    private String Name;
    private int quantity;
    private String last_update_date;

    public Stock()
    {

    }
    public long getStock_id() {
        return stock_id;
    }

    public void setStock_id(long stock_id) {
        this.stock_id = stock_id;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(String last_update_date) {
        this.last_update_date = last_update_date;
    }
}