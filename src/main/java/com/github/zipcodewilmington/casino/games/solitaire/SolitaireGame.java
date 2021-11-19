package com.github.zipcodewilmington.casino.games.solitaire;

import com.github.zipcodewilmington.casino.*;

import java.util.ArrayList;
import java.util.List;
public class SolitaireGame implements GameInterface {
    private Deck deck;
    private Stock stock;
    private Talon talon;
    private Tableu tableu;
    private Foundations foundations;
    //add multiplayer functionality
    private List<PlayerInterface> players;
    public SolitaireGame(){
        players = new ArrayList<>();
    }

    @Override
    public void add(PlayerInterface player) {
        players.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        players.remove(player);
    }

    @Override
    public void run() {
        /**
        if(!players.isEmpty()){
            this.launchSequence();
        }
         */

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
