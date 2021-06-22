

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateTest {


    //this method will start conversions
    public static void RunConversions() throws InputMismatchException {

        ArrayList<Double> myList = new ArrayList<Double>();

        ArrayList<String> myStringList = new ArrayList<String>();

        String shouldContinue = "y";
        Scanner s2 = new Scanner(System.in);
        int choice = 0;
        System.out.println("Welcome to currency converter");


        do {
            try {
                System.out.println("Please choose an option (1/2/3)");
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
                    //challenge
                    Result result = new Result((usd.calculate(input)), "USD to ILS");
                    myStringList.add(String.valueOf(usd.calculate(input)) + ", USD to ILS");

                }
                if (choice == 2) {

                    System.out.println("Please enter an amount to convert");

                    Double input = s2.nextDouble();
                    ICalculate ils = (ICalculate) CoinFactory.getCoinInstance(Coins.USD);
                    System.out.printf("%s - %s %s %n ", ils.calculate(input), input, "ILS to USD");

                    myList.add(ils.calculate(input));
                    //challenge
                    Result result = new Result((ils.calculate(input)), "ILS to USD");
                    myStringList.add(String.valueOf(ils.calculate(input)) + ", ILS to USD");

                } else if (choice == 3) {
                    System.out.println("Please enter an amount to convert");

                    Double input = s2.nextDouble();
                    ICalculate eur = (ICalculate) CoinFactory.getCoinInstance(Coins.EUR);
                    System.out.printf("%s - %s %s %n ", eur.calculate(input), input, "ILS to EUR");

                    myList.add(eur.calculate(input));
                    //challenge
                    Result result = new Result((eur.calculate(input)), "ILS to EUR");
                    myStringList.add(String.valueOf(eur.calculate(input)) + ", ILS to EUR");
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Invalid choice, please try again");
                shouldContinue = s2.next();
            }

            System.out.println("Start over? choose Y/N");
            shouldContinue = s2.next();


        } while (shouldContinue.equalsIgnoreCase("Y"));

        System.out.println("Thanks for using our currency converter");


        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        for (int i = 0; i < myStringList.size(); i++) {
            System.out.println(myStringList.get(i));
        }


        final String FILENAME = "C:\\Users\\LENOVO\\Desktop\\logs\\aaa.txt";


        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
            for (Double line : myList) {
                bw.write(line + "\n");
                bw.newLine();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {


        RunConversions();


    }
}

