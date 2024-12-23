package GUI_exam;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * 센터에 들어갈 페널 기본 틀 환불 퇴실에 관련된 정보있는 칸 만들 예정
 * <ul>
 * 	<li>2024-12-7 : 최초생성 기본틀 구성
 * 	<li>2024-12-22 : 클래스 구분
 *  <li>2024-12-22 : 다른 클래스들 패널로 추가
 * </ul>
 * 
 * @return CenterPanel
 */
public class CenterPanel extends JPanel {
	public CenterPanel() {
		this.setLayout(new CardLayout());
		this.setBackground(Color.WHITE);

		// RecordPanel과 HomePanel 객체 생성
		RecordPanel recordPanel = new RecordPanel();
		HomePanel homePanel = new HomePanel(recordPanel);

		this.add(homePanel, "home");
		this.add(recordPanel, "record");
		
	}
    /**
     * `CardLayout`을 사용하여 지정된 패널을 화면에 표시
     * 
     * @param panelName 전환할 패널의 이름("home" 또는 "record")
     */
	public void showPanel(String panelName) {
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, panelName);
    }
}
