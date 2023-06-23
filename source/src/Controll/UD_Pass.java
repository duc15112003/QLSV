package Controll;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import UI.UI_Changepass;
import UI.UI_Login;

public class UD_Pass {
	String idtam;
	String mk;
	String mktam;
	public void update() {
		 idtam = UI_Changepass.idchua.getText();
		 mk = UI_Changepass.pass.getText();
		 mktam = UI_Changepass.checkpass.getText();
		
		if(mk.equals(mktam)) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=duc;password=123");
				PreparedStatement cs = cn.prepareStatement("use QLSV;update BangUser set matkhau = ? where id = ?");
				cs.setString(1, mk);
				cs.setString(2,idtam);
				cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Đã update thành công vui lòng đăng nhập lại: ");
				new UI_Login();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null,"mật khẩu đang không trùng nhau");
		}
	}

}
