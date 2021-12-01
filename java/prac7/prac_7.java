import java.util.*;

public class prac_7 {

    public static void main(String[] args) {
        Queue<Integer> initCards = new ArrayDeque<>();
        Random rand = new Random();
        while(initCards.size() < 10){
            int val = rand.nextInt(10);
            if(!initCards.contains(val)){
                initCards.add(val);
            }
        }

        Queue<Integer> first = new ArrayDeque<>();
        Queue<Integer> second = new ArrayDeque<>();
        for(int i = 0; i < 5; i++) {
            first.add(initCards.poll());
            second.add(initCards.poll());
        }
        int count = 0;

        while(first.size() > 0 && second.size() > 0){
            int firstVal = first.poll();
            int secondVal = second.poll();
            if(firstVal >  secondVal) {
                first.add(firstVal);
                first.add(secondVal);
            }
            else{
                second.add(firstVal);
                second.add(secondVal);
            }

            count++;
            if(count == 106){
                System.out.println("botva");
                return;
            }
        }

        if(first.isEmpty()){
            System.out.println("Выиграл второй игрок, количество ходов " + count);
        }
        else
            System.out.println("Выиграл первый игрок, количество ходов  " + count);
    }
}