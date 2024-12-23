package GUI_exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * 메인 화면의 상단 영역(NORTH)을 구성하는 패널 클래스.
 * <ul>
 * 	<li>2024-12-22: 최초 생성 및 상단 패널 레이아웃 구성</li>
 * 	<li>2024-12-22: 버튼의 테두리 및 포커스 표시 제거로 깔끔하게 구현</li>
 * 	<li>2024-12-23: 버튼에 청주대 마크 넣기</li>
 * </ul>
 * 
 */
public class NorthPanel extends JPanel {
    /**
     * NorthPanel 생성자.
     * <p>
     * BorderLayout을 설정하여 패널을 구성
     * 상단에 "수리 및 신고 시스템" 버튼추가
     * </p>
     */
	public NorthPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);

		JButton homeButton = new JButton("수리 및 신고 시스템", new ImageIcon("image/CJU_Mark.jpg"));
		homeButton.setBorderPainted(false); // 테두리 없애기
		homeButton.setBackground(Color.WHITE);
		homeButton.setFocusPainted(false); // 포커스 표시 없애기

		this.add(homeButton, BorderLayout.WEST);
	}
}