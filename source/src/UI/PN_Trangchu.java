package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class PN_Trangchu extends JPanel{
	public PN_Trangchu() {
		setBackground(Color.WHITE);
		
		setSize(778,453);
		setLayout(null);
		
		JLabel lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(getClass().getResource("/FPT_Polytechnic.png")));
		lbllogo.setBounds(23, 29, 320, 108);
		add(lbllogo);
		
		JLabel lbllocation1 = new JLabel("");
		lbllocation1.setIcon(new ImageIcon(getClass().getResource("/placeholder.png")));
		lbllocation1.setBounds(353, 11, 32, 32);
		add(lbllocation1);
		
		JLabel lblline1 = new JLabel("Tòa nhà QTSC9 (toà T), đường Tô Ký, phường Tân Chánh");
		lblline1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblline1.setBounds(395, 11, 373, 14);
		add(lblline1);
		
		JLabel lblline2 = new JLabel(" Hiệp, quận 12, TP HCM");
		lblline2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblline2.setBounds(395, 34, 162, 14);
		add(lblline2);
		
		JLabel lbllocation2 = new JLabel("");
		lbllocation2.setIcon(new ImageIcon(getClass().getResource("/placeholder.png")));
		lbllocation2.setBounds(353, 54, 32, 32);
		add(lbllocation2);
		
		JLabel lblNewLabel = new JLabel("778/B1 Nguyễn Kiệm, phường 04, quận Phú Nhuận, TP HCM");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(395, 63, 383, 14);
		add(lblNewLabel);
		                  
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/phone-call.png")));
		lblNewLabel_1.setBounds(353, 98, 32, 32);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("0704738009 - Huỳnh Tấn Phát");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(395, 104, 192, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin học tập");
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(23, 165, 149, 23);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Thông tin hoạt động");
		lblNewLabel_3_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(226, 165, 162, 23);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Thông tin học phí");
		lblNewLabel_3_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_1_1.setBounds(430, 165, 162, 23);
		add(lblNewLabel_3_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(202, 165, 1, 255);
		separator.setBorder(new LineBorder(Color.gray));
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(new LineBorder(Color.gray));
		separator_1.setBounds(405, 165, 1, 255);
		add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.white);
		panel.setBounds(10, 202, 182, 51);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("THÔNG BÁO PHÁT GIÁI NHẤT");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(22, 12, 160, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(getClass().getResource("/medal.png")));
		lblNewLabel_5.setBounds(2, 11, 16, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_1 = new JLabel("HỌC KỲ SPRING 2023");
		lblNewLabel_4_1.setForeground(Color.RED);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(22, 28, 160, 14);
		panel.add(lblNewLabel_4_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(10, 264, 182, 51);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4_2 = new JLabel("THÔNG BÁO ĐỨC GIÁI NHÌ");
		lblNewLabel_4_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_2.setBounds(22, 12, 160, 14);
		panel_1.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("HỌC KỲ SPRING 2023");
		lblNewLabel_4_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_1.setBounds(22, 28, 160, 14);
		panel_1.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("New label");
		lblNewLabel_5_1.setIcon(new ImageIcon(getClass().getResource("/silver-medal.png")));
		lblNewLabel_5_1.setBounds(2, 11, 16, 16);
		panel_1.add(lblNewLabel_5_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(10, 326, 182, 51);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("THÔNG BÁO PHÚC GIÁI BA");
		lblNewLabel_4_2_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_2_1.setBounds(22, 12, 160, 14);
		panel_2.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("HỌC KỲ SPRING 2023");
		lblNewLabel_4_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_1_1.setBounds(22, 28, 160, 14);
		panel_2.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("New label");
		lblNewLabel_5_2.setIcon(new ImageIcon(getClass().getResource("/bronze-medal.png")));
		lblNewLabel_5_2.setBounds(2, 11, 16, 16);
		panel_2.add(lblNewLabel_5_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_3.setBounds(213, 202, 182, 51);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_5_3 = new JLabel("New label");
		lblNewLabel_5_3.setIcon(new ImageIcon(getClass().getResource("/medal.png")));
		lblNewLabel_5_3.setBounds(2, 11, 16, 16);
		panel_3.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_4_3 = new JLabel("THÔNG BÁO DSSV BẢO LƯU");
		lblNewLabel_4_3.setForeground(Color.RED);
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_3.setBounds(22, 12, 160, 14);
		panel_3.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("HỌC KỲ SUMMER 2023");
		lblNewLabel_4_1_2.setForeground(Color.RED);
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_2.setBounds(22, 28, 160, 14);
		panel_3.add(lblNewLabel_4_1_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_4.setBounds(213, 264, 182, 51);
		add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("New label");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(getClass().getResource("/silver-medal.png")));
		lblNewLabel_5_1_1.setBounds(2, 11, 16, 16);
		panel_4.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("THÔNG BÁO DSSV THÔI HỌC");
		lblNewLabel_4_2_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_4_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_2_2.setBounds(22, 12, 160, 14);
		panel_4.add(lblNewLabel_4_2_2);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("HỌC KỲ SUMMER 2023");
		lblNewLabel_4_1_1_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_4_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_1_2.setBounds(22, 28, 160, 14);
		panel_4.add(lblNewLabel_4_1_1_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_5.setBounds(213, 326, 182, 51);
		add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("New label");
		lblNewLabel_5_2_1.setIcon(new ImageIcon(getClass().getResource("/bronze-medal.png")));
		lblNewLabel_5_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1.setBounds(2, 11, 16, 16);
		panel_5.add(lblNewLabel_5_2_1);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("TÌM NHÀ TRỌ KHÔNG KHÓ,");
		lblNewLabel_4_2_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_4_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_2_1_1.setBounds(22, 12, 160, 14);
		panel_5.add(lblNewLabel_4_2_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("MỌI THỨ ĐÃ CÓ NHÀ F LO");
		lblNewLabel_4_1_1_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_1_1_1.setBounds(22, 28, 160, 14);
		panel_5.add(lblNewLabel_4_1_1_1_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_6.setBounds(416, 202, 182, 51);
		add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("New label");
		lblNewLabel_5_1_1_1.setIcon(new ImageIcon(getClass().getResource("/silver-medal.png")));
		lblNewLabel_5_1_1_1.setBounds(2, 11, 16, 16);
		panel_6.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_4_2_2_1 = new JLabel("THÔNG BÁO HẠN CHÓT HỌC");
		lblNewLabel_4_2_2_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_4_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_2_2_1.setBounds(22, 12, 160, 14);
		panel_6.add(lblNewLabel_4_2_2_1);
		
		JLabel lblNewLabel_4_1_1_2_1 = new JLabel("PHÍ HỌC KỲ SUMMER 2023");
		lblNewLabel_4_1_1_2_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_4_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_1_2_1.setBounds(22, 28, 160, 14);
		panel_6.add(lblNewLabel_4_1_1_2_1);
		
		JTextPane txtpnDasdsa = new JTextPane();
		txtpnDasdsa.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnDasdsa.setForeground(Color.WHITE);
		txtpnDasdsa.setText("Xem thêm");
		txtpnDasdsa.setBackground(SystemColor.textHighlight);
		txtpnDasdsa.setBounds(10, 397, 78, 23);
		add(txtpnDasdsa);
		
		JTextPane txtpnDasdsa_1 = new JTextPane();
		txtpnDasdsa_1.setText("Xem thêm");
		txtpnDasdsa_1.setForeground(Color.WHITE);
		txtpnDasdsa_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnDasdsa_1.setBackground(SystemColor.textHighlight);
		txtpnDasdsa_1.setBounds(213, 397, 78, 23);
		add(txtpnDasdsa_1);
		
		JTextPane txtpnDasdsa_1_1 = new JTextPane();
		txtpnDasdsa_1_1.setText("Xem thêm");
		txtpnDasdsa_1_1.setForeground(Color.WHITE);
		txtpnDasdsa_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnDasdsa_1_1.setBackground(SystemColor.textHighlight);
		txtpnDasdsa_1_1.setBounds(416, 273, 78, 23);
		add(txtpnDasdsa_1_1);
		setVisible(true);
	}
}