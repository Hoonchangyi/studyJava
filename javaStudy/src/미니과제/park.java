package 미니과제;

import java.util.Scanner;
//이창훈
public class park {

    public static int Ba = 10000;
    public static int Ge = 8000;
    public static int Sp = 4000;

    public static int age;
    public static int time;
    public static char respect;
    public static char card;
    static Scanner input = new Scanner(System.in);

    public static void input(){
        while (true){
            System.out.println("[입장권 계산]");
            System.out.print("나이을 입력해주세요.(숫자) : ");
            age = input.nextInt();
            if (age<0){
                System.out.println("나이 입력이 잘못됐습니다.");
                continue;
            }

            System.out.print("입장시간을 입력해주세요.(숫자) : ");
            time = input.nextInt();
            if(time<0||time>24){
                System.out.println("입장시간 입력은 24시 시준으로 부탁드립니다.");
                continue;
            }

            System.out.print("국가유공자여부를 입력해주세요.(y/n) : ");
            respect = Character.toLowerCase(input.next().charAt(0));
            if (respect != 'n' && respect != 'y'){
                System.out.println("입력값이 잘못됐습니다.");
                continue;
            }

            System.out.print("복지카드여부를 입력해주세요.(y/n) : ");
            card = Character.toLowerCase(input.next().charAt(0));
            if (card != 'n' && card != 'y'){
                System.out.println("입력값이 잘못됐습니다.");
                continue;
            }
            break;
        }
    }
    public static void main(String[] args) {

        int finalCost = Ba;

        input();

        if(age<3){
            finalCost = Math.min(finalCost, 0);

        }else if (age<13){
            finalCost = Math.min(finalCost, Sp);

        }
        if (respect == 'y' || card == 'y') {
            finalCost = Math.min(finalCost, Ge);
        }
        if(time>=17){
            finalCost = Math.min(finalCost, Sp);
        }

        System.out.println("입장료 : " + finalCost);

    }
}
