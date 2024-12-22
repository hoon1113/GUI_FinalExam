package GUI_exam;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
/**
 * <ul>
 * 	<li>2024-12-22 : 로그인 화면을 먼저 보이게 하기위한 클래스 구분
 * </ul>
 * 
 */
public class MainPanel extends JPanel{
	public MainPanel() {
		this.setLayout(new BorderLayout());
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
