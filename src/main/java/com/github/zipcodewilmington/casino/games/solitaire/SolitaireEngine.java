package com.github.zipcodewilmington.casino.games.solitaire;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.*;

public class SolitaireEngine {
    private CasinoAccount casino;
    private SolitairePlayer player;
    private SolitaireGame game;
    private Deck deck;
    private Stock stock;
    private Talon talon;
    private Tableu tableu;
    private Foundations foundations;
    public SolitaireEngine(CasinoAccount casino,SolitairePlayer player, SolitaireGame game){
        launchSequence();
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
