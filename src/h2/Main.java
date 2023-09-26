package h2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Input: ");

            String inputTokens = scanner.nextLine();

            String outputString = vendingMachine.lambda();

            if(!outputString.equals("")){
                System.out.println("Output: " + outputString);
            }
            else{
                System.out.println("nothing");
            }

            vendingMachine.delta(inputTokens);
        }
    }
}