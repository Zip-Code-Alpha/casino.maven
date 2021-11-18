package com.github.zipcodewilmington.casino.games.solitaire;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Deck;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import java.util.ArrayList;
import java.util.List;
public class SolitaireGame implements GameInterface {
    private Deck deck;
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
        if(!players.isEmpty()){
            this.launchSequence();

        }

    }
    public void launchSequence(){
        this.deck = new Deck();
        deck.shuffle();
        //SolitaireStackSeptet
        //the remainder of the deck which will prob
    }
}
