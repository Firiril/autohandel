package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
public class GameEngine {

    public GameEngine() {
        loadBrands();
        loadSegments();
        loadColors();
        loadDamage();
    }

    public List<Customer> potentialCustomers = new ArrayList<Customer>();
    public List<Car> carsAvailableForPlayer = new ArrayList<>();


    private List <String>  brands = new ArrayList<String>();
    private List <String>  segments= new ArrayList<String>();
    private List <String>  colors = new ArrayList<String>();
    private List <String>  damage = new ArrayList<String>();

    public void createCustomer(int i){
        for(int k =0;k<i;k++){
           generateRandomCustomer();
        }

    }

    public void generateRandomCustomer(){

        Customer randomGeneratedCustomer = new Customer("klient",3000.0);

        randomGeneratedCustomer.setSegmentOfInterest(segments.get(getRandomNumberUsingNextInt(1,segments.size()+1)-1));
        randomGeneratedCustomer.setBrandOfInterest1(brands.get(getRandomNumberUsingNextInt(1,brands.size()+1)-1));
        randomGeneratedCustomer.setBrandOfInterest2(brands.get(getRandomNumberUsingNextInt(1,brands.size()+1)-1));


        if(getRandomNumberUsingNextInt(1,100)<20){
            randomGeneratedCustomer.setTypeOfInterest("dostawczy");
            randomGeneratedCustomer.setMinPalletes((getRandomNumberUsingNextInt(1,10)));

            switch (randomGeneratedCustomer.getSegmentOfInterest()) {

                case "standard":{
                    randomGeneratedCustomer.setMoney(getRandomNumberUsingNextInt(30000,70000));
                    break;
                }
                case "premium":{
                    randomGeneratedCustomer.setMoney(getRandomNumberUsingNextInt(35000,60000));
                    break;
                }
                case "budget":{
                    randomGeneratedCustomer.setMoney(getRandomNumberUsingNextInt(13000,28000));
                    break;
                }

            }
        }
        else{
            randomGeneratedCustomer.setTypeOfInterest("osobowy");
            switch (randomGeneratedCustomer.getSegmentOfInterest()) {

                case "standard":{
                    randomGeneratedCustomer.setMoney(getRandomNumberUsingNextInt(30000,60000));
                    break;
                }
                case "premium":{
                    randomGeneratedCustomer.setMoney(getRandomNumberUsingNextInt(40000,80000));
                    break;
                }
                case "budget":{
                    randomGeneratedCustomer.setMoney(getRandomNumberUsingNextInt(13000,25500));
                    break;
                }

            }

        }
        int damageRoll = getRandomNumberUsingNextInt(1,damage.size()+1)-1;

        if(getRandomNumberUsingNextInt(1,101)>52){
            randomGeneratedCustomer.setCanBuyDamagedCar(false);
        }else {
            randomGeneratedCustomer.setCanBuyDamagedCar(true);

            String damagedComponent = damage.get(getRandomNumberUsingNextInt(1,damage.size()+1)-1);

            switch (damagedComponent) {
                case "Breaks":{
                    randomGeneratedCustomer.setCanBuyCarWDamagedBreaks(true);
                    break;
                }
                case "Engine":{
                    randomGeneratedCustomer.setCanBuyCarWDamagedEngine(true);
                    break;
                }
                case "Transmission":{
                    randomGeneratedCustomer.setCanBuyCarWDamagedTransmission(true);
                    break;
                }
                case "Body":{
                   randomGeneratedCustomer.setCanBuyCarWDamagedBody(true);
                }
                case "Suspension":{
                    randomGeneratedCustomer.setCanBuyCarWDamagedSuspension(true);
                    break;
                }
            }
        }

        this.potentialCustomers.add(randomGeneratedCustomer);
    }

    public void createCar(int i){
        for(int k =0;k<i;k++){

          generateRandomCar();
        }

    }

    public void generateRandomCar(){

        Car randomGeneratedCar= new Car();
        randomGeneratedCar.brand= brands.get(getRandomNumberUsingNextInt(1,brands.size()+1)-1);
        randomGeneratedCar.color= colors.get(getRandomNumberUsingNextInt(1,colors.size()+1)-1);
        randomGeneratedCar.segment= segments.get(getRandomNumberUsingNextInt(1,segments.size()+1)-1);

       if(getRandomNumberUsingNextInt(1,100)<20){
           randomGeneratedCar.type="dostawczy";
           randomGeneratedCar.setEuropalletes(getRandomNumberUsingNextInt(1,10));

           switch (randomGeneratedCar.segment) {

               case "standard":{
                   randomGeneratedCar.setPrice(getRandomNumberUsingNextInt(20000,30000));
                   break;
               }
               case "premium":{
                   randomGeneratedCar.setPrice(getRandomNumberUsingNextInt(30000,45000));
                   break;
               }
               case "budget":{
                   randomGeneratedCar.setPrice(getRandomNumberUsingNextInt(7000,15500));
                   break;
               }

           }
       }
       else{
           randomGeneratedCar.type="osobowy";
           switch (randomGeneratedCar.segment) {

               case "standard":{
                   randomGeneratedCar.setPrice(getRandomNumberUsingNextInt(15000,25000));
                   break;
               }
               case "premium":{
                   randomGeneratedCar.setPrice(getRandomNumberUsingNextInt(30000,50000));
                   break;
               }
               case "budget":{
                   randomGeneratedCar.setPrice(getRandomNumberUsingNextInt(4000,13000));
                   break;
               }

           }

       }
        int damageRoll = getRandomNumberUsingNextInt(1,damage.size()+1)-1;
        for(int i =0;i<damageRoll;i++){
            randomGeneratedCar.damagedCar=true;
            String damagedComponent = damage.get(getRandomNumberUsingNextInt(1,damage.size()+1)-1);

            switch (damagedComponent) {
                case "Breaks":{
                    randomGeneratedCar.setDamagedBreaks(true);
                    break;
                }
                case "Engine":{
                    randomGeneratedCar.setDamagedEngine(true);
                    break;
                }
                case "Transmission":{
                    randomGeneratedCar.setDamagedTransmission(true);
                    break;
                }
                case "Body":{
                    randomGeneratedCar.setDamagedBody(true);
                }
                case "Suspension":{
                    randomGeneratedCar.setDamagedSuspension(true);
                    break;
                }
            }
        }

        carsAvailableForPlayer.add(randomGeneratedCar);




    }
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }




    public void buyAD(Player player, int i){
        switch (i){

            case 1:{
                if(player.getMoney()>1000){
                    createCustomer(getRandomNumberUsingNextInt(1,6));
                    System.out.println("udało ci sie kupic reklame.");
                    System.out.println("Przybyło kilku potenchalnych kupców");
                    player.setMoney(player.getMoney()-1000);

                }else{
                    System.out.printf("Nie masz pieniedzy na reklame w gazecie");

                }


            }
            case 2:{
                if(player.getMoney()>300){
                    createCustomer(1);
                    System.out.println("udało ci sie kupic reklame.");
                    System.out.println("Przybywa jeden potencjalny kupiec");
                    player.setMoney(player.getMoney()-300);

                }else{
                    System.out.printf("Nie masz pieniedzy na reklame w internecie");

                }

            }


        }

    }



public void mainMenu(){
    System.out.println("1. Przeglądaj baze samochodów do kupienia");
    System.out.println("2. Kup samochód");
    System.out.println("3. Przeglądaj posiadane samochody");
    System.out.println("4. Napraw samochód");
    System.out.println("5. Przejrzyj potencjalnych klientów");
    System.out.println("6. Sprzedaj samochód klientowi");
    System.out.println("7. Kup reklame ");
    System.out.println("8. Sprawdź stan konta");
    System.out.println("9. sprawdź historie tranzakcji");
    System.out.println("10. Sprawdź historie napraw");
    System.out.println("11. Suma wydaktów na naprawy i mycia samochodu");
}



            public void showCarsAvailableToBuy(){
                    if(!this.carsAvailableForPlayer.isEmpty())
                for(int i=0;i<this.carsAvailableForPlayer.size();i++){
                    System.out.println(i+1+" "+this.carsAvailableForPlayer.get(i).toString());
                }else{
                        System.out.println("Brak samochodów do kupna");
                    }


}
            public void showPotentialCustomers(){
                if(!this.potentialCustomers.isEmpty())
                        for(int i=0;i<this.potentialCustomers.size();i++){
                             System.out.println(i+1+" "+this.potentialCustomers.get(i).toString());
                          }else{
                    System.out.println("Brak potencjalnych klientów");
                }
            }

            public void showDamage(){
                for(int i=0;i<this.damage.size();i++){
                    System.out.println(i+1+" "+this.damage.get(i).toString());
                }

            }















    private void loadBrands(){
        brands.add("BMW");
        brands.add("Honda");
        brands.add("Toyota");
        brands.add("Suzuki");
        brands.add("Audi");
        brands.add("Mercedes");
        brands.add("Ford");
        brands.add("Fiat");
        brands.add("Volvo");
        brands.add("Citroen");

    }

    private void loadSegments(){
       segments.add("standard");
       segments.add("premium");
       segments.add("budget");
    }

    private void loadColors(){
        colors.add("niebieski");
        colors.add("czerwony");
        colors.add("czarny");
        colors.add("biały");
        colors.add("zielony");
        colors.add("szary");
    }

    public void loadDamage() {
        damage.add("Breaks");
        damage.add("Suspension");
        damage.add("Engine");
        damage.add("Body");
        damage.add("Transmission");
    }


}
