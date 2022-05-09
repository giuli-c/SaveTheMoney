package it.savethemoney.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import it.savethemoney.controller.BankAccount;

	public class SavingPlainView extends JFrame{
		
		/**
		 * Finestra di benvenuto dove lo user può inserire i propri dati personali 
		 */
		private static final long serialVersionUID = 1L;
		
		private final String title = "SAVING PLAIN";
		private JPanel principalPanel;
		private BankAccount controller;
		private BankAccountView bankAccountView;
		private JScrollPane scrollPane;
		private JPanel objectiveArea;
		
		
		private static SavingPlainView instance = null; 
		 
	    private SavingPlainView(BankAccountView bankAccount, BankAccount controller) {
			this.bankAccountView 	= bankAccount;
			this.controller 	 	= controller;
			this.Init();
	    }
	 
	    /**
	     * Metodo statico per utilizzo del Singleton Pattern. L'interfaccia SavingPlainView viene creata esclusivamente se non è già stata creata
	     * In questo modo riusciamo a salvare i dati precedentemente inseriti all'interno dell'interfaccia (no sovrascrittura)
	     * @param bankAccount
	     * @param controller
	     * @return
	     */
	    public static SavingPlainView getInstance(BankAccountView bankAccount, BankAccount controller) {
	        if (instance == null) {
	            instance = new SavingPlainView(bankAccount, controller);
	        }
	        
	        return instance;
	    }
	 	
		
		/**
		 * Inizializzazione della finestra
		 */
		private void Init() {
			this.setTitle(title);
			this.setPreferredSize(new Dimension(450, 350));
			this.setResizable(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);				// dove si apre l'interfaccia (al centro)
			
			principalPanel = new JPanel();	
			principalPanel.setPreferredSize(new Dimension(250, 200));
			principalPanel.setLayout(new BorderLayout());	
			
			principalPanel.add(createScrollPane(), BorderLayout.CENTER);
			principalPanel.add(createButtonsPanel(), BorderLayout.PAGE_END);
			
			this.objectiveArea = new JPanel();
			objectiveArea.setPreferredSize(new Dimension(200, 150));
			this.objectiveArea.setLayout(new BoxLayout(this.objectiveArea, BoxLayout.PAGE_AXIS));
			
			this.getContentPane().add(principalPanel);
			this.pack();
			this.setLocationRelativeTo(null);				// dove si apre l'interfaccia (al centro)
			this.setVisible(true);
		}
			
		private JPanel createNewObjective(String name, Double amount, Double paidAmountUser) {			
			
			/**
			 * Pannello contenente tutti i dati del nuovo obbiettivo creato
			 */		
			JPanel newObjectivePanel = new JPanel();
			newObjectivePanel.setPreferredSize(new Dimension(300, 100));
			newObjectivePanel.setLayout(new BoxLayout(newObjectivePanel, BoxLayout.LINE_AXIS));
			newObjectivePanel.setBorder(BorderFactory.createLoweredBevelBorder());
			
			/**
			 * creazione della sezione dei dati relativo all'obbiettivo creato
			 */				
			JPanel objectiveDataPanel = new JPanel();
			objectiveDataPanel.setPreferredSize(new Dimension(200, 100));
			objectiveDataPanel.setLayout(new BoxLayout(objectiveDataPanel, BoxLayout.PAGE_AXIS));
			objectiveDataPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
			
			/**
			 * Creazione della sezione NOME da inserire dentro NEWOBJECTIVEPANEL
			 * 
			 */
			JTextField nameObjective 	= new JTextField("Name: " + name);
			nameObjective.setPreferredSize(new Dimension(150, 40));
			nameObjective.setFont(new Font("Cambria", Font.ITALIC, 15));
			nameObjective.setEditable(false);
			
			/** 
			*creazione della sezione IMPORTO DA RAGGIUNGERE da inserire dentro NEWOBJECTIVEPANEL
			*/
			JTextField importObjective 	= new JTextField("Import: " + amount);
			importObjective.setPreferredSize(new Dimension(150, 40));
			importObjective.setFont(new Font("Cambria", Font.ITALIC, 15));
			importObjective.setEditable(false);
			
			/**
			 * aggiungo i vari pannelli al pannello relativo ai dati
			 */
			objectiveDataPanel.add(nameObjective);
			objectiveDataPanel.add(importObjective);
			
			
			/**
			 * creazione della sezione dei BOTTONI dei dati relativo all'obbiettivo creato
			 */
			JPanel buttonsDataPanel = new JPanel();
			buttonsDataPanel.setPreferredSize(new Dimension(150, 100));
			buttonsDataPanel.setLayout(new BoxLayout(buttonsDataPanel, BoxLayout.PAGE_AXIS));
			buttonsDataPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
			
			
			/**
			 * creazione del bottone per modificare l'obbiettivo creato da inserire dentro NEWOBJECTIVEPANEL
			 */
			JButton modifyObjectiveButton = new JButton("...");
			modifyObjectiveButton.setPreferredSize(new Dimension(50, 30));
			modifyObjectiveButton.addActionListener(event -> {
				this.setVisible(false);
				this.dispose();	
				new ModififyObjectiveView(this, controller, name, amount);
			});
			
			/**
			 * definizione della funzione del bottone remove
			 * Per permettere la rimozione dall'interfaccia dell'elemento in questione è stata definita una nuova variabile figlio da eliminare
			 * necessaria per poter risalire al componente interno a me necessario
			 * removeButton.getParent() 			= buttonsDataPanel;
			 * removeButton.getParent().getParent()	= newObjectivePanel (buttonsDataPanel dentro newObjectivePanel)
			 * childToRemove.getParent()			= objectiveArea (newObjectivePanel dentro objectiveArea) ovvero l'elemento da eliminare
			 * Dopo di che è stato rimosso l'obbiettivo dal set degli obbiettivi
			 */
			JButton removeButton = new JButton("Remove");
			removeButton.setPreferredSize(new Dimension(80, 30));
			removeButton.addActionListener(event -> {
				this.setVisible(true);
				this.dispose();
				
				var childToRemove = removeButton.getParent().getParent();
				childToRemove.getParent().remove(childToRemove);
				this.setVisible(true);
				
				this.controller.removeObjective(this.controller.getObjectiveSet().stream().filter(o -> o.getName().equals(name)).findFirst().get());
			});
			
			/**
			 * inserimento dei bottoni relativo ai dati
			 */
			buttonsDataPanel.add(modifyObjectiveButton);
			buttonsDataPanel.add(removeButton);
			
			/**
			 * aggiungo i vari pannelli al pannello generale per la creazione di un nuovo obbiettivo
			 */
			newObjectivePanel.add(objectiveDataPanel);
			newObjectivePanel.add(buttonsDataPanel);
			
			return newObjectivePanel;
		}
		
		/**
		 * 
		 * @return scrollPane, ovvero la sezione di scorrimento
		 */
		private JScrollPane createScrollPane() {
			
			this.scrollPane = new JScrollPane();
			this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
			
			return scrollPane;
		}

		private JPanel createButtonsPanel() {
			
			JPanel buttonsPanel = new JPanel();
			buttonsPanel.setLayout(new BorderLayout());
			buttonsPanel.setBorder(BorderFactory.createEmptyBorder(50,20,20,20)); 
			
			/**
			 * definizione del bottone per aggiungere obbiettivi
			 */
			JButton addObjectives = new JButton("Add Objective");
			addObjectives.setPreferredSize(new Dimension(150, 50));
			addObjectives.addActionListener(event -> {
				this.setVisible(false);
				this.dispose();	
				new NewObjectiveView(this, controller);
			});
			
			/**
			 * definizione della funzione del bottone back
			 */
			JButton backButton = new JButton("Back");	
			backButton.setPreferredSize(new Dimension(150, 50));
			backButton.addActionListener(event -> {
				this.setVisible(false);
				this.dispose();	
				this.bankAccountView.setVisible(true);
			});
			
			buttonsPanel.add(backButton, BorderLayout.LINE_START);
			buttonsPanel.add(addObjectives, BorderLayout.LINE_END);
			
			return buttonsPanel;
		}
		
		/**
		 * metodo per aggiornare la lista degli obbiettivi dopo l'aggiunta di un nuovo obbiettivo:
		 * è stato necessario trasformare il set in una lista per inserire l'ultimo obbiettivo creato nell'objectiveArea
		 * Inoltre è stato necessario aggiornare lo ScrollPane ogni inserimento inserimento di obbiettivo
		 * e rendere il Frame visibile.
		 * 
		 */
		public void edit() {
			this.objectiveArea.add(createNewObjective(List.copyOf(controller.getObjectiveSet()).get(this.controller.getObjectiveSet().size() - 1).getName(),
													  List.copyOf(controller.getObjectiveSet()).get(this.controller.getObjectiveSet().size() - 1).getGoalAmount(),
													  null));
			
			this.scrollPane.setViewportView(this.objectiveArea);
			
			this.setVisible(true);
		}
}
				
				
