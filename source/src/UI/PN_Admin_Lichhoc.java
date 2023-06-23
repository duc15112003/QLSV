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
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.print.Doc;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import UI.*;
import Controll.*;
import OOP.OOP_Lichhoc;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import OOP.*;
public class PN_Admin_Lichhoc  extends JPanel {
	private static final String DefaultTableModel = null;
	public static Connection con;
	   DefaultTableModel tblModel;
	  
	
	
		  CL_Admin  cl = new CL_Admin();

		ArrayList<OOP_Lichhoc> list = new ArrayList<OOP_Lichhoc>();
		 int index = 0;
	private  JPanel contentPane;
	public static JTable table_1;
	public static Object tbl_lichhoc_admin;
	public static JTextField txtmasv;
	public static  JTextField txtngayhoc;
public static  JTextField txtthoigian;
	public static  JTextField txtmamonhoc;
	public static  JTextField txtphonghoc;
	public static JTextField txtcahoc;
	public static JComboBox combo; 
	public static  JTextField txtmatimkiem;
	public static JTextField txtmalich;
	private JTable table;

	
	 

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PN_Admin_Lichhoc() {
		setSize(803,664);
		
		setLayout(null);	
			/**
			 * Create the panel.
			 */
				setBackground(new Color(255, 255, 255));
				setSize(803,664);
				
				JLabel lblNewLabel_3 = new JLabel("Lịch dạy \r\ngiảng viên\r\n\r\n\r\n");
				lblNewLabel_3.setForeground(new Color(255, 153, 0));
				lblNewLabel_3.setFont(new Font("Arial", Font.ITALIC, 30));
				lblNewLabel_3.setBounds(267, 7, 315, 37);
			add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setIcon(new ImageIcon("D:\\Eclipse\\DAM_QLSV\\src\\image\\home-6-16.png"));
lblNewLabel_4.setBounds(201, 13, 23, 14);
			   add(lblNewLabel_4);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(102, 153, 204));
				panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.setBounds(8, 45, 769, 53);
				add(panel);
				panel.setLayout(null);
				
				JButton btn_timkiem = new JButton("Tìm kiếm");
				
				btn_timkiem.setIcon(new ImageIcon("D:\\Eclipse\\DAM_QLSV\\bin\\image\\search-2-24.png"));
				btn_timkiem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//cl.search();
					}
				});
				
				btn_timkiem.setBounds(533, 12, 114, 33);
				panel.add(btn_timkiem);	
				
				JButton btn_timkiem_1 = new JButton("Reset");
				btn_timkiem_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					   //cl.clean();
					}
				});
				btn_timkiem_1.setBounds(657, 12, 102, 33);
				panel.add(btn_timkiem_1);
				
				txtmatimkiem = new JTextField();
				txtmatimkiem.setBounds(68, 16, 455, 29);
				panel.add(txtmatimkiem);
				txtmatimkiem.setColumns(10);
			
				JButton btnthem = new JButton("Thêm lh");
				btnthem.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnthem.setIcon(new ImageIcon("D:\\Eclipse\\DAM_QLSV\\bin\\image\\add-user-3-32.png"));
				btnthem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
			           add();
			           reset();
				
			        }				
					
				});
				btnthem.setForeground(new Color(0, 0, 0));
