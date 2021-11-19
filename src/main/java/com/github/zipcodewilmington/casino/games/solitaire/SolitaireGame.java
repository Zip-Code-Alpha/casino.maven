package com.github.zipcodewilmington.casino.games.solitaire;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
public class SolitaireGame implements GameInterface {
    private static final String PROMPT = "Available Commands: DRAW,RESET,EXIT,and \"x:y\" where x can be ta,b fa or TALON and y" +
            " can be fa or ta\n\t-x\n\t\t-ta,b = t is short for Tableu (the 7 stacks of cards at the bottom), a is the index of the Tableu(1-7 inclusive), and b is the number of" +
            " cards in the sequence you want to omit(0inclusive - (length of sequence)non-inclusive)\n\t\t" +
            "-fa = f is short for Foundation (the 4 initially empty stacks of cards), a is the index of the foundation (1-4 inclusive)\n\t\t" +
            "-TALON is the name given to the cards most immediately drawn from the draw pile\n" +
            "The colon represents a directional operator specifying where you want to put your selection (x goes to y)\n" +
            "\t-y\n\t\t-ta = tableu and index(you may place your selection only on the the top of a destination tableu stack)\n\t\t" +
            "-fa = foundation and index";
    private Deck deck;
    private Stock stock;
    private Talon talon;
    private Tableu tableu;
    private Foundations foundations;
    private final IOConsole console = new IOConsole(AnsiColor.WHITE);
    //add multiplayer functionality
    private PlayerInterface player;
    public SolitaireGame(){
    }

    @Override
    public void add(PlayerInterface player) {
        this.player = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.player = null;
    }

    @Override
    public void run() {
        if(player == null) {
            this.launchSequence();
            int i = 0;
            while(!this.foundations.areAllFoundationsFull()) {
                console.println(PROMPT);
                console.println(printGame());
                //ex command c1,2: c2
                List<String> input = player.play();
                if(!takeInput(input)){
                    console.println("INVALID COMMAND");
                }
            }
        }
        else{
                System.out.println("Players is empty");
        }
    }
    private String printGame() {
        //and prompt?
        return null;
    }
    private void launchSequence(){
        this.deck = new Deck();
        this.deck.shuffle();
        this.tableu = new Tableu(deck);
        this.foundations = new Foundations();
        this.talon = new Talon();
        this.stock = new Stock(deck);
    }
    private boolean takeInput(List<String> input){
        return false;
    }
}
