package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controll.CL_Sinhvien;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class UI_ChangePassNew {
	JFrame frame;
	public static JTextField txtmkold;
	public static JTextField txtmknew;
	public static JTextField txtconfirm;
	CL_Sinhvien cl = new CL_Sinhvien();
	public UI_ChangePassNew() {
		init();
	}
	public void init() {
		frame = new JFrame();
		frame.setSize(500,300);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mật khẩu cũ:");
		lblNewLabel.setBounds(10, 91, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu mới:");
		lblNewLabel_1.setBounds(10, 143, 73, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Xác nhận");
		lblNewLabel_2.setBounds(10, 197, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtmkold = new JTextField();
		txtmkold.setBounds(110, 88, 196, 20);
		frame.getContentPane().add(txtmkold);
		txtmkold.setColumns(10);
		
		txtmknew = new JTextField();
		txtmknew.setBounds(110, 140, 196, 20);
		frame.getContentPane().add(txtmknew);
		txtmknew.setColumns(10);
		
		txtconfirm = new JTextField();
		txtconfirm.setBounds(110, 194, 196, 20);
		frame.getContentPane().add(txtconfirm);
		txtconfirm.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ĐỔI MẬT KHẨU");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(153, 21, 136, 47);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(110, 225, 89, 23);
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//cl.changePassnew();
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnConfirm);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(209, 225, 89, 23);
		frame.getContentPane().add(btnExit);
	}
}
