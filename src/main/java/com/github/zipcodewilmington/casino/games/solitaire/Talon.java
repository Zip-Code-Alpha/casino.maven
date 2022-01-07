package com.github.zipcodewilmington.casino.games.solitaire;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//3rd card is top of talon
public class Talon {
    //talon has hidden while display has displayed?
    private final LinkedList<Card> talonStack;
    private final IOConsole blackCardConsole = new IOConsole(AnsiColor.BLACK);
    private final IOConsole redCardConsole = new IOConsole(AnsiColor.RED);
    private final IOConsole talonConsole = new IOConsole(AnsiColor.PURPLE);

    private static final int MAX_AMOUNT_IN_DISPLAY_QUEUE = 3;
    private final IOConsole errorConsole = new IOConsole(AnsiColor.BLUE);
    //stack of displayed cards? which puts the rest in the talon
    private final LinkedList<Card> displayQueue;
    public Talon(){
        this.talonStack = new LinkedList<>();
        this.displayQueue = new LinkedList<>();
    }
    //how to display
    public void accept(Card card){
        if(displayQueue.size() > MAX_AMOUNT_IN_DISPLAY_QUEUE){
            errorConsole.println("overfilled display(accept)");
        }
        else if (displayQueue.size() == MAX_AMOUNT_IN_DISPLAY_QUEUE) {
            this.talonStack.push(this.displayQueue.pollLast());
        }
        this.displayQueue.push(card);
    }
    public Card preDonate(){
        if(displayQueue.size() > MAX_AMOUNT_IN_DISPLAY_QUEUE){
            errorConsole.println("overfilled display(donate)");
            return null;
        }
        else if(displayQueue.size() == 0){
            errorConsole.println("Error: Nothing to Donate");
            return null;
        }
        else{
            return displayQueue.peek();
        }
    }
    //check if able to donate in outside class
    public Card donate(){
        if(displayQueue.size() > MAX_AMOUNT_IN_DISPLAY_QUEUE){
            errorConsole.println("overfilled display(donate)");
            return null;
        }
        else if(displayQueue.size() == 0){
            errorConsole.println("Error: Nothing to Donate");
            return null;
        }
        else{
            Card donation = displayQueue.poll();
            if(!talonStack.isEmpty()){
                displayQueue.offer(talonStack.pop());
            }
            return donation;
        }
    }
    //to Stock;
    //**must be checked outside of method**
    public LinkedList<Card> toStock(){
        while(!displayQueue.isEmpty()){
            this.talonStack.push(displayQueue.pollLast());
        }
        LinkedList<Card> temp = (LinkedList<Card>) this.talonStack.clone();
        this.talonStack.clear();
        Collections.reverse(temp);

        return temp;
    }
    public void display(){

        talonConsole.print("TALON: ");
        if(this.displayQueue.isEmpty()){
            talonConsole.print("EMPTY");
        }
        //double check this
        //talonConsole.print(": ");
        printCards(this.displayQueue);

    }
    //make sure talon works as intendedt1r
    //toString of Card //call every update?
    public List<Card> getCards(){
        return this.displayQueue;
    }
    public boolean isEmpty(){
        return this.displayQueue.isEmpty();
    }
    public void printCards(List<Card>cards){
        Collections.reverse(cards);
        for(Card card: cards){
            if(!(card == null) && !((card.getSuit()) == null)){
                Suit suit = card.getSuit();
                if(suit.getColor().equals(AnsiColor.BLACK)){
                    blackCardConsole.print(card.toString());
                }
                else{
                    redCardConsole.print(card.toString());
                }
            }
        }
        Collections.reverse(cards);
        errorConsole.print("\n");
    }
    //current problem is that when stack is only 3 cards; order is reversed every time
}
