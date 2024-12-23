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
 * 기숙사 건의사항을 간편하게 올릴수있는 프로그램
 * 
 * @author 김기훈
 *         <p>
 *         카드 레이아웃을 활용하여 로그인 화면과 메인 화면을 전환. 사용자 정보 파일(stu.csv)을 읽어 로그인.
 *         </p>
 * 
 * 
 *         <ul>
 *         <li>2024-12-7 : 최초생성 기본틀 구성</li>
 *         <li>2024-12-22 : 클래스 구분</li>
 *         <li>2024-12-22 : 카드레이아웃을 위한 엑션리스너추가</li>
 *         <li>2024-12-22 : 로그인 화면 클래스 처음에 보이게 설정</li>
 *         <li>2024-12-22 : 메인패널로 패널 분리후 카드레이아웃을 이용해 로그인 화면과 메인화면 보이게 함</li>
 *         </ul>
 * 
 */
public class FinalExam extends JFrame {
	private CardLayout cardLayout;
	private JPanel mainContainer;
	private HashMap<String, String> loginInfo;

	/**
	 * FinalExam 클래스의 생성자.
	 * <p>
	 * 창의 제목 : "기숙사 건의사항"
	 * 카드 레이아웃을 이용해 로그인 화면과 메인 화면 간의 전환
	 * </p>
	 */
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
		// 처음에 RockPanel을 표시
		cardLayout.show(mainContainer, "RockPanel");
		this.setVisible(true);
	}
    /**
     * CSV 파일의 사용자 로그인 정보를 HashMap에 저장.
     * 
     * @param fileName 읽어올 CSV 파일 경로
     * @return 학번과 비밀번호를 저장한 HashMap
     */
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
	 * 프로그램 실행
	 * @param args
	 */
	public static void main(String[] args) {
		new FinalExam();
	}
}
