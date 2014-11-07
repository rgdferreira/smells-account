package com.uol.smells;

import org.junit.Assert;
import org.junit.Test;

public class CompanyAccountTest {

	@Test
	public void depositPositiveValues() {
		CompanyAccount companyAccount = new CompanyAccount();
		companyAccount.deposit(10.50d);
		companyAccount.deposit(3.554d);
		Assert.assertEquals(14.05d, companyAccount.getBalance(), 0.01d);
	}
	
	@Test
	public void depositNegativeValues() {
		CompanyAccount companyAccount = new CompanyAccount();
		companyAccount.deposit(-10.50d);
		companyAccount.deposit(3.554d);
		Assert.assertEquals(3.55d, companyAccount.getBalance(), 0.01d);
	}
	
	@Test
	public void withdrawPositiveValues() {
		CompanyAccount companyAccount = new CompanyAccount();
		companyAccount.deposit(10.00d);
		companyAccount.withdraw(1.56);
		companyAccount.withdraw(2.38);
		Assert.assertEquals(6.06d, companyAccount.getBalance(), 0.01d);
	}
	
	@Test
	public void withdrawNegativeValues() {
		CompanyAccount companyAccount = new CompanyAccount();
		companyAccount.deposit(10.00d);
		companyAccount.withdraw(-1.56);
		companyAccount.withdraw(-2.38);
		Assert.assertEquals(10.00d, companyAccount.getBalance(), 0.01d);
	}
	
	@Test
	public void withdrawGreatherValueThanBalance() {
		CompanyAccount companyAccount = new CompanyAccount();
		companyAccount.deposit(10.00d);
		companyAccount.withdraw(1.56);
		companyAccount.withdraw(12.38);
		Assert.assertEquals(8.44d, companyAccount.getBalance(), 0.01d);
	}
	
	@Test
	public void transferPositiveValues() {
		CompanyAccount companyAccount1 = new CompanyAccount();
		companyAccount1.deposit(10.00d);
		
		CompanyAccount companyAccount2 = new CompanyAccount();
		companyAccount2.deposit(1.00d);
		
		companyAccount1.transferToAccount(companyAccount2, 2.50d);
		
		Assert.assertEquals(7.50d, companyAccount1.getBalance(), 0.01d);
		Assert.assertEquals(3.50d, companyAccount2.getBalance(), 0.01d);
	}
	
	@Test
	public void transferNegativeValues() {
		CompanyAccount companyAccount1 = new CompanyAccount();
		companyAccount1.deposit(10.00d);
		
		CompanyAccount companyAccount2 = new CompanyAccount();
		companyAccount2.deposit(1.00d);
		
		companyAccount1.transferToAccount(companyAccount2, -2.50d);
		
		Assert.assertEquals(10.00d, companyAccount1.getBalance(), 0.01d);
		Assert.assertEquals(1.00d, companyAccount2.getBalance(), 0.01d);
	}
	
	@Test
	public void transferGreatherValueThanBalance() {
		CompanyAccount companyAccount1 = new CompanyAccount();
		companyAccount1.deposit(10.00d);
		
		CompanyAccount companyAccount2 = new CompanyAccount();
		companyAccount2.deposit(1.00d);
		
		companyAccount1.transferToAccount(companyAccount2, 2.50d);
		companyAccount1.transferToAccount(companyAccount2, 10.00d);
		
		Assert.assertEquals(7.50d, companyAccount1.getBalance(), 0.01d);
		Assert.assertEquals(3.50d, companyAccount2.getBalance(), 0.01d);
	}
	
	@Test
	public void checkDepositStatement() {
		CompanyAccount companyAccount = new CompanyAccount();
		companyAccount.deposit(10.50d);
		companyAccount.withdraw(1.50d);
		companyAccount.deposit(3.554d);
		Assert.assertEquals("Deposit - 10.5", companyAccount.getStatement(0));
		Assert.assertEquals("Deposit - 3.554", companyAccount.getStatement(2));
	}
	
	@Test
	public void checkWithdrawStatement() {
		CompanyAccount companyAccount = new CompanyAccount();
		companyAccount.deposit(10.50d);
		companyAccount.withdraw(1.50d);
		companyAccount.deposit(3.554d);
		companyAccount.withdraw(2.50d);
		Assert.assertEquals("Withdraw - 1.5", companyAccount.getStatement(1));
		Assert.assertEquals("Withdraw - 2.5", companyAccount.getStatement(3));
	}
	
	@Test
	public void checkTransferStatement() {
		CompanyAccount companyAccount1 = new CompanyAccount();
		companyAccount1.deposit(10.00d);
		
		CompanyAccount companyAccount2 = new CompanyAccount();
		companyAccount2.deposit(1.00d);
		
		companyAccount1.transferToAccount(companyAccount2, 2.50d);
		companyAccount1.deposit(10.00d);
		companyAccount1.transferToAccount(companyAccount2, 10.00d);
		
		Assert.assertEquals("Transfer to account 0 - 2.5", companyAccount1.getStatement(1));
		Assert.assertEquals("Transfer to account 0 - 10.0", companyAccount1.getStatement(3));
	}
	
	@Test
	public void checkStatementGreaterThanTen() {
		CompanyAccount companyAccount = new CompanyAccount();
		companyAccount.deposit(10.50d);
		companyAccount.withdraw(1.50d);
		companyAccount.deposit(3.554d);
		companyAccount.deposit(10.50d);
		companyAccount.withdraw(1.50d);
		companyAccount.deposit(3.554d);
		companyAccount.deposit(10.50d);
		companyAccount.withdraw(1.50d);
		companyAccount.deposit(3.554d);
		companyAccount.deposit(10.50d);
		companyAccount.withdraw(1.50d);
		companyAccount.deposit(3.554d);
		Assert.assertEquals("Deposit - 3.554", companyAccount.getStatement(11));
	}
}
