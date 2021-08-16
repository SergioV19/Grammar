package models;

import java.util.ArrayList;

public class GrammarTree {

	private NodeProduction root;
	private ArrayList<Production> productions;

	public GrammarTree(String initialSymbol, ArrayList<Production> productions) {
		this.root = new NodeProduction(initialSymbol);
		this.productions = productions;
		addProductions();
	}

	public NodeProduction getRoot() {
		return root;
	}

	private void addProductions() {
		addProductions(root, 1);
	}

	private void addProductions(NodeProduction nodeProduction, int count) {
		for (Production production : productions) {
			for (int i = 0; i < nodeProduction.getProduction().length(); i++) {
				if (production.getProducer().equals(String.valueOf(nodeProduction.getProduction().charAt(i)))) {
					nodeProduction.addChild(nodeProduction.getProduction().replace(production.getProducer(),
							production.getProduction()));
				}
			}
		}
		if (count < 5) {
			count++;
			for (NodeProduction production : nodeProduction.getChilds()) {
				addProductions(production, count);
			}
		}
	}

}
