package models;

import java.util.ArrayList;

public class Grammar {

	private ArrayList<String> terminals, noTerminals;
	private String axiomticSymbol;
	private ArrayList<Production> productions;
	private GrammarTree grammarTree;

	public Grammar(ArrayList<String> terminals, ArrayList<String> noTerminals, String axiomticSymbol,
			ArrayList<Production> productions) {
		super();
		this.terminals = terminals;
		this.noTerminals = noTerminals;
		this.axiomticSymbol = axiomticSymbol;
		this.productions = productions;

	}

	public void genetateTreeGrammar() {
		grammarTree = new GrammarTree(axiomticSymbol, productions);
	}

	public String getAxiomticSymbol() {
		return axiomticSymbol;
	}

	public ArrayList<String> getNoTerminals() {
		return noTerminals;
	}

	public ArrayList<Production> getProductions() {
		return productions;
	}

	public ArrayList<String> getTerminals() {
		return terminals;
	}

	public void showTree() {
		showTree(grammarTree.getRoot(),"",0);
	}

	private void showTree(NodeProduction production, String tab, int id) {
		tab+=" ";
		id++;
		System.out.println(tab +id+  production.getProduction());
		for (NodeProduction p : production.getChilds()) {
			showTree(p, tab,id);
		}
	}

	public static void main(String[] args) {
		ArrayList<String> terminals = new ArrayList<String>();
		terminals.add("m");
		terminals.add("n");
		ArrayList<String> noTerminals = new ArrayList<String>();
		noTerminals.add("S");
		noTerminals.add("A");
		noTerminals.add("B");
		ArrayList<Production> productions = new ArrayList<Production>();
		productions.add(new Production("B", "*"));
		productions.add(new Production("B", "m"));
		productions.add(new Production("A", "Bn"));
		productions.add(new Production("A", "Am"));
		productions.add(new Production("A", "n"));
		productions.add(new Production("S", "Am"));
		Grammar grammar = new Grammar(terminals, noTerminals, "S", productions);
		grammar.genetateTreeGrammar();
		grammar.showTree();
	}
}
