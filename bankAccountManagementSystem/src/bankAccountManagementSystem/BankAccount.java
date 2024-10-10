package bankAccountManagementSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
	
	private ArrayList<String> transactionHistory;
	private double balance;
	private Scanner sc;
	private Account account;
	
	public BankAccount(Account account) {
		this.transactionHistory = new ArrayList<>();
		this.balance = 0.0;
		this.sc =  new Scanner(System.in);
		this.account = account;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to XyZ Bank!!");
		System.out.println("");
		
		System.out.println("Enter the Accout Number: ");
		String accountNumber = sc.nextLine();
		
		System.out.println("Enter the Account Holder Name: ");
		String accountHolderName = sc.nextLine();
		
		System.out.println("");
		
		Account account = new Account(accountNumber, accountHolderName);
		BankAccount ba = new BankAccount(account);
		
		if(!accountNumber.isEmpty() && !accountHolderName.isEmpty()) {
			System.out.println("Account created successfully!!");
		}
		else {
			System.out.println("Please enter the details correctly");
		}
		
		while(true) {
		System.out.println("");
		System.out.println("Choose an Option: ");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Check Balance");
		System.out.println("4. View Transaction History");
		System.out.println("5. View Account Details");
		System.out.println("6. Exit");
		
		System.out.println("");
		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();
		
			switch(choice) {
				case 1 :
					ba.deposit();
					break;
				case 2:
					ba.withdraw();
					break;
				case 3: 
					ba.checkbalance();
					break;
				case 4:
					ba.viewTransactionHistory();
					break;
				case 5: 
					account.displayAccountDetails();
					break;
				case 6: 
					System.out.println("");
					System.out.println("Thank your for banking with us!!");
					System.exit(0);
					break;
				default: 
					System.out.println("Wrong Choice!!");
					break;
			}
		}
		
	}


	public void viewTransactionHistory() {
	
		if(transactionHistory.isEmpty()) {
			System.out.println("No Transactions has been done yet.");
		}
		else {
			System.out.println("Transaction History: ");
			for(String i : transactionHistory) {
				System.out.println(i);
			}
		}
		
	}

	public void checkbalance() {
		
		System.out.println("Current Balance is: " + balance);
	}

	public void withdraw() {

		System.out.println("");
		System.out.println("Please enter the amount to withdraw: ");
		double withdraw = sc.nextDouble();
		
		if(withdraw > balance) {
			System.out.println("Insufficient balance!!");
			System.out.println("Current balance is: " + balance);	
		}
		else {
			balance -= withdraw;
			addTrasaction("Withdrew: ", withdraw);
			System.out.println("Transaction successful!");
			System.out.println("Current balance is: " + balance);
		}
		
	}

	public void deposit() {
		
		System.out.println("");
		System.out.println("Please enter the amount to deposit: ");
		double deposit = sc.nextDouble();
		if(deposit > 0) {
			balance += deposit;
			addTrasaction("Deposited: ", deposit);
			System.out.println("Transaction successful!");
			System.out.println("Current Balance: " + balance);
		}
		else {
			System.out.println("Please enter a positive number.");
		}

	}
	
	private void addTrasaction(String transactionType, double amount) {
		
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
		String timeStamp = dateTime.format(formatter);
		
		transactionHistory.add(transactionType + amount + " on " + timeStamp); 
	}
	
}
