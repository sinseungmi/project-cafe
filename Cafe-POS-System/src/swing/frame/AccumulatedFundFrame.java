package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ColorConvertOp;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import action.AccumulatedFundButton;
import action.AccumulatedFundTextFiel;


public class AccumulatedFundFrame extends DefaultFrame{
	
	/*
	 * setSize(), setPreferredSize() 둘다 크기를 지정해주는 메서드.
	 * 하지만 layout에서 지정을 할때는 setPreferredSize(new Dimension(x,y))를 써야한다.
	 * 
	 * */
	
	public AccumulatedFundFrame() {
	
		//(프레임)====================================================================
		
		//기본 프레임 설정
		setTitle("적립 화면");
		setSize(420,580);
		setLocation(500,100);
		setResizable(false);
		getContentPane().setBackground(new Color(243, 235, 207));
		
		//입력 필드 설정, 글씨 설정
		Font font = new Font("맑은 고딕", Font.PLAIN, 18);
		RoundJTextField textField = new RoundJTextField(30);
		textField.setFont(font);
		textField.setBounds(76,60,260,65);
		textField.setForeground(new Color(160, 160, 160));
		textField.setText("전화번호를 입력하세요");  
		
		//번호 버튼이 들어갈 패널 추가
		JPanel num_panel = new JPanel();
		num_panel.setPreferredSize(new Dimension(350,400));
		num_panel.setBounds(55,160,300,330);
		num_panel.setLayout(new GridLayout(4,3,8,8));
		num_panel.setBackground(new Color(245, 235, 208));
		
	
		ArrayList<JButton> numBtns = new ArrayList<>();
		StringBuilder phoneNum = new StringBuilder();  
		//텍스트 필드에서 입력 받는 숫자를 이어서 받기 위해 스트링빌더 준비
		
		
		//(액션)======================================================================
		
		//텍스트필드액션 불러오기
		textField.addMouseListener(new AccumulatedFundTextFiel(textField));
		//텍스트필드 비활성화 시켜서 키보드로 입력 못하게 막음.
		textField.setEditable(false); 
		
		//numBtns의 인덱스 9,10,11은 ←,0,적립으로 글자 변경 or 각각의 맞는 스타일로 다시 변경.
		for (int i = 0; i < 12; i++) {
			if (i == 10) {
				numBtns.add(new JButton("0"));
				num_button_style(numBtns,i);
			}else if (i == 9){
				numBtns.add(new JButton("←"));
				num_button_style(numBtns,i);
				numBtns.get(i).setFont(new Font("궁서체",Font.BOLD,30));
			}else if (i == 11) {
				numBtns.add(new JButton("적립"));
				num_button_style(numBtns,i);
				numBtns.get(i).setBackground(new Color(115,185,112));
				numBtns.get(i).setForeground(Color.white);  //버튼 글자색 변경
			}else {
				numBtns.add(new JButton(Integer.toString(i + 1)));
				num_button_style(numBtns,i);
			}
			
			//버튼 클릭시 일어나는 액션
			numBtns.get(i).addMouseListener(new AccumulatedFundButton(this,textField, numBtns, phoneNum));
		
		}
		
		
		//(프레임에 추가하면서 마무리)========================================================
		
		//번호패널에 번호 버튼들 추가
		for (JButton btn : numBtns) {
			num_panel.add(btn);	
		}
		
		//프레임에 패널이랑 텍스트필드 추가
		add(num_panel);
		add(textField);

		setVisible(true);
		repaint();
	}
	
	//버튼 스타일 메서드
	private void num_button_style(ArrayList<JButton> numBtns, int num) {
		numBtns.get(num).setFont(new Font("맑은 고딕",Font.PLAIN,20));
		numBtns.get(num).setBackground(new Color(255,255,255));
		numBtns.get(num).setForeground(Color.GRAY);
		numBtns.get(num).setBorderPainted(false);
		
	}

	public JFrame getAccumulatedFundFrame() {
		return this;
	}
	
	public static void main(String[] args) {
		new AccumulatedFundFrame();
		
	}

}
