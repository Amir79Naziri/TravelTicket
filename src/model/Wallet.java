package model;

import java.io.Serializable;

public class Wallet implements Serializable {
    private double value;

    public Wallet(double value) {
        this.value = value;
    }

    public boolean buyTicket(double cost) {
        if (cost <= value) {
            value -= cost;
            return true;
        }
        return false;
    }

    public double getValue() {
        return value;
    }

    public void charge(double price) {
        value += price;


    }

}
