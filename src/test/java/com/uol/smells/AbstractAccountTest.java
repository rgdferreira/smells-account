package com.uol.smells;

import org.junit.Assert;
import org.junit.Test;

public class AbstractAccountTest {

	@Test
	public void closeCompanyAccount() {
		Account acc = new CompanyAccount();
		acc.deposit(10.00d);
		acc.closeAccount();
		Assert.assertEquals(0.00d, ((CompanyAccount)acc).getBalance(), 0.01d);
		Assert.assertEquals(0, ((CompanyAccount)acc).getStatus());
	}
	
	@Test
	public void closePersonAccount() {
		Account acc = new PersonAccount();
		acc.deposit(10.00d);
		acc.closeAccount();
		Assert.assertEquals(0.00d, ((PersonAccount)acc).getBalanceValue(), 0.01d);
		Assert.assertEquals(0, ((PersonAccount)acc).getStatusAccount());
	}
	
	@Test
	public void closeSavingAccount() {
		Account acc = new SavingAccount();
		acc.deposit(10.00d);
		acc.closeAccount();
		Assert.assertEquals(0.00d, ((SavingAccount)acc).getBalance(), 0.01d);
	}
}
