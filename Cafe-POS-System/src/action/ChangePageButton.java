package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import swing.frame.ChoosePageFrame;
import swing.frame.EmployeesManagementFrame;

public class ChangePageButton implements ActionListener {
	
	JFrame frame;
	
	public ChangePageButton(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnName = ((JButton)e.getSource()).getText();
		frame.dispose();
		
		switch (btnName) {
		case "<HTML>직원<br>관리</HTML>":
			new EmployeesManagementFrame();
			break;
		case "<HTML>판매<br>등록</HTML>":
			break;
		case "<HTML>매출<br>조회</HTML>":
			break;
		case "<HTML>재고<br>관리</HTML>":
			break;
		case "<<":
			new ChoosePageFrame();
			break;
		}
	}
	
}
