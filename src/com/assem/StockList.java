package com.assem;

import java.util.*;

public class StockList {
    private Map<String,StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();//to maintain insertion order, for Treemap=ascending order
    }
    public int addStock(StockItem item){
        if(item!=null){
            StockItem inStock=list.get(item.getName());
            if(inStock!=null){
                item.adjustStock(inStock.availableQuantity());
            }
            list.put(item.getName(),item);
            return item.availableQuantity();
        }
        return 0;
    }
    public int sellStock(String item,int quantity){
        StockItem inStock=list.get(item);

        if((inStock!=null)&&(inStock.availableQuantity()>=quantity)&&(quantity>0)){
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }
    public StockItem get(String key){
        return list.get(key);
    }
    public Map<String,Double>priceList(){//to give the list in ascending order
        Map<String,Double>price=new TreeMap<>();
        for(Map.Entry<String,StockItem>item:list.entrySet()){
            price.put(item.getKey(),item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(price);
    }
    public Map<Double,String>priceItemInserTion(){//to give the list in price ascending order
        Map<Double,String>price=new TreeMap<>();
        for(Map.Entry<String,StockItem>item:list.entrySet()){
            price.put(item.getValue().getPrice(),item.getKey());
        }
        return Collections.unmodifiableMap(price);
    }
    public Map<String, StockItem>items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s="\nStock List:\n";
        double totalCost=0.0;
        for(Map.Entry<String,StockItem>item:list.entrySet()){//iterating through the map
            StockItem stockItem=item.getValue();//gonna return single item

            double itemValue=stockItem.getPrice()*stockItem.availableQuantity();
            s=s+stockItem+". There are "+stockItem.availableQuantity()+" in stock.\n";
        }
        return s;
    }
}
