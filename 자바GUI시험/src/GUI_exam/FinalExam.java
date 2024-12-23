package GUI_exam;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.*;

/**
 * 센터에 들어갈 페널 기본 틀 환불 퇴실에 관련된 정보있는 칸 만들 예정
 * 
 * @author 김기훈
 * 실행되는 메인 클래스
 * 
 * <ul>
 * 	<li>2024-12-7 : 최초생성 기본틀 구성 </li>
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
	private HashMap<String, String> loginInfo;

	FinalExam() {
		this.setTitle("기숙사 건의사항");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);

		loginInfo = loadLoginInfo("image//stu.csv");

		cardLayout = new CardLayout();
		mainContainer = new JPanel(cardLayout);

		RockPanel rockPanel = new RockPanel(e -> {
			cardLayout.show(mainContainer, "MainPanel");
		}, loginInfo);

		MainPanel mainPanel = new MainPanel();

		mainContainer.add(rockPanel, "RockPanel");
		mainContainer.add(mainPanel, "MainPanel");

		this.add(mainContainer);
		cardLayout.show(mainContainer, "RockPanel"); // 처음에 RockPanel을 표시
		this.setVisible(true);
	}

	private HashMap<String, String> loadLoginInfo(String fileName) {
		HashMap<String, String> info = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length >= 2) {
					info.put(parts[0].trim(), parts[1].trim());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return info;
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
