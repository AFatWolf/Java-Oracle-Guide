public class Card {
    private int rank;
    private int suit;
    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    private static final int ACE = 1;
    // suit
    private static final int HEART = 1;
    private static final int SPADES = 2;
    private static final int CLUBS = 3;
    private static final int DIAMONDS = 4;
    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }
    public void display(){
        String rankInString;
        String suitInString;
        switch(rank){
            case(JACK):
                rankInString = "Jack";
                break;
            case(QUEEN):
                rankInString = "Queen";
                break;
            case(KING):
                rankInString = "King";
                break;
            case(ACE):
                rankInString = "Ace";
                break;
            default:
                rankInString = Integer.toString(rank);
                break;
        }
        switch(suit){
            case(HEART):
                suitInString = "Heart";
                break;
            case(SPADES):
                suitInString = "Spades";
                break;
            case(CLUBS):
                suitInString = "Clubs";
                break;
            case(DIAMONDS):
                suitInString = "Diamonds";
                break;
            default:
                suitInString = "Not Found";
                break;
        }
        System.out.println("The rank is: " + rankInString + ". The suit is: " + suitInString);
    }
}