package 미니과제;

import java.util.Scanner;
//이창훈
public class tax {
    public static long[] annualIncome = {0, 12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
    public static long[] deduction = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};
    public static long[] tax = {6, 15, 24, 35, 38, 40, 42, 45};
    public static long deductionCalculation(long annualIncome, int index) {
        long reDeduction = (annualIncome * tax[index] / 100) - deduction[index] ;

        return reDeduction;
    };

    public static long input(){
        long income;
        Scanner input = new Scanner(System.in);

        System.out.println("[과세금액 계산 프로그램]");
        while (true) {
            System.out.print("연소득을 입력해 주세요. : ");
            income = input.nextInt();

            if(income < 0) {
                System.out.println("입력이 잘못되었습니다. 다시 입력해주세요.");
                continue;
            }
            break;
        }

        return income;
    }

    public static void main(String[] args) {

        long income = input();

        int index = 0;
        int taxCost = 0;

        while(true) {
            if(index>8) {
                long re = (income - annualIncome[index])  * tax[index] / 100;
                System.out.printf("%,15d * %2d%% = %,12d \n", (income - annualIncome[index]), tax[index], re);
                taxCost += re;
                break;
            }


            if(income > annualIncome[index+1]) {
                long re = (annualIncome[index+1] - annualIncome[index]) * tax[index] / 100 ;
                System.out.printf("%,15d * %2d%% = %,12d \n", (annualIncome[index+1] - annualIncome[index]), tax[index], re);
                taxCost += re;
                index++;
            } else {
                long re = (income - annualIncome[index])  * tax[index] / 100;
                System.out.printf("%,15d * %2d%% = %,12d \n", (income - annualIncome[index]), tax[index], re);
                taxCost += re;
                break;
            }
        }

        System.out.println();
        System.out.printf("[세율에 의한 세금] : \t\t\t %,10d원 \n", taxCost);
        System.out.printf("[누진공제 계산에 의한 세금] : \t %,10d원 \n", deductionCalculation(income, index));

    }
}