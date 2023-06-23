package Controll;
import java.sql.*;
import java.util.*;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import UI.UI_Changepass;

public class CL_ChangePass {

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
				return count;
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
			String idtam= "";
			String email="";
				email = JOptionPane.showInputDialog("Nhập email để nhận code");
				int so1 =(int) (Math.random() * 999999);
				if(email == null) {
					
				}else {
				if(Database(email)==0) {
					JOptionPane.showMessageDialog(null, "email không có trong danh sách");
					email();
				}else {
					try {
						
							Properties p = new Properties();
							p.put("mail.smtp.auth", "true");
							p.put("mail.smtp.starttls.enable", "true");
							p.put("mail.smtp.host", "smtp.gmail.com");
							p.put("mail.smtp.port", 587);
							final String accountName = "phuctphps26443@fpt.edu.vn";
							final String accountPassword = "mkvbkkclysiiniam";
							String textsubject ="Thay Đổi Mật Khẩu Tài Khoản";
							String textcontent = "Bạn Đang Yêu Cầu đổi mật khẩu cho mã sinh viên "+laymasv(email)+"Mã code kích hoạt thay đổi là: "+ so1;
							Session s = Session.getInstance(p,
									new javax.mail.Authenticator() {
									protected PasswordAuthentication getPasswordAuthentication() {
									return new PasswordAuthentication(accountName, accountPassword);
									}
									});
							Message msg = new MimeMessage(s);
							try {
								msg.setFrom(new InternetAddress(accountName));//laays email từ input dialog
								msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));// nhận từ inputdialog
								msg.setSubject("CC");
								msg.setText(textcontent);
								Transport.send(msg);
								JOptionPane.showMessageDialog(null, "Gui thanh cong");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							String checkma = JOptionPane.showInputDialog("Nhap ma code: ");
							if(so1 == Integer.parseInt(checkma)) {
								idtam = laymasv(email);
								new UI_Changepass();
								UI_Changepass.idchua.setText(laymasv(email));
								
							}else {
								JOptionPane.showMessageDialog(null, "Sai mã");
							}
							
						}
						
					 catch (Exception e) {
						// TODO: handle exception
						}
					}
				}
			}
}
