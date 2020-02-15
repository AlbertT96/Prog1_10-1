package sda.prog1_10.bank;

import java.util.Objects;

public class Account {
	private AccountKind accountKind;
	private int balance;
	private String accountNumber;

	public Account(AccountKind accountKind, String accountNumber) {
		this.accountKind = accountKind;
		this.accountNumber = accountNumber;
		this.balance = 0;
	}

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountKind(AccountKind accountKind) {
		this.accountKind = accountKind;
	}

	public AccountKind getAccountKind() {
		return accountKind;
	}

	public int getBalance() {
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void deposit(int amount) {
		this.balance += amount;
		System.out.println("Wpłata na rachunek " + this.accountNumber
		+ " zaksięgowana.");
	}

	public boolean withdraw(int amount) {
		if(this.balance < amount) {
			System.out.println("Stan konta " + this.accountNumber
			+ " mniejszy niż żądana kwota : " + amount);
			return false;
		}
		this.balance -= amount;
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Account account = (Account) o;
		return Objects.equals(accountNumber, account.accountNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber);
	}

	@Override
	public String toString() {
		return "accountNumber=" + accountNumber;
	}
}
