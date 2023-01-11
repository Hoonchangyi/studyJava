package 미니과제;

import java.util.Random;
import java.util.Scanner;
//이창훈
public class birth {

    public static void Create(int yy, int mm, int dd, char sex){
        int sexNum = 0;

        if(sex == 'm' && yy <= 1999){
            sexNum = 1;
        }else if(sex == 'f' && yy <= 1999){
            sexNum = 0;
        }else if(sex == 'm' && yy > 1999){
            sexNum = 3;
        }else if(sex == 'f' && yy > 1999){
            sexNum = 4;
        }
        StringBuilder builder = new StringBuilder();

        builder.append(Integer.toString(yy).substring(2,4)) // 출생년도
                .append(mm >= 10? mm : String.format("%02d", mm)) // 출생월
                .append(dd >= 10 ? dd : String.format("%02d", dd)) //출생일
                .append("-")   // -
                .append(sexNum)  // 성별 번호
                .append(new Random().nextInt(1000000)); // 임의 번호

        System.out.println(builder);
    }


    public static void main(String[] args) {
        int year, month, day;
        char sex;
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("[주민등록번호 계산]");
            System.out.print("출생년도를 입력해주세요.(yyyy) : ");
            year = input.nextInt();
            if(year < 1000 || year > 2022) {
                System.out.println("입력이 잘못되었습니다.");
                continue;
            }
            System.out.print("출생월을 입력해주세요.(mm) : ");
            month = input.nextInt();
            if(month <= 0 || month > 12) {
                System.out.println("입력이 잘못되었습니다.");
                continue;
            }

            System.out.print("출생일을 입력해주세요.(dd) : ");
            day = input.nextInt();
            if(day <= 0 || day > 31) {
                System.out.println("입력이 잘못되었습니다.");
                continue;
            }

            System.out.print("성별을 입력해주세요.(m/f) : ");
            sex = Character.toLowerCase(input.next().charAt(0));
            if(sex != 'm' && sex != 'f') {
                System.out.println("입력이 잘못되었습니다.");
                continue;
            }
            break;
        }
        Create(year, month, day, sex);

    }
}
