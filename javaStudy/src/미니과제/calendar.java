package 미니과제;

import java.time.LocalDate;
import java.util.Scanner;
//이창훈
public class calendar {
    public static void make(int yy, int mm) {

        int date = 1;
        int day;

        LocalDate makeDate = LocalDate.of(yy, mm, date);
        day = makeDate.getDayOfWeek().getValue();

        // 달력 출력
        System.out.println(mm >= 10 ?
                String.format("[%d년 %d월]", yy, mm) : String.format("[%d년 %02d월]", yy, mm));

//        System.out.println("일  월   화  수  목   금  토  ");
        System.out.println("일\t월\t화\t수\t목\t금\t토\t");


        for (int i = 0; i < day % 7; i++) {
            System.out.print("   ");
        }


        for(int i=1; i<=makeDate.lengthOfMonth(); i++) {
            System.out.printf("%02d  ", date++);
            day++;

            if(day % 7 == 0) {
                System.out.println("");
            }
        }
    }
    public static void main(String[] args) {
        int year;
        int month;

        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("[달력 출력 프로그램]");
            System.out.print("달력의 년도를 입력해 주세요. (yyyy) : ");
            year = input.nextInt();

            if(year < 0) {
                System.out.println("입력이 잘못되었습니다.");

                continue;
            }

            System.out.print("달력의 월을 입력해 주세요. (mm) : ");
            month = input.nextInt();

            if(month <= 0 || month > 12) {
                System.out.println("입력이 잘못되었습니다.");

                continue;
            }
            break;
        }

        System.out.println();

        make(year, month);
    }
}
