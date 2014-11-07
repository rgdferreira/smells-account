package com.uol.smells;

public class PersonAccount extends AbstractPersonAccount {

	private int id;
	private int size = 0;
	private String[] statementDescription = new String[10];
	private double[] statementValue = new double[10];
	private double balance;
	private int status;
	
	@Override
	public void deposit(double value) {
		if(value < 0) {
			return;
		}
		
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
		if(value < 0) {
			return false;
		}
		
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
		if(value < 0) {
			return false;
		}
		
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
        statementDescription[size] = "Transfer to account " + account;
        statementValue[size] = value;
        size++;
        
        account.receiveTransfer(value);
		
		return true;
	}

	@Override
	public void receiveTransfer(double value) {
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
        statementDescription[size] = "Receive transfer";
        statementValue[size] = value;
        size++;
	}
	
	@Override
	public String toString() {
		return this.id + "";
	}
	
	public double getBalanceValue() {
		return balance;
	}
	
	public int getStatusAccount() {
		return status;
	}

	public void setStatusAccount(int status) {
		this.status = status;
	}

	public String getStatement(int position) {
		return statementDescription[position] + " - " + statementValue[position];
	}
}
