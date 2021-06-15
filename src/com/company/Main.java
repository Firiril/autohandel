package com.company;




import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        GameEngine gameEngine = new GameEngine();
        Mechanic janusz = new Mechanic("Janusz", 0.0, 100, 0, 1.2);
        Mechanic marian = new Mechanic("Marian", 0.0, 90, 0, 0.9);
        Mechanic adrian = new Mechanic("Adrian", 0.0, 80, 2, 0.65);
        gameEngine.createCar(10);
        gameEngine.createCustomer(8);

        double startingMoney = 100000.0;
        Player player = new Player("Marcin", startingMoney);





        Scanner scanner = new Scanner(System.in);

        while (player.getMoney() < startingMoney * 2) {
            System.out.println("Aktualna tura: "+player.moves);
            gameEngine.mainMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    gameEngine.showCarsAvailableToBuy();
                    break;
                }
                case 2: {
                    gameEngine.showCarsAvailableToBuy();
                    System.out.println("Kupuje samochód nr: ");
                    int choice2 = scanner.nextInt();
                    player.buyCar(gameEngine, choice2);
                    player.moves++;
                    gameEngine.createCar(3);
                    break;

                }
                case 3: {
                    System.out.println("Twoje samochody do sprzedania: ");
                    player.showCars();
                    break;
                }
                case 4: {
                             System.out.println("Wybierz mechanika: ");
                                System.out.println("1. Janusz ");
                                System.out.println("2. Marian");
                                System.out.println("3. Adrian ");
                                player.moves++;
                                        int choice2 = scanner.nextInt();
                                switch (choice2){
                                    case 1:{
                                        janusz.chooseThingToRepair(player,janusz,marian,adrian);
                                        break;
                                    }
                                    case 2:{
                                        marian.chooseThingToRepair(player,janusz,marian,adrian);
                                        break;
                                    }
                                    case 3:{
                                        adrian.chooseThingToRepair(player,janusz,marian,adrian);
                                        break;
                                    }
                                }

                                break;
                        }
                        case 5: {
                            System.out.println("Potencjalni klienci: ");
                            gameEngine.showPotentialCustomers();
                            break;


                        }
                        case 6: {
                            System.out.println("Wybierz samochod do sprzedania: ");
                            player.showCars();
                            int carID = scanner.nextInt();
                            System.out.println("Wybierz potencjalnego klienta: ");
                            gameEngine.showPotentialCustomers();
                            int customerID = scanner.nextInt();
                            System.out.println("podaj kwote za jaką chcesz sprzedać (int): ");
                            int sellPrice = scanner.nextInt();
                            if(player.sellCar(player.carsToSell.get(carID-1),gameEngine.potentialCustomers.get(customerID-1),sellPrice)){
                                System.out.println("Zapłaciłes podatek od sprzedazy auta w wysokości: "+player.carsToSell.get(carID-1).getPrice()*0.02);
                                player.setMoney(player.getMoney()-player.carsToSell.get(carID-1).getPrice()*0.02);
                                player.carsToSell.remove(carID-1);
                                gameEngine.potentialCustomers.remove(customerID-1);
                                player.setMoney(player.getMoney()+sellPrice);

                                gameEngine.createCustomer(2);

                            }
                            player.moves++;



                            break;
                        }
                        case 7: {
                            System.out.println("Wybierz rodzaj reklamy do kupna");
                            System.out.println("1.Ogłoszenie w gazecie.");
                            System.out.println("2. Reklema w internecie");
                            int choice2 = scanner.nextInt();
                            gameEngine.buyAD(player,choice2);
                            break;

                        }
                        case 8: {
                            System.out.println("twój stan konta to: "+player.getMoney());
                            break;

                        }
                        case 9: {
                            System.out.println("twoja historia tranzakcji: ");
                            player.showTransactions();
                            break;


                        } case 10: {
                            System.out.println("wybierz samochód: ");
                            player.showCars();
                                 int carID = scanner.nextInt();
                                 player.carsToSell.get(carID-1).showRepairs();
                            break;


                                    }


                        case 11: {
                            System.out.println("twoja suma wydatków: ");
                            for(int i=0;i<player.carsToSell.size();i++){
                                System.out.println(player.carsToSell.get(i).getBrand()+"  "+player.carsToSell.get(i).repairCosts+50);

                            }
                            break;

                        }

                    }
                }
        System.out.println("Przeszedłes gre w: "+player.moves+"  tur");










    }

    }