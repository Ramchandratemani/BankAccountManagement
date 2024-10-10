# BankAccountManagement
This is a practice project to maintain a bank account for an individual user.


Problem Statement: Bank Account Management System
You are tasked with building a simple bank account management system using Java. The system should allow the user to perform basic banking operations like checking balance, depositing money, withdrawing money, and viewing transaction history.

Requirements:
Create a BankAccount class with the following attributes:

accountNumber (String): The unique account number.
accountHolderName (String): The name of the account holder.
balance (double): The current balance in the account.
transactionHistory (ArrayList<String>): To store the history of transactions (deposit/withdrawal).
Methods in BankAccount class:

deposit(double amount): This method allows the user to deposit money into the account. The amount should be added to the balance, and a message should be recorded in the transaction history.
withdraw(double amount): This method allows the user to withdraw money from the account. The amount should be subtracted from the balance only if sufficient funds are available, and the transaction should be recorded in the transaction history. If insufficient funds, display an appropriate message.
checkBalance(): This method should display the current balance in the account.
viewTransactionHistory(): This method should display all the transactions performed on the account.
Main Application:

In the main() method, allow the user to:
Create a new bank account by inputting accountNumber and accountHolderName.
Perform operations like deposit, withdraw, check balance, and view transaction history by showing a simple menu with options.
Validation:

Ensure the deposit and withdrawal amounts are positive.
Ensure that the withdrawal does not exceed the available balance.
Display appropriate messages for errors (e.g., insufficient funds, invalid inputs).
