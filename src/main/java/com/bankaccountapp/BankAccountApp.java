package com.bankaccountapp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();


        String file = "/Users/alimirzayev/Downloads/NewBankAccounts.csv";
        List<String[]> newAccounHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccounHolders) {
            System.out.println("New Account");
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));
            }
            else if (accountType.equals("Checking")) {
                  accounts.add(new Checking(name, sSN, initDeposit));
            }
            else {
                System.out.println("Unknown Account Type");
            }

        }

        for (Account acc : accounts) {
            System.out.println("\n **************");
            acc.showInfo();
        }
        
    }

}
