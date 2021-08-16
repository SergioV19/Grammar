package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import views.MyJFramePrincipal;

public class Presenter implements ActionListener{

	private MyJFramePrincipal framePrincipal;
	
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
}
