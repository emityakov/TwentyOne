public abstract class Player {
    private Hand hand;
    private String name;

    public Player(){
        this.setHand(new Hand());
        this.setName("");
    }

    public Player(Hand hand, String name) {
        this.hand = hand;
        this.name = name;
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHand(){
        System.out.println(this.name + " имеет следующие карты:");
        System.out.println(this.hand + ". Всего очков: " + this.hand.scoreCount());
    }

    public void takeCard(Deck deck){
        this.hand.takeCardFromDesc(deck);
        System.out.println(this.name + " получает карту");
        this.printHand();
    }

    public abstract void decision(Deck deck);
}
