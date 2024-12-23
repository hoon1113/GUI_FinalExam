package GUI_exam;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * <p>
 * 로그인 화면을 구현하는 클래스 KeyAdapter를 이용해 Enter 키를 눌러 로그인가능하게 구현
 * </p>
 * 
 * <p>
 * 배경 이미지와 입력 필드, 로그인 버튼을 포함 로그인 정보가 일치하지 않으면 에러 메시지가 표시
 * </p>
 *
 * <ul>
 * <li>2024-12-22 : 클래스 구분</li>
 * <li>2024-12-22 : 로그인 화면 구성 틀만 작성완료</li>
 * <li>2024-12-22 : 엑션리스너 추가로 로그인 버튼 누르면 메인패널로 화면 전환되게 구현</li>
 * <li>2024-12-23 : 엔터키로 로그인 가능하도록 구현</li>
 * <li>2024-12-23 : 배경화면 청주대사진으로 변경 및 글자 잘 보이게 레이블 배경색 추가</li>
 * </ul>
 */
public class RockPanel extends JPanel {
	private HashMap<String, String> loginInfo;
	private JLabel errorLabel;
	private BufferedImage backgroundImage;

	/**
	 * RockPanel 생성자.
	 * 
	 * @param PanelListener 로그인 버튼 클릭 시 액션을 처리하는 리스너
	 * @param loginInfo     사용자 학번과 비밀번호 정보가 저장된 HashMap
	 */

	public RockPanel(ActionListener PanelListener, HashMap<String, String> loginInfo) {
		this.loginInfo = loginInfo;

		// 이미지 로드
		try {
			backgroundImage = ImageIO.read(new File("image//CJUBackground.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			backgroundImage = null; // 이미지 로드 실패 시, 배경은 빈 상태
		}

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		// 학번 및 비밀번호
		JLabel idLabel = new JLabel("학번 :");
		idLabel.setOpaque(true);
		idLabel.setBackground(new Color(173, 216, 230));
		JTextField idField = new JTextField(15);

		JLabel passwordLabel = new JLabel("비밀번호 :");
		passwordLabel.setOpaque(true);
		passwordLabel.setBackground(new Color(173, 216, 230));
		JPasswordField passwordField = new JPasswordField(15);
		// 로그인 실패시 뜨는 글자
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setVisible(false);

		ActionListener loginAction = e -> {
			String id = idField.getText();
			String password = new String(passwordField.getPassword());

			if (loginInfo.containsKey(id) && loginInfo.get(id).equals(password)) {
				errorLabel.setVisible(false);
				PanelListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "로그인"));
			} else {
				errorLabel.setText("로그인 정보가 옳지 않습니다");
				errorLabel.setVisible(true);
			}
		};

		JButton loginButton = createButton("로그인", "로그인", loginAction);

		KeyAdapter enterKeyAdapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginAction.actionPerformed(null);
				}
			}
		};
		idField.addKeyListener(enterKeyAdapter);
		passwordField.addKeyListener(enterKeyAdapter);

		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(idLabel, gbc);

		gbc.gridx = 1;
		this.add(idField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(passwordLabel, gbc);

		gbc.gridx = 1;
		this.add(passwordField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(loginButton, gbc);

		gbc.gridy = 3;
		this.add(errorLabel, gbc);
	}

	/**
	 * 컴포넌트가 그려질 때 호출되는 메소드로, 배경 이미지를 그림
	 * 
	 * @param g 그래픽 객체
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 배경 이미지 그리기
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	/**
	 * 버튼을 생성하고 리스너를 추가하는 메소드
	 * 
	 * @param name          버튼 텍스트
	 * @param actionCommand 버튼 액션 커맨드
	 * @param listener      버튼 클릭 시 처리할 액션 리스너
	 * @return 생성된 JButton
	 */
	private JButton createButton(String name, String actionCommand, ActionListener listener) {
		JButton loginButton = new JButton(name);
		loginButton.setBackground(new Color(173, 216, 230));
		loginButton.setOpaque(true);
		loginButton.setBorderPainted(false);
		loginButton.setActionCommand(actionCommand);
		loginButton.addActionListener(listener);
		return loginButton;
	}
}