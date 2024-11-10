// Danieli, Gabriel

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main class to test the Hand class
 */
public class Main {
    public static void main(String[] args) {
        Map<HandVal, List<String>> testData = loadTestData();
        for (HandVal handVal : testData.keySet()) {
            for (String handDesc : testData.get(handVal)) {
                if (!testHand(handDesc, handVal)) {
                    System.out.println("Test failed for hand: " + handDesc + " - Expected: " + handVal);
                }
            }
        }
    }

    /**
     * Test a hand
     *
     * @param handDesc the hand description as string
     * @param expectedHandVal the expected hand value
     * @return true if the hand value is as expected
     */
    static boolean testHand(String handDesc, HandVal expectedHandVal) {
        Hand hand = new Hand(handDesc);
        return hand.getHandValue() == expectedHandVal;
    }

    /**
     * Load handVals and Hands from "Hands to be tested.txt" and store them in a HashMap
     * with handVal as key and a list of Strings representing hands as value
     *
     * @return the HashMap
     */
    static Map<HandVal, List<String>> loadTestData() {
        Map<HandVal, List<String>> hands = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("./Hands to be tested.txt"));
            HandVal handVal = null;
            List<String> handList = new ArrayList<>();
            for (String line : lines) {
                if (line.startsWith("//")) {
                    handVal = HandVal.valueOf(line.substring(3));
                    handList = new ArrayList<>();
                } else if (line.isEmpty()) {
                    hands.put(handVal, handList);
                    handVal = null;
                } else {
                    handList.add(line.substring(1, line.length()-1));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return hands;
    }


}