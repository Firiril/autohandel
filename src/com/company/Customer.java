package com.company;

public class Customer extends Human{
    private String brandOfInterest1;
    private String brandOfInterest2;
    private String segmentOfInterest;
    private String typeOfInterest;
    private int minPalletes;
    private Boolean canBuyDamagedCar=false;
    private Boolean canBuyCarWDamagedBreaks=false;
    private Boolean canBuyCarWDamagedSuspension=false;
    private Boolean canBuyCarWDamagedEngine=false;
    private Boolean canBuyCarWDamagedBody=false;
    private Boolean canBuyCarWDamagedTransmission=false;

    public Customer(String name, double money) {
        super(name, money);
    }

    public void setMinPalletes(int minPalletes) {
        this.minPalletes = minPalletes;
    }

    public int getMinPalletes() {
        return minPalletes;
    }

    public void setBrandOfInterest1(String brandOfInterest1) {
        this.brandOfInterest1 = brandOfInterest1;
    }

    public void setBrandOfInterest2(String brandOfInterest2) {
        this.brandOfInterest2 = brandOfInterest2;
    }

    public void setSegmentOfInterest(String segmentOfInterest) {
        this.segmentOfInterest = segmentOfInterest;
    }

    public void setTypeOfInterest(String typeOfInterest) {
        this.typeOfInterest = typeOfInterest;
    }

    public void setCanBuyDamagedCar(Boolean canBuyDamagedCar) {
        this.canBuyDamagedCar = canBuyDamagedCar;
    }

    public void setCanBuyCarWDamagedBreaks(Boolean canBuyCarWDamagedBreaks) {
        this.canBuyCarWDamagedBreaks = canBuyCarWDamagedBreaks;
    }

    public void setCanBuyCarWDamagedSuspension(Boolean canBuyCarWDamagedSuspension) {
        this.canBuyCarWDamagedSuspension = canBuyCarWDamagedSuspension;
    }

    public void setCanBuyCarWDamagedEngine(Boolean canBuyCarWDamagedEngine) {
        this.canBuyCarWDamagedEngine = canBuyCarWDamagedEngine;
    }

    public void setCanBuyCarWDamagedBody(Boolean canBuyCarWDamagedBody) {
        this.canBuyCarWDamagedBody = canBuyCarWDamagedBody;
    }

    public void setCanBuyCarWDamagedTransmission(Boolean canBuyCarWDamagedTransmission) {
        this.canBuyCarWDamagedTransmission = canBuyCarWDamagedTransmission;
    }


    public String getBrandOfInterest1() {
        return brandOfInterest1;
    }

    public String getBrandOfInterest2() {
        return brandOfInterest2;
    }

    public String getSegmentOfInterest() {
        return segmentOfInterest;
    }

    public String getTypeOfInterest() {
        return typeOfInterest;
    }

    public Boolean getCanBuyDamagedCar() {
        return canBuyDamagedCar;
    }

    public Boolean getCanBuyCarWDamagedBreaks() {
        return canBuyCarWDamagedBreaks;
    }

    public Boolean getCanBuyCarWDamagedSuspension() {
        return canBuyCarWDamagedSuspension;
    }

    public Boolean getCanBuyCarWDamagedEngine() {
        return canBuyCarWDamagedEngine;
    }

    public Boolean getCanBuyCarWDamagedBody() {
        return canBuyCarWDamagedBody;
    }

    public Boolean getCanBuyCarWDamagedTransmission() {
        return canBuyCarWDamagedTransmission;
    }

    @Override
    public String toString() {
        return "Customer: " +
                "brandOfInterest1='" + brandOfInterest1 + '\'' +
                ", brandOfInterest2='" + brandOfInterest2 + '\'' +
                ", segmentOfInterest='" + segmentOfInterest + '\'' +
                ", typeOfInterest='" + typeOfInterest + '\''
                ;
    }
}
