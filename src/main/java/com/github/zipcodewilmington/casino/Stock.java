package com.github.zipcodewilmington.casino;

import java.util.LinkedList;

public class Stock {
    LinkedList<Card> stockStack;
    public Stock(Deck deck){
        this.stockStack = deck.getDeck();
    }
    public Card draw(){
        return stockStack.pop();
    }
    public boolean acceptTalon(LinkedList<Card> talon){
        if(!this.stockStack.isEmpty()){
            System.out.println("stack is not empty");
            return false;
        }
        else{
            this.stockStack = talon;
            return true;
        }
    }
    public boolean isEmpty(){
        return stockStack.size() == 0;
    }
    public int getSize(){
        return stockStack.size();
    }
    //toString of this should be the card back; except if its empty
}
