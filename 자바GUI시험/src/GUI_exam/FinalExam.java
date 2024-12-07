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
	private JPanel North, East, South, West, Center, HomePanel;
	private JButton Home, Memory, Pay, Point, Check;
	private JRadioButton Radio1;
	private JLabel l1, l2;
	/**
	 * @author 김기훈
	 * @created 2024-12-07
	 * 카드레이아웃으로 좌측 버튼 누르면 그 창(페널)으로 이동
	 * 
	 */
	public FinalExam() {
		this.setTitle("기숙사 건의사항");
		this.setSize(700,500);
		this.setLayout(new BorderLayout());
		North = new JPanel(new FlowLayout(FlowLayout.LEFT)); North.setBackground(Color.white);
		West = new JPanel(new GridLayout(8,0)); West.setBackground(Color.white);
		East = new JPanel(); East.setBackground(Color.white);
		Center = new JPanel(new FlowLayout(FlowLayout.LEFT)); Center.setBackground(Color.white);
		South = new JPanel(); South.setBackground(Color.white);
		
		HomePanel = HomePanel();
		Center.add(HomePanel);
		
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
		this.add(Center, BorderLayout.CENTER);
		this.add(East, BorderLayout.EAST);
		this.add(South, BorderLayout.SOUTH);
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
		Memory.setFocusPainted(false);
		Memory.setBorderPainted(false);
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
		Pay.setBorderPainted(false);
		Pay.setFocusPainted(false);
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
		Point.setBorderPainted(false);
		Point.setFocusPainted(false);
		return Point;
	}
	/**
	 * 창이 처음 열렸을때 center에 보여지는 화면
	 * 수리 및 신고 내용이 보여진다.
	 * 첫번째 콤보박스에서 선택한것에 따라 두번째 콤보박스내용물이 달라짐
	 * 
	 * <ul>
	 * 	<li>2024-12-7 : 최초생성 기본틀 구성 및 첫번째 콤보박스 생성
	 *  <li>2024-12-7 : 첫번째 콤보박스 클릭에 따라 두번째 콤보박스 내용 변경
	 * </ul>
	 * @return HomePanel
	 */
	private JPanel HomePanel () {
		JPanel HomePanel = new JPanel();
		JLabel l1 = new JLabel("접수");
		HomePanel.setBackground(Color.white);
		String[] places = {"전체", "화장실", "생활관", "거실", "샤워실", "신발장", "발코니"};
		JComboBox<String> place = new JComboBox<String>(places);
		JLabel l2 = new JLabel("의");
		JComboBox<String> spot = new JComboBox<>();
		HomePanel.add(l1); HomePanel.add(place); HomePanel.add(l2); HomePanel.add(spot);
		place.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selec = (String) place.getSelectedItem();
				spot.removeAllItems();
				switch (selec) {
				case "전체":
					spot.addItem("변기");
					spot.addItem("타일");
					spot.addItem("책상");
					spot.addItem("침대");
					spot.addItem("옷장");
					spot.addItem("창문");
					spot.addItem("선풍기");
					spot.addItem("바닥");
					spot.addItem("에어컨");
					spot.addItem("보일러");
					spot.addItem("샤워기");
					spot.addItem("배수구");
					spot.addItem("벽");
					spot.addItem("타올걸이");
					spot.addItem("거울");
					spot.addItem("신발서랍");
					spot.addItem("서랍거울");
					spot.addItem("난간");
					spot.addItem("실외기");
					spot.addItem("완강기");
					spot.addItem("조명");
					break;
				case "화장실":
					spot.addItem("변기");
					spot.addItem("타일");
					spot.addItem("조명");
					break;
				case "생활관":
					spot.addItem("책상");
					spot.addItem("침대");
					spot.addItem("옷장");
					spot.addItem("창문");
					spot.addItem("선풍기");
					spot.addItem("바닥");
					spot.addItem("조명");
					break;
				case "거실":
					spot.addItem("바닥");
					spot.addItem("에어컨");
					spot.addItem("보일러");
					spot.addItem("조명");
					break;
				case "샤워실":
					spot.addItem("타일");
					spot.addItem("샤워기");
					spot.addItem("배수구");
					spot.addItem("벽");
					spot.addItem("타올걸이");
					spot.addItem("거울");
					spot.addItem("조명");
					break;
				case "신발장":
					spot.addItem("바닥");
					spot.addItem("신발서랍");
					spot.addItem("서랍거울");
					spot.addItem("조명");
					break;
				case "발코니":
					spot.addItem("난간");
					spot.addItem("실외기");
					spot.addItem("완강기");
					break;
				}
				
			}
		});
		return HomePanel;
	}
	/**
	 * 화면 실행 메서드
	 * @param args
	 */
	public static void main(String[] args) {
		new FinalExam();
	}
}
