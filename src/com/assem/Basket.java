package com.assem;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private final Map<StockItem,Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBasket(StockItem item,int quantity){
        if((item!=null)&(quantity>0)){
            int inBasket=list.getOrDefault(item,0);
            list.put(item,inBasket+quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer>item(){
        return Collections.unmodifiableMap(list);
    }
    public String toString(){
        String s=name+"'s shopping basket contains "+list.size()+((list.size()==1)?" item":" items")+"\n";
        double totalCost=0.0;
        for(Map.Entry<StockItem,Integer>item:list.entrySet()){
            s=s+item.getKey()+". "+item.getValue()+" purchased\n";
            totalCost+=item.getKey().getPrice()*item.getValue();
        }
        return s+"Total cost: €"+totalCost;
    }
}