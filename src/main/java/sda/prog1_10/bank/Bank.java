package sda.prog1_10.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private static Integer customerNumber = 0;
	private static Integer accountNumber = 0;

	public String getNextCustomerNumber(){
		String newId = customerNumber.toString();
		customerNumber++;
		return newId;
	}

	public String getNextAccountNumber(){
		String newId = "IBAN"+accountNumber.toString();
		accountNumber++;
		return newId;
	}

	private String name;
	private List<Customer> customers;

	public Bank(String name) {
		this.name = name;
		customers = new ArrayList<>();
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public boolean addCustomer(Customer customer) {
		if(checkCustomerOnList(customer)) {
			System.out.println("Klient " + customer + " już jest w systemie.");
			return false;
		}
		customer.setId(getNextCustomerNumber());
		customers.add(customer);
		System.out.println("Klient " + customer + " dodany");
		return true;
	}

	public boolean removeCustomer(Customer customer) {
		if(checkCustomerOnList(customer)) {
			return removeCustomerIfHasNoAccounts(customer);
		}
		return customerNotFound(customer);
	}

	private boolean customerNotFound(Customer customer) {
		System.out.println("Klienta " + customer + " nie znaleziono w systemie.");
		return false;
	}

	private boolean removeCustomerIfHasNoAccounts(Customer customer) {
		if(customer.getAccounts().isEmpty()) {
			return removeCustomerWithEmptyAccountList(customer);
		}
		System.out.println("Nie można usunąć klienta " + customer
				+ " bo ma otwarte rachunki");
		return false;
	}

	private boolean removeCustomerWithEmptyAccountList(Customer customer) {
		customers.remove(customer);
		System.out.println("Klient " + customer + " usunięty.");
		return true;
	}

	public boolean addAccount(Customer customer, AccountKind accountKind) {
		if(checkCustomerOnList(customer)) {
			List<Account> customerAccounts = customer.getAccounts();
			Account account = new Account(getNextAccountNumber());
			account.setAccountKind(accountKind);
			customerAccounts.add(account);
			System.out.println("Dla klienta " + customer +
			" założono konto " + account);
			return true;
		}
		return customerNotFound(customer);
	}

	public boolean deposit(Customer customer, Account account, int amount) {
		if(customers.contains(customer)) {
			List<Account> accounts = customer.getAccounts();
			if(accounts.contains(account)) {
				accounts.get(accounts.indexOf(account))
						.deposit(amount);
				customer.setAccounts(accounts);
				System.out.println("Wpłata " + amount + " na rachunek "
				+ account + " zaksięgowana.");
				return true;
			}
		}
		return customerNotFound(customer);
	}

	public boolean withdraw(Customer customer, Account account, int amount) {
		if(checkCustomerOnList(customer)) {
			List<Account> accounts = customer.getAccounts();
			if(accounts.contains(account)) {
				if(
						accounts.get(accounts.indexOf(account)).withdraw(amount)
						) {
					System.out.println("Wypłata " + amount + " z rachunku "
							+account + "zaksięgowana.");
					return true;
				}
				System.out.println("Wypłata nie powiodła się.");
				return false;
			}
			System.out.println("Nie znaleziono konta " + account
			+ "dla klienta " + customer);
			return false;
		}
		return customerNotFound(customer);
	}

	public boolean deleteAccount(Customer customer, Account account) {
		if(checkCustomerOnList(customer)){
			List<Account> accounts = customer.getAccounts();
			if(accounts.contains(account)) {
				return removeAccountIfBalanceZero(account, accounts);
			}
			return accountNotFound(account);
		}
		return customerNotFound(customer);
	}

	private boolean removeAccountIfBalanceZero(Account account, List<Account> accounts) {
		if(account.getBalance() == 0) {
			accounts.remove(account);
			System.out.println("Rachunek " + account + " usunięty");
			return true;
		}
		System.out.println("Na rachunku " + account + " saldo niezerowe, nie można usunąć.");
		return false;
	}

	private boolean accountNotFound(Account account) {
		System.out.println("Nie znaleziono konta " + account);
		return false;
	}

	public void printAccountList(Customer customer, boolean printBalance) {
		if(checkCustomerOnList(customer)) {
			List<Account> accounts = customer.getAccounts();
			accounts.stream()
					.forEach(a -> System.out.println(
							"\t" + a.getAccountNumber() +
							" " + a.getAccountKind() +
							" " + (printBalance ? a.getBalance() : "")
					));
		}
	}

	public void printCustomerList(boolean printBalance) {
		customers.stream()
				.forEach(c ->
					printCustomerAndHisAccounts(printBalance, c)
				);
	}

	private void printCustomerAndHisAccounts(boolean printBalance, Customer c) {
		System.out.println(c);
		printAccountList(c, printBalance);
	}

	private boolean checkCustomerOnList(Customer customer) {
		return customers.contains(customer);
	}

	public void printAllBankAccounts(){
		customers.stream().forEach(
				c -> {
					List<Account> customerAccounts= c.getAccounts();
					customerAccounts.forEach(System.out::println);
				}
		);
		System.out.println("=============================");
		customers.stream().map(Customer::getAccounts).flatMap(x -> x.stream()).forEach(System.out::println);
	}

}
