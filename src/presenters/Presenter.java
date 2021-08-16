package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.MyJFramePrincipal;

public class Presenter implements ActionListener{

	private MyJFramePrincipal framePrincipal;
	
	public Presenter() {
		framePrincipal = new MyJFramePrincipal(this);
		framePrincipal.setVisible(true);
		System.out.println("Holis");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
