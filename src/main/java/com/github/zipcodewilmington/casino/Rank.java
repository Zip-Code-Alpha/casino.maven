package com.github.zipcodewilmington.casino;

public enum Rank {
    ACE("A"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K");
    private final String abbr;

    Rank(String abbr) {
        this.abbr = abbr;
    }
    int getValue(){
        return this.ordinal();
    }

    String getShortening(){
        return this.abbr;
    }
}
