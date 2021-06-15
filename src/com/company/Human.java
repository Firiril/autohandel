package com.company;

public class Human {
    public String name;
    private double money;

    public Human(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
}
