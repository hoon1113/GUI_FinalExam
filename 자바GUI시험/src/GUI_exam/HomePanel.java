package GUI_exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
/**
 * 창이 처음 열렸을때 center에 보여지는 화면
 * 수리 및 신고 내용이 보여진다.
 * 첫번째 콤보박스에서 선택한것에 따라 두번째 콤보박스내용물이 달라짐
 * 
 * <ul>
 * 	<li>2024-12-7 : 최초생성 기본틀 구성 및 첫번째 콤보박스 생성
 *  <li>2024-12-7 : 첫번째 콤보박스 클릭에 따라 두번째 콤보박스 내용 변경
 *  <li>2024-12-22 : 클래스 구분
 *  <li>2024-12-22 : 안에 패널로 구분해 디자인 챙김 및 switch 사용으로 코드 간단화
 *  <li>2024-12-22 : 등록버튼을 눌렀을때 최종 건의사항 및 신고 내용 보여지는 레이블 추가 (여러 줄 텍스트 출력위해 HTML 사용 (GPT도움))
 * </ul>
 * @return HomePanel
 */
public class HomePanel extends JPanel {
    public HomePanel() {
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelPanel.setBackground(Color.WHITE);
        JLabel label1 = new JLabel("접수");
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        labelPanel.add(label1);
        
        JPanel comboBoxPanel = new JPanel(new GridLayout(0,4));
        comboBoxPanel.setBackground(Color.WHITE);
        
        String[] places = {"전체", "화장실", "생활관", "거실", "샤워실", "신발장", "발코니"};
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
        
        this.add(labelPanel, BorderLayout.NORTH);
        this.add(comboBoxPanel, BorderLayout.CENTER);
        this.add(textAreaPanel, BorderLayout.SOUTH);
        
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPlace = (String) placeComboBox.getSelectedItem();
                String selectedSpot = (String) spotComboBox.getSelectedItem();
                String suggestion = suggestionTextArea.getText();

                // 출력할 텍스트 구성
                String outputText = "<html><b>선택된 항목:</b> " + selectedPlace + "의 " + selectedSpot
                        + "<br><b>건의사항:</b> " + suggestion + "</html>";

                // 결과 출력
                outputLabel.setText(outputText);
            }
        });

        placeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPlace = (String) placeComboBox.getSelectedItem();
                spotComboBox.removeAllItems();

                switch (selectedPlace) {
                    case "전체":
                        addItems(spotComboBox, "변기", "타일", "책상", "침대", "옷장", "창문", "선풍기", "바닥", "에어컨", "보일러", "샤워기", "배수구", "벽", "타올걸이", "거울", "신발서랍", "서랍거울", "난간", "실외기", "완강기", "조명");
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
}