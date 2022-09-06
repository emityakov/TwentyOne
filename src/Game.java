import java.util.Scanner;

public class Game {
    private Deck deck;
    private final Human human;
    private final Computer computer;
    Scanner input = new Scanner(System.in);

    public Game(){
        human = new Human(new Hand(),"User", 100);
        computer = new Computer(new Hand(), "Computer");
        //начинаем игру
        game();
    }

    private void game() {
        while(human.getAmount() > 0.0D) {
            //делаем ставку
            double bet = makeBet();

            //перемешиваем колоду карт
            deck = new Deck();
            deck.shuffle();

            //сбрасываем карты c предыдущей руки
            computer.getHand().clearHand();
            human.getHand().clearHand();

            //Даем две карты компьютеру
            computer.getHand().takeCardFromDesc(deck);
            computer.getHand().takeCardFromDesc(deck);

            //Даем две карты игроку
            human.getHand().takeCardFromDesc(deck);
            human.getHand().takeCardFromDesc(deck);

            //Печатаем карты на руках
            human.printHand();

            //Проверка на 21 очко
            if (human.getHand().scoreCount() == 21 && computer.getHand().scoreCount() == 21) {
                System.out.println("У вас и у компьютера очко! Ничья!");
            } else if (human.getHand().scoreCount() == 21 && computer.getHand().scoreCount() != 21) {
                System.out.println("У вас очко! Вы победили!");
                human.setAmount(human.getAmount() + bet);
            } else if (human.getHand().scoreCount() != 21 && computer.getHand().scoreCount() == 21) {
                System.out.println("У компьютера очко! Вы проиграли!");
                human.setAmount(human.getAmount() - bet);
            } else {
                human.decision(deck);
                //Проверка на перебор у игрока
                if (human.getHand().scoreCount() > 21) {
                    System.out.println("У вас перебор! Вы проиграли!");
                    human.setAmount(human.getAmount() - bet);
                    if (human.getAmount() == 0.0D) {
                        System.out.println("Игра закончена! У Вас на счету 0");
                        return;
                    }
                } else {
                    //работает ИИ
                    computer.decision(deck);
                    //Проверка на перебор у компьютера
                    if (computer.getHand().scoreCount() > 21) {
                        System.out.println("У компьютера перебор! Вы выиграли!");
                        human.setAmount(human.getAmount() + bet);
                    } else if (computer.getHand().scoreCount() > human.getHand().scoreCount()) {
                        System.out.println("У компьютера больше очков! Вы проиграли!");
                        human.setAmount(human.getAmount() - bet);
                        if (human.getAmount() == 0.0D) {
                            System.out.println("Игра закончена! У Вас на счету 0");
                            return;
                        }
                    } else if (human.getHand().scoreCount() > computer.getHand().scoreCount()) {
                        System.out.println("У вас больше очков! Вы выйграли!");
                        human.setAmount(human.getAmount() + bet);
                    } else {
                        System.out.println("У вас одинкоковое количество очков! Ничья!");
                    }
                }
            }
        }

    }

    private double makeBet(){
        double bet;
        do{
            System.out.println("У вас " + human.getAmount() + " игровых денег. Сделайте ставку!");
            bet = input.nextDouble();
            if (bet > human.getAmount()) {
                System.out.println("Вы не можете поставить больше, чем у вас есть.");
            }
            if (bet <= 0.0) {
                System.out.println("Вы не можете поставить неположительное число.");
            }
        }while (bet <= 0 || bet > human.getAmount());
        return bet;
    }



}
