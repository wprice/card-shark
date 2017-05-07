package org.test.cardshark;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import java.util.Stack;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Created by wprice on 4/21/17.
 */
public class CardTest {


  @Test
  public void testCard() {
    Card card = new Card(Suit.CLUB, 10);
    assertThat(card.getSuit(), is(Suit.CLUB));
    assertThat(card.getValue(), is(10));
    assertThat(card.isFaceCard(), is(false));
  }

  @Test
  public void testRandomCard() {

    PodamFactoryImpl factory = new PodamFactoryImpl();
    Card random = factory.manufacturePojoWithFullData(Card.class);
    CardSharkTestHelper.typeComplies(random);
  }

  @Test
  public void testFaceCards() {
    Card card = new Card(Suit.HEART, 1);
    assertThat(card.isFaceCard(), is(true));
  }

  @Test
  public void testCardStack() {
    Card card = new Card(Suit.HEART, 1);
    Stack<Card> cards = new Stack<>();
    cards.push(card);
    card = new Card(Suit.HEART, 1);
    cards.push(card);
    System.out.println(cards.size());

  }
}
