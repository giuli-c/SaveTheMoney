package it.savethemoney.model;

public interface Services {

	void deposit(double amount);		// eccezione se negativo(amount) IllegalArgumentException
	void payTransfer(double value);
	void payWithdraw(double value);
	void payPayment(double value);
	// i pagamenti generano eccezioni!!!!! IllegalArgumentException
}
