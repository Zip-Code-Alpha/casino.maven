package com.github.zipcodewilmington.casino.games.solitaire;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.Console;

public class SolitairePlayer implements PlayerInterface {
    CasinoAccount casinoAccount;
    private E e;
    private final IOConsole console = new IOConsole(AnsiColor.GREEN);
    public SolitairePlayer(CasinoAccount casinoAccount){
        this.casinoAccount = casinoAccount;
    }
    @Override
    public CasinoAccount getArcadeAccount() {
        return this.casinoAccount;
    }

    @Override
    public <E> E play() {
        String input = console.getStringInput("What's your next move?").toUpperCase();
        String[] splitter = input.split(" ");
        if(splitter[1].equals("TO")){
            if(splitter[0].charAt(0) == 'F'){
                return null;
            }
            return null;
        }
        return null;
    }
}
