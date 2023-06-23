package Controll;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Xuliemail {
	
	public int Database(String email) {
		int count = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			CallableStatement call = cn.prepareCall("{call sp_checkemail (?)}");
			call.setString(1, email);
			ResultSet rs = call.executeQuery();
			while(rs.next()) {
				count++; 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
		}
	
	public String laymasv(String email) {
		String idsinhvien ="";
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
				CallableStatement call = cn.prepareCall("{call sp_Timkiemsv (?)}");
				call.setString(1, email);
				ResultSet rs = call.executeQuery();
				while(rs.next()) {
					idsinhvien = rs.getString("masinhvien");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			return idsinhvien;
	}
	
	public void email() {
		String email="";
			email = JOptionPane.showInputDialog("Nhập email để nhận code");
			if(email == null) {
				
			}else {
			if(Database(email)==0) {
				JOptionPane.showMessageDialog(null, "email không có trong danh sách");
				email();
			}else {
				try {
					
					JOptionPane.showMessageDialog(null, "Đã tìm thấy");
					JOptionPane.showMessageDialog(null, laymasv(email));

				} catch (Exception e) {
					// TODO: handle exception
					}
				}
			}
		}
	}

