package GUI_exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class FinalExam extends JFrame{
	private JPanel North, East, South, West, Center;
	private JButton Home, Memory, Pay, Point, Check;
	private JRadioButton Radio1;
	private JLabel MainName;
	
	public FinalExam() {
		this.setTitle("기숙사 건의사항");
		this.setSize(700,500);
		this.setLayout(new BorderLayout());
		North = new JPanel(new FlowLayout(FlowLayout.LEFT));
		North.setBackground(Color.white);
		West = new JPanel(new GridLayout(8,0));
		West.setBackground(Color.white);
		East = new JPanel();
		East.setBackground(Color.white);
		Center = new JPanel();
		Center.setBackground(Color.white);
		South = new JPanel();
		South.setBackground(Color.white);
		
		Home = HomeButton("수리 및 신고 시스템");
		North.add(Home);
		
		Memory = MemoryButton("기록");
		West.add(Memory);
		
		Pay = PayButton("환불 및 퇴실");
		West.add(Pay);
		
		Point = PointButton("벌점 건의");
		West.add(Point);
		
		this.add(North, BorderLayout.NORTH);
		this.add(West, BorderLayout.WEST);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	private JButton HomeButton (String name) {
		JButton Home = new JButton(name, new ImageIcon("image/CJU_Mark.jpg"));
		Home.setBorderPainted(false);
		Home.setBackground(Color.white);
		Home.setFocusPainted(false);
		return Home;
	}
	private JButton MemoryButton (String name) {
		JButton Memory = new JButton(name);
		return Memory;
	}
	private JButton PayButton (String name) {
		JButton Pay = new JButton(name);
		return Pay;
	}
	private JButton PointButton (String name) {
		JButton Point = new JButton(name);
		return Point;
	}
	public static void main(String[] args) {
		new FinalExam();

	}
}
