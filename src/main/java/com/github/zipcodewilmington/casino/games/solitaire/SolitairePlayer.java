package com.github.zipcodewilmington.casino.games.solitaire;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.Console;

public class SolitairePlayer implements PlayerInterface {
    CasinoAccount casinoAccount;
    private final IOConsole console = new IOConsole(AnsiColor.GREEN);
    public SolitairePlayer(CasinoAccount casinoAccount){
        this.casinoAccount = casinoAccount;
    }
    @Override
    public CasinoAccount getArcadeAccount() {
        return this.casinoAccount;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        String input = console.getStringInput("What's your next move?");
        return null;
    }
}
