package com.uol.smells;

public interface Account {
	
	void deposit(double value);
	boolean withdraw(double value);
	boolean transferToAccount(Account account, double value);
	void receiveTransfer(double value);
	void closeAccount();
}
