package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.solitaire.Card;
import com.github.zipcodewilmington.casino.games.solitaire.Rank;
import com.github.zipcodewilmington.casino.games.solitaire.Suit;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TalonTest {
    @Test
    public void testAccept(){}
    @Test
    public void testCard(){
        Card immigrant = new Card(Rank.TEN,Suit.SPADES);
        Card destiny = new Card(Rank.JACK,Suit.HEARTS);
        Assertions.assertEquals(destiny.getRank().getValue(),immigrant.getRank().getValue() + 1);
        Assert.assertNotEquals(destiny.getSuit().getColor(),immigrant.getSuit().getColor());
    }
}
