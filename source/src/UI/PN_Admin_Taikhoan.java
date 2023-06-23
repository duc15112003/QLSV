package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controll.CL_Admin;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import java.awt.Label;

public class PN_Admin_Taikhoan extends JPanel{
	private JTable table;
	public static JTable table_1;
	public static JTextField txtmasv;
	public static JTextField txttensv;
	public static JTextField txtemail;
	public static JTextField txtmatkhau;
	public static Label lbltaikhoan;
	public static JLabel lblanh;
	CL_Admin cl = new CL_Admin();
	public PN_Admin_Taikhoan() {
		init();
		cl.Taikhoan_fillfirsttk();
		cl.Taikhoan_filltbtaikhoan();
	}
	public void init() {
		setSize(822,644);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Sinh Viên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 34, 120, 30);
		add(lblNewLabel);
		
		JLabel lblTnSinhVin = new JLabel("Tên Sinh Viên:");
		lblTnSinhVin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTnSinhVin.setBounds(10, 91, 120, 30);
		add(lblTnSinhVin);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(10, 146, 120, 30);
		add(lblEmail);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"M\u00E3 Sinh Vi\u00EAn", "T\u00EAn Sinh Vi\u00EAn", "Email", "M\u1EADt Kh\u1EA9u", "\u1EA2nh"},
			},
			new String[] {
				"T\u00E0i Kho\u1EA3n", "T\u00EAn Sinh Vi\u00EAn", "Email", "M\u1EADt kh\u1EA9u", "\u1EA2nh"
			}
		));
		
		table.setRowHeight(20);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(0, 0, 0)));
		table.setBackground(new Color(102, 153, 204));
		table.setBounds(25, 332, 761, 20);
		add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table_1.setBounds(25, 352, 761, 228);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.Taikhoan_filltxt();
			}
		});
		add(table_1);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMtKhu.setBounds(310, 34, 120, 30);
		add(lblMtKhu);
		
		txtmasv = new JTextField();
		txtmasv.setBounds(10, 60, 151, 20);
		add(txtmasv);
		txtmasv.setColumns(10);
		
		txttensv = new JTextField();
		txttensv.setColumns(10);
		txttensv.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				cl.Taikhoan_email();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		txttensv.setBounds(10, 119, 151, 20);
		add(txttensv);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(10, 187, 151, 20);
		add(txtemail);
		
		txtmatkhau = new JTextField();
		txtmatkhau.setColumns(10);
		txtmatkhau.setBounds(310, 60, 151, 20);
		add(txtmatkhau);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(615, 61, 158, 211);
		add(panel);
		
		lblanh = new JLabel("");
		lblanh.setBackground(Color.WHITE);
		lblanh.setBounds(10, 11, 138, 189);
		panel.add(lblanh);
		
		JButton btnadd = new JButton("Thêm");
		btnadd.setForeground(Color.WHITE);
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnadd.setBackground(new Color(0, 153, 204));
		btnadd.setBounds(301, 173, 129, 50);
		add(btnadd);
		
		JButton btndelete = new JButton("Xóa");
		btndelete.setForeground(Color.WHITE);
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btndelete.setBackground(new Color(0, 153, 204));
		btndelete.setBounds(301, 236, 129, 50);
		add(btndelete);
		
		JButton btnsave = new JButton("Lưu");
		btnsave.setForeground(Color.WHITE);
		btnsave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnsave.setBackground(new Color(0, 153, 204));
		btnsave.setBounds(459, 236, 129, 50);
		add(btnsave);
		
		JButton btnupdate = new JButton("Sửa");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.Taikhoan_updateemail();
			}
		});
		btnupdate.setForeground(Color.WHITE);
		btnupdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnupdate.setBackground(new Color(0, 153, 204));
		btnupdate.setBounds(459, 175, 129, 50);
		add(btnupdate);
		
		lbltaikhoan = new Label("New label");
		lbltaikhoan.setBounds(10, 10, 209, 22);
		add(lbltaikhoan);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBackground(new Color(0, 153, 204));
		btnReset.setBounds(301, 97, 129, 50);
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.Taikhoan_reset();
				
			}
		});
		add(btnReset);
		
		JButton btnExcel = new JButton("In Excel");
		btnExcel.setForeground(Color.WHITE);
		btnExcel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExcel.setBackground(new Color(0, 153, 204));
		btnExcel.setBounds(459, 97, 129, 50);
		btnExcel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.Taikhoan_excel();
				
			}
		});
		add(btnExcel);
		setVisible(true);
	}
}