package GUI_exam;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * 좌측에있는 환불 및 퇴실, 기록, 벌점 건의 버튼
 * <ul>
 * 	<li>2024-12-7 : 최초생성 기본틀 구성
 *  <li>2024-12-22 : 클래스 구분
 *  <li>2024-12-22 : 엑션리스너 추가 및 버튼 디자인 수정
 * </ul>
 * 
 * @param name, 버튼안에 들어갈 이름 설정
 */
public class WestPanel extends JPanel {
    public WestPanel(ActionListener buttonListener) {
        this.setLayout(new GridLayout(8, 0,1,1));
        this.setBackground(Color.WHITE);
        Color Light_Blue = new Color(74, 168, 216);
        this.add(createButton("홈", "home", buttonListener, Light_Blue));
        this.add(createButton("기록", "record", buttonListener, Light_Blue));
        this.add(createButton("환불 및 퇴실", "refund_checkout", buttonListener, Light_Blue));
        this.add(createButton("벌점 건의", "penalty", buttonListener, Light_Blue));
    }

    private JButton createButton(String name, String actionCommand, ActionListener listener, Color bule) {
        JButton button = new JButton(name);
        button.setBackground(bule);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setActionCommand(actionCommand);
        button.addActionListener(listener);
        return button;
    }
}