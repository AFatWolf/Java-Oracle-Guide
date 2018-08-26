// 26/08/2018
public class Deck {
    Card[] cards;
    private static final int NUMBER_OF_CARDS = 52;
    Deck(){
        cards = new Card[NUMBER_OF_CARDS];
        int index = 0; // index for the deck
        for(Card.Rank rank: Card.Rank.values())
            for(Card.Suit suit: Card.Suit.values()){
                cards[index++] = new Card(rank,suit);
            }
    }

    public void display(){
        for(int i = 0; i < NUMBER_OF_CARDS; i++){
            cards[i].display();
        }
    }

    public static void main(String[] args){
        Deck deck = new Deck();
        deck.display();
    }
}