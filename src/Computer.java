public class Computer extends Player{

    public Computer(Hand hand, String name) {
        super(hand, name);
    }

    @Override
    public void decision(Deck deck) {
        while(this.getHand().scoreCount() < 17){
            this.takeCard(deck);
        }
    }
}

