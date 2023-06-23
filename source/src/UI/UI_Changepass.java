package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controll.CL_ChangePass;
import Controll.UD_Pass;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class UI_Changepass {
	
	public static JFrame frame;
	private JLabel lbltieude;
	public static JPasswordField pass;
	public static JPasswordField checkpass;
	public static JLabel idchua;
	UD_Pass ud = new UD_Pass();
	public UI_Changepass() {
		init();
		
	}
	private void init() {
		frame = new JFrame("Chang password");
		frame.getContentPane().setLayout(null);
		frame.setSize(559, 279);
		frame.setLocationRelativeTo(null);
	
		lbltieude = new JLabel("Đặt mật khẩu mới");
		lbltieude.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltieude.setForeground(Color.RED);
		lbltieude.setBounds(219, 11, 153, 28);
		frame.getContentPane().add(lbltieude);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu mới");
		lblNewLabel_1.setBounds(36, 102, 97, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập lại mật khẩu");
		lblNewLabel_2.setBounds(36, 155, 113, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		JButton btnquaylai = new JButton("Quay lại");
		btnquaylai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UI_Login();
			}
		});
		btnquaylai.setBounds(347, 206, 89, 23);
		frame.getContentPane().add(btnquaylai);
		
		pass = new JPasswordField();
		pass.setBounds(199, 99, 248, 20);
		frame.getContentPane().add(pass);
		
		checkpass = new JPasswordField();
		checkpass.setBounds(199, 152, 205, 20);
		frame.getContentPane().add(checkpass);
		
		JCheckBox checkpassoke = new JCheckBox("");
		checkpassoke.setBounds(410, 139, 41, 33);
		checkpassoke.setIcon(new ImageIcon("C:\\Users\\DUC CODER SERVER\\Desktop\\eclipse java\\QLSV\\src\\image\\visibility.png"));
		frame.getContentPane().add(checkpassoke);
		
		JLabel lblNewLabel = new JLabel("Hello!");
		lblNewLabel.setBounds(185, 43, 41, 28);
		frame.getContentPane().add(lblNewLabel);
		
		idchua = new JLabel("");
		idchua.setBounds(219, 50, 70, 14);
		frame.getContentPane().add(idchua);
		
		JButton btndoi = new JButton("Đổi");
		btndoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ud.update();
			}
		});
		btndoi.setBounds(200, 206, 89, 23);
		frame.getContentPane().add(btndoi);
		
		JLabel lblNewLabel_4 = new JLabel("Cùng đặt lại mật khẩu nhé");
		lblNewLabel_4.setBounds(273, 50, 198, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new UI_Changepass();
	}
}
