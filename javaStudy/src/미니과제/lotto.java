package 미니과제;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//이창훈
public class lotto {
    public static int prompt() {
        int num;
        Scanner input = new Scanner(System.in);

        System.out.println("[로또 당첨 프로그램]");
        while(true){
            System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10) : ");
            num = input.nextInt();
            if(num <= 0 || num > 10){
                System.out.println("입력이 잘못되었습니다.");
                continue;
            }
            break;
        }

        return num;
    }

    public static void main(String[] args) {
        int num;
        int[] winner = new int[6];
        int[][] lotto;
        char seq = 'A';

        num = prompt();
        lotto = new int[num][6];


        for (int i = 0; i < lotto.length; i++) {
            for (int ii = 0; ii < lotto[i].length; ii++) {
                lotto[i][ii] = new Random().nextInt(45) + 1;

                for (int k = 0; k < ii; k++) {
                    if(lotto[i][ii] == lotto[i][k]){
                        ii--;
                        break;
                    }
                }
            }
            Arrays.sort(lotto[i]);
        }


        for (int i = 0; i < lotto.length; i++) {
            System.out.print(seq++ + "\t");
            for (int ii = 0; ii < lotto[i].length; ii++) {
                if(ii == 5) {
                    System.out.printf("%02d\n", lotto[i][ii]);
                } else {
                    System.out.printf("%02d, ", lotto[i][ii]);
                }
            }
        }

        for (int i=0; i<6; i++) {
            winner[i] = new Random().nextInt(45) + 1;

            for (int j = 0; j < i; j++) {
                if(winner[i] == winner[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(winner);

        System.out.println("[로또 발표]");
        System.out.print("\t");
        for(int i=0; i<6; i++) {
            if(i==5){
                System.out.print(winner[i] < 10 ? String.format("%02d\n", winner[i]): winner[i]+"\n");
            } else {
                System.out.print(winner[i] < 10 ? String.format("%02d, ", winner[i]): winner[i]+", ");
            }
        }
        System.out.println();


        seq = 'A';
        System.out.println("[내 로또 발표]");

        for(int i=0; i<num; i++) {
            int eqCnt = 0;
            System.out.print(seq++ +"\t");
            for (int j = 0; j < 6; j++) {
                if(j==5){
                    System.out.print(lotto[i][j] < 10 ? String.format("%02d ", lotto[i][j]): lotto[i][j]+ " ");
                } else {
                    System.out.print(lotto[i][j] < 10 ? String.format("%02d, ", lotto[i][j]): lotto[i][j]+", ");
                }
                for (int k = 0; k < 6; k++) {
                    if(winner[k] == lotto[i][j])
                        eqCnt++;
                }
            }
            System.out.println(" => " + eqCnt + "개 일치");
        }
    }
}