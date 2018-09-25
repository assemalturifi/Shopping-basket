package com.assem;

import java.util.Scanner;

public class Main {
    private static StockList stockList=new StockList();
    private static Basket yourBasket=new Basket("Your Basket");
    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        StockItem temp0=new StockItem("bread",2.0,100);
        StockItem temp1=new StockItem("cake",3.4,7);
        StockItem temp2=new StockItem("bmw",7000.0,2);
        StockItem temp3=new StockItem("chair",22,10);
        StockItem temp4=new StockItem("cup",1.5,200);
        StockItem temp5=new StockItem("wine",11.11,4);
        StockItem temp6=new StockItem("juice",2.50,35);
        StockItem temp7=new StockItem("phone",400.0,35);
        StockItem temp8=new StockItem("towel",2.40,80);
        StockItem temp9=new StockItem("vase",5.76,40);

        stockList.addStock(temp0);
        stockList.addStock(temp1);
        stockList.addStock(temp2);
        stockList.addStock(temp3);
        stockList.addStock(temp4);
        stockList.addStock(temp5);
        stockList.addStock(temp6);
        stockList.addStock(temp7);
        stockList.addStock(temp8);
        stockList.addStock(temp9);

        StockItem temp10=new StockItem("vase",5.76,40);

        //stockList.items().put(temp10.getName(),temp10);// you cannt do this because the Collection.unmodifiableMap from stockList class


        boolean quit=false;
        int choice=0;
        printOptions();
        while(!quit){
            System.out.println("Enter your choice: ");
            choice=scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printOptions();
                    break;
                case 1:
                    System.out.println(stockList);
                    break;
                case 2:
                    addToBasket();
                    break;
                case 3:
                    checkYourbasket();
                    break;
                case 4:
                    System.out.println(stockList.priceList());
                    break;
                case 5:
                    System.out.println(stockList.priceItemInserTion());
                    break;
                case 6:
                    quit=true;
                    break;
            }
        }
    }
    public static int sellItem(Basket basket,String item,int quantity){
        StockItem stockItem=stockList.get(item);

        if(stockList.sellStock(item,quantity)!=0){
            basket.addToBasket(stockItem,quantity);
            return quantity;
        }
        return 0;
    }
    public static void addToBasket(){
        System.out.println("Enter an item to add to your basket: ");
        String item=scanner.nextLine().toLowerCase();

        StockItem stockItem=stockList.get(item);
        if(stockItem==null){
            System.out.println("We dont sell "+item);
        }
        else {
            System.out.println("Enter the quantity that you want to purchase: ");
            int quantity = scanner.nextInt();

            if (quantity <= stockList.get(item).availableQuantity()) {
                sellItem(yourBasket, item, quantity);
                System.out.println(yourBasket);
            } else {
                System.out.println("There is no enough quantity");
            }
        }
    }
    public static void checkYourbasket(){
        System.out.println(yourBasket);
    }
    public static void printOptions() {
        System.out.println("Available actions:\npress any of the actions below: ");
        System.out.println("0 - TO print menu options\n" +
                "1 - TO see the items, their stocks and their prices in insertion order\n" +
                "2 - TO add an item to your basket\n"+
                "3 - TO check your basket\n"+
                "4 - TO get the list of items in ascending order\n"+
                "5 - TO get the list in price ascending order\n"+
                "6 - TO quit");

    }
}
