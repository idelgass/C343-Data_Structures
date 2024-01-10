import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MyDeckOfCards implements DeckADT {
    public ArrayList<String> cardList;

    public MyDeckOfCards()
    {
        initialize();
    }

    @Override
    public void initialize() //Why do we need this method? Just use constructor?
    {
        cardList = new ArrayList<>(Arrays.asList(
                "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS",
                "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC",
                "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH",
                "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD"));
    }

    @Override
    public String drawRandomCard()
    {
        Random rand = new Random();
        String cardToDraw = cardList.get(rand.nextInt(cardList.size()));
        cardList.remove(cardToDraw);
        return cardToDraw;
    }

    @Override
    public void shuffleDeck()
    {
        Random rand = new Random();
        for(int i = 0; i < cardList.size(); i++)
        {
            int swapIndex = i + rand.nextInt(cardList.size() - i);
            swapCards(i, swapIndex);
        }
    }
    public void swapCards(int index1, int index2) // Auxiliary function to swap two indices in cardList
    {
        String tempCard = cardList.get(index1);
        cardList.set(index1, cardList.get(index2));
        cardList.set(index2, tempCard);
    }

    @Override
    public String drawTopCardFromDeck()
    {
        String topCard = cardList.get(0);
        cardList.remove(0);
        return topCard;
    }

    @Override
    public String toString() // Converts to string so it can be printed to console
    {
        String output = "";
        for(String card : cardList) {
            if (cardList.get(0) == card) {output += card;} //only runs for first card to avoid comma being placed at start of string
            else {output += ", " + card;}
        }
        return output;
    }

    public static void main(String[] args) {
        MyDeckOfCards deck1 = new MyDeckOfCards();
        System.out.println("Deck 1: " + deck1.toString());
        System.out.println("Shuffling deck 1...");
        deck1.shuffleDeck();
        System.out.println("Deck 1: " + deck1.toString());
        System.out.println("Draw random card from deck 1: " + deck1.drawRandomCard());
        System.out.println("Deck 1: " + deck1.toString());
        System.out.println("Draw random card from deck 1: " + deck1.drawRandomCard());
        System.out.println("Deck 1: " + deck1.toString());
        System.out.println("Draw from top of deck 1: " + deck1.drawTopCardFromDeck());
        System.out.println("Deck 1: " + deck1.toString());



        MyDeckOfCards deck2 = new MyDeckOfCards();
        System.out.println("Deck 2: " + deck2.toString());
        System.out.println("Draw from top of deck 2: " + deck2.drawTopCardFromDeck());
        System.out.println("Deck 2: " + deck2.toString());
        System.out.println("Draw random card from deck 2: " + deck2.drawRandomCard());
        System.out.println("Deck 2: " + deck2.toString());
        System.out.println("Shuffling deck 2...");
        System.out.println("Deck 2: " + deck2.toString());
        System.out.println("Draw random card from deck 2: " + deck2.drawRandomCard());
        System.out.println("Deck 2: " + deck2.toString());





    }
}
