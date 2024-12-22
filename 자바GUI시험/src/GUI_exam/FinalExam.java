package GUI_exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 센터에 들어갈 페널 기본 틀 환불 퇴실에 관련된 정보있는 칸 만들 예정
 * 
 * @author 김기훈
 * 실행되는 메인 클래스
 * 
 * <ul>
 * 	<li>2024-12-7 : 최초생성 기본틀 구성
 * 	<li>2024-12-22 : 클래스 구분
 * 	<li>2024-12-22 : 카드레이아웃을 위한 엑션리스너추가
 * 	<li>2024-12-22 : 로그인 화면 클래스 처음에 보이게 설정
 * </ul>
 * 
 */
public class FinalExam extends JFrame {
	private JPanel mainPanel;

	public FinalExam() {
		this.setTitle("기숙사 건의사항");
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel testPanel = new JPanel();
		testPanel.setBackground(Color.black);
		
		NorthPanel northPanel = new NorthPanel();
		CenterPanel centerPanel = new CenterPanel();
		WestPanel westPanel = new WestPanel(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String actionCommand = e.getActionCommand();
				centerPanel.showPanel(actionCommand);
			}
		});
		RockPanel rockPanel = new RockPanel();
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(westPanel, BorderLayout.WEST);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		this.add(rockPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * 화면 실행 메서드
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new FinalExam();
	}
}