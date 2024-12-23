package GUI_exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class NorthPanel extends JPanel {
    public NorthPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        JButton homeButton = new JButton("수리 및 신고 시스템", new ImageIcon("image/CJU_Mark.jpg"));
        homeButton.setBorderPainted(false);
        homeButton.setBackground(Color.WHITE);
        homeButton.setFocusPainted(false);

        this.add(homeButton, BorderLayout.WEST);
    }
}