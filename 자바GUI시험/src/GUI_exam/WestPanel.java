package GUI_exam;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * 좌측에있는 환불 및 퇴실, 기록, 벌점 건의 버튼
 * <ul>
 * 	<li>2024-12-7 : 최초생성 기본틀 구성
 *  <li>2024-12-22 : 클래스 구분
 * </ul>
 * 
 * @param name, 버튼안에 들어갈 이름 설정
 */
public class WestPanel extends JPanel {
    public WestPanel() {
        this.setLayout(new GridLayout(8, 0));
        this.setBackground(Color.WHITE);

        // Add buttons
        this.add(createButton("기록"));
        this.add(createButton("환불 및 퇴실"));
        this.add(createButton("벌점 건의"));
    }

    private JButton createButton(String name) {
        JButton button = new JButton(name);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        return button;
    }
}