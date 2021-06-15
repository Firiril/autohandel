package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player extends Human{


    public int moves = 0;
    public List<Car> carsToSell= new ArrayList<Car>();
    public List<String> transactions = new ArrayList<String>();


    public Player(String name, double money) {
        super(name, money);
    }

    public void buyCar(Car car){
        carsToSell.add(car);
    }
    public void viewCarsToSell(){
        for(int i=0;i<carsToSell.size();i++){
            System.out.println(carsToSell.get(i).toString());
        }
    }


    public void buyCar(GameEngine gameEngine, int i ){
        if(this.getMoney()>gameEngine.carsAvailableForPlayer.get(i-1).getPrice()){
            this.carsToSell.add(gameEngine.carsAvailableForPlayer.get(i-1));
            System.out.println("Kupiłeś samochód za: "+gameEngine.carsAvailableForPlayer.get(i-1).getPrice());
            this.setMoney(getMoney()-gameEngine.carsAvailableForPlayer.get(i-1).getPrice());
            this.transactions.add("Kupno: ");
            this.transactions.add(gameEngine.carsAvailableForPlayer.get(i-1).brand);
            this.transactions.add(String.valueOf(gameEngine.carsAvailableForPlayer.get(i-1).getPrice()));
            System.out.println("Opłaciłes podatek za kupno pojazdu wysokości: "+gameEngine.carsAvailableForPlayer.get(i-1).getPrice()*0.02);
            this.setMoney(getMoney()-gameEngine.carsAvailableForPlayer.get(i-1).getPrice()*0.02);
            System.out.println("Umycie samochodu kosztowało cię: 50");
            this.setMoney(getMoney()-50.0);
            gameEngine.carsAvailableForPlayer.remove(i-1);

        }else{
            System.out.println("Nie masz tyle pieniedzy!");
        }



    }


    public void showCars(){
        if(!this.carsToSell.isEmpty())
        for(int i=0;i<this.carsToSell.size();i++){
            System.out.println(i+1+" "+this.carsToSell.get(i).toString());
        }else{
            System.out.println("Nie posiadasz nic do sprzedania");
        }

    }



    public Boolean sellCar(Car car, Customer customer, int price){

        if(car.getBrand()==customer.getBrandOfInterest1()||car.getBrand()== customer.getBrandOfInterest2())
        if(price< customer.getMoney()) {
            if(customer.getCanBuyCarWDamagedBody()==false&&car.getDamagedBody()==true){
                System.out.println("Potencjalny klient nie chce kupić tego samochodu.");
                return false;
            }else if(customer.getCanBuyCarWDamagedBreaks()==false&&car.getDamagedBreaks()==true){
                System.out.println("Potencjalny klient nie chce kupić tego samochodu.");
                return false;
            }else if(customer.getCanBuyCarWDamagedEngine()==false&&car.getDamagedEngine()==true){
                System.out.println("Potencjalny klient nie chce kupić tego samochodu.");
                return false;
            }else if(customer.getCanBuyCarWDamagedSuspension()==false&&car.getDamagedSuspension()==true){
                System.out.println("Potencjalny klient nie chce kupić tego samochodu.");
                return false;
            }else if(customer.getCanBuyCarWDamagedTransmission()==false&&car.getDamagedTransmission()==true){
                System.out.println("Potencjalny klient nie chce kupić tego samochodu.");
                return false;
            }else{
                System.out.println("Udało ci się sprzedać samochód");
                this.transactions.add("Sprzedaż: ");
                this.transactions.add(car.brand);
                this.transactions.add(String.valueOf(price));


                return true;
            }

        }else{
            System.out.println("Klient nie ma tyle pieniedzy");
            return false;
        }
        return false;

    }


    public void showTransactions(){
        if(!this.transactions.isEmpty())
        for(int i=0;i<this.transactions.size()+2;i+=3){
            System.out.println(transactions.get(i)+"--"+transactions.get(i+1)+"     "+transactions.get(i+2));
        }else{
            System.out.println("brak tranzakcji");
        }
    }






}
