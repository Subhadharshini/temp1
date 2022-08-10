package com.example.project.asset;

import com.example.project.bonds.Bond;
import com.example.project.property.Property;
import com.example.project.share.Share;
import com.example.project.stock.Stock;
import com.example.project.trader.Trader;

import javax.persistence.*;
import java.util.List;

@Entity
public class Asset{
    @Id
    @GeneratedValue
    private long id;

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private Trader trader;
    @ManyToOne(cascade = CascadeType.ALL)
    private Share share;

    private long price;
    private long net_changes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Stock> Stocks;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Bond> Bonds;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Property> Properties;

    public Asset(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getNet_changes() {
        return net_changes;
    }

    public void setNet_changes(long net_changes) {
        this.net_changes = net_changes;
    }

    public List<Stock> getStocks() {
        return Stocks;
    }

    public void setStocks(List<Stock> stocks) {
        Stocks = stocks;
    }

    public List<Bond> getBonds() {
        return Bonds;
    }

    public void setBonds(List<Bond> bonds) {
        Bonds = bonds;
    }

    public List<Property> getProperties() {
        return Properties;
    }

    public void setProperties(List<Property> properties) {
        Properties = properties;
    }
}