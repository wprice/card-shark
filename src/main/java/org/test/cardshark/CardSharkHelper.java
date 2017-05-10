package org.test.cardshark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wprice on 5/7/17.
 */
public class CardSharkHelper {

  public static int MIN_CARD = 2;
  public static int MAX_CARD = 14;

  private static final Logger logger = LoggerFactory.getLogger(CardSharkHelper.class);

  /**
   * Log cards to logger for convenience
   *
   * @param cards the list of cards
   *
   * @see Card
   */
  public static void logCards(final List<Card> cards) {
    cards.forEach(card -> logger.debug("{}", card.toString()));
  }

  public static void dumpCards(final List<Card> cards) {
    cards.forEach(System.out::println);
  }

  public static List<Card> sortCards(final List<Card> cards) {
    return sortCards(cards, Comparator.comparingInt(Card::getValue));
  }

  public static List<Card> sortCardsBySuit(final List<Card> cards) {
    return sortCards(cards, Comparator.comparingInt(o -> o.getSuit().getValue()));
  }

  public static List<Card> sortCards(final List<Card> cards, final Comparator<Card> comparator) {
    return cards.stream().sorted(comparator).collect(Collectors.toList());
  }

  /**
   * Count the number of face cards in the list of cards.
   *
   * @param cards the list of cards
   * @return the count of face cards
   *
   * @see FaceCardType
   */
  public static long faceCardCount(final List<Card> cards) {
    return cardCount(cards, Card::isFaceCard);
  }

  /**
   *
   * @param cards
   * @param cardValue
   * @return
   */
  public static long cardCount(final List<Card> cards, int cardValue) {
    return cardCount(cards, card -> card.getValue() == cardValue);
  }

  public static long cardCount(final List<Card> cards, final Predicate<Card> predicate) {
    return cards.stream().filter(predicate).count();
  }

  public static HandRank rankCards(final List<Card> cards) {
    return null;
  }


}
