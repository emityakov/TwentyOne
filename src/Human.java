import java.util.Scanner;

public class Human extends Player {
    Scanner input = new Scanner(System.in);
    //счет игрока
    private double amount;

    public Human(Hand hand, String name, int amount) {
        super(hand, name);
        this.amount = amount;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        if(amount < 0){
            this.amount = 0;
        }
        else{
            this.amount = amount;
        }
    }

    @Override
    public void decision(Deck deck) {
        int decision = 0;
        boolean getNum = true;

        while(getNum){

            try{
                System.out.println("Ваш ход. Введите: (1) взять карту (2) не брать карту");
                decision = input.nextInt();
                getNum = false;

            }
            catch(Exception e){
                System.out.println("Ошибка");
                input.next();
            }

        }

        //если вы решили взять еще
        if (decision == 1) {
            //берем карту из колоды
            this.takeCard(deck);
            //завершаем метод, если у нас перебор или 21 очко
            if(this.getHand().scoreCount() > 20){
                return;
            }
            //если нет 21 очка или перебора запускаем метод рекурсивно
            else{
                this.decision(deck);
            }
            //если будет введено что=то кроме 1, будем считать, что карты больше не нужно
        } else {
            System.out.println("Вы остановились.");
        }
    }

}
