package com.uol.smells;

public abstract class AbstractAccount implements Account {

	public void closeAccount() {
		if(this instanceof CompanyAccount) {
			CompanyAccount cAcc = (CompanyAccount) this;
			double value = cAcc.getBalance();
			if(value > 0) {
				cAcc.withdraw(value);
			}
			cAcc.setStatus(0);
		} else if(this instanceof PersonAccount) {
			PersonAccount pAcc = (PersonAccount) this;
			double value = pAcc.getBalanceValue();
			if(value > 0) {
				pAcc.withdraw(value);
			}
			pAcc.setStatusAccount(0);
		} else if(this instanceof SavingAccount) {
			SavingAccount sAcc = (SavingAccount) this;
			double value = sAcc.getBalance();
			if(value > 0) {
				sAcc.withdraw(value);
			}
		}
	}
}
