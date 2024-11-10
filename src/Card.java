public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Add a constructor that takes a String consisting of two characters as an argument,
    // with the suit as first character and rank as second character
    // examples: "D2"= DIAMOND-TWO, "HA"= HEART-ACE, "ST"= SPADE-TEN, "CK"= CLUB-KING
    public Card(String cardDesc) {
        cardDesc = cardDesc.toUpperCase();  // just in case the input is lowercase
        if (cardDesc.length() != 2) {
            throw new IllegalArgumentException("Invalid card description: " + cardDesc);
        }
        switch (cardDesc.charAt(0)) {
            case 'C': this.suit = Suit.CLUB; break;
            case 'D': this.suit = Suit.DIAMOND; break;
            case 'H': this.suit = Suit.HEART; break;
            case 'S': this.suit = Suit.SPADE; break;
            default:
                throw new IllegalArgumentException("Invalid suit: " + cardDesc.charAt(0));
        }
        switch (cardDesc.charAt(1)) {
            case '2': this.rank = Rank.TWO; break;
            case '3': this.rank = Rank.THREE; break;
            case '4': this.rank = Rank.FOUR; break;
            case '5': this.rank = Rank.FIVE; break;
            case '6': this.rank = Rank.SIX; break;
            case '7': this.rank = Rank.SEVEN; break;
            case '8': this.rank = Rank.EIGHT; break;
            case '9': this.rank = Rank.NINE; break;
            case 'T': this.rank = Rank.TEN; break;
            case 'J': this.rank = Rank.JACK; break;
            case 'Q': this.rank = Rank.QUEEN; break;
            case 'K': this.rank = Rank.KING; break;
            case 'A': this.rank = Rank.ACE; break;
            default:
                throw new IllegalArgumentException("Invalid rank: " + cardDesc.charAt(1));
        }
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return suit + "-" + rank;
    }
}
