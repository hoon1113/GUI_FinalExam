package GUI_exam;

import java.awt.*;
import javax.swing.*;

/**
 * <ul>
 * 	<li>2024-12-22 : 클래스 구분
 * 	<li>2024-12-22 : 로그인 화면 구성 틀만 작성완료
 * </ul>
 */
public class RockPanel extends JPanel {
	public RockPanel() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		JLabel idLabel = new JLabel("학번:");
		JTextField idField = new JTextField(15);

		JLabel passwordLabel = new JLabel("비밀번호:");
		JPasswordField passwordField = new JPasswordField(15);

		JButton loginButton = new JButton("로그인");
		loginButton.setBackground(new Color(173, 216, 230)); 
		loginButton.setOpaque(true);
		loginButton.setBorderPainted(false);

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
	}
}
