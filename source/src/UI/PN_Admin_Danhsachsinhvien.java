package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controll.*;
import OOP.OOP_Sinhvien;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.SystemColor;

public class PN_Admin_Danhsachsinhvien extends JPanel {
	public static JTable tblSinhvien;
	public static JTextField txtmasinhvien;
	public static JTextField txttensinhvien;
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public static JComboBox cbomalop;
	public static JRadioButton rdonam;
	public static JRadioButton rdonu;
	public static JRadioButton rdokhac;
	public static JTextArea txtdiachi;
	public static JLabel anh;
	public static String path;
	DefaultTableModel tblModel;
	
	JLabel lblNewLabel;
	JSeparator separator;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	JLabel lblNewLabel_6;
	JSeparator separator_1;
	public static JTextField txtngaythangnamsinh;
	//CL_Admin ad = new CL_Admin();
	private JTable table_1;
	List<OOP_Sinhvien> list = new ArrayList<>();
	List<OOP_Sinhvien> listsvnhap = new ArrayList<>();
	List<OOP_Sinhvien> listtk = new ArrayList<>();
	public PN_Admin_Danhsachsinhvien() {
		
		setBackground(Color.WHITE);
		setSize(803, 644);
		setLayout(null);
		
		tblSinhvien = new JTable();
		tblSinhvien.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		tblSinhvien.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Ma SV", "Ten SV", "Ma Lop", "Gioi Tinh", "Ngay Sinh", "Dia Chi", "Email"
			}
		));
		tblSinhvien.setBounds(10, 361, 761, 254);
		tblSinhvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			fillclicked();
			}
		});
		add(tblSinhvien);
		
		txtmasinhvien = new JTextField();
		txtmasinhvien.setBounds(10, 80, 130, 20);
		add(txtmasinhvien);
		txtmasinhvien.setColumns(10);
		
		txttensinhvien = new JTextField();
		txttensinhvien.setColumns(10);
		txttensinhvien.setBounds(10, 136, 130, 20);
		add(txttensinhvien);
		
		cbomalop = new JComboBox();
		cbomalop.setBounds(10, 201, 130, 22);
		add(cbomalop);
		
		rdonam = new JRadioButton("Nam");
		rdonam.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdonam);
		rdonam.setBackground(Color.WHITE);
		rdonam.setBounds(246, 79, 55, 23);
		add(rdonam);
		
		rdonu = new JRadioButton("Nữ");
		rdonu.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdonu);
		rdonu.setBackground(Color.WHITE);
		rdonu.setBounds(303, 79, 55, 23);
		add(rdonu);
		
		rdokhac = new JRadioButton("Khác");
		rdokhac.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(rdokhac);
		rdokhac.setBackground(Color.WHITE);
		rdokhac.setBounds(360, 79, 56, 23);
		add(rdokhac);
		
		txtdiachi = new JTextArea();
		txtdiachi.setBounds(10, 263, 130, 69);
		add(txtdiachi);
		
		lblNewLabel = new JLabel("Giới Tính");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(246, 64, 75, 14);
		add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.GREEN);
		separator.setBounds(235, 47, 1, 285);
		separator.setBorder(new LineBorder(Color.black));
		add(separator);
		
		lblNewLabel_2 = new JLabel("Mã Sinh Viên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 63, 114, 14);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Tên Sinh Viên");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 111, 114, 14);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Mã Lớp");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 182, 82, 14);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Địa Chỉ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 239, 75, 14);
		add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Ngày Sinh");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(246, 109, 89, 14);
		add(lblNewLabel_6);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.GREEN);
		separator_1.setBorder(new LineBorder(Color.black));
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(479, 47, 1, 285);
		add(separator_1);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				autouser();
				addsvtosql();
				filldatatolist();
				filldatatotable();
				reset();
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(0, 153, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(246, 171, 82, 39);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sửa");
		btnNewButton_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 String gioitinh = "", email="Chua cap" ;
				 if(rdonam.isSelected())
					{
						gioitinh = "Nam";
					}
					else if(rdonu.isSelected())
					{
						gioitinh="Nữ";
					}
					else if(rdokhac.isSelected())
					{
						gioitinh="Khác";
					}
					
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
				            + "databaseName=QLSV;user=phat;password=123;encrypt=false");
					String query = "update SINHVIEN set hotensinhvien=?,malop=?,gioitinh=?,ngaysinh=?,diachi=?, email=?,anh = ? where masinhvien=?";
					
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, txttensinhvien.getText());
					pst.setString(2, (String)cbomalop.getSelectedItem());
					pst.setString(3,gioitinh);
					pst.setString(4, txtngaythangnamsinh.getText());
					pst.setString(5, txtdiachi.getText());
					pst.setString(6, email);
					pst.setString(7, path);
					pst.setString(8, txtmasinhvien.getText());
					pst.executeQuery();
					
					tblModel = (DefaultTableModel) tblSinhvien.getModel();
					String[] row = {txtmasinhvien.getText(),(String)cbomalop.getSelectedItem(),gioitinh,txtngaythangnamsinh.getText(),
					txtdiachi.getText(), email};
					tblModel.addRow(row);
					//tblModel.setRowCount(0);
					
					

				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(new Color(0, 153, 204));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1.setBounds(360, 172, 89, 39);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBackground(new Color(0, 153, 204));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteuser();
				deletesinhvien();
				filldatatolist();
				filldatatotable();
				reset();
			}
		});
		btnNewButton_2.setBounds(246, 229, 82, 39);
		add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Tìm Kiếm");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tk_user();
				filltk();
			}
		});
		btnNewButton_2_1.setForeground(SystemColor.text);
		btnNewButton_2_1.setBackground(new Color(0, 153, 204));
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_2_1.setBounds(360, 229, 89, 39);
		add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Add Ảnh");
		btnNewButton_2_1_1.setForeground(SystemColor.text);
		btnNewButton_2_1_1.setBackground(new Color(0, 153, 204));
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
                fc.addChoosableFileFilter(new FileNameExtensionFilter(
                    "Image (jpg, jpeg, png, bmp, gif)", 
                    "jpg", "jpeg", "png", "bmp", "gif"
                ));
                int n = fc.showOpenDialog(btnNewButton_2_1_1);
  
                if(n == JFileChooser.APPROVE_OPTION)
                path = fc.getSelectedFile().getAbsolutePath();
                anh.setIcon(new ImageIcon(path));
                System.out.println(path);
				
			}
		});
		btnNewButton_2_1_1.setBounds(576, 263, 129, 50);
		add(btnNewButton_2_1_1);
		
		txtngaythangnamsinh = new JTextField();
		txtngaythangnamsinh.setBounds(246, 136, 155, 20);
		add(txtngaythangnamsinh);
		txtngaythangnamsinh.setColumns(10);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"M\u00E3 SV", "T\u00EAn SV", "M\u00E3 L\u1EDBp", "Gi\u1EDBi T\u00EDnh", "Ng\u00E0y Sinh", "\u0110\u1ECBa ch\u1EC9", "Email"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setRowHeight(20);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_1.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(0, 0, 0)));
		table_1.setBackground(new Color(102, 153, 204));
		table_1.setBounds(10, 343, 761, 20);
		add(table_1);
		
		JButton btnExcel = new JButton("Excel");
		btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcel.setForeground(Color.WHITE);
		btnExcel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExcel.setBackground(new Color(0, 153, 204));
		btnExcel.setBounds(360, 282, 89, 39);
		add(btnExcel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(563, 47, 155, 177);
		add(panel);
		panel.setLayout(null);
		
		anh = new JLabel("New label");
		anh.setBounds(10, 5, 135, 161);
		panel.add(anh);
		
		JButton btnNewButton_2_1_2 = new JButton("Reset");
		btnNewButton_2_1_2.setForeground(Color.WHITE);
		btnNewButton_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_2_1_2.setBackground(new Color(0, 153, 204));
		btnNewButton_2_1_2.setBounds(246, 279, 82, 39);
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reset();
			}
		});
		add(btnNewButton_2_1_2);
		
		//ad.Dssv_filldataall();
	//	ad.Dssv_filldatavocombobox();
		filldataincombo();
		filldatatolist();
	}
	public void filldataincombo() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV; select malophoc from LOPHOC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cbomalop.addItem(rs.getString("malophoc"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void filldatatolist() {
		try {
			list.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV; select * from SINHVIEN");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				OOP_Sinhvien sv = new OOP_Sinhvien(rs.getString("masinhvien"),rs.getString("hotensinhvien"),rs.getString("malop"),rs.getString("gioitinh"),rs.getString("ngaysinh"),rs.getString("diachi"),rs.getString("email"), rs.getString("anh"));
				list.add(sv);
			}
			filldatatotable();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void filldatatotable() {
		tblModel = (DefaultTableModel)tblSinhvien.getModel();
		tblModel.setRowCount(0);
		for(OOP_Sinhvien sv :list) {
			Object[] op = new Object[] {sv.getMasv(),sv.getTensv(),sv.getMalop(),sv.getGioitinh(),sv.getNgaysinh(),sv.getDiachi(),sv.getEmail()};
			tblModel.addRow(op);
		}
		
	}
	public void autouser() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV; insert into BangUser values(?,?,?)");
			ps.setString(1,txtmasinhvien.getText());
			ps.setString(2,"123");
			ps.setString(3,"User");
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void addsvtosql() {
		if(txtmasinhvien.getText().equals("")) {
			JOptionPane.showMessageDialog(cbomalop, "Đang trống dữ liệu");
		}else {
			try {
				String gt = "";
				if(rdonam.isSelected()) {
					gt = "Nam";
				}else if(rdonu.isSelected()){
					gt = "Nữ";
				}else if(rdokhac.isSelected()) {
					gt = "Khác";
				}

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV; insert into SINHVIEN values(?,?,?,?,?,?,?,?)");
			ps.setString(1, txtmasinhvien.getText());
			ps.setString(2, txttensinhvien.getText());
			ps.setString(3, (String)cbomalop.getSelectedItem());
			ps.setString(4, gt);
			ps.setString(5, txtngaythangnamsinh.getText());
			ps.setString(6, txtdiachi.getText());
			ps.setString(7, "Chưa cấp");
			ps.setString(8, path);
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
	}
	public void tk_user() {
		try {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=QLSV;username=phat;password=123");
				PreparedStatement ps = cn.prepareStatement("use QLSV; select * from SINHVIEN where masinhvien = ?");
				ps.setString(1,txtmasinhvien.getText());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					OOP_Sinhvien sv = new OOP_Sinhvien(rs.getString("masinhvien"),rs.getString("hotensinhvien"),rs.getString("malop"),rs.getString("gioitinh"),rs.getString("ngaysinh"),rs.getString("diachi"),rs.getString("email"), rs.getString("anh"));
					listtk.add(sv);
				}
				ps.executeQuery();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void filltk() {
		tblModel = (DefaultTableModel)tblSinhvien.getModel();
		tblModel.setRowCount(0);
		for(OOP_Sinhvien sv :listtk) {
			Object[] op = new Object[] {sv.getMasv(),sv.getTensv(),sv.getMalop(),sv.getGioitinh(),sv.getNgaysinh(),sv.getDiachi(),sv.getEmail()};
			tblModel.addRow(op);
		}
	}
	public void deleteuser() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV; delete from Banguser where id = ?");
			ps.setString(1, txtmasinhvien.getText());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void deletesinhvien() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV; delete from SINHVIEN where masinhvien = ?");
			ps.setString(1, txtmasinhvien.getText());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void fillclicked() {
		txtmasinhvien.setEnabled(false);
		int index = tblSinhvien.getSelectedRow();
		txtmasinhvien.setText(list.get(index).getMasv()) ;
		txttensinhvien.setText(list.get(index).getTensv());;
		cbomalop.setSelectedItem(list.get(index).getMalop());
		if(list.get(index).getGioitinh().equals("Nam")) {
			rdonam.setSelected(true);
		}else if(list.get(index).getGioitinh().equals("Nữ")) {
			rdonu.setSelected(true);
		}else if(list.get(index).getGioitinh().equals("Khác")) {
			rdokhac.setSelected(true);
		}
		txtngaythangnamsinh.setText(list.get(index).getNgaysinh());
		txtdiachi.setText(list.get(index).getDiachi());
	}
	public void update() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV; Update SINHVIEN set hotensinhvien =?, malop = ?,gioitinh = ?,ngaysinh = ?,diachi = ?,anh = ?");
			ps.setString(1, txttensinhvien.getText());
			ps.setString(2, (String)cbomalop.getSelectedItem());
			ps.setString(3, TOOL_TIP_TEXT_KEY);
			ps.setString(4, TOOL_TIP_TEXT_KEY);
			ps.setString(5, TOOL_TIP_TEXT_KEY);
			ps.setString(6, TOOL_TIP_TEXT_KEY);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void reset() {
		txtmasinhvien.setEnabled(true);	
		txttensinhvien.setText("");
		cbomalop.setSelectedIndex(1);
		txtdiachi.setText("");
		rdonam.setSelected(true);
		txtngaythangnamsinh.setText("");
		anh.setIcon(new ImageIcon());
	}
}