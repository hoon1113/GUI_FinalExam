package GUI_exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.concurrent.Flow;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RecordPanel extends JPanel {
	private JPanel centerPanel;
    private int recordCount = 0; // 기록 순서를 위한 카운터

    public RecordPanel() {
        this.setLayout(new BorderLayout());

        // 상단 레이블 ("기록")
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel recordLabel = new JLabel("기록");
        northPanel.add(recordLabel);

        // 중앙 패널 (기록 레이블 추가 영역)
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 1, 5, 5)); // 세로로 레이블 추가

        // 기본 스타일
        northPanel.setBackground(Color.WHITE);
        centerPanel.setBackground(Color.WHITE);

        // 구성 추가
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * 기록을 추가하는 메서드
     * @param recordText 추가할 기록 텍스트
     */
    public void addRecord(String recordText) {
        recordCount++; // 순서 증가
        JLabel record = new JLabel(recordCount + ". " + recordText); // 순서 번호와 텍스트 결합
        record.setHorizontalAlignment(SwingConstants.LEFT);
        centerPanel.add(record); // 중앙 패널에 레이블 추가
        centerPanel.revalidate(); // UI 갱신
        centerPanel.repaint();
    }
}
