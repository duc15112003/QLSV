package Controll;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import UI.*;
public class CL_Login {
	String id;
	String email;
	String pass;
	String loai;
	int count = 0;
	int dem = 0;
	public void Login() {
		id = UI_Login.txtuser.getText(); 
		pass = UI_Login.txtpass.getText();
		
	
		if(Validate_Login.checkemail(id)==false) {
			JOptionPane.showMessageDialog(null, "Bạn Đang Để Trống id");
		}else if(Validate_Login.checkemail(pass)==false) {
			JOptionPane.showMessageDialog(null, "Bạn Đang Để Trống mật khẩu");
		}else {
			if(returnId(id, pass)== true) {
				
				if(returnLoai(id).equals("User")) {
					new UI_Sinhvien();
					UI_Sinhvien.idchuatam.setText(id);
					UI_Sinhvien.name.setText(returnTenSV(id));
					UI_Login.frame.setVisible(false);
				}else if(returnLoai(id).equals("Admin")){
					JOptionPane.showMessageDialog(null, "Admin thành công");
					UI_TrangChuAdmin ui_TrangChuAdmin = new UI_TrangChuAdmin(); 
					UI_TrangChuAdmin.frame.setVisible(true);
					UI_TrangChuAdmin.lblten.setText(returnTenadmin(id));
					UI_TrangChuAdmin.lblidan.setText(id);
					UI_Login.frame.setVisible(false);
				}
			
			}else{
				if(dem<3) {
					JOptionPane.showMessageDialog(null,"Sai pass hoặc id");
					dem++;
				}else{
					int check = JOptionPane.showConfirmDialog(null,"Bạn nhập sai quá nhiều có muốn đổi mật khẩu không ?");
					if(check == JOptionPane.YES_OPTION) {
						CL_ChangePass cl_ChangePass = new CL_ChangePass();
						cl_ChangePass.email();
					}
				}
			}
		}
	}
	public boolean returnId(String id,String pass) {
		String idtam = "";
		String passw = "";
		boolean ret = false;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			CallableStatement ps = cn.prepareCall("{call sp_Login_1 (?)}");
			ps.setString(1,id);
			ResultSet kq = ps.executeQuery();
			while(kq.next()) {
				idtam = kq.getString("id");
				passw = kq.getString("matkhau");
			}
			if(id.equals(idtam) && pass.equals(passw)) {
				ret = true;
			}else {
				ret = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	public String returnLoai(String id) {
		String loai = "";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			CallableStatement ps = cn.prepareCall("{call sp_Loaitk (?)}");
			ps.setString(1,id);
			ResultSet kq = ps.executeQuery();
			while(kq.next()) {
				loai = kq.getString("loaitk");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return loai;
	}
	public String returnTenSV(String id) {
		String ten = "";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			CallableStatement ps = cn.prepareCall("{call sp_tenchutk (?)}");
			ps.setString(1,id);
			ResultSet kq = ps.executeQuery();
			while(kq.next()) {
				ten = kq.getString("hotensinhvien");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ten;
	}
	public String returnTenadmin(String id) {
		String tenadmin  ="";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			CallableStatement ps = cn.prepareCall("{call sp_Tenadmin (?)}");
			ps.setString(1,id);
			ResultSet kq = ps.executeQuery();
			while(kq.next()) {
				tenadmin = kq.getString("tenadmin");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return tenadmin;
	}
	
}
