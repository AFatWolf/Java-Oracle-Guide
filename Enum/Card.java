public class Card {
    public static enum Rank {
        TWO     (2),
        THREE   (3),
        FOUR    (4),
        FIVE    (5),
        SIX     (6),
        SEVEN   (7),
        EIGHT   (8),
        NINE    (9),
        TEN     (10),
        JACK    (11),
        QUEEN   (12),
        KING    (13),
        ACE     (1);

        private final int value;
        Rank(int value){
            this.value = value;
        }
    }

    public static enum Suit{
        HEART   (1),
        DIAMONDS(2),
        CLUBS   (3),
        SPADES  (4);

        private final int value;

        Suit(int value){
            this.value = value;
        }
    }

    Rank rank;
    Suit suit;
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public void display() {
        String rankToString = rank.toString();
        String suitToString = suit.toString();
        System.out.println("This card is " + rankToString + " " + suitToString);
    }
}