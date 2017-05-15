package org.test.cardshark;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

  public static HandRank rank(final List<Card> cards) {

    if(royalFlush(cards)) {
      return HandRank.ROYAL_FLUSH;
    } else if(straightFlush(cards)) {
      return HandRank.STRAIGHT_FLUSH;
    } else if(straight(cards)) {
      return HandRank.STRAIGHT;
    } else if(fourOfAKind(cards)) {
      return HandRank.FOUR_OF_A_KIND;
    }

    return null;
  }

  public static boolean allFaceCards(final List<Card> cards) {
    return cards.stream().allMatch(Card::isFaceCard);
  }

  public static boolean allSuit(final Suit suit, final List<Card> cards) {
    return cards.stream().allMatch(card -> card.getSuit() == suit);
  }

  public static boolean straight(final List<Card> cards) {

    for(int i = 0; i < cards.size() -1 ; i++) {
      if(cards.get(i).getValue() + 1 != cards.get(i + 1).getValue()) {
        return false;
      }
    }
    return true;
  }
  public static boolean flush(final List<Card> cards) {

    for(Suit suit: Suit.values()) {
      if(allSuit(suit, cards)) {
        return true;
      }
    }
    return false;

  }
  public static boolean straightFlush(final List<Card> cards) {
    return straight(cards) && flush(cards);
  }
  public static boolean royalFlush(final List<Card> cards) {
    //TODO HACK,HACK,HACK
    return straight(cards) && flush(cards) && (cards.get(0).getValue() == 10);
  }

  public static boolean fourOfAKind(final List<Card> cards) {
    return true;
  }

  public static boolean threeOfAKind(final List<Card> cards) {
    Map<Integer, Long> cardMap = cards.stream().collect(Collectors.groupingBy(o -> o.getValue(), Collectors.counting()));
    return cardMap.values().stream().anyMatch(aLong -> aLong.equals(3));
  }

  private static Map<Integer, Long> occurences(final List<Card> cards) {
    return cards.stream().collect(Collectors.groupingBy(o -> o.getValue(), Collectors.counting()));
  }
}
