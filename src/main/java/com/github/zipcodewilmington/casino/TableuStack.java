package com.github.zipcodewilmington.casino;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;

public class TableuStack {
    private NodedLinkedList<Card> showing;
    private LinkedList<Card> hidden; //stack
    public TableuStack(){
        hidden = new LinkedList<>();
        showing = new NodedLinkedList<>();
    }
    //for initialization purposes only
    public void addCard(Card adder){
        hidden.add(adder);
    }
    //flips the first card of the hidden stack if and only if the showing stack is null
    public void flipHidden(){
        if(showing.head == null &&  ! hidden.isEmpty()){
            showing.addNode(new Node<>(hidden.pop(), null));
        }
        if(hidden.isEmpty()){
            //reveal a blank space ( how to represent a blank space?)(null suit and null rank)
            //maybe I should just have both be null
            System.out.println("Adding Blank Space Implementation");
        }
        else{
            //throw a custom exception?
            System.out.println("ExceptionPlaceHolder: the showing stack is not empty");
        }
        //logger perhaps?
    }
    //pre-conditions: depth is less than length of sequence and greater than 0
    public Node<Card> emmigrateSequence(int depth){
        return showing.retrieveSubList(depth);
    }
    public void immigrateSequence(Node<Card> other){
        showing.addNode(other);
    }
}
