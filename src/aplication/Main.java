package aplication;

import model.entities.Account;
import model.exceptions.WithdrawLimitExceededException;
import model.exceptions.NotEnoughBalanceException;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            Integer number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            Double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            Double amount = sc.nextDouble();
            account.withDraw(amount);

            System.out.printf("New balance: $ %.2f%n", account.getBalance());
        } catch (WithdrawLimitExceededException e) {
            System.out.println("Withdraw error: Not enough balance");
        } catch (NotEnoughBalanceException e) {
            System.out.println("Withdraw error: The amount exceeds withdraw limit");
        } catch (Exception e) {
            System.out.println("Unexpected error.");
        }

        sc.close();
    }
}
