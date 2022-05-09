package it.savethemoney.controller;

import java.util.Set;

import it.savethemoney.implementation.ObjectivesImpl;
import it.savethemoney.implementation.PresentElementException;
import it.savethemoney.model.AccountBalance;
import it.savethemoney.model.Category;
import it.savethemoney.model.Expense;
import it.savethemoney.model.Objectives;

public interface BankAccount {
	
	/**
	 * aggiunge un nuovo obbiettivo al set degli obbiettivi, se non � gi� presente
	 * 
	 * @param name = nome del nuovo obbiettivo
	 * @param amount = importo da raggiungere del nuovo obbiettivo
	 * @throws PresentElementException = restituisce PresentElementException se l'elemento da aggiungere al set � gi� presnete al suo interno
	 */
	void newObjective(String name, Double amount) throws PresentElementException; //genera eccezione
	
	/**
	 * rimuove l'obbiettivo dal set
	 * 
	 * @param o = obbiettivo da rimuovere
	 * @throws NullPointerException = restituisce NullPointEcpetion se l'elemento da rimuovere non � presente nel set
	 */
	void removeObjective(Objectives o) throws NullPointerException; //genera eccezione
	
	void addExpense(String name, String date, double amount, Category c);	//genera eccezioni
	
	/**
	 * 
	 * @param e = expense to remove
	 */
	void removeExpense(Category c, Expense e);	//genera eccezioni
	
	String getName();
	
	AccountBalance getAccountBalance();
	
	/**
	 * 
	 * @return il set di obbiettivi inseriti dall'utente
	 */
	Set<ObjectivesImpl> getObjectiveSet();
}
