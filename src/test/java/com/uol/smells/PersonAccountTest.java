package com.uol.smells;

import org.junit.Assert;
import org.junit.Test;

public class PersonAccountTest {

	@Test
	public void depositPositiveValues() {
		PersonAccount personAccount = new PersonAccount();
		personAccount.deposit(10.50d);
		personAccount.deposit(3.554d);
		Assert.assertEquals(14.05d, personAccount.getBalanceValue(), 0.01d);
	}
	
	@Test
	public void depositNegativeValues() {
		PersonAccount personAccount = new PersonAccount();
		personAccount.deposit(-10.50d);
		personAccount.deposit(3.554d);
		Assert.assertEquals(3.55d, personAccount.getBalanceValue(), 0.01d);
	}
	
	@Test
	public void withdrawPositiveValues() {
		PersonAccount personAccount = new PersonAccount();
		personAccount.deposit(10.00d);
		personAccount.withdraw(1.56);
		personAccount.withdraw(2.38);
		Assert.assertEquals(6.06d, personAccount.getBalanceValue(), 0.01d);
	}
	
	@Test
	public void withdrawNegativeValues() {
		PersonAccount personAccount = new PersonAccount();
		personAccount.deposit(10.00d);
		personAccount.withdraw(-1.56);
		personAccount.withdraw(-2.38);
		Assert.assertEquals(10.00d, personAccount.getBalanceValue(), 0.01d);
	}
	
	@Test
	public void withdrawGreatherValueThanBalance() {
		PersonAccount personAccount = new PersonAccount();
		personAccount.deposit(10.00d);
		personAccount.withdraw(1.56);
		personAccount.withdraw(12.38);
		Assert.assertEquals(8.44d, personAccount.getBalanceValue(), 0.01d);
	}
	
	@Test
	public void transferPositiveValues() {
		PersonAccount personAccount1 = new PersonAccount();
		personAccount1.deposit(10.00d);
		
		PersonAccount personAccount2 = new PersonAccount();
		personAccount2.deposit(1.00d);
		
		personAccount1.transferToAccount(personAccount2, 2.50d);
		
		Assert.assertEquals(7.50d, personAccount1.getBalanceValue(), 0.01d);
		Assert.assertEquals(3.50d, personAccount2.getBalanceValue(), 0.01d);
	}
	
	@Test
	public void transferNegativeValues() {
		PersonAccount personAccount1 = new PersonAccount();
		personAccount1.deposit(10.00d);
		
		PersonAccount personAccount2 = new PersonAccount();
		personAccount2.deposit(1.00d);
		
		personAccount1.transferToAccount(personAccount2, -2.50d);
		
		Assert.assertEquals(10.00d, personAccount1.getBalanceValue(), 0.01d);
		Assert.assertEquals(1.00d, personAccount2.getBalanceValue(), 0.01d);
	}
	
	@Test
	public void transferGreatherValueThanBalance() {
		PersonAccount personAccount1 = new PersonAccount();
		personAccount1.deposit(10.00d);
		
		PersonAccount personAccount2 = new PersonAccount();
		personAccount2.deposit(1.00d);
		
		personAccount1.transferToAccount(personAccount2, 2.50d);
		personAccount1.transferToAccount(personAccount2, 10.00d);
		
		Assert.assertEquals(7.50d, personAccount1.getBalanceValue(), 0.01d);
		Assert.assertEquals(3.50d, personAccount2.getBalanceValue(), 0.01d);
	}
	
	@Test
	public void checkDepositStatement() {
		PersonAccount personAccount = new PersonAccount();
		personAccount.deposit(10.50d);
		personAccount.withdraw(1.50d);
		personAccount.deposit(3.554d);
		Assert.assertEquals("Deposit - 10.5", personAccount.getStatement(0));
		Assert.assertEquals("Deposit - 3.554", personAccount.getStatement(2));
	}
	
	@Test
	public void checkWithdrawStatement() {
		PersonAccount personAccount = new PersonAccount();
		personAccount.deposit(10.50d);
		personAccount.withdraw(1.50d);
		personAccount.deposit(3.554d);
		personAccount.withdraw(2.50d);
		Assert.assertEquals("Withdraw - 1.5", personAccount.getStatement(1));
		Assert.assertEquals("Withdraw - 2.5", personAccount.getStatement(3));
	}
	
	@Test
	public void checkTransferStatement() {
		PersonAccount personAccount1 = new PersonAccount();
		personAccount1.deposit(10.00d);
		
		PersonAccount personAccount2 = new PersonAccount();
		personAccount2.deposit(1.00d);
		
		personAccount1.transferToAccount(personAccount2, 2.50d);
		personAccount1.deposit(10.00d);
		personAccount1.transferToAccount(personAccount2, 10.00d);
		
		Assert.assertEquals("Transfer to account 0 - 2.5", personAccount1.getStatement(1));
		Assert.assertEquals("Transfer to account 0 - 10.0", personAccount1.getStatement(3));
	}
	
	@Test
	public void checkStatementGreaterThanTen() {
		PersonAccount personAccount = new PersonAccount();
		personAccount.deposit(10.50d);
		personAccount.withdraw(1.50d);
		personAccount.deposit(3.554d);
		personAccount.deposit(10.50d);
		personAccount.withdraw(1.50d);
		personAccount.deposit(3.554d);
		personAccount.deposit(10.50d);
		personAccount.withdraw(1.50d);
		personAccount.deposit(3.554d);
		personAccount.deposit(10.50d);
		personAccount.withdraw(1.50d);
		personAccount.deposit(3.554d);
		Assert.assertEquals("Deposit - 3.554", personAccount.getStatement(11));
	}
}
