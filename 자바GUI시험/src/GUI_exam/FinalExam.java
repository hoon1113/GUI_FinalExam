package GUI_exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FinalExam extends JFrame{
	private JPanel northPanel, westPanel, centerPanel;

    public FinalExam() {
        this.setTitle("기숙사 건의사항");
        this.setSize(700, 500);
        this.setLayout(new BorderLayout());

        northPanel = new NorthPanel();
        westPanel = new WestPanel();
        centerPanel = new CenterPanel();

        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        }
    
	/**
	 * 화면 실행 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		new FinalExam();
	}
}
