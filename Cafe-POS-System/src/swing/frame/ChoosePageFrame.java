package swing.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class ChoosePageFrame extends DefaultFrame {
	
	public ChoosePageFrame() {
		setTitle("Choose Page");
		
		String[] btns_name = {"<HTML>����<br>����</HTML>", "<HTML>�Ǹ�<br>���</HTML>", "<HTML>����<br>��ȸ</HTML>"};
		ArrayList<JButton> btns = new ArrayList<>();
		
		for (int i = 0; i < btns_name.length; i++) {
			btns.add(new JButton(btns_name[i]));
		}
		
		for (int i = 0; i < btns_name.length; i++) {
			btns.get(i).setBounds(300 * (i + 1), 220, 250, 500);
			btns.get(i).setFont(new Font("���� ����", Font.BOLD|Font.ITALIC, 50));
			btns.get(i).setForeground(Color.WHITE);
			btns.get(i).setBackground(new Color(53, 84, 0));
			btns.get(i).setBackground(new Color(53, 84, 0));
			btns.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals(btns_name[0])) {
						System.out.println("���� ���� ��ư");
					} else if (e.getActionCommand().equals(btns_name[1])) {
						System.out.println("�Ǹ� ��� ��ư");
					} else {
						System.out.println("���� ��ȸ ��ư");
					}
				}
			});
			
			add(btns.get(i));
		}
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ChoosePageFrame();
	}
}