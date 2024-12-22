package GUI_exam;

import java.awt.CardLayout;
import java.awt.Color;
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
 * 	<li>2024-12-22 : 메인패널로 패널 분리후 카드레이아웃을 이용해 로그인 화면과 메인화면 보이게 함
 * </ul>
 * 
 */
public class FinalExam extends JFrame {
	private CardLayout cardLayout;
	private JPanel mainContainer;

	FinalExam() {
		this.setTitle("기숙사 건의사항");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);

		cardLayout = new CardLayout();
		mainContainer = new JPanel(cardLayout);

		RockPanel rockPanel = new RockPanel(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				if ("로그인".equals(command)) {
					cardLayout.show(mainContainer, "MainPanel");
				}
			}
		});

		MainPanel mainPanel = new MainPanel();

		mainContainer.add(rockPanel, "RockPanel");
		mainContainer.add(mainPanel, "MainPanel");

		this.add(mainContainer);
		cardLayout.show(mainContainer, "RockPanel");
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