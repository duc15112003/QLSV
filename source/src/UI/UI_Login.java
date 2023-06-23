package UI;

import java.awt.Color;

import javax.swing.*;
import java.awt.Font;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Controll.CL_ChangePass;
import Controll.CL_Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class UI_Login {
	
    MatteBorder textFiled__border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(103, 128, 159));
	public static JFrame frame;
	public JPanel panel_frame;
	JPanel panel_Logo;
	JLabel Logo;
	public static JPanel panel_Login;
	public static JLabel tieudelogin;
	public static JLabel icon_user;
	public static JLabel icon_email;
	public static JLabel icon_pass;
	public static JTextField txtuser;
	public static JPasswordField txtpass;
	JButton btnNewButton;
	CL_Login cl = new CL_Login();
	CL_ChangePass ps = new CL_ChangePass();
	private JLabel lblNewLabel_1;
	boolean ret = true;
	public UI_Login() {
		init();
	}
	private void init() {
		frame = new JFrame("Login Form");
		frame.setSize(820, 486);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		panel_frame = new JPanel();
		panel_frame.setSize(600,400);
		panel_frame.setBackground(Color.white);
		panel_frame.setLayout(null);
		frame.getContentPane().add(panel_frame);
		
		panel_Logo = new JPanel();
		panel_Logo.setBounds(10, 11, 376, 425);
		panel_Logo.setLayout(null);
		panel_Logo.setBackground(new Color(51, 102, 153));
		panel_frame.add(panel_Logo);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(getClass().getResource("/man.png")));
		Logo.setBounds(110, 106, 144, 155);
		panel_Logo.add(Logo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 204));
		panel.setBounds(0, 199, 376, 226);
		panel_Logo.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/pdf-file-6-64.png")));
		lblNewLabel_1.setBounds(114, 64, 158, 128);
		panel.add(lblNewLabel_1);
		
		panel_Login = new JPanel();
		panel_Login.setBorder(null);
		panel_Login.setBounds(396, 11, 398, 425);
		panel_Login.setBackground(Color.white);
		panel_Login.setLayout(null);
		panel_frame.add(panel_Login);
		
		tieudelogin = new JLabel("Login");
		tieudelogin.setForeground(new Color(51, 102, 153));
		tieudelogin.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		tieudelogin.setBounds(147, 9, 151, 74);
		panel_Login.add(tieudelogin);
		
		icon_user = new JLabel("");
		icon_user.setIcon(new ImageIcon(getClass().getResource("/edit-user-32.png")));
		icon_user.setBounds(39, 110, 36, 37);
		panel_Login.add(icon_user);
icon_email = new JLabel("");
		icon_email.setIcon(new ImageIcon(getClass().getResource("/lock-3-32.png")));
		icon_email.setBounds(39, 192, 36, 33);
		panel_Login.add(icon_email);
		
		icon_pass = new JLabel("");
		icon_pass.setIcon(new ImageIcon(getClass().getResource("/padlock-10-24.png")));
		icon_pass.setBounds(25, 235, 24, 53);
		panel_Login.add(icon_pass);
		txtuser = new JTextField();
		txtuser.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtuser.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method 
				String name = txtuser.getText().trim().toLowerCase();
				if (name.equals("id") ||  name .equals("")) {
					txtuser.setText("id");
					txtuser.setForeground(new Color(58, 83, 155));
					
				}
      }
				
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				String name = txtuser.getText().trim().toLowerCase();
				if (name.equals("id")) {
					txtuser.setText("");
					txtuser.setForeground(Color.black);
					
				}
			}
		});
		
		txtuser.setText("id");
		txtuser.setBounds(85, 120, 292, 27);
		txtuser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(102,102,102)));
		panel_Login.add(txtuser);
		txtuser.setColumns(10);
		txtuser.setBorder(textFiled__border);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBackground(new Color(51, 102, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.Login();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(82, 300, 292, 43);
		panel_Login.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Quên Mật Khẩu ?");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(88, 249, 121, 25);
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ps.email();
				
			}
		});
		panel_Login.add(lblNewLabel);
		
		txtpass = new JPasswordField();
		txtpass.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				String pass = String.valueOf(txtpass.getPassword()).trim().toLowerCase();
				if (pass.equals("password") ||  pass .equals("")) {
					txtpass.setText("password");
					txtpass.setForeground(new Color(58, 83, 155));
			}
			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
				String pass = String.valueOf(txtpass.getPassword()).trim().toLowerCase();
				if (pass.equals("password")) {
					txtpass.setText("");
					txtpass.setForeground(Color.black);
					
				}
				
			}
		});
		txtpass.setBounds(85, 197, 252, 27);
txtpass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(102,102,102)));
		txtpass.setText("password");
		panel_Login.add(txtpass);
		txtpass.setBorder(textFiled__border);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ret==true) {
					txtpass.setEchoChar((char)0);
					ret = false;
				}else {
					txtpass.setEchoChar('*');
					ret = true;
				}

			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/anhienMK-32.png")));
		lblNewLabel_2.setBounds(343, 198, 34, 27);
		
		panel_Login.add(lblNewLabel_2);
		
	}
}