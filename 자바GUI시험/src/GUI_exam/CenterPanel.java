package GUI_exam;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;
/**
 * 센터에 들어갈 페널 기본 틀
 * 환불 퇴실에 관련된 정보있는 칸 만들 예정
 * <ul>
 * 	<li>2024-12-7 : 최초생성 기본틀 구성
 *  <li>2024-12-22 : 클래스 구분
 * </ul>
 * 
 */
public class CenterPanel extends JPanel {
    public CenterPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.WHITE);

        JPanel homePanel = new HomePanel();
        this.add(homePanel);
    }
}
