package com.company;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public  String brand;
    public  String color;
    public  String segment;
    public  String type;
    private int europalletes;
    private double price;
    private double mileage;
    public Boolean damagedCar=false;
    private Boolean damagedBreaks=false;
    private Boolean damagedSuspension=false;
    private Boolean damagedEngine=false;
    private Boolean damagedBody=false;
    private Boolean damagedTransmission=false;
    public double repairCosts=0;

    public Car(String brand, String color, String segment, String type, double price, double mileage, Boolean damagedCar) {
        this.brand = brand;
        this.color = color;
        this.segment = segment;
        this.type = type;
        this.price = price;
        this.mileage = mileage;
        this.damagedCar = damagedCar;
    }
    public  List<String> repairs= new ArrayList<String>();


    public Car() {
    }

    public void showRepairs(){
        if(!this.repairs.isEmpty()){
            for(int i =0;i<repairs.size()+2;i+=3){
                System.out.println(repairs.get(i)+"  "+repairs.get(i+1)+"  "+repairs.get(i+2));
            }
        }else{
            System.out.println("samochód nie posiada histori serwisowej");
        }

    }


    public void setEuropalletes(int europalletes) {
        this.europalletes = europalletes;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setDamagedBreaks(Boolean damagedBreaks) {
        this.damagedBreaks = damagedBreaks;
    }

    public void setDamagedSuspension(Boolean damagedSuspension) {
        this.damagedSuspension = damagedSuspension;
    }

    public void setDamagedEngine(Boolean damagedEngine) {
        this.damagedEngine = damagedEngine;
    }

    public void setDamagedBody(Boolean damagedBody) {
        this.damagedBody = damagedBody;
    }

    public void setDamagedTransmission(Boolean damagedTransmission) {
        this.damagedTransmission = damagedTransmission;
    }

    public String getBrand() {
        return brand;
    }

    public Boolean getDamagedCar() {
        return damagedCar;
    }

    public Boolean getDamagedBreaks() {
        return damagedBreaks;
    }

    public Boolean getDamagedSuspension() {
        return damagedSuspension;
    }

    public Boolean getDamagedEngine() {
        return damagedEngine;
    }

    public Boolean getDamagedBody() {
        return damagedBody;
    }

    public Boolean getDamagedTransmission() {
        return damagedTransmission;
    }

    public double getPrice() {
        return price;
    }

    public double getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        if(this.type=="dostawczy"){
            return "Car: " +
                    "brand='" + brand + '\'' +
                    ", color='" + color + '\'' +
                    ", segment='" + segment + '\'' +
                    ", type='" + type + '\'' +
                    ", europalletes=" + europalletes +
                    ", price=" + price +
                    ", damagedCar=" + damagedCar+
            ", damagedBreaks=" + damagedBreaks +
                    ", damagedSuspension=" + damagedSuspension +
                    ", damagedEngine=" + damagedEngine +
                    ", damagedBody=" + damagedBody +
                    ", damagedTransmission=" + damagedTransmission
                    ;


        }
        return "Car: " +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", segment='" + segment + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", damagedCar=" + damagedCar+
        ", damagedBreaks=" + damagedBreaks +
                ", damagedSuspension=" + damagedSuspension +
                ", damagedEngine=" + damagedEngine +
                ", damagedBody=" + damagedBody +
                ", damagedTransmission=" + damagedTransmission
                ;


    }

    public String toStringSimple(){



        if(this.type=="dostawczy"){
            return "Car: " +
                    "brand='" + brand + '\'' +
                    ", color='" + color + '\'' +
                    ", segment='" + segment + '\'' +
                    ", type='" + type + '\'' +
                    ", europalletes=" + europalletes +
                    ", price=" + price +
                    ", damagedCar=" + damagedCar
                    ;


        }
        return "Car: " +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", segment='" + segment + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", damagedCar=" + damagedCar
                ;

    }

    public String toStringRepairWashing(){

        return "Car: " +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", segment='" + segment + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", damagedCar=" + damagedCar
                ;

    }





}
