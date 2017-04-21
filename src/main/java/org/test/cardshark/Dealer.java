package org.test.cardshark;

/**
 * Created by wprice on 4/21/17.
 */
public interface Dealer {

    Deck shuffle(Deck deck);
    Deck shuffle();
    Deck shuffle(int decks);
    Card deal();
}
