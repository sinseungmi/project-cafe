package swing.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import javafx.scene.layout.Border;
import jdbc.hikari.HikariCP;
import jdbc.method.SelectDrinkInfo;
import jdbc.method.SelectEtcInfo;
import jdbc.method.SelectProductInfo;
import jdbc.method.SelectRtdInfo;
import swing.frame.DefaultFrame;

public class ReceiptView{
	String sql = "SELECT m_type_id FROM receipt_table ORDER BY receipt_id";

	Random ran = new Random();
	SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
	SimpleDateFormat f2 = new SimpleDateFormat("yyyyMMdd");
	
	int sum = 0;
	public ReceiptView() {
		printReceipt();
	}
	
	public void printReceipt() {	
		try (
				Connection conn = HikariCP.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();

		) {
			System.out.println("┌────────────────   영　수　증	 ───────────────┐");
			System.out.println("│[매장명]　몽승커피강남효성점		     		│");
			System.out.println("│[사업자]　123-45-67890		     		│");
			System.out.println("│[주   소]　서울특별시 강남구 역삼동 826-27 11, 12층		│");
			System.out.println("│[대표자]　서예림		[TEL]　010-1234-5678	│");
			System.out.printf("│[매출일]　%s\t%11s%s│\n", f1.format(Calendar.getInstance().getTime()), "[결제자]", "이승운");
			System.out.printf("│[영수증]　%s-%d-%d				│\n", f2.format(Calendar.getInstance().getTime()), 01, 01);
			System.out.println("│===============================================│");
			System.out.printf("│\t%s\t\t%7s\t%5s\t%11s\t│\n", "삼  품  명", "단  가", "수  량", "금  액");
			System.out.println("│-----------------------------------------------│");
			while (rs.next()) {
				if (rs.getInt(1) <= 110) {
					sum += new SelectDrinkInfo().getSum();
				} else if (rs.getInt(1) <= 130) {
					sum += new SelectEtcInfo().getSum();
				} else if (rs.getInt(1) <= 200) {
					sum += new SelectProductInfo().getSum();
				} else if (rs.getInt(1) == 210){
					sum += new SelectRtdInfo().getSum();
				}
			}
			System.out.println("│-----------------------------------------------│");
			System.out.printf("│%s\t\t\t\t%8d│\n", "합  계  금  액", sum);
			System.out.println("│-----------------------------------------------│");
			System.out.printf("│%s\t\t\t\t%8d│\n", "부가세  과세물품가액", sum);
			System.out.printf("│%s\t\t\t\t%8.0f│\n", "부          가          세 ", sum * 0.1);
			System.out.println("│-----------------------------------------------│");
			System.out.printf("│%s\t\t\t\t%8d│\n", "받  을  금  액", sum);
			System.out.printf("│%s\t\t\t\t%8d│\n", "받  은  금  액", sum);
			System.out.printf("│%s\t\t\t\t%8d│\n", "거  스  름  돈", 0);
			System.out.println("│-----------------------------------------------│");
			System.out.println("│\t\t\t\t\t\t│");
			System.out.printf("│%s\t\t\t\t%8d│\n", "신  용  카  드", sum);
			System.out.println("│-----------------------------------------------│");
			System.out.printf("│%s : %s\t\t\t\t\t│\n", "결  제  방  법", "일시불");
			System.out.printf("│%s :\t\t\t\t%8d│\n", "결  제  금  액", sum);
			System.out.printf("│%s : %8d\t\t\t\t│\n", "승  인  번  호", ran.nextInt(89999999) + 10000000);
			System.out.printf("│%s : %s\t\t│\n", "결  제  일  시", f1.format(Calendar.getInstance().getTime()));
			System.out.println("└───────────────────────────────────────────────┘");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
	
	public static void main(String[] args) {
		new ReceiptView();
	}
}