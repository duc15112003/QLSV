package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Controll.CL_Sinhvien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class UI_Caidat {
	JFrame frame;
	public static JLabel lblmasv;
	public static JLabel lbltensv;
	public static JLabel lblanh;
	public static JLabel lblMatkhau;
	public static JLabel lblgt;
	CL_Sinhvien cl = new CL_Sinhvien();
	public UI_Caidat() {
		init();
		frame.setVisible(true);
	}
	public void init() {
		frame = new JFrame();
		frame.setSize(500,300);
		frame.getContentPane().setLayout(null);
		
		lblanh = new JLabel("");
		lblanh.setBounds(305, 36, 134, 180);
		frame.getContentPane().add(lblanh);
		
		JLabel lblNewLabel = new JLabel("Mã Sinh Viên:");
		lblNewLabel.setBounds(10, 54, 121, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Sinh Viên:");
		lblNewLabel_1.setBounds(10, 97, 103, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Giới tính:");
		lblNewLabel_2.setBounds(10, 144, 78, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mật khẩu:");
		lblNewLabel_3.setBounds(10, 193, 78, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblmasv = new JLabel();
		lblmasv.setBounds(98, 54, 46, 14);
		frame.getContentPane().add(lblmasv);
		
		lbltensv = new JLabel();
		lbltensv.setBounds(98, 97, 46, 14);
		frame.getContentPane().add(lbltensv);
		
		lblgt = new JLabel();
		lblgt.setBounds(98, 144, 61, 14);
		frame.getContentPane().add(lblgt);
		
		lblMatkhau = new JLabel();
		lblMatkhau.setBounds(98, 193, 89, 14);
		frame.getContentPane().add(lblMatkhau);
		
		JButton btnchangePass = new JButton("Đổi MK");
		btnchangePass.setBounds(168, 189, 89, 23);
		btnchangePass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UI_ChangePassNew();
			}
		});
		frame.getContentPane().add(btnchangePass);
		
	}
	public static void main(String[] args) {
		new UI_Caidat();
	}
}