btnthem.setBackground(new Color(51, 102, 153));
				btnthem.setBounds(74, 561, 129, 50);
				add(btnthem);
				
				JPanel panel_1 = new JPanel();
				panel_1.setForeground(new Color(0, 0, 0));
				
				panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin l\u1ECBch h\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_1.setBackground(new Color(255, 255, 255));
				
				panel_1.setBounds(12, 138, 768, 282);
				add(panel_1);
				panel_1.setLayout(null);
				
				table_1 = new JTable();
				table_1.setBounds(5, 19, 758, 20);
				panel_1.add(table_1);
				table_1.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(0, 0, 0)));
				table_1.setBackground(new Color(102, 153, 204));
     			table_1.setRowHeight(20);
				table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				table_1.setModel(new DefaultTableModel(
					new Object[][] {
						{"  M\u00E3 sinh vi\u00EAn", "    Ng\u00E0y h\u1ECDc", "     Ca h\u1ECDc", "        Th\u1EDDi gian", "      M\u00E3 l\u1ECBch h\u1ECDc", "    Ph\u00F2ng h\u1ECDc "},
					},
					new String[] {
						"New column", "New column", "New column", "New column", "New column", "New column"
					}
				));
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
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
				
				tblModel = (DefaultTableModel)table.getModel();
				tblModel.setRowCount(0);
				table.setBounds(5, 50, 758, 209);
				panel_1.add(table);
				table_1.getColumnModel().getColumn(1).setResizable(false);
				
				JButton btnxoa = new JButton("Xóa lh");
				btnxoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnxoa.setIcon(new ImageIcon("D:\\Eclipse\\DAM_QLSV\\bin\\image\\trash-9-32.png"));
                btnxoa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							xoa();
							reset();
				}

									});
				btnxoa.setForeground(Color.BLACK);
				btnxoa.setBackground(new Color(51, 102, 153));
				btnxoa.setBounds(420, 560, 129, 50);
				add(btnxoa);
				
				JButton btnNew = new JButton("Làm mới\r\n");
				btnNew.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnNew.setIcon(new ImageIcon("D:\\Eclipse\\DAM_QLSV\\bin\\image\\sinchronize-32.png"));
				btnNew.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						reset();
				       
					}
				});
				btnNew.setForeground(Color.BLACK);
				btnNew.setBackground(new Color(51, 102, 153));
				btnNew.setBounds(601, 560, 129, 50);
				add(btnNew);
				
				JButton btnexcel = new JButton("Excel\r\n");
				btnexcel.setBackground(new Color(51, 102, 153));
				btnexcel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//cl.excel();
					}
				});
				btnexcel.setBounds(709, 109, 68, 23);
				add(btnexcel);
				
				JButton btnsuasv = new JButton("Sửa lh");
				btnsuasv.setIcon(new ImageIcon("D:\\Eclipse\\DAM_QLSV\\bin\\image\\edit-user-32 admn.png"));
				btnsuasv.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					//cl.update();
					update();
					reset();
						
					}
				});
				btnsuasv.setForeground(Color.BLACK);
				btnsuasv.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnsuasv.setBackground(new Color(51, 102, 153));
				btnsuasv.setBounds(243, 562, 129, 50);
				add(btnsuasv);
				
				JLabel lblNewLabel = new JLabel("Mã sv:\r\n\r\n");
				lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
				lblNewLabel.setBounds(41, 435, 38, 14);
				add(lblNewLabel);
				
				JLabel lblNgyHc = new JLabel("Ngày học:\r\n");
				lblNgyHc.setFont(new Font("Arial", Font.PLAIN, 11));
				lblNgyHc.setBounds(26, 479, 56, 14);
				add(lblNgyHc);
				
				JLabel lblCaHc = new JLabel("Ca học:\r\n");
				lblCaHc.setFont(new Font("Arial", Font.PLAIN, 11));
				lblCaHc.setBounds(28, 527, 56, 14);
				add(lblCaHc);
				
				JLabel lblThiGian = new JLabel("Thời gian:\r\n");
				lblThiGian.setFont(new Font("Arial", Font.PLAIN, 11));
				lblThiGian.setBounds(406, 438, 62, 14);
				add(lblThiGian);
				
				JLabel lblMLchHc = new JLabel("Mã lịch học:");
				lblMLchHc.setFont(new Font("Arial", Font.PLAIN, 11));
				lblMLchHc.setBounds(393, 479, 75, 14);
				add(lblMLchHc);
				
				JLabel lblPhngHc = new JLabel("Phòng học:");
				lblPhngHc.setFont(new Font("Arial", Font.PLAIN, 11));
				lblPhngHc.setBounds(401, 523, 68, 14);
				add(lblPhngHc);
