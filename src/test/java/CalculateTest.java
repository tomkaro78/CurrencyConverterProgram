

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateTest {

//    private static ICalculate usd;
//    private static ICalculate ils;
//    private static double input;

    //this method will start conversions

    public static void RunConversions() throws InputMismatchException {

        ArrayList<Double> myList = new ArrayList<Double>();

        String shouldContinue = "y";
        Scanner s2 = new Scanner(System.in);
        int choice = 0;
        System.out.println("Welcome to currency converter");


           do {
               try {
                   System.out.println("Please choose an option (1/2)");
                   System.out.println("1. Dollars to Shekels");
                   System.out.println("2. Shekels to Dollars");
                   System.out.println("3. Shekels to Euro");

                   choice = s2.nextInt();

                   if (choice < 1 || choice > 3) {
                       System.out.println("Invalid choice, please try again");
                       continue;
                   }

                   if (choice == 1) {
                       System.out.println("Please enter an amount to convert");

                       Double input = s2.nextDouble();
                       ICalculate usd = (ICalculate) CoinFactory.getCoinInstance(Coins.ILS);
                       System.out.printf("%s - %s %s %n", usd.calculate(input), input, "USD to ILS");

                       myList.add(usd.calculate(input));

                   }
                   if (choice == 2) {
                       System.out.println("Please enter an amount to convert");

                       Double input = s2.nextDouble();
                       ICalculate ils = (ICalculate) CoinFactory.getCoinInstance(Coins.USD);
                       System.out.printf("%s - %s %s %n ", ils.calculate(input), input, "ILS to USD");

                       myList.add(ils.calculate(input));
                   } else if (choice == 3) {
                       System.out.println("Please enter an amount to convert");

                       Double input = s2.nextDouble();
                       ICalculate ils = (ICalculate) CoinFactory.getCoinInstance(Coins.EUR);
                       System.out.printf("%s - %s %s %n ", ils.calculate(input), input, "ILS to EUR");
                   }
               } catch (InputMismatchException e) {
                   e.printStackTrace();
                   shouldContinue =s2.next();
               }

               System.out.println("Start over? choose Y/N");
               shouldContinue = s2.next();



           } while (shouldContinue.equalsIgnoreCase("Y"));





        System.out.println("Thanks for using our currency converter");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        //FileWriter fw = new FileWriter("C:\\Users\\LENOVO\\Desktop\\logs\\aaa.txt");


    }

    public static void main(String[] args) throws IOException {


       RunConversions();


}
}

