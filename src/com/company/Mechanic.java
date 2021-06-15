package com.company;

import java.util.Random;
import java.util.Scanner;


public class Mechanic extends Human{

    private int chanceOfRepair;
    private int chanceOfBreakingOtherPart;
    private double repairCostMultiplier;


    public Mechanic(String name, double money, int chanceOfRepair, int chanceOfBreakingOtherPart, double repairCostMultiplier) {
        super(name, money);
        this.chanceOfRepair = chanceOfRepair;
        this.chanceOfBreakingOtherPart = chanceOfBreakingOtherPart;
        this.repairCostMultiplier = repairCostMultiplier;
    }

    public Boolean repairEngine(Car car, Player player){
        if(!car.getDamagedEngine()){
            System.out.println("Samochód nie wymaga naprawy");
            return true;
        }
        else{
            System.out.println("Koszt naprawy jest zależny od samochodu!");
            double repairCost;
            switch (car.segment){
                case "standard":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = car.getPrice()*0.4*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa silnika");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedEngine(false);
                        car.setPrice(car.getPrice()*2);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else{
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = car.getPrice()*0.4*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
                case "premium":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = car.getPrice()*0.35*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa silnika");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedEngine(false);
                        car.setPrice(car.getPrice()*2);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else{
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = car.getPrice()*0.35*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
                case "budget":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = car.getPrice()*0.45*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa silnika");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedEngine(false);
                        car.setPrice(car.getPrice()*2);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else {
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = car.getPrice() * 0.45 * repairCostMultiplier;
                        player.setMoney(player.getMoney() - repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public Boolean repairBreaks(Car car, Player player){
        if(!car.getDamagedBreaks()){
            System.out.println("Samochód nie wymaga naprawy");
            return true;
        }
        else{
            System.out.println("Koszt naprawy jest zależny od samochodu!");
            double repairCost;
            switch (car.segment){
                case "standard":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = 1200*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa hamulców");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedBreaks(false);
                        car.setPrice(car.getPrice()+ car.getPrice()*0.1);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else{
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = 1200*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
                case "premium":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = 2800*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa hamulców");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedBreaks(false);
                        car.setPrice(car.getPrice()+ car.getPrice()*0.1);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else{
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = 2800*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
                case "budget":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = 700*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa hamulców");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedBreaks(false);
                        car.setPrice(car.getPrice()+ car.getPrice()*0.1);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else {
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = 700*repairCostMultiplier;
                        player.setMoney(player.getMoney() - repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Boolean repairBody(Car car, Player player){
        if(!car.getDamagedBody()){
            System.out.println("Samochód nie wymaga naprawy");
            return true;
        }
        else{
            System.out.println("Koszt naprawy jest zależny od samochodu!");
            double repairCost;
            switch (car.segment){
                case "standard":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = 6000*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa karoseri");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedBody(false);
                        car.setPrice(car.getPrice()+ car.getPrice()*0.5);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else{
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = 6000*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
                case "premium":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = 8000*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa karoseri");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedBody(false);
                        car.setPrice(car.getPrice()+ car.getPrice()*0.5);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else{
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = 8000*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
                case "budget":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = 3500*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa karoseri");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedBody(false);
                        car.setPrice(car.getPrice()+ car.getPrice()*0.5);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else {
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = 3500*repairCostMultiplier;
                        player.setMoney(player.getMoney() - repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
            }
        }
        return true;
    }



    public Boolean repairSuspension(Car car, Player player){
        if(!car.getDamagedSuspension()){
            System.out.println("Samochód nie wymaga naprawy");
            return true;
        }
        else{
            System.out.println("Koszt naprawy jest zależny od samochodu!");
            double repairCost;
            switch (car.segment){
                case "standard":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = 1800*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa zawieszenia");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedSuspension(false);
                        car.setPrice(car.getPrice()+ car.getPrice()*0.2);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else{
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = 1800*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
                case "premium":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = 3000*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa zawieszenia");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedSuspension(false);
                        car.setPrice(car.getPrice()+ car.getPrice()*0.2);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else{
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = 3000*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
                case "budget":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = 1200*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa zawieszenia");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedSuspension(false);
                        car.setPrice(car.getPrice()+ car.getPrice()*0.2);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else {
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = 1200*repairCostMultiplier;
                        player.setMoney(player.getMoney() - repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public Boolean repairTransmission(Car car, Player player){
        if(!car.getDamagedTransmission()){
            System.out.println("Samochód nie wymaga naprawy");
            return true;
        }
        else{
            System.out.println("Koszt naprawy jest zależny od samochodu!");
            double repairCost;
            switch (car.segment){
                case "standard":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = 6000*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa skrzyni biegów");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedTransmission(false);
                        car.setPrice(car.getPrice()+ car.getPrice()*0.5);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else{
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = 6000*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
                case "premium":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = 8000*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa skrzyni biegów");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedTransmission(false);
                        car.setPrice(car.getPrice()+ car.getPrice()*0.5);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else{
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = 8000*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
                case "budget":{
                    if(chanceOfRepair>getRandomNumberUsingNextInt(1,101)-1)
                    {
                        repairCost = 3500*repairCostMultiplier;
                        player.setMoney(player.getMoney()-repairCost);
                        breakRandomPart(car);
                        car.repairs.add(this.name);
                        car.repairs.add("Naprawa skrzyni biegów");
                        car.repairs.add(String.valueOf(repairCost));
                        car.setDamagedTransmission(false);
                        car.setPrice(car.getPrice()+ car.getPrice()*0.5);
                        car.repairCosts+=repairCost;
                        return  true;
                    }
                    else {
                        System.out.println("Naprawa nie powiodła się!");
                        System.out.println("Zostaniesz obciążony kosztami naprawy!");
                        repairCost = 3500*repairCostMultiplier;
                        player.setMoney(player.getMoney() - repairCost);
                        breakRandomPart(car);
                        car.repairCosts+=repairCost;
                        return false;
                    }
                }
            }
        }
        return true;
    }












    public void breakRandomPart(Car car){

        if(this.chanceOfBreakingOtherPart>0){
            if(this.chanceOfBreakingOtherPart>getRandomNumberUsingNextInt(1,101)-1){
                switch(getRandomNumberUsingNextInt(1,5)){
                    case 1:{
                        car.setDamagedBreaks(true);
                        System.out.println("Hamulce zostały uszkodzone podczas naprawy!");
                        break;
                    }
                    case 2:{
                        car.setDamagedEngine(true);
                        System.out.println("Silnik został uszkodzony podczas naprawy!");
                        break;
                    }
                    case 3:{
                        car.setDamagedBody(true);
                        System.out.println("Karoseria została uszkodzona podczas naprawy!");
                        break;
                    }
                    case 4:{
                        car.setDamagedSuspension(true);
                        System.out.println("Zawieszenie zostało uszkodzone podczas naprawy!");
                        break;
                    }
                    case 5:{
                        car.setDamagedTransmission(true);
                        System.out.println("Skrzynia biegów została uszkodzona podczas naprawy!");
                        break;
                    }
                }
            }
        }
        else{

        }



    }
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }



    public void chooseThingToRepair(Player player, Mechanic janusz, Mechanic marian,Mechanic adrian){

        System.out.println("Wybierz samochód");
        player.showCars();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println("Wybrałeś"+player.carsToSell.get(choice-1));
        System.out.println("Co chcesz naprawic?");
        System.out.println("1. Hamulce");
        System.out.println("2. Zawieszenie");
        System.out.println("3. Silnik");
        System.out.println("4. Karoserie");
        System.out.println("5. Skrzynia biegów");

        int choice2 = scanner.nextInt();
        switch(choice2){
            case 1:{
                if(!(repairBreaks(player.carsToSell.get(choice-1),player))){
                    System.out.println("Naprawa nie powiodła się!");
                    System.out.println("Janusz zajął się samochodem");
                    janusz.repairBreaks(player.carsToSell.get(choice-1),player);
                }

                    break;
            }
            case 2:{
                if(!(repairSuspension(player.carsToSell.get(choice-1),player))){
                    System.out.println("Naprawa nie powiodła się!");
                    System.out.println("Janusz zajął się samochodem");
                    janusz.repairSuspension(player.carsToSell.get(choice-1),player);
                }

                break;


            }
            case 3:{
                if(!(repairEngine(player.carsToSell.get(choice-1),player))){
                    System.out.println("Naprawa nie powiodła się!");
                    System.out.println("Janusz zajął się samochodem");
                    janusz.repairEngine(player.carsToSell.get(choice-1),player);
                }

                break;

            }
            case 4:{
                if(!(repairBody(player.carsToSell.get(choice-1),player))){
                    System.out.println("Naprawa nie powiodła się!");
                    System.out.println("Janusz zajął się samochodem");
                    janusz.repairBody(player.carsToSell.get(choice-1),player);
                }

                break;

            }
            case 5:{
                if(!(repairTransmission(player.carsToSell.get(choice-1),player))){
                    System.out.println("Naprawa nie powiodła się!");
                    System.out.println("Janusz zajął się samochodem");
                    janusz.repairTransmission(player.carsToSell.get(choice-1),player);
                }

                break;

            }


        }

    }



}