txtmasv = new JTextField();
				txtmasv.setBounds(90, 431, 260, 27);
				add(txtmasv);
				txtmasv.setColumns(10);
				
				txtngayhoc = new JTextField();
				txtngayhoc.setColumns(10);
				txtngayhoc.setBounds(91, 477, 260, 27);
				add(txtngayhoc);
				
			
				
				txtthoigian = new JTextField();
				txtthoigian.setColumns(10);
				txtthoigian.setBounds(472, 430, 260, 27);
				add(txtthoigian);
				
				txtmamonhoc = new JTextField();
				txtmamonhoc.setColumns(10);
				txtmamonhoc.setBounds(100, 104, 130, 27);
				add(txtmamonhoc);
				
				txtphonghoc = new JTextField();
				txtphonghoc.setColumns(10);
				txtphonghoc.setBounds(473, 516, 260, 27);
				add(txtphonghoc);
				
				txtcahoc = new JTextField();
				txtcahoc.setBounds(89, 519, 260, 27);
				add(txtcahoc);
				txtcahoc.setColumns(10);
				combo = new JComboBox();
				combo.setBounds(11, 100, 79, 33);
				add(combo);
				combo.setModel(new DefaultComboBoxModel(new String[] {"HP01", "HP02", "HP03", "HP04"}));
				
				txtmalich = new JTextField();
				txtmalich.setBounds(472, 473, 260, 28);
				add(txtmalich);
				txtmalich.setColumns(10);
				
				JButton btnNewButton = new JButton("Hiển Thị Tất Cả");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						filltb();
					}
				});
				btnNewButton.setBounds(267, 106, 149, 23);
				add(btnNewButton);
				combo.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
							PreparedStatement ps = cn.prepareStatement("use QLSV;select * from LICHHOC where mamonhoc = ?");
							ps.setString(1,(String)combo.getSelectedItem());
							ResultSet rs = ps.executeQuery();
							while(rs.next()) {
								DefaultTableModel model = (DefaultTableModel)table.getModel();
								Vector vt = new Vector();
								vt.add(rs.getString("masv"));
								vt.add(rs.getString("ngayhoc"));
								vt.add(rs.getString("cahoc"));
								vt.add(rs.getString("thoigian"));
								vt.add(rs.getString("malichhoc"));
								vt.add(rs.getString("PhongHoc"));
								model.addRow(vt);
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				});
				combo.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//cl.table();
						
					}
				}); 
				//cl.filldataall();
				
	        	}
	public void add() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV;Insert into LICHHOC values(?,?,?,?,?,?,?)");
			ps.setString(1,txtmasv.getText());
			ps.setString(2,txtngayhoc.getText());
			ps.setString(3,txtcahoc.getText());
			ps.setString(4,txtthoigian.getText());
			ps.setString(5,txtmalich.getText());
			ps.setString(6,txtphonghoc.getText());
			ps.setString(7,txtmamonhoc.getText());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void filltb(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV;select * from LICHHOC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				Vector vt = new Vector();
				vt.add(rs.getString("masv"));
				vt.add(rs.getString("ngayhoc"));
				vt.add(rs.getString("cahoc"));
				vt.add(rs.getString("thoigian"));
				vt.add(rs.getString("malichhoc"));
				vt.add(rs.getString("PhongHoc"));
				model.addRow(vt);
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	public void reset() {
		txtmasv.setText("");
		txtngayhoc.setText("");
		txtcahoc.setText("");
		txtthoigian.setText("");
		txtmalich.setText("");
		txtphonghoc.setText("");
		txtmamonhoc.setText("");
	}
	public void update() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV;Update LICHHOC set masinhvien =?,ngayhoc=?,cahoc=?,thoigian=?,malichhoc=?,PhongHoc=?,mamonhoc=?");
			ps.setString(1,txtmasv.getText());
			ps.setString(2,txtngayhoc.getText());
			ps.setString(3,txtcahoc.getText());
			ps.setString(4,txtthoigian.getText());
			ps.setString(5,txtmalich.getText());
			ps.setString(6,txtphonghoc.getText());
			ps.setString(7,txtmamonhoc.getText());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void xoa() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV;delete from LICHHOC where malichhoc = ?");;
			ps.setString(1,txtmalich.getText());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}