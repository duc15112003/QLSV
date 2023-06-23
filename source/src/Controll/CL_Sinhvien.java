package Controll;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import UI.PN_Diemdanh;
import UI.PN_Lichhoc;
import UI.UI_Caidat;
import UI.UI_ChangePassNew;
import UI.UI_Login;
import UI.UI_Sinhvien;
import OOP.*;

public class CL_Sinhvien {
//	List<OOP_BangDiem> listdiem = new ArrayList();
	List<OOP_Diemdanh> listdiemdanh = new ArrayList();
//	List<OOP_BangDiem> listlichhoc = new ArrayList();
	List<OOP_Lichhoc> listlhsv = new ArrayList<>();
	String id ;
	String masv;
	String tensv;
	String gioitinh;
	String anh;
	String matkhau;
	String matkhaucf;
	String mamon;
	public void filldatadiemdanh() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			CallableStatement ps = cn.prepareCall("{call sp_diemdanh (?)}");
			ps.setString(1, UI_Sinhvien.idchuatam.getText());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				OOP_Diemdanh op = new OOP_Diemdanh(rs.getString("malichhoc"),rs.getString("mamonhoc"),rs.getString("cahoc"),rs.getBoolean("Comathoacvangmat"));
				listdiemdanh.add(op);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		diemdanh();
	}
	public void filldiemdanhtheomamon() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=duc;password=123");
			CallableStatement ps = cn.prepareCall("{call sp_diemdanh (?)}");
			ps.setString(1, UI_Sinhvien.idchuatam.getText());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				OOP_Diemdanh op = new OOP_Diemdanh(rs.getString("malichhoc"),rs.getString("mamonhoc"),rs.getString("cahoc"),rs.getBoolean("Comathoacvangmat"));
				listdiemdanh.add(op);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		diemdanh();
	}
	
	public void diemdanh() {
		PN_Diemdanh.table.clearSelection();
		DefaultTableModel model = (DefaultTableModel) PN_Diemdanh.table.getModel();
		model.setRowCount(0);
		for(OOP_Diemdanh ds:listdiemdanh) {
		        	Object[] op  = new Object[]{ds.getMalichhoc(),ds.getMonhoc(),ds.getCahoc(),ds.isTrangthai()}; 
		        	model.addRow(op);
		        }
		}
		
	public void fillngayhoc() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV;select ngayhoc from LICHHOC where masv = ?");
			ps.setString(1,UI_Sinhvien.idchuatam.getText());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PN_Lichhoc.ngayhoc.addItem(rs.getString("ngayhoc"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void fillmoitable() {
		DefaultTableModel model = (DefaultTableModel) PN_Diemdanh.table.getModel();
		model.setRowCount(0);
		for(OOP_Diemdanh ds:listdiemdanh) {
		        	Object[] op  = new Object[]{ds.getMalichhoc(),ds.getMonhoc(),ds.getCahoc(),ds.isTrangthai()}; 
		        	model.addRow(op);
		        }
		}

	
	public void findmamon() {
		int count = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=duc;password=123");
			CallableStatement call = cn.prepareCall("{call sp_Findnamefromma(?)}");
			call.setString(1,(String)PN_Diemdanh.comboBox.getSelectedItem());
			ResultSet rs1 = call.executeQuery();
			while (rs1.next()) {
				mamon = rs1.getString("mahocphan");
				count++;
			}
			if(count == 0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy mã điểm danh");
			}else {
			CallableStatement call1 = cn.prepareCall("{call sp_diemdanhtheomamonhoc(?,?)}");
			call1.setString(1, UI_Sinhvien.idchuatam.getText());
			call1.setString(2,mamon);
			ResultSet rs2 = call1.executeQuery();
			while(rs2.next()) {
				OOP_Diemdanh op = new OOP_Diemdanh(rs2.getString("malichhoc"),rs2.getString("mamonhoc"),rs2.getString("cahoc"),rs2.getBoolean("Comathoacvangmat"));
				listdiemdanh.add(op);
			}
			fillmoitable();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public String returnId(String id) {
		id = UI_Login.txtuser.getText();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			CallableStatement ps = cn.prepareCall("select sv.masinhvien, hotensinhvien , gioitinh, matkhau ,anh from SINHVIEN sv, banguser where sv.masinhvien = banguser.id and sv.masinhvien = ?");
			ps.setString(1,id);
			ResultSet kq = ps.executeQuery();
			while(kq.next()) {
				masv = kq.getString("masinhvien");
				tensv = kq.getString("hotensinhvien");
				gioitinh = kq.getString("gioitinh");
				anh = kq.getString("anh");
				matkhau = kq.getString("matkhau");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return id;
	}
	public void setting() {
		returnId(id);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection c = null;
			c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=FPL_Daotao;username=phat;password=123");
			PreparedStatement ps = c.prepareStatement("use QLSV;select sv.masinhvien, hotensinhvien , gioitinh, matkhau ,anh from SINHVIEN sv, banguser where sv.masinhvien = banguser.id and sv.masinhvien = ?");
			ps.setString(1, UI_Sinhvien.idchuatam.getText());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			UI_Caidat.lblmasv.setText(UI_Sinhvien.idchuatam.getText());
			UI_Caidat.lbltensv.setText(tensv);
			UI_Caidat.lblgt.setText(gioitinh);
			ImageIcon icon = new ImageIcon("C:\\Users\\Admin\\.vscode\\Desktop\\java3\\QLSV\\src\\image\\" + anh);
			UI_Caidat.lblanh.setIcon(icon);
			UI_Caidat.lblMatkhau.setText(matkhau);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public void changePassnew() {
		
		matkhau = UI_ChangePassNew.txtmknew.getText();
		matkhaucf = UI_ChangePassNew.txtconfirm.getText();
		if(matkhau.equals(matkhaucf)) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
				PreparedStatement cs = cn.prepareStatement("use QLSV;update BangUser set matkhau = ? where id = ?");
				cs.setString(1, matkhau);
				cs.setString(2, UI_Sinhvien.idchuatam.getText());
				cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Đã update thành công vui lòng đăng nhập lại: ");
				new UI_Login();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Mật khẩu không trùng!!!");
		}
}

	
	public void filllichhocdata() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV;select * from LICHHOC where masv = ?");
			ps.setString(1,UI_Sinhvien.idchuatam.getText());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OOP_Lichhoc op = new OOP_Lichhoc(rs.getString("masv"),rs.getString("ngayhoc"), rs.getString("cahoc"),rs.getString("thoigian"), rs.getString("malichhoc"),rs.getString("PhongHoc"), rs.getString("mamonhoc"));
				listlhsv.add(op);
			}
			filltablelhdata();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void filltablelhdata() {
		DefaultTableModel model = (DefaultTableModel)PN_Lichhoc.tblLichHoc.getModel();
		model.setRowCount(0);
		for (OOP_Lichhoc lh:listlhsv) {
			Object[]op = new Object[] {lh.getNgayhoc(),lh.getCahoc(),lh.getThoigian(),lh.getMalichhoc(),lh.getPhongHoc(),lh.getMamonhoc()};
			model.addRow(op);
		}
	}
	public void filllichhocall() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			CallableStatement ps = cn.prepareCall("{call sp_lichhoc(?)}");
			ps.setString(1, UI_Sinhvien.idchuatam.getText());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				OOP_Diemdanh op = new OOP_Diemdanh(rs.getString("malichhoc"),rs.getString("mamonhoc"),rs.getString("cahoc"),rs.getBoolean("Comathoacvangmat"));
				listdiemdanh.add(op);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void findtheongay() {

		listlhsv.clear();
		try {
			String ngayhoc = (String)PN_Lichhoc.ngayhoc.getSelectedItem();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV;select masv,ngayhoc,cahoc,thoigian,malichhoc,PhongHoc,mamonhoc from LICHHOC where masv = ? and ngayhoc = ?");
			ps.setString(1, UI_Sinhvien.idchuatam.getText());
			ps.setString(2,ngayhoc);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				OOP_Lichhoc op = new OOP_Lichhoc(rs.getString("masv"),rs.getString("ngayhoc"), rs.getString("cahoc"),rs.getString("thoigian"), rs.getString("malichhoc"),rs.getString("PhongHoc"), rs.getString("mamonhoc"));
				listlhsv.add(op);
			}
			filltablelhdata();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void exit() {
		int i = JOptionPane.showConfirmDialog(null,"Bạn có muốn thoát","Yes",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(i==JOptionPane.YES_OPTION) {
			UI_Sinhvien.frame.setVisible(false);
			UI_Login.frame.setVisible(true);
			UI_Login.txtpass.setText("");
		}
	}
}