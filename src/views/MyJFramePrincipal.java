package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import presenters.Events;

public class MyJFramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField terminals, noTerminals, axiomaticSymbol, productions;
	private ActionListener l;
	
	public MyJFramePrincipal(ActionListener l) {
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(5, 1, 10, 10));
		setLocationRelativeTo(null);
		
		this.l = l;
		
		terminals = new JTextField();
		setJTextField(terminals, "Ingrese los simbolos terminales separados por comas (,)  :");
		noTerminals = new JTextField();
		setJTextField(noTerminals, "Ingrese los simbolos no terminales separados por comas (,)  :");
		axiomaticSymbol = new JTextField();
		setJTextField(axiomaticSymbol, "Ingrese el simbolo inicial axiomatico  :");
		productions = new JTextField();
		setJTextField(productions, "Ingrese las producciones serparadas por comas (,) formato :(T>>a)");
		
		add(terminals);
		add(noTerminals);
		add(axiomaticSymbol);
		add(productions);
		add(editButton("Crear gramatica", Events.CREATE_GRAMMAR.name()));
	}
	
	private JButton editButton(String name, String commandName) {
		JButton btn = new JButton(name);
		btn.setActionCommand(commandName);
		btn.addActionListener(l);
		return btn;
	}
	
	private void setJTextField(JTextField jTextField, String title) {
		jTextField.setBorder(BorderFactory.createTitledBorder(title));
	}
	
	public String getTerminals() {
		return terminals.getText().replaceAll("\\s","");
	}
	
	public String getNoTerminals() {
		return noTerminals.getText().replaceAll("\\s","");
	}
	
	public String getAxiomatic() {
		return axiomaticSymbol.getText().replaceAll("\\s","");
	}
	
	public String getProductions() {
		return productions.getText().replaceAll("\\s","");
	}
}
