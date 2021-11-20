package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.games.solitaire.SolitaireGame;
import com.github.zipcodewilmington.casino.games.solitaire.SolitairePlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class SolitaireGameTest {
    private SolitaireGame game;
    private IOConsole console = new IOConsole();
    @Before
    public void before(){
        this.game = new SolitaireGame();
        game.add(new SolitairePlayer(new CasinoAccount()));
        game.launchSequence();
    }
    @Test
    public void initTest(){
        //test if the three components exist (the tableu(which is the septet);
        // the foundation which is the four initially empty stacks
        // and the stock & waste which are the draw and put pile respectively
    }
    @Test
    public void initPrintTest(){
        before();
        draw3test();
        //stock
        //talon
        game.printGame();
        //foundations
        //tableu

    }
    public void draw3test(){
        before();
        game.takeInput(new ArrayList<>(Collections.singleton("DRAW")));
    }

}
