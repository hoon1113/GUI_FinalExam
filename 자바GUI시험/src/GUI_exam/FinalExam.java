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
	/**
	 * @author 김기훈
	 * @created 2024-12-07
	 * 
	 */
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
	/**
	 * 상단에좌측에 있는 청주대 로고
	 * 나중에 홈으로 돌아가는 기능 추가 예정
	 * <ul>
	 * 	<li>2024-12-7 : 최초생성 기본틀 구성
	 * </ul>
	 * 
	 * @param name, 버튼안에 들어갈 이름 설정
	 * @return Home
	 */
	private JButton HomeButton (String name) {
		JButton Home = new JButton(name, new ImageIcon("image/CJU_Mark.jpg"));
		Home.setBorderPainted(false);
		Home.setBackground(Color.white);
		Home.setFocusPainted(false);
		return Home;
	}
	/**
	 * 좌측에 있는 기록 버튼
	 * 등록한 값을 기록하는 곳, 등록 버튼 눌렀을때 문장이 여기에 기록되어 찍힘
	 * <ul>
	 * 	<li>2024-12-7 : 최초생성 기본틀 구성
	 * </ul>
	 * @param name, 버튼에 들어갈 이름 설정
	 * @return Memory
	 */
	private JButton MemoryButton (String name) {
		JButton Memory = new JButton(name);
		return Memory;
	}
	/**
	 * 좌측에있는 환불 및 퇴실 버튼
	 * 환불 퇴실에 관련된 정보있는 칸 만들 예정
	 * <ul>
	 * 	<li>2024-12-7 : 최초생성 기본틀 구성
	 * </ul>
	 * 
	 * @param name, 버튼안에 들어갈 이름 설정
	 * @return Pay
	 */
	private JButton PayButton (String name) {
		JButton Pay = new JButton(name);
		return Pay;
	}
	/**
	 * 좌측에있는 벌점 건의 버튼
	 * 나중에 벌점에 관련된 정보 넣을 예정 (시간없으면 라벨로 정보만 나열할 예정)
	 * <ul>
	 * 	<li>2024-12-7 : 최초생성 기본틀 구성
	 * </ul>
	 * 
	 * @param name, 버튼안에 들어갈 이름 설정
	 * @return Point
	 */
	private JButton PointButton (String name) {
		JButton Point = new JButton(name);
		return Point;
	}
	/**
	 * 화면 실행 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		new FinalExam();
	}
}
