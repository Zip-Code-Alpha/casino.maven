package com.github.zipcodewilmington.casino.games.solitaire;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
public class SolitaireGame implements GameInterface {
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
                console.println(printGame());
                String input = player.play();
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
}
