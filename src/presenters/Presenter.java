package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			System.out.println("creada");
			break;
		}
	}
}
