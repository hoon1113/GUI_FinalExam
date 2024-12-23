package GUI_exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * <p>
 * 홈 화면을 구성하는 패널 수리 및 신고 내용이 표시 첫 번째 콤보박스에서 선택한 항목에 따라 두 번째 콤보박스의 내용이 동적으로 변경
 * </p>
 * 
 * <p>
 * 버튼을 클릭하면 수리 항목과 건의 사항 표시됨
 * </p>
 * <ul>
 * <li>2024-12-7 : 최초생성 기본틀 구성 및 첫번째 콤보박스 생성</li>
 * <li>2024-12-7 : 첫번째 콤보박스 클릭에 따라 두번째 콤보박스 내용 변경</li>
 * <li>2024-12-22 : 클래스 구분</li>
 * <li>2024-12-22 : 안에 패널로 구분해 디자인 챙김 및 switch 사용으로 코드 간단화</li>
 * <li>2024-12-22 : 등록버튼을 눌렀을때 최종 건의사항 및 신고 내용 보여지는 레이블 추가 (여러 줄 텍스트 출력위해 HTML
 * 사용)</li>
 * <li>2024-12-23 : HashMap을 이용한 이스터에그 추가</li>
 * </ul>
 * 
 * @return HomePanel
 */
public class HomePanel extends JPanel {
	private int recordCounter = 1; // 순번 카운터
	private RecordPanel recordPanel;
	private HashMap<String, String> userData = new HashMap<>();
	private JPanel csvOutputPanel;

	/**
	 * HomePanel 생성자 수리 및 신고 내용 입력과 출력 콤보박스 및 텍스트 필드를 포함하는 UI를 설정
	 * 
	 * @param recordPanel 수리 기록을 저장할 RecordPanel
	 */
	public HomePanel(RecordPanel recordPanel) {
		this.recordPanel = recordPanel;
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());

		// CSV 데이터 로드
		loadCsvData("image//stu1.csv");

		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		labelPanel.setBackground(Color.WHITE);
		JLabel label1 = new JLabel("접수");
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		labelPanel.add(label1);

		JPanel comboBoxPanel = new JPanel(new GridLayout(0, 4, 2, 2));
		comboBoxPanel.setBackground(Color.WHITE);

		String[] places = { "전체", "화장실", "생활관", "거실", "샤워실", "신발장", "발코니" };
		JComboBox<String> placeComboBox = new JComboBox<>(places);
		JLabel label2 = new JLabel("의");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		JComboBox<String> spotComboBox = new JComboBox<>();
		JButton finish = new JButton("등록");

		comboBoxPanel.add(placeComboBox);
		comboBoxPanel.add(label2);
		comboBoxPanel.add(spotComboBox);
		comboBoxPanel.add(finish);

		JPanel textAreaPanel = new JPanel(new BorderLayout());
		textAreaPanel.setBackground(Color.WHITE);
		JLabel textAreaLabel = new JLabel("기타 건의사항:");
		JTextArea suggestionTextArea = new JTextArea(5, 30);
		suggestionTextArea.setLineWrap(true);
		suggestionTextArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(suggestionTextArea);

		JLabel outputLabel = new JLabel();
		outputLabel.setHorizontalAlignment(SwingConstants.LEFT);
		outputLabel.setOpaque(true);
		outputLabel.setBackground(Color.LIGHT_GRAY);
		outputLabel.setForeground(Color.BLACK);

		JPanel outputPanel = new JPanel(new BorderLayout());
		outputPanel.setBackground(Color.WHITE);
		outputPanel.add(outputLabel, BorderLayout.CENTER);

		textAreaPanel.add(textAreaLabel, BorderLayout.NORTH);
		textAreaPanel.add(scrollPane, BorderLayout.CENTER);
		textAreaPanel.add(outputPanel, BorderLayout.SOUTH);

		JPanel comboDesignPanel = new JPanel(new GridLayout(6, 0));
		comboDesignPanel.setBackground(Color.WHITE);
		comboDesignPanel.add(comboBoxPanel);

		JPanel CenterCombo = new JPanel(new GridLayout(3, 0));
		CenterCombo.setBackground(Color.WHITE);
		CenterCombo.add(comboDesignPanel);
		CenterCombo.add(textAreaPanel);

		this.add(labelPanel, BorderLayout.NORTH);
		this.add(CenterCombo, BorderLayout.CENTER);

		// CSV 출력 패널
		csvOutputPanel = new JPanel(new GridLayout(0, 1));
		csvOutputPanel.setBackground(Color.WHITE);
		this.add(csvOutputPanel, BorderLayout.SOUTH);
		/**
		 * 만약 "one above all" 입력하고 등록버튼 클릭시 이스터에그 발동
		 */
		finish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedPlace = (String) placeComboBox.getSelectedItem();
				String selectedSpot = (String) spotComboBox.getSelectedItem();
				String suggestion = suggestionTextArea.getText();

				// 출력할 텍스트 구성
				if ("one above all".equalsIgnoreCase(suggestion.trim())) {
					displayCsvData();
				} else {
					String outputText = "<html><b>수리항목:</b> " + selectedPlace + "의 " + selectedSpot
							+ "<br><b>건의사항:</b> " + suggestion + "</html>";
					outputLabel.setText(outputText);

					// RecordPanel에 기록 추가
					String recordText = "수리항목: " + selectedPlace + "의 " + selectedSpot + ", 건의사항: " + suggestion;
					recordPanel.addRecord(recordText);
					recordCounter++;
				}
			}
		});

		placeComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedPlace = (String) placeComboBox.getSelectedItem();
				spotComboBox.removeAllItems();

				switch (selectedPlace) {
				case "전체":
					addItems(spotComboBox, "변기", "타일", "책상", "침대", "옷장", "창문", "선풍기", "바닥", "에어컨", "보일러", "샤워기", "배수구",
							"벽", "타올걸이", "거울", "신발서랍", "서랍거울", "난간", "실외기", "완강기", "조명");
					break;
				case "화장실":
					addItems(spotComboBox, "변기", "타일", "조명");
					break;
				case "생활관":
					addItems(spotComboBox, "책상", "침대", "옷장", "창문", "선풍기", "바닥", "조명");
					break;
				case "거실":
					addItems(spotComboBox, "바닥", "에어컨", "보일러", "조명");
					break;
				case "샤워실":
					addItems(spotComboBox, "타일", "샤워기", "배수구", "벽", "타올걸이", "거울", "조명");
					break;
				case "신발장":
					addItems(spotComboBox, "바닥", "신발서랍", "서랍거울", "조명");
					break;
				case "발코니":
					addItems(spotComboBox, "난간", "실외기", "완강기");
					break;
				}
			}

			private void addItems(JComboBox<String> comboBox, String... items) {
				for (String item : items) {
					comboBox.addItem(item);
				}
			}
		});
	}

	/**
	 * CSV 파일 데이터를 HashMap에 저장
	 * 
	 * @param filePath 로드할 CSV 파일의 경로
	 */
	private void loadCsvData(String filePath) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "EUC-KR"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 3) {
					userData.put(parts[0], "비밀번호: " + parts[1] + ", 이름: " + parts[2]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * CSV 데이터를 출력
	 */
	private void displayCsvData() {
		csvOutputPanel.removeAll();
		for (String key : userData.keySet()) {
			JLabel csvEntryLabel = new JLabel("학번: " + key + ", " + userData.get(key));
			csvOutputPanel.add(csvEntryLabel);
		}
		csvOutputPanel.revalidate();
		csvOutputPanel.repaint();
	}
}
