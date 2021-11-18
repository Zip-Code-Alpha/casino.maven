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
    public void acceptTalon(LinkedList<Card> talon){
        if(!this.stockStack.isEmpty()){
            System.out.println("stack is not empty");
        }
        else{
            this.stockStack = talon;
        }
    }
    //toString of this should be the card back; except if its empty
}
