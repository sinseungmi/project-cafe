package swing.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import action.ChangePageActionForChooseFrame;

public class ChoosePageFrame extends DefaultFrame {

	public ChoosePageFrame() {
		setTitle("Choose Page");
		// getContentPane() 후 배경색 지정해야 변경가능
		getContentPane().setBackground(Color.white);
		// new Color(255, 255, 227)
		String[] btns_name = { "직원 관리", "판매 등록", "매출 조회", "재고 관리" };
		ArrayList<JButton> btns = new ArrayList<>();

		for (int i = 0; i < btns_name.length; i++) {
			btns.add(new JButton(btns_name[i]));
		}

		JLabel logo = new JLabel();

		ImageIcon infoImg = new ImageIcon("./image/star.png");
		JLabel info = new JLabel(infoImg);
		info.setOpaque(true);
		info.setBounds(475, 150, 500, 300);
		info.setBackground(Color.white);
		info.setHorizontalAlignment(JLabel.LEFT);
		add(info);

		// 다른 프레임으로 이동하는 액션 리스너
		ChangePageActionForChooseFrame channel = new ChangePageActionForChooseFrame(this);

		// <<<<<<< HEAD
		// ==================================================== 직원 관리 벙튼
		btns.get(0).setBounds(160, 520, 250, 250);
		btns.get(0).setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 45));
		btns.get(0).setForeground(Color.white);
		// btns.get(i).setBackground(new Color(53, 84, 0));
		btns.get(0).setBackground(new Color(3, 102, 53));
		// =======

		// ==================================================== 판매 등록 벙튼
		btns.get(1).setBounds(760, 520, 250, 250);
		btns.get(1).setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 45));
		btns.get(1).setForeground(Color.white);
		// btns.get(i).setBackground(new Color(53, 84, 0));
		btns.get(1).setBackground(new Color(3, 102, 53));
		// 버튼 선택 시 실행되는 액션 추가
		btns.get(1).addActionListener(channel);

		add(btns.get(1));

		// ==================================================== 매출 조회 벙튼
		btns.get(2).setBounds(460, 520, 250, 250);
		btns.get(2).setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 45));
		btns.get(2).setForeground(Color.white);
		// btns.get(i).setBackground(new Color(53, 84, 0));
		btns.get(2).setBackground(new Color(3, 102, 53));
		// 버튼 선택 시 실행되는 액션 추가
		btns.get(2).addActionListener(channel);

		add(btns.get(2));

		// ==================================================== 직원 관리 벙튼
		btns.get(3).setBounds(1060, 520, 250, 250);
		btns.get(3).setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 45));
		btns.get(3).setForeground(Color.white);
		// btns.get(i).setBackground(new Color(53, 84, 0));
		btns.get(3).setBackground(new Color(3, 102, 53));
		// 버튼 선택 시 실행되는 액션 추가
		btns.get(3).addActionListener(channel);

		add(btns.get(3));

		this.repaint();
		// setVisible(true);
		// repaint() : AWT안에 구현되어있기 때문에 Frame을 상속받으면 바로 사용 가능
		// 추가된 컴포넌트들을 다시 제대로 업데이트해준다.
		// (안해주면 프레임에 마우스를 올려야지 버튼이 뜸, setvisible(true)도 같은 역할을 해주는데 여기서는 안돼서 repaint로
		// 함)
	}

	public static void main(String[] args) {
		new ChoosePageFrame();
	}

}
