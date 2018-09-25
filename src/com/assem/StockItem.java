package com.assem;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private  double price;
    private int quantityInStock;

    public StockItem(String name,double price) {
        this.name = name;
        this.price=price;
        this.quantityInStock =0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityInStock;
    }

    public void setPrice(double price){
        if(price>0.0){
            this.price=price;
        }
    }
    public void adjustStock(int quantity){
        int newQuantity=this.quantityInStock +quantity;
        if(newQuantity>=0){
            this.quantityInStock =newQuantity;
        }
    }
    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equls");
        if(obj==this){
            return true;
        }
        if((obj==null)||(obj.getClass()!=this.getClass())){
            return false;
        }
        String objName=((StockItem)obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+31;//can be any number
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if(this==o){
            return 0;
        }
        if(o!=null){
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }
    @Override
    public String toString() {
        return this.name+": price €"+this.price;
    }
}
