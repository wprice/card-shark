package org.test.cardshark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
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

  public static List<Card> sortCards(final List<Card> cards, Comparator<Card> comparator) {
    return cards.stream().sorted(comparator).collect(Collectors.toList());
  }

}
