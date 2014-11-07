package com.uol.smells;

import org.junit.Assert;
import org.junit.Test;

public class SavingAccountTest {
	
	@Test
	public void depositPositiveValues() {
		SavingAccount savingAccount = new SavingAccount();
		savingAccount.deposit(10.50d);
		savingAccount.deposit(3.554d);
		Assert.assertEquals(14.05d, savingAccount.getBalance(), 0.01d);
	}
	
	@Test
	public void depositNegativeValues() {
		SavingAccount savingAccount = new SavingAccount();
		savingAccount.deposit(-10.50d);
		savingAccount.deposit(3.554d);
		Assert.assertEquals(3.55d, savingAccount.getBalance(), 0.01d);
	}
	
	@Test
	public void withdrawPositiveValues() {
		SavingAccount savingAccount = new SavingAccount();
		savingAccount.deposit(10.00d);
		savingAccount.withdraw(1.56);
		savingAccount.withdraw(2.38);
		Assert.assertEquals(6.06d, savingAccount.getBalance(), 0.01d);
	}
	
	@Test
	public void withdrawNegativeValues() {
		SavingAccount savingAccount = new SavingAccount();
		savingAccount.deposit(10.00d);
		savingAccount.withdraw(-1.56);
		savingAccount.withdraw(-2.38);
		Assert.assertEquals(10.00d, savingAccount.getBalance(), 0.01d);
	}
	
	@Test
	public void withdrawGreatherValueThanBalance() {
		SavingAccount savingAccount = new SavingAccount();
		savingAccount.deposit(10.00d);
		savingAccount.withdraw(1.56);
		savingAccount.withdraw(12.38);
		Assert.assertEquals(8.44d, savingAccount.getBalance(), 0.01d);
	}
	
	@Test
	public void checkDepositStatement() {
		SavingAccount savingAccount = new SavingAccount();
		savingAccount.deposit(10.50d);
		savingAccount.withdraw(1.50d);
		savingAccount.deposit(3.554d);
		Assert.assertEquals("Deposit - 10.5", savingAccount.getStatement(0));
		Assert.assertEquals("Deposit - 3.554", savingAccount.getStatement(2));
	}
	
	@Test
	public void checkWithdrawStatement() {
		SavingAccount savingAccount = new SavingAccount();
		savingAccount.deposit(10.50d);
		savingAccount.withdraw(1.50d);
		savingAccount.deposit(3.554d);
		savingAccount.withdraw(2.50d);
		Assert.assertEquals("Withdraw - 1.5", savingAccount.getStatement(1));
		Assert.assertEquals("Withdraw - 2.5", savingAccount.getStatement(3));
	}
	
	@Test
	public void checkStatementGreaterThanTen() {
		SavingAccount savingAccount = new SavingAccount();
		savingAccount.deposit(10.50d);
		savingAccount.withdraw(1.50d);
		savingAccount.deposit(3.554d);
		savingAccount.deposit(10.50d);
		savingAccount.withdraw(1.50d);
		savingAccount.deposit(3.554d);
		savingAccount.deposit(10.50d);
		savingAccount.withdraw(1.50d);
		savingAccount.deposit(3.554d);
		savingAccount.deposit(10.50d);
		savingAccount.withdraw(1.50d);
		savingAccount.deposit(3.554d);
		Assert.assertEquals("Deposit - 3.554", savingAccount.getStatement(11));
	}

}
