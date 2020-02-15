package sda.prog1_10.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
	private String name;
	private String surname;
	private String id;
	private List<Account> accounts;

	public Customer(String name, String surname) {
		this.name = name;
		this.surname = surname;
		accounts = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Customer customer = (Customer) o;
		return Objects.equals(name, customer.name) &&
				Objects.equals(surname, customer.surname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, surname);
	}

	@Override
	public String toString() {
		return "name=" + name + ' ' +
				", surname=" + surname;
	}
}
