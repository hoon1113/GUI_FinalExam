package GUI_exam;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 좌측에있는 환불 및 퇴실, 기록, 벌점 건의 버튼
 * <ul>
 * <li>2024-12-7 : 최초생성 기본틀 구성
 * <li>2024-12-22 : 클래스 구분
 * <li>2024-12-22 : 엑션리스너 추가 및 버튼 디자인 수정
 * </ul>
 * 
 * @param  buttonListener 버튼 클릭 시 처리할 액션 리스너
 */
public class WestPanel extends JPanel {
	public WestPanel(ActionListener buttonListener) {
		this.setLayout(new GridLayout(8, 0, 1, 1));
		this.setBackground(Color.WHITE);
		Color Light_Blue = new Color(74, 168, 216);
		this.add(createButton("홈", "home", buttonListener, Light_Blue));
		this.add(createButton("기록", "record", buttonListener, Light_Blue));
	}

	/**
	 * 버튼을 생성하고 액션 리스너를 추가하는 메소드.
	 * 
	 * @param name          버튼에 표시될 텍스트
	 * @param actionCommand 버튼의 액션 커맨드
	 * @param listener      버튼 클릭 시 처리할 액션 리스너
	 * @param bule          버튼의 배경색
	 * @return 생성된 JButton 객체
	 */

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