package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controll.CL_Sinhvien;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JTextField;
 

public class PN_Lichhoc extends JPanel {
	public static JTable tblLichHoc;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel tblModel;
	public static JComboBox ngayhoc;
	CL_Sinhvien ctrl = new CL_Sinhvien();
	public  PN_Lichhoc() {
		setSize(778,453);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(65, 11, 658, 113);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Chú ý chọn học kỳ để  xem thời khóa biểu đúng nhất");
		lblNewLabel_1.setBounds(282, 45, 336, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		ngayhoc = new JComboBox();
		ngayhoc.setBackground(new Color(255, 255, 255));
		ngayhoc.setBounds(94, 43, 153, 22);
		ngayhoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ctrl.findtheongay();
			}
		});
		panel.add(ngayhoc);
		ngayhoc.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		JLabel lblNewLabel = new JLabel("Ngày Học");
		lblNewLabel.setBounds(10, 30, 74, 47);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(65, 100, 658, 300);
		add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		tblLichHoc = new JTable();
		tblLichHoc.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		tblLichHoc.setBounds(10, 53, 633, 192);
		panel_1.add(tblLichHoc);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(51, 153, 255));
		table_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"      NG\u00C0Y H\u1ECCC", "         CA H\u1ECCC", "     TH\u1EDCI GIAN", "          M\u00C3 LH", "    PH\u00D2NG H\u1ECCC", "     M\u00D4N  H\u1ECCC"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(10, 32, 633, 16);
		panel_1.add(table_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table_2.setBounds(10, 34, 633, 16);
		panel_2.add(table_2);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_3.setBounds(10, 54, 633, 192);
		panel_2.add(table_3);
		
		JLabel lblNewLabel_2 = new JLabel("Sinh viên không vắng quá 3 buổi (17%) tổng số buổi học");
		lblNewLabel_2.setForeground(new Color(204, 0, 51));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\FrameLichHoc\\src\\framelichhoc\\warning.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(75, 411, 407, 31);
		add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 153, 255));
		panel_3.setBounds(534, 411, 55, 31);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Trước");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(90,21,234));
				lblNewLabel_3.setForeground(new Color(255,255,255));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(153, 153, 255));
				lblNewLabel_3.setForeground(new Color(0,0,0));
			}
		});
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 55, 31);
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 153, 255));
		panel_3.setBackground(new Color(102, 153, 255));
		panel_4.setBounds(635, 411, 55, 31);
		add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Sau");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setBackground(new Color(90,21,234));
				lblNewLabel_4.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(new Color(153, 153, 255));
				lblNewLabel_4.setForeground(new Color(0,0,0));
			}
		});
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 55, 31);
		panel_4.add(lblNewLabel_4);
		ctrl.fillngayhoc();
		ctrl.filllichhocdata();
	
	}
}
