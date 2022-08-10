package com.example.project.bonds;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
public class Bond {
    @Id
    @GeneratedValue
    private long bond_id;


    private String maturity_date;
    private String doi;

    private String Issuer;
    private long interest_rate;
    private long principle;



    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public Bond()
    {

    }

    public long getBond_id() {
        return bond_id;
    }

    public void setBond_id(long bond_id) {
        this.bond_id = bond_id;
    }

    public String getMaturity_date() {
        return maturity_date;
    }

    public void setMaturity_date(String maturity_date) {
        this.maturity_date = maturity_date;
    }

    public String getIssuer() {
        return Issuer;
    }

    public void setIssuer(String issuer) {
        Issuer = issuer;
    }

    public long getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(long interest_rate) {
        this.interest_rate = interest_rate;
    }

    public long getPrinciple() {
        return principle;
    }

    public void setPrinciple(long principle) {
        this.principle = principle;
    }


}
