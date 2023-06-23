package UI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PN_Bangdiem extends JPanel {
	private JTable tblBangDiem;
	private JTextField txtTenHocPhan;
	private JTable table_1;
	private Connection conn;
	DefaultTableModel tblModel;

	/**
	 * Create the panel.
	 */
	public PN_Bangdiem() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(778,453);
		
	   
		tblBangDiem = new JTable();
		tblBangDiem.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		tblBangDiem.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tblBangDiem.setBounds(117, 152, 600, 80);
		add(tblBangDiem);
		
		JLabel lblNewLabel = new JLabel("Tên Học Phần:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(63, 36, 91, 29);
		add(lblNewLabel);
		
		txtTenHocPhan = new JTextField();
		
		
		
		txtTenHocPhan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
				            + "databaseName=QLSV;user=duc;password=123;encrypt=false");
					String query = "select DIEMHOCPHAN.mahocphan,diemhocphan,SINHVIEN.masinhvien from DIEMHOCPHAN,HOCPHAN,SINHVIEN\r\n"
							+ "where HOCPHAN.mahocphan = DIEMHOCPHAN.mahocphan and SINHVIEN.masinhvien = DIEMHOCPHAN.masv \r\n"
							+ "and HOCPHAN.tenhocphan = ? and SINHVIEN.masinhvien=?";
					Statement stt = conn.createStatement();
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, txtTenHocPhan.getText());
					pst.setString(2, UI_Sinhvien.idchuatam.getText());
					ResultSet rs = pst.executeQuery();
					tblModel = (DefaultTableModel) tblBangDiem.getModel();
					tblModel.setRowCount(0);
					String ma,diem,tinhtrang;
					while(rs.next())
					{
						ma=rs.getString(1);
						diem=rs.getString(2);	
						String[] row = {ma,diem,check(diem)};
						tblModel.addRow(row);
					}
					stt.close();
					rs.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		txtTenHocPhan.setBounds(173, 36, 188, 29);
		add(txtTenHocPhan);
		txtTenHocPhan.setColumns(10);
		
		
		table_1 = new JTable();
		table_1.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(0, 0, 0)));
		table_1.setBackground(new Color(102, 153, 204));
		table_1.setRowHeight(20);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"              M\u00C3 H\u1ECCC PH\u1EA6N", "                    \u0110I\u1EC2M", "              T\u00CCNH TR\u1EA0NG"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.setBounds(117, 136, 600, 16);
		add(table_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(117, 278, 600, 133);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sinh viên có điểm trung bình môn >= 5 được xếp tình trạng môn \"Đạt\"");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Icons\\Icons\\warning.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(10, 11, 580, 43);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sinh viên chú ý điểm và xem điểm thường xuyên ");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Icons\\Icons\\warning.png"));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 76, 580, 43);
		panel.add(lblNewLabel_2);
		

	}
	public String check(String diem){
		
		if( (float) Double.parseDouble(diem)<5){
			return "Chưa Đạt";
		}else if( (float) Double.parseDouble(diem) >= 5){
			return "Đạt";
		}else {
			return null;
		}

	}
}
