package org.test.cardshark;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
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
    assertThat(card, equalTo(Card.cardWithValues(card.getSuit(), card.getValue())));
    CardSharkTestHelper.typeComplies(card);
  }

  @Test
  public void testRandomCard() {
    CardSharkTestHelper.typeComplies(CardSharkTestHelper.randomCard());
  }

  @Test
  public void testFaceCards() {
    Card card = CardSharkTestHelper.randomCard(true);
    assertThat(card.isFaceCard(), is(true));
    assertThat(FaceCardType.isFaceCard(card), is(true));
    CardSharkTestHelper.typeComplies(card);
  }

  @Test
  public void testCardStack() {
    Card card = new Card(Suit.HEART, 1);
    Stack<Card> cards = new Stack<>();
    cards.push(card);
    card = new Card(Suit.HEART, 1);
    cards.push(card);
    assertThat(cards.size(), is(2));
    cards.push(card);
  }

  @Test
  public void testCardSort() {
    List<Card> cards = CardSharkTestHelper.randomCards(5);
    List<Card> sorted = CardSharkHelper.sortCards(cards);
    assertThat(cards, not(CardSharkHelper.sortCards(cards)));
    assertThat(cards.containsAll(CardSharkHelper.sortCards(cards)), is(true));
    sorted = CardSharkHelper.sortCards(cards, (o1, o2) -> o1.getSuit().getValue() - o2.getSuit().getValue());
    assertThat(sorted, is(CardSharkHelper.sortCardsBySuit(cards)));

  }

  @Test
  public void testFaceCardCount() {
    List<Card> cards = new ArrayList<>();
    cards.add(new Card(Suit.SPADE, FaceCardType.ACE.getValue()));
    assertThat(CardSharkHelper.faceCardCount(cards), is(1L));
    assertThat(CardSharkHelper.cardCount(cards, FaceCardType.ACE.getValue()), is(1L));
  }

  @Test
  public void testCardCount() {

    List<Card> cards = CardSharkTestHelper.randomCards(7);
    Map<Integer, Long> cardMap = cards.stream().collect(Collectors.groupingBy(o -> o.getValue(), Collectors.counting()));

  }
}
