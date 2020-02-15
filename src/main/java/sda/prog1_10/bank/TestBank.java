package sda.prog1_10.bank;

import java.util.List;

import sda.prog1_10.bank.migration.CustomersMigration;

public class TestBank {

	public static void main(String[] args) {
		Bank bank = new Bank("SDA Bank");
		Customer customer1 = new Customer("Jan", "Kowalski");
		Customer customer2 = new Customer("Maria", "Wróbel");
		Customer customer3 = new Customer("Danuta", "Więcek");

		bank.addCustomer(customer1);
		bank.addCustomer(customer2);
		bank.addCustomer(customer3);

		bank.addAccount(customer1, AccountKind.CURRENT);
		bank.addAccount(customer1, AccountKind.SAVINGS);
		bank.addAccount(customer2, AccountKind.CURRENT);
		bank.addAccount(customer3, AccountKind.CURRENT);
		bank.addAccount(customer3, AccountKind.SAVINGS);

		bank.printCustomerList(true);
		Account account = customer1.getAccounts().get(0);
		bank.deposit(customer1, account, 10);
		account = customer3.getAccounts().get(1);
		bank.deposit(customer3, account, 25);

		bank.printCustomerList(true);
		CustomersMigration migration = new CustomersMigration();
		List<Customer> migratedCustomers = migration.migrate("BankData.txt", "\\|");
		migration.addMigratedCustomers(bank, migratedCustomers);


		System.out.println("Migration done.");
		bank.printCustomerList(true);

		System.out.println("================All accounts================");
		bank.printAllBankAccounts();
	}

}
