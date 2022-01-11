package com.github.zipcodewilmington.casino.games.solitaire;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

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

    @Override //t should have an index and a depth
    public <E> E play() {
        String input = console.getStringInput("What's your next move?").toUpperCase();
        input = input.replace("\\s",""); //removes whitespace
        //input = input.replace(";",":");
        String[] splitter = input.split(":");
        List<String> output = new ArrayList<>();
        //draw ; reset ; exit
        if(splitter[0].equals(input)){
            switch(input){
                case"DRAW": case"RESET": case"EXIT": case"D": case"R": case"E":
                    output.add(input);
                    break;
                default:
                    output.add("INVALID COMMAND");
                    break;
            }
            return (E) output;
        }
        //talon
        else if(splitter.length == 2){
            String initWord = splitter[0];
            if(initWord.equals("TALON")){
                output.add("TALON");
            }

            else if(splitter[0].charAt(0) == 'T'){
                output.add(splitter[0].substring(0,1));
                output.add(splitter[0].substring(1,2));
                String[] resplitter;
                if((resplitter = splitter[0].split(",")).length == 2){
                    output.add(resplitter[1]);
                }
            }
            else if(splitter[0].charAt(0) == 'F'){
                output.add(splitter[0].substring(0,1));
                output.add(splitter[0].substring(1,2));
                //try catch in-game for indexes of foundations and tableus game
            }
            else{
                output.add("INVALID COMMAND 2");
                return (E) output;
            }
            return (E) playTo(output,splitter[1]);
        }
        output.add("INVALID COMMAND 3");
        return (E) output;
    }
    private List<String> playTo(List<String> output,String secondWord) {
        if (secondWord.length() == 2) {
            switch (secondWord.charAt(0)) {
                case 'F':
                    output.add("F");
                    break;
                case 'T':
                    output.add("T");
                    break;
                default:
                    output.clear();
                    output.add("INVALID COMMAND");
                    return output;
            }
            output.add(secondWord.substring(1, 2));
            return output;
        }
        output.clear();
        output.add("INVALID COMMAND");
        return output;
    }
}
