import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;

public class Hand {

    private final ArrayList<Card> cards = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        //создаем итератор
        Iterator iterator = this.cards.iterator();

        //проходим по коллекции
        while(iterator.hasNext()) {
            Card card = (Card)iterator.next();
            result.append(card).append(" ");
        }
        return result.toString();
    }

    public int scoreCount(){

        //переменная для подсчета количества тузов и текущего общего значения
        int score = 0;
        int aces = 0;

        //создаем итератор
        Iterator<Card> i = cards.iterator();
        //для каждой карты на руках
        while (i.hasNext()){
            Card card = i.next();
            //добавляем значение карты к количеству очков
            score += card.getValue();
            //Сколько тузов было добавлено
            if (card.getValue() == 11){
                aces++;
            }
        }

        //если у нас есть сценарий, в котором у нас есть несколько тузов, как, например, в случае вытягивания 10, за которыми следуют два или более туза (10+11+1 > 21)
        //вернитесь и установите каждый туз на 1, пока не станет меньше 21, если это возможно
        if (score > 21 && aces > 0){
            while(aces > 0 && score > 21){
                aces --;
                score -= 10;
            }
        }
        return score;
    }

    public void takeCardFromDesc(Deck deck){
        cards.add(deck.takeCard());
    }

    public void clearHand(){
        cards.clear();
    }
}