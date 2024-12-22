package GUI_exam;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NorthPanel extends JPanel {
    public NorthPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.WHITE);

        JButton homeButton = new JButton("수리 및 신고 시스템", new ImageIcon("image/CJU_Mark.jpg"));
        homeButton.setBorderPainted(false);
        homeButton.setBackground(Color.WHITE);
        homeButton.setFocusPainted(false);

        this.add(homeButton);
    }
}