public class Deck {
    Card[] cards;
    int numberOfCards;
    public Deck(){
        numberOfCards = 52;
        cards = new Card[numberOfCards];
        int pos = 0;
        for(int rank = 1; rank <= 13; rank++){
            for(int suit = 1; suit <= 4; suit++){
                cards[pos++] = new Card(rank,suit);
            }
        }
    }
    public void displayDeck(){
        for(int i = 0; i < numberOfCards; i++)
            cards[i].display();
    }
}