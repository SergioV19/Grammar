package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.Grammar;
import models.Production;
import views.MyJFramePrincipal;

public class Presenter implements ActionListener{

	private MyJFramePrincipal framePrincipal;
	private Grammar grammar;
	
	public Presenter() {
		
		framePrincipal = new MyJFramePrincipal(this);
		framePrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case CREATE_GRAMMAR:
			ArrayList<String> terminals = convert(framePrincipal.getTerminals());
			ArrayList<String> noTerminals = convert(framePrincipal.getNoTerminals());
			String axiomatic = framePrincipal.getAxiomatic();
			ArrayList<Production> productions = convertProductions(framePrincipal.getProductions());
			grammar = new Grammar(terminals, noTerminals, axiomatic, productions);
			grammar.genetateTreeGrammar();
			grammar.showTree();
			break;
		}
	}
	
	private ArrayList<String> convert(String text){
		ArrayList<String> list = new ArrayList<String>();
		String [] listText = text.split(",");
		for (String string : listText) {
			list.add(string);
		}
		return list;
	}
	
	private ArrayList<Production> convertProductions(String text){
		ArrayList<Production> productions = new ArrayList<Production>();
		ArrayList<String> temp = convert(text);
		for (String p : temp) {
			productions.add(new Production(p.split(">>")[0], p.split(">>")[1]));
		}
		return productions;
	}
}
