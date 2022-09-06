import java.util.*;

public class Deck {
    private Stack<Card> deck = new Stack();


    public Deck(){
        initDeck();
    }

    private void initDeck() {
        deck.clear();
        for(Card.Rank rank: Card.Rank.values()){
            for(Card.Suit suit: Card.Suit.values()) {
                deck.push(new Card(rank, suit));
            }
        }
    }


    public String toString(){
        //Строка для хранения всего, что мы собираемся вернуть
        StringBuilder output = new StringBuilder();

        //создаем итератор
        Iterator iterator = deck.iterator();

        //проходим по всей коллекции
        while(iterator.hasNext()) {
            Card card = (Card) iterator.next();
            output.append(card);
            output.append("\n");
        }

        return output.toString();
    }


    public void shuffle(){
        Collections.shuffle(deck, new Random());
    }

    public Card takeCard(){
        //Берем карту и удаляем ее из колоды
        Card card = new Card(deck.pop());
        return card;
    }


}
