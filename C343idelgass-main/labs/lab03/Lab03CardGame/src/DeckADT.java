public interface DeckADT {
    // create a full set of cards (with 52 cards; no Jokers)
    public void initialize();

    // draw a random card, and return the card as a string. For example "2S" is the 2 of Spades
    // A = Ace, 2-10, J = Jack, Q = Queen, K = King, S = Spades, C = Clubs, H = Hearts, D = Diamonds
    public String drawRandomCard();

    //TODO: Add 2 more methods of your choosing
    // drawTopCardFromDeck(), shuffleDeck(), pushCardOnTopOfDeck(), pushCardOnBottomOfDeck() (or a new one you create)
    public void shuffleDeck();
    public String drawTopCardFromDeck();
}
