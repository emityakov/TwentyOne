public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Card(Card card){
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }


    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue(){
        return rank.value;
    }


    @Override
    public String toString() {
        return String.format("%s%s", rank.name, suit.symbol);
    }

    public enum Rank {
        Six("6", 6), Seven("7", 7), Eight("8", 8), Nine("9", 9),
        Ten("10", 10), Jack("J", 2), Queen("Q", 3), King("K", 4), Ace("A", 11);

        private final String name;
        private final int value;

        Rank(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }

    public enum Suit {
        Hearts('♥'), Clubs('♣'), Spades('♠'), Diamonds('♦');

        private final char symbol;

        Suit(char symbol){
            this.symbol = symbol;
        }
    }






}