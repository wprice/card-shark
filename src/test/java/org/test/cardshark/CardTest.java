package org.test.cardshark;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

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

  @Test(expected = IllegalStateException.class)
  public void testInvalidMinCard() {
    Card card = new Card(Suit.SPADE, CardSharkHelper.MIN_CARD - 1);
  }

  @Test(expected = IllegalStateException.class)
  public void testInvalidMaxCard() {
    Card card = new Card(Suit.SPADE, CardSharkHelper.MAX_CARD + 1);
  }

  @Test
  public void testFaceCards() {
    Card card = CardSharkTestHelper.randomCard(true);
    assertThat(card.isFaceCard(), is(true));
    assertThat(FaceCardType.isFaceCard(card), is(true));
    assertThat(FaceCardType.isFaceCard(new Card(Suit.SPADE, 2)), is(false));

    List<Card> faceCards = IntStream.rangeClosed(0 , 4).mapToObj(value -> CardSharkTestHelper.randomCard(true)).collect(
        Collectors.toList());

    assertThat(CardSharkHelper.allFaceCards(faceCards), is(true));
  }

  @Test
  public void testCardSort() {
    List<Card> cards = CardSharkTestHelper.randomCards(5);
    assertThat(cards, not(CardSharkHelper.sortCards(cards)));
    assertThat(cards.containsAll(CardSharkHelper.sortCards(cards)), is(true));

    assertThat(CardSharkHelper
            .sortCards(cards, (o1, o2) -> o1.getSuit().getValue() - o2.getSuit().getValue()),
        is(CardSharkHelper.sortCardsBySuit(cards)));

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

  @Test
  public void testCardSuit() {
    List<Card> cards = CardSharkTestHelper.cardsOfSameSuit(3, Suit.SPADE);
    assertThat(CardSharkHelper.allSuit(Suit.SPADE, cards), is(true));
    assertThat(CardSharkHelper.allSuit(Suit.HEART, cards), not(true));
  }

  @Test
  public void testRoyalFlush(){
    List<Card> cards= CardSharkTestHelper.royalFlush(Suit.SPADE);
    assertThat(CardSharkHelper.royalFlush(cards), is(true));
  }

  @Test
  public void testStraight() {
    List<Card> cards = CardSharkTestHelper.cardsOfSuitAndSequence(Suit.SPADE, 2, 7);
    assertThat(CardSharkHelper.straight(cards), is(true));
    cards = new ArrayList<>();
    cards.add(new Card(Suit.SPADE, 4));
    cards.add(new Card(Suit.SPADE, 8));
    assertThat(CardSharkHelper.straight(cards), is(false));

  }
  @Test
  public void testFlush() {
    List<Card> cards = CardSharkTestHelper.flushOfSuit(Suit.SPADE, 4);
    CardSharkHelper.dumpCards(cards);
    assertThat(CardSharkHelper.flush(cards), is(true));
    cards.add(new Card(Suit.HEART, CardSharkTestHelper.randomCardValue()));
    assertThat(CardSharkHelper.flush(cards), is(false));
  }

  @Test
  public void testStraightFlush(){
    List<Card> cards = CardSharkTestHelper.cardsOfSuitAndSequence(Suit.SPADE, 2, 7);
    assertThat(CardSharkHelper.straightFlush(cards), is(true));
  }

  @Test
  public void testFourOfAKind() {
    List<Card> cards = CardSharkTestHelper.fourOfAKind(8);
    assertThat(CardSharkHelper.fourOfAKind(cards), is(true));
  }

}
