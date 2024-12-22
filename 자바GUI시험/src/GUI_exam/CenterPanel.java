package GUI_exam;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * 센터에 들어갈 페널 기본 틀 환불 퇴실에 관련된 정보있는 칸 만들 예정
 * <ul>
 * <li>2024-12-7 : 최초생성 기본틀 구성
 * <li>2024-12-22 : 클래스 구분
 * </ul>
 * 
 */
public class CenterPanel extends JPanel {
	public CenterPanel() {
		this.setLayout(new CardLayout());
		this.setBackground(Color.WHITE);

		HomePanel homePanel = new HomePanel();
		RecordPanel recordPanel = new RecordPanel();
		Refund_CheckoutPanel refund_checkoutPanel = new Refund_CheckoutPanel();

		this.add(homePanel, "home");
		this.add(recordPanel, "record");
		this.add(refund_checkoutPanel, "refund_checkout");
		
	}
	public void showPanel(String panelName) {
        CardLayout cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, panelName);
    }
}
