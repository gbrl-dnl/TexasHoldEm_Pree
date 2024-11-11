package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

import TexasHoldEm.Hand;
import TexasHoldEm.HandVal;
import static TexasHoldEm.Main.loadTestData;

public class HandTest {

    private static Map<HandVal, List<String>> testData;
    private static final String RESULT_FILE = "test-results-JUnit.txt";

    @BeforeAll
    public static void setUp() {
        testData = loadTestData();
        try {
            Files.write(Paths.get(RESULT_FILE), "".getBytes()); // Clear the file before writing
        } catch (IOException e) {
            System.err.println("Error clearing result file: " + e.getMessage());
        }
    }

    @Test
    public void testHighCardHands() {
        testHandsForValue(HandVal.HIGH_CARD);
    }

    @Test
    public void testPairHands() {
        testHandsForValue(HandVal.PAIR);
    }

    @Test
    public void testTwoPairsHands() {
        testHandsForValue(HandVal.TWO_PAIRS);
    }

    @Test
    public void testThreeOfAKindHands() {
        testHandsForValue(HandVal.THREE_OF_A_KIND);
    }

    @Test
    public void testStraightHands() {
        testHandsForValue(HandVal.STRAIGHT);
    }

    @Test
    public void testFlushHands() {
        testHandsForValue(HandVal.FLUSH);
    }

    @Test
    public void testFullHouseHands() {
        testHandsForValue(HandVal.FULL_HOUSE);
    }

    @Test
    public void testPoker() {
        testHandsForValue(HandVal.POKER);
    }

    @Test
    public void testStraightFlushHands() {
        testHandsForValue(HandVal.STRAIGHT_FLUSH);
    }

    @Test
    public void testRoyalFlushHands() {
        testHandsForValue(HandVal.ROYAL_FLUSH);
    }

    private void testHandsForValue(HandVal handVal) {
        List<String> hands = testData.get(handVal);
        if (hands != null) {
            for (String handDesc : hands) {
                boolean result = handVal.equals(new Hand(handDesc).calcHandValue());
                String log = "Test " + (result ? "passed" : "failed") + " for hand: " + handDesc + " Should be: " + handVal + "\n";
                try {
                    Files.write(Paths.get(RESULT_FILE), log.getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    System.err.println("Error writing to result file: " + e.getMessage());
                }
                assertEquals(handVal, new Hand(handDesc).calcHandValue(), log);
            }
        }
    }
}