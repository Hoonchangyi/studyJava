package 미니과제;

import java.util.Random;
//이창훈
public class vote {
    public static void main(String[] args) {
        final String[] mens = {"이재명", "윤석열", "심상정", "안철수"};

        double ing = 0.0;
        int[] num = new int[4];
        int numIndex;
        int winer= 0;


        for(numIndex = 1; numIndex <= 10000; numIndex++) {

            ing = numIndex / 10000.0 * 100;

            int vote = new Random().nextInt(4);
            num[vote]++;

            System.out.printf("[투표진행율] : %.2f%%,  %d명 투표 => %s \n", ing, numIndex, mens[vote]);

            System.out.printf("[기호:1] 이재명 : %.2f%%, (투표수 : %d)\n", (num[0]/10000.0)*100, num[0]);
            System.out.printf("[기호:2] 윤석열 : %.2f%%, (투표수 : %d)\n", (num[1]/10000.0)*100, num[1]);
            System.out.printf("[기호:3] 심상정 : %.2f%%, (투표수 : %d)\n", (num[2]/10000.0)*100, num[2]);
            System.out.printf("[기호:4] 안철수 : %.2f%%, (투표수 : %d)\n", (num[3]/10000.0)*100, num[3]);
        }


        int tmpMax = num[0];
        for(int i=1; i<4; i++){
            if( tmpMax < num[i]){
                tmpMax = num[i];
                winer = i;
            }
        }

        System.out.println("[투표 결과] 당선인 : " + mens[winer] );
    }
}