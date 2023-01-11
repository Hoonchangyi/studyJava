package 미니과제;

import java.util.Scanner;
//이창훈
public class cash {
    public static int back(int cost){
        if (cost / 10 > 300){
            return 300;
        }
        return (int)Math.floor(cost/1000) * 100;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("[캐시백 계산]");
        System.out.print("결제금액을 입력해주세요.(금액) : ");

        int cost = input.nextInt();

        if(cost < 0){
            System.out.println("잘못된 입력값 입니다.");
        }else {
            String re = String.format("결제 금액은 %s이고, 캐시백은 %s원 입니다.", cost, back(cost));
            System.out.println(re);
        }




    }
}
