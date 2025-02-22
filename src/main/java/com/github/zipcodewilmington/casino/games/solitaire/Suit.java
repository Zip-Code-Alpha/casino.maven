package com.github.zipcodewilmington.casino.games.solitaire;


import com.github.zipcodewilmington.utils.AnsiColor;

public enum Suit {
    CLUBS("\u2663", AnsiColor.BLACK),
    SPADES("\u2660",AnsiColor.BLACK),
    HEARTS("\u2665",AnsiColor.RED),
    DIAMONDS("\u2666",AnsiColor.RED);
    private final String abbr;
    private final AnsiColor color;
    Suit(String abbr, AnsiColor color){
        this.abbr = abbr;
        this.color = color;
    }
    String getShortening(){
        return this.abbr;
    }
    public AnsiColor getColor(){
        return this.color;
    }
    int getValue(){ return this.ordinal();};

}
