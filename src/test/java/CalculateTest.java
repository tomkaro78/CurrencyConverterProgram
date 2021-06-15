

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateTest {

    private static ICalculate usd;
    private static ICalculate ils;
    private static double input;

    public static void test() {

        String shouldContinue = "yes";

        Scanner s2 = new Scanner(System.in);
        int choice = 0;
        System.out.println("Welcome to currency converter");

        do {
            System.out.println("Please choose an option (1/2)");
            System.out.println("1. Dollars to Shekels");
            System.out.println("2. Shekels to Dollars");
            choice = s2.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Invalid choice, please try again");
                continue;
            }

            if (choice == 1) {
                System.out.println("Please enter an amount to convert");
                Double input = s2.nextDouble();
                ICalculate usd = (ICalculate) CoinFactory.getCoinInstance(Coins.ILS);
                System.out.println(usd.calculate(input));
            } else if (choice == 2) {
                System.out.println("Please enter an amount to convert");
                Double input = s2.nextDouble();
                ICalculate ils = (ICalculate) CoinFactory.getCoinInstance(Coins.USD);
                System.out.println(ils.calculate(input));
            }
            System.out.println("Start over? choose Y/N");
            shouldContinue = s2.next();

            ArrayList<Double> myList = new ArrayList<Double>();
            myList.add(CoinFactory.getCoinInstance(Coins.USD).calculate(s2.nextDouble()));
            myList.add(CoinFactory.getCoinInstance(Coins.ILS).calculate(s2.nextDouble()));

        } while (shouldContinue.equalsIgnoreCase("Y"));
    }

    public static void main(String[] args) {


        test();
//        ArrayList<Double> myList = new ArrayList<Double>();
//        myList.add(usd.calculate(input));
//        myList.add(ils.calculate(input));
//
//        for (int i =0; i < myList.size(); i++){
//            System.out.println(myList.get(i));
//        }

    }
}

