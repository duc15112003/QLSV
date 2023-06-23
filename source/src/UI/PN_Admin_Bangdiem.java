package UI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import UI.*;
import Controll.*;
import OOP.OOP_BangDiem;


import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.color.ColorSpace;

import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class PN_Admin_Bangdiem extends JPanel {
	public static JFrame frame;
	public static Connection conn;
	   DefaultTableModel tblModel;
	   int index = 0;
	   CL_Admin cl = new CL_Admin();
		ArrayList<OOP_BangDiem> list = new ArrayList<OOP_BangDiem>();
	private  JPanel contentPane;
	public  static JTable tbl_bangdiem_admin;
	public static JTable table_1;
	public static JTextField txtmatimkiem;
	public static JTextField txtmasinhvien;
	public static JTextField txttensinhvien;
	public static JTextField txtmamon;
	public static JTextField txtdiem;
	
	 

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PN_Admin_Bangdiem() {
		
		init();
		cl.bangdiem_filldataall();

	}

	
	 
	
	public void init(){
		
		setVisible(true);
		setSize(803,663);
		setBounds(100, 100, 450, 300);
	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
	
			/**
			 * Create the panel.
			 */
				setBackground(new Color(255, 255, 255));
				setLayout(null);
				setSize(803,664);
				
				JLabel lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setIcon(new ImageIcon("D:\\Eclipse\\DAM_QLSV\\src\\image\\home-6-16.png"));
lblNewLabel_4.setBounds(201, 13, 23, 14);
			   add(lblNewLabel_4);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(102, 153, 204));
				panel.setBounds(8, 26, 769, 71);
				add(panel);
				panel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Mã sv:");
				lblNewLabel.setBackground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
				lblNewLabel.setBounds(10, 28, 49, 14);
				panel.add(lblNewLabel);
				
			    txtmatimkiem = new JTextField();
			  
				txtmatimkiem.setBounds(60, 20, 463, 33);
				panel.add(txtmatimkiem);
				txtmatimkiem.setColumns(10);
				
				JButton btn_timkiem = new JButton("Tìm kiếm");
				btn_timkiem.setForeground(new Color(255, 255, 255));
				btn_timkiem.setBackground(new Color(44, 130, 201));
				btn_timkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				btn_timkiem.setIcon(new ImageIcon("C:\\Users\\Admin\\.vscode\\Desktop\\java3\\QLSV\\src\\image\\search-2-24.png"));
				btn_timkiem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cl.bangdiem_search();
					}
				});
				
				btn_timkiem.setBounds(533, 20, 114, 33);
				panel.add(btn_timkiem);
				
				JButton btn_timkiem_1 = new JButton("Reset");
				btn_timkiem_1.setBackground(new Color(44, 130, 201));
				btn_timkiem_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				btn_timkiem_1.setForeground(new Color(255, 255, 255));
				btn_timkiem_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtmatimkiem.setText("");
						cl.bangdiem_clean();
					}
				});
				btn_timkiem_1.setIcon(new ImageIcon("C:\\Users\\Admin\\.vscode\\Desktop\\java3\\QLSV\\src\\image\\sinchronize-24.png"));
				btn_timkiem_1.setBounds(657, 20, 102, 33);
				panel.add(btn_timkiem_1);
				
				JLabel lblNewLabel_1 = new JLabel("Mã sinh viên:");
				lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
				lblNewLabel_1.setBounds(22, 138, 92, 14);
				add(lblNewLabel_1);
				
				txtmasinhvien = new JTextField();
				txtmasinhvien.setBounds(122, 132, 292, 27);
				add(txtmasinhvien);
				txtmasinhvien.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("Tên sinh viên:");
				lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
				lblNewLabel_2.setBounds(20, 177, 106, 14);
				add(lblNewLabel_2);
				
				txttensinhvien = new JTextField();
				txttensinhvien.setBounds(121, 173, 292, 27);
				add(txttensinhvien);
				txttensinhvien.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel("Mã môn:");
				lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
				lblNewLabel_5.setBounds(52, 215, 59, 14);
				add(lblNewLabel_5);
				
				txtmamon = new JTextField();
				txtmamon.setColumns(10);
				txtmamon.setBounds(122, 210, 292, 27);
				add(txtmamon);
				
				JLabel lblNewLabel_6 = new JLabel("Điểm:");
				lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
				lblNewLabel_6.setBounds(70, 251, 40, 21);
				add(lblNewLabel_6);
				
				txtdiem = new JTextField();
				txtdiem.setColumns(10);
				txtdiem.setBounds(121, 249, 292, 27);
				add(txtdiem);
				
				JButton btnthem = new JButton("Thêm sv");
				btnthem.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnthem.setIcon(new ImageIcon("C:\\Users\\Admin\\.vscode\\Desktop\\java3\\QLSV\\src\\image\\add-user-3-32.png"));
				btnthem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
			           cl.bangdiem_save();
						cl.bangdiem_clean();
			          
			         
		
			          
			        }				
					
				});
				btnthem.setForeground(new Color(255, 255, 255));
				btnthem.setBackground(new Color(0, 153, 204));
				btnthem.setBounds(471, 138, 129, 50);
				add(btnthem);
				
				JButton btnSua = new JButton("Sửa sv");
				btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnSua.setIcon(new ImageIcon("C:\\Users\\Admin\\.vscode\\Desktop\\java3\\QLSV\\src\\image\\edit-user-32 admn.png"));
				btnSua.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
					cl.bangdiem_clean();
					 
						
					}
				});
				btnSua.setForeground(new Color(255, 255, 255));
				btnSua.setBounds(610, 138, 129, 50);
				btnSua.setBackground(new Color(0, 153, 204));
				add(btnSua);
				
				JPanel panel_1 = new JPanel();
				panel_1.setForeground(new Color(0, 0, 0));
				panel_1.setBackground(new Color(255, 255, 255));
				
				panel_1.setBounds(7, 300, 770, 182);
				add(panel_1);
				panel_1.setLayout(null);
				tbl_bangdiem_admin = new JTable();
				tbl_bangdiem_admin.setFont(new Font("Tahoma", Font.BOLD, 15));
				tbl_bangdiem_admin.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						cl.bangdiem_filldatatotextfield();
					}
				});
				
				tbl_bangdiem_admin.setBounds(5, 45, 762, 128);
			
				panel_1.add(tbl_bangdiem_admin);
				
				tbl_bangdiem_admin.setBackground(new Color(255, 255, 255));
				tbl_bangdiem_admin.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
				tbl_bangdiem_admin.setModel(new DefaultTableModel(
					new Object[][] {
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
				
				table_1 = new JTable();
				table_1.setBounds(5, 25, 762, 20);
				panel_1.add(table_1);
				table_1.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(0, 0, 0)));
				table_1.setBackground(new Color(102, 153, 204));
     			table_1.setRowHeight(20);
				table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				table_1.setModel(new DefaultTableModel(
					new Object[][] {
						{"    M\u00E3 sinh vi\u00EAn", "    T\u00EAn sinh vi\u00EAn", "      M\u00E3 m\u00F4n", "      \u0110i\u1EC3m", "T\u00ECnh tr\u1EA1ng"},
					},
					new String[] {
"New column", "New column", "New column", "New column", "New column"
					}
				));
				
				JButton btnxoa = new JButton("Xóa sv");
				btnxoa.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnxoa.setIcon(new ImageIcon("C:\\Users\\Admin\\.vscode\\Desktop\\java3\\QLSV\\src\\image\\trash-9-32.png"));
				btnxoa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					        if (index == -1) {
					            JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng để xóa!");
					        } else {
					            cl.bangdiem_delete();
					            cl.bangdiem_filldataall();
					            cl.bangdiem_clean();
					            JOptionPane.showMessageDialog(null, "Xóa thành công!");
					        }
					}

									});
				btnxoa.setForeground(new Color(255, 255, 255));
				btnxoa.setBackground(new Color(0, 153, 204));
				btnxoa.setBounds(471, 220, 129, 50);
				add(btnxoa);
				
				JButton btnNew = new JButton("Làm mới\r\n");
				btnNew.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNew.setIcon(new ImageIcon("C:\\Users\\Admin\\.vscode\\Desktop\\java3\\QLSV\\src\\image\\sinchronize-32.png"));
				btnNew.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtmasinhvien.setText(null);
				        txttensinhvien.setText(null);
				        txtmamon.setText(null);
				        txtdiem.setText(null);
				       
					}
				});
				btnNew.setForeground(new Color(255, 255, 255));
				btnNew.setBackground(new Color(0, 153, 204));
				btnNew.setBounds(610, 220, 129, 50);
				add(btnNew);
				
				JButton btnexcel = new JButton("Excel");
				btnexcel.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnexcel.setForeground(new Color(255, 255, 255));
				btnexcel.setBackground(new Color(0, 255, 64));
				btnexcel.setBounds(682, 547, 92, 31);
				btnexcel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//cl.bangdiem_excel();
						
					}
				});
				add(btnexcel);
				table_1.getColumnModel().getColumn(0).setResizable(false);
				
		}
	           	}