package com.uol.smells;

public class SavingAccount extends AbstractAccount {

	private int id;
	private int size = 0;
	private String[] statementDescription = new String[10];
	private double[] statementValue = new double[10];
	private double balance;
	
	@Override
	public void deposit(double value) {
		balance += value;
		
		 int newSize = size + 1;
         if (newSize > statementDescription.length) {
            String[] newDescriptions = 
               new String[statementDescription.length + 10];
            double[] newValues = 
               new double[statementDescription.length + 10];
            System.arraycopy(statementDescription, 0, newDescriptions, 0, size);
            System.arraycopy(statementValue, 0, newValues, 0, size);
            statementDescription = newDescriptions;
            statementValue = newValues;
         }
         statementDescription[size] = "Deposit";
         statementValue[size] = value;
         size++;
	}
	
	@Override
	public boolean withdraw(double value) {
		if(balance < value) {
			return false;
		}
		
		balance -= value;
		
		int newSize = size + 1;
        if (newSize > statementDescription.length) {
           String[] newDescriptions = 
              new String[statementDescription.length + 10];
           double[] newValues = 
              new double[statementDescription.length + 10];
           System.arraycopy(statementDescription, 0, newDescriptions, 0, size);
           System.arraycopy(statementValue, 0, newValues, 0, size);
           statementDescription = newDescriptions;
           statementValue = newValues;
        }
        statementDescription[size] = "Withdraw";
        statementValue[size] = value;
        size++;
		
		return true;
	}

	@Override
	public boolean transferToAccount(Account account, double value) {
		return false;
	}

	@Override
	public void receiveTransfer(double value) {
	}
	
	@Override
	public String toString() {
		return this.id + "";
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getStatement(int position) {
		return statementDescription[position] + statementValue[position];
	}
}
