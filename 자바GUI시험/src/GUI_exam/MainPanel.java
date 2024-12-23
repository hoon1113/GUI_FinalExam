package GUI_exam;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * <p>
 * 메인 화면은 BorderLayout 각 영역 클래스로 구현
 * WestPanel에서 발생한 액션 이벤트를 통해 CenterPanel의 내용변경
 * </p>
 * 
 * <ul>
 * 	<li>2024-12-22 : 로그인 화면을 먼저 보이게 하기위한 클래스 구분</li>
 * </ul>
 * 
 */
public class MainPanel extends JPanel {
	/**
	 * <ul>
	 * 	<li>북쪽(NORTH): {@link NorthPanel} </li>
	 * 	<li>서쪽(WEST): {@link WestPanel} </li>
	 * 	<li>중앙(CENTER): {@link CenterPanel} </li>
	 * 	</ul>
	 * <p>
	 * WestPanel의 버튼 클릭 이벤트를 통해 CenterPanel의 내용변경
	 * </p>
	 */
	public MainPanel() {
		this.setLayout(new BorderLayout(2, 2));
		this.setBackground(Color.WHITE);

		NorthPanel northPanel = new NorthPanel();
		CenterPanel centerPanel = new CenterPanel();
		WestPanel westPanel = new WestPanel(e -> {
			String actionCommand = e.getActionCommand();
			centerPanel.showPanel(actionCommand);
		});
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(westPanel, BorderLayout.WEST);
		this.add(centerPanel, BorderLayout.CENTER);
	}
}
