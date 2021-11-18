package com.github.zipcodewilmington.casino.games.solitaire;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class SolitairePlayer implements PlayerInterface {
    CasinoAccount casinoAccount;
    public SolitairePlayer(){}
    @Override
    public CasinoAccount getArcadeAccount() {
        return this.casinoAccount;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
