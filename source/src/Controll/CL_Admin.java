package Controll;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import OOP.*;
import UI.*
;
@SuppressWarnings("unchecked")
public class CL_Admin {
	List<OOP_DiemDanhAdmin> listdiemdanhct = new ArrayList<>();
	List<OOP_Sinhvien> listbangsv = new ArrayList<OOP_Sinhvien>();
	List<OOP_BangDiem> listbangdiem = new ArrayList<OOP_BangDiem>();
	String masv;
	String madiemdanh;
	String malichhoc;
	String tinhtrang;
	String anh;
	String cahoc;
	String malop;
	OOP_DiemDanhAdmin ddct = new OOP_DiemDanhAdmin();
// ----------- Bang Diem	
	Connection con;
	DefaultTableModel tblModel;
	int index=0;
	String tensv;
	String diem;
	String mahocphan;
	String trangthai;
	boolean ret = false;
// -------------- Lich hoc
	ArrayList<OOP_Lichhoc> listlichhoc = new ArrayList<OOP_Lichhoc>();
	String ngayhoc;
	String thoigian;
	String phonghoc;
	String mamonhoc;
	
// ------------------------ Danh Sach Sinh Vien
	
//tk
	List<OOP_taikhoan> listtaikhoan = new ArrayList<OOP_taikhoan>();
	String masinhvien;
	String tensinhvien;
	String email;
	String password;
	OOP_taikhoan tk = new OOP_taikhoan();
	public void Dssv_fillchitietsv() {
		
	}
	public void Dssv_filldatavocombobox() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = null;
			cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV;select malophoc from LOPHOC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PN_Admin_Danhsachsinhvien.cbomalop.addItem(rs.getString("malophoc"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void Dssv_filldataall() {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = null;
			cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV; select * from SINHVIEN");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				OOP_Sinhvien op = new OOP_Sinhvien(rs.getString("masinhvien"), rs.getString("hotensinhvien"), rs.getString("malop"), rs.getString("gioitinh"),rs.getString("ngaysinh"), rs.getString("diachi"), rs.getString("email"), rs.getString("anh"));
				listbangsv.add(op);
			}
			Dssv_filldatafromtable();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void Dssv_filldatafromtable() {
		DefaultTableModel model = (DefaultTableModel)PN_Admin_Danhsachsinhvien.tblSinhvien.getModel();
        model.setRowCount(0);
        for(OOP_Sinhvien ds : listbangsv) {
        	Object[] op  = new Object[]{ds.getMasv(),ds.getTensv(),ds.getMalop(),ds.getGioitinh(),ds.getNgaysinh(),ds.getDiachi(),ds.getEmail(),ds.getAnh()}; 
        	model.addRow(op);
        }
	}
	public void Dssv_filldatatotextfield() {
		int index = PN_Admin_Danhsachsinhvien.tblSinhvien.getSelectedRow();
		PN_Admin_Danhsachsinhvien.txtmasinhvien.setText(listbangsv.get(index).getMasv());
		PN_Admin_Danhsachsinhvien.txttensinhvien.setText(listbangsv.get(index).getTensv());
		PN_Admin_Danhsachsinhvien.cbomalop.setSelectedItem(listbangsv.get(index).getMalop());
		if(listbangsv.get(index).getGioitinh().equals("Nam")) {
			PN_Admin_Danhsachsinhvien.rdonam.setSelected(true);
		}else if(listbangsv.get(index).getGioitinh().equals("Nữ")) {
			PN_Admin_Danhsachsinhvien.rdonu.setSelected(true);
		}else {
			PN_Admin_Danhsachsinhvien.rdokhac.setSelected(true);
		}
		
		PN_Admin_Danhsachsinhvien.txtngaythangnamsinh.setText(listbangsv.get(index).getNgaysinh());
		PN_Admin_Danhsachsinhvien.txtdiachi.setText(listbangsv.get(index).getDiachi());
		
	}
	public boolean Dssv_checkdate(String date) {
	     String datePattern = "\\d{4}-\\d{1,2}-\\d{1,2}";
	     return date.matches(datePattern);
	}
// ------------------------ Bang diem
	public void bangdiem_clean() {
		PN_Admin_Bangdiem.txtmasinhvien.setText(null);
	    PN_Admin_Bangdiem.txttensinhvien.setText(null);
	    PN_Admin_Bangdiem.txtmamon.setText(null);
	    PN_Admin_Bangdiem. txtdiem.setText(null);
		
	}
	
	
	public void bangdiem_addform() {
		masv = PN_Admin_Bangdiem.txtmasinhvien.getText();
		tensv =	PN_Admin_Bangdiem.txttensinhvien.getText();
		mahocphan = PN_Admin_Bangdiem.txtmamon.getText();
		diem = PN_Admin_Bangdiem.txtdiem.getText();
		OOP_BangDiem bd = new OOP_BangDiem(masv,tensv,mahocphan,diem);
		listbangdiem.add(bd);
		  
	}
	
	 public void bangdiem_save() {
		  bangdiem_addform();
        try {
       	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
			            + "databaseName=QLSV;user=phat;password=123;encrypt=false");
            PreparedStatement ps = con.prepareStatement("  INSERT INTO BANGDIEM VALUES ( ?, ?, ?)");
             ps.setString(1, PN_Admin_Bangdiem.txtmasinhvien.getText());
             ps.setString(2, PN_Admin_Bangdiem.txtmamon.getText());
             ps.setString(3, PN_Admin_Bangdiem.txtdiem.getText());
             ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "Lưu thành công");
       } catch (Exception e) {
            e.printStackTrace();
       }
        
        bangdiem_filldatafromtable();
		}
   

	 
	 public void  bangdiem_addupdate(){
		 try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
			            + "databaseName=QLSV;user=phat;password=123;encrypt=false");
	           String ma =  PN_Admin_Bangdiem.txtmasinhvien.getText();
	            PreparedStatement ps = con.prepareStatement("UPDATE  BANGDIEM  SET mahocphan = ?, diemhocphan = ? WHERE masv = ? ");
	            ps.setString(1,PN_Admin_Bangdiem. txttensinhvien.getText());
	            ps.setString(2,PN_Admin_Bangdiem. txtmamon.getText());
	            ps.setString(3,PN_Admin_Bangdiem. txtdiem.getText());
	            ps.setString(4,ma);
	            ps.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
	 
	 
	 public void bangdiem_update() {
		     index = PN_Admin_Bangdiem.tbl_bangdiem_admin.getSelectedRow();
	       if (index == -1) {
	            JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng cập nhật");
	       } else {
	    	   listbangdiem.remove(index);
	    	    bangdiem_addupdate();
	            OOP_BangDiem bd = new OOP_BangDiem();
	            bd.masv = String.valueOf( PN_Admin_Bangdiem.txtmasinhvien.getText());
	            bd.ten = String.valueOf( PN_Admin_Bangdiem.txttensinhvien.getText());
	            bd.mamon = String.valueOf( PN_Admin_Bangdiem.txtmamon.getText());
	            bd.diem = String.valueOf( PN_Admin_Bangdiem.txtdiem.getText());
	            listbangdiem.add(bd);
				bangdiem_filldatafromtable();
	            JOptionPane.showMessageDialog(null, "Update thành công");
	      
	 }
	 }
	 public void bangdiem_deleteall() {
		 try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = null;
			cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+ "databaseName=QLSV;user=phat;password=123;encrypt=false");
				PreparedStatement ps = cn.prepareStatement("use QLSV;delete from BANGDIEM");
				ps.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 public void  bangdiem_delete() {
		 String idxoa = PN_Admin_Bangdiem.txtmasinhvien.getText();
		 try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
			            + "databaseName=QLSV;user=phat;password=123;encrypt=false");
				PreparedStatement ptmt  = con.prepareStatement("DELETE FROM BANGDIEM  WHERE masv = ?");
				ptmt.setString(1, idxoa);
				ptmt.executeUpdate();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		 
	 }
	 public void bangdiem_search() {
		 @SuppressWarnings("unused")
		int count  = 0;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
			            + "databaseName=QLSV;user=phat;password=123;encrypt=false");
				String query =  "select dhp.masv,sv.hotensinhvien,dhp.mahocphan,dhp.diemhocphan from DIEMHOCPHAN dhp inner join SINHVIEN sv on dhp.masv = sv.masinhvien where masv=? ";		
				@SuppressWarnings("unused")
				Statement stt = conn.createStatement();
				PreparedStatement pst = conn.prepareStatement(query);
				pst.setString(1,  PN_Admin_Bangdiem.txtmatimkiem.getText());
				
				ResultSet rs = pst.executeQuery();
				tblModel = (DefaultTableModel)  PN_Admin_Bangdiem.tbl_bangdiem_admin.getModel();
				tblModel.setRowCount(0);
				@SuppressWarnings("unused")
				String  ma ,ten ,mamon , diem,tinhtrang;
				while(rs.next())
				{
					ma=rs.getString(1);
					ten=rs.getString(2);
					mamon=rs.getString(3);
					diem=rs.getString(4);	
					String[] row = {ma,ten,mamon,diem,bangdiem_travediem(diem)};
					tblModel.addRow(row);
					
				}
			} catch (Exception E) {
		
			}
    }
	 public  void bangdiem_filldataall() {
		listbangdiem.clear();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = null;
			cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = cn.prepareStatement("use QLSV;select dhp.masv,sv.hotensinhvien,dhp.mahocphan,dhp.diemhocphan from DIEMHOCPHAN dhp inner join SINHVIEN sv on dhp.masv = sv.masinhvien");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				OOP_BangDiem bd = new OOP_BangDiem(rs.getString("masv"), rs.getString("hotensinhvien"),rs.getString("mahocphan"),rs.getString("diemhocphan"));
               listbangdiem.add(bd);
			}
			bangdiem_filldatafromtable();
		} catch (Exception e) {
 			// TODO: handle exception
		}
		System.out.println(listbangdiem.size());
	}
	public void bangdiem_filldatafromtable() {
		DefaultTableModel model = (DefaultTableModel) PN_Admin_Bangdiem.tbl_bangdiem_admin.getModel();
        model.setRowCount(0);
        for(OOP_BangDiem ds : listbangdiem) {
       	 
        	Object[] bd  = new Object[]{ds.getMasv(),ds.getTen(),ds.getMamon(),ds.getDiem(),bangdiem_travediem(ds.getDiem())}; 
        	model.addRow(bd);
        }
	}
	public void bangdiem_filldatatotextfield() {
		int index =  PN_Admin_Bangdiem.tbl_bangdiem_admin.getSelectedRow();
	   PN_Admin_Bangdiem.txtmasinhvien.setText(listbangdiem.get(index).getMasv());
	   PN_Admin_Bangdiem.txttensinhvien.setText(listbangdiem.get(index).getTen());
	   PN_Admin_Bangdiem.txtmamon.setText(listbangdiem.get(index).getMamon());
	   PN_Admin_Bangdiem.txtdiem.setText(listbangdiem.get(index).getDiem());

		
	}
	public String bangdiem_travediem(String diem) {
		trangthai = "";
		if(Double.parseDouble(diem) < 5) {
			trangthai = "chưa đạt";
		}else {
			trangthai = "đạt";
		}
		return trangthai;	
	}
//	public void bangdiem_excel() {
//		try {
//			   XSSFWorkbook wordkbook = new XSSFWorkbook();
//		        XSSFSheet sheet=wordkbook.createSheet("DSBDSV");
//		        XSSFRow row =null;
//		        Cell cell=null;
//		        row=sheet.createRow(2);
//		        
//		        cell=row.createCell(0,CellType.STRING);
//		        cell.setCellValue("DANH SACH DIEM SINH VIEN");
//		        
//		        row=sheet.createRow(3);
//		        cell=row.createCell(0,CellType.STRING);
//		        cell.setCellValue("STT");
//		        
//		        cell=row.createCell(1,CellType.STRING);
//		        cell.setCellValue("masv");
//		        
//		        cell=row.createCell(2,CellType.STRING);
//		        cell.setCellValue("tensv");
//		        
//		        cell=row.createCell(3,CellType.STRING);
//		        cell.setCellValue("mahocphan");
//		        
//		        cell=row.createCell(4,CellType.STRING);
//		        cell.setCellValue("diemhocphan");
//		        
//		        cell=row.createCell(5,CellType.STRING);
//		        cell.setCellValue("trangthai");
//		        
//		        
//		        for(int i=0; i<listbangdiem.size(); i++) {
//		         
//		            //Modelbook book =arr.get(i);
//		            row=sheet.createRow(4+i);
//		            
//		            cell=row.createCell(0,CellType.NUMERIC);
//		            cell.setCellValue(i+1);
//		            
//		            cell=row.createCell(1,CellType.STRING);
//		            cell.setCellValue(listbangdiem.get(i).getMasv());
//		            
//		            
//		            cell=row.createCell(2,CellType.STRING);
//		            cell.setCellValue(listbangdiem.get(i).getTensv());
//		            
//		            cell=row.createCell(3,CellType.STRING);
//		            cell.setCellValue(listbangdiem.get(i).getMahocphan());
//		            
//		            cell=row.createCell(4,CellType.STRING);
//		            cell.setCellValue(listbangdiem.get(i).getDiemhocphan());
//		            
//		            cell= row.createCell(5,CellType.STRING);
//		            cell.setCellValue(bangdiem_travediem(listbangdiem.get(i).getDiemhocphan()));
//		          
//		            
//		        }
//		        File f = new File("C:\\Users\\Admin\\.vscode\\Desktop\\java3\\QLSV\\excelbangdiem.xlsx");
//		        try 
//		        {
//		            FileOutputStream fis = new FileOutputStream(f);
//		            wordkbook.write(fis);
//		            fis.close();
//		        }
//		        catch (FileNotFoundException ex) {
//		            ex.printStackTrace();
//		       
//		        }
//		        catch (IOException ex)
//		        {
//		          ex.printStackTrace();
//		        }
//		        
//		        
//		      JOptionPane.showMessageDialog(null, "In  file excel thành công ");
//		        
//			
//		} catch (Exception e) {
//		e.printStackTrace();// TODO: handle exception
//		}
//		
//	}
// 	--------------------------

//	---------------- Diem danh
//	public void Diemdanh_excel() {
//		try {
//			   XSSFWorkbook wordkbook = new XSSFWorkbook();
//		        XSSFSheet sheet=wordkbook.createSheet("DSDDSV");
//		        XSSFRow row =null;
//		        Cell cell=null;
//		        row=sheet.createRow(2);
//		        
//		        cell=row.createCell(0,CellType.STRING);
//		        cell.setCellValue("DANH SACH DIEM DANH SINH VIEN");
//		        
//		        cell=row.createCell(0,CellType.STRING);
//		        cell.setCellValue("STT");
//		        
//		        row=sheet.createRow(3);
//		        cell=row.createCell(1,CellType.STRING);
//		        cell.setCellValue("masv");
//		        
//		        cell=row.createCell(2,CellType.STRING);
//		        cell.setCellValue("madiemdanh");
//		        
//		        cell=row.createCell(3,CellType.STRING);
//		        cell.setCellValue("malichhoc");
//		        
//		        cell=row.createCell(4,CellType.STRING);
//		        cell.setCellValue("tinhtrang");
//		        
//		        cell=row.createCell(5,CellType.STRING);
//		        cell.setCellValue("anh");
//		        
//		        cell=row.createCell(6,CellType.STRING);
//		        cell.setCellValue("cahoc");
//		        
//		        cell=row.createCell(7,CellType.STRING);
//		        cell.setCellValue("malop");
//		        
//		        for(int i=0; i<listdiemdanhct.size(); i++) {
//		         
//		            //Modelbook book =arr.get(i);
//		            row=sheet.createRow(4+i);
//		            
//		            
//		            cell=row.createCell(0,CellType.NUMERIC);
//		            cell.setCellValue(i+1);
//		            
//		            cell=row.createCell(1,CellType.STRING);
//		            cell.setCellValue(listdiemdanhct.get(i).getMasv());
//		            
//		            
//		            cell=row.createCell(2,CellType.STRING);
//		            cell.setCellValue(listdiemdanhct.get(i).getMadiemdanh());
//		            
//		            cell=row.createCell(3,CellType.STRING);
//		            cell.setCellValue(listdiemdanhct.get(i).getMalichhoc());
//		            
//		            cell=row.createCell(4,CellType.STRING);
//		            cell.setCellValue(listdiemdanhct.get(i).getTinhtrang());
//		            
//		            cell= row.createCell(5,CellType.STRING);
//		            cell.setCellValue(listdiemdanhct.get(i).getAnh());
//		            
//		            cell= row.createCell(6,CellType.STRING);
//		            cell.setCellValue(listdiemdanhct.get(i).getCahoc());
//		            
//		            cell= row.createCell(7,CellType.STRING);
//		            cell.setCellValue(listdiemdanhct.get(i).getMalop());
//		          
//		            
//		        }
//		        File f = new File("C:\\Users\\Admin\\.vscode\\Desktop\\java3\\QLSV\\exceldiemdanh.xlsx");
//		        try 
//		        {
//		            FileOutputStream fis = new FileOutputStream(f);
//		            wordkbook.write(fis);
//		            fis.close();
//		        }
//		        catch (FileNotFoundException ex) {
//		            ex.printStackTrace();
//		       
//		        }
//		        catch (IOException ex)
//		        {
//		          ex.printStackTrace();
//		        }
//		        
//		        
//		      JOptionPane.showMessageDialog(null, "In  file excel thành công ");
//		        
//			
//		} catch (Exception e) {
//		e.printStackTrace();// TODO: handle exception
//		}
//		
//	}
	
	public void Diemdanh_filllistdiemdanhchitiet() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = null;
			cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			CallableStatement call = cn.prepareCall("{sp_filldataddct(?)}");
			call.setString(1, (String) PN_Admin_Diemdanh.cbolophoc.getSelectedItem());
			ResultSet rs = call.executeQuery();
			while(rs.next()) {
				OOP_DiemDanhAdmin op = new OOP_DiemDanhAdmin(rs.getString("masinhvien"), rs.getString("malichhoc"),rs.getString("anh"),false, rs.getString("cahoc"),rs.getString("malop"));
				listdiemdanhct.add(op);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void Diemdanh_clearlist() {
		listdiemdanhct.clear();
	}
	public void filltbdiemdanhchitiet() {
		Diemdanh_clearlist();
		Diemdanh_filllistdiemdanhchitiet();
		DefaultTableModel model = (DefaultTableModel) UI.PN_Admin_Diemdanh.table.getModel();
		model.setRowCount(0);
		for (OOP_DiemDanhAdmin ddct : listdiemdanhct) {
			Object[] o = new Object[] {ddct.getMasv(),ddct.getMalichhoc(),ddct.isTinhtrang(),ddct.getCahoc(),ddct.getMalop()};
			model.addRow(o);
		}
	}
	

	public void filltblichhoc() {
		
	}
	public void Taikhoan_filllisttaikhoan() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection ct = null;
			ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = ct.prepareStatement("select sv.masinhvien , sv.hotensinhvien, sv.email ,bu.matkhau , sv.anh from SINHVIEN sv inner join BangUser bu on sv.masinhvien = bu.id where loaitk = 'User'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				@SuppressWarnings("rawtypes")
				Vector data = new Vector();
				data.add(rs.getString("masinhvien"));
				data.add(rs.getString("hotensinhvien"));
				data.add(rs.getString("email"));
				data.add(rs.getString("matkhau"));
				data.add(rs.getString("anh"));
				tk = new OOP_taikhoan(rs.getString("masinhvien"),rs.getString("hotensinhvien"),rs.getString("email"),rs.getString("matkhau"),rs.getString("anh"));
				listtaikhoan.add(tk);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Taikhoan_clearlist() {
		listtaikhoan.clear();
	}
	public void Taikhoan_filltbtaikhoan() {
		Taikhoan_clearlist();
		Taikhoan_filllisttaikhoan();
		DefaultTableModel model = (DefaultTableModel) PN_Admin_Taikhoan.table_1.getModel();
		model.setRowCount(0);
		for (OOP_taikhoan tk  : listtaikhoan) {
			Object[] o = new Object[] {tk.getMasinhvien(),tk.getTensinhvien(),tk.getEmail(),tk.getPassword(),tk.getAnh()};
			model.addRow(o);
		}
		
	}
	public void Taikhoan_filltxt() {
		int index = PN_Admin_Taikhoan.table_1.getSelectedRow();
		PN_Admin_Taikhoan.lbltaikhoan.setText("Tài khoản của bạn là: " + listtaikhoan.get(index).getMasinhvien() + "." );
		PN_Admin_Taikhoan.txtmasv.setText(listtaikhoan.get(index).getMasinhvien());
		PN_Admin_Taikhoan.txttensv.setText(listtaikhoan.get(index).getTensinhvien());
		PN_Admin_Taikhoan.txtemail.setText(listtaikhoan.get(index).getEmail());
		PN_Admin_Taikhoan.txtmatkhau.setText(listtaikhoan.get(index).getPassword());
		ImageIcon icon = new ImageIcon(listtaikhoan.get(index).getAnh());
		PN_Admin_Taikhoan.lblanh.setIcon(icon);
		
	}
	public void Taikhoan_reset() {
		PN_Admin_Taikhoan.txtmasv.setText("");
		PN_Admin_Taikhoan.txttensv.setText("");
		PN_Admin_Taikhoan.txtemail.setText("");
		PN_Admin_Taikhoan.txtmatkhau.setText("");
		PN_Admin_Taikhoan.lblanh.setIcon(new ImageIcon("C:\\Users\\Admin\\.vscode\\Desktop\\java3\\QLSV\\src\\image\\1.jpg"));
	}
	public void Taikhoan_email() {
		String hoten = PN_Admin_Taikhoan.txttensv.getText();
		String ten = CL_bodau.removeAccent(hoten.substring(hoten.lastIndexOf(" ")));
		String firsthoten = hoten.substring(0, 1);
		String tendem = hoten.substring(hoten.indexOf(" "), hoten.lastIndexOf(" ")).trim();
		String firsttendem = tendem.substring(0,1);

String masv = PN_Admin_Taikhoan.txtmasv.getText();
		String duoiemail = "@fpt.edu.vn";
		PN_Admin_Taikhoan.txtemail.setText(ten.toLowerCase().trim() + firsthoten.toLowerCase() + firsttendem.toLowerCase() +masv.toLowerCase() + duoiemail);
	}
	public void Taikhoan_fillfirsttk() {
		Taikhoan_filllisttaikhoan();
		PN_Admin_Taikhoan.txtmasv.setText(listtaikhoan.get(0).getMasinhvien());
		PN_Admin_Taikhoan.txttensv.setText(listtaikhoan.get(0).getTensinhvien());
		PN_Admin_Taikhoan.txtmatkhau.setText(listtaikhoan.get(0).getPassword());
		PN_Admin_Taikhoan.txtemail.setText(listtaikhoan.get(0).getEmail());
		ImageIcon icon = new ImageIcon("C:\\Users\\Admin\\.vscode\\Desktop\\java3\\QLSV\\src\\image\\" + listtaikhoan.get(0).getAnh());
		PN_Admin_Taikhoan.lblanh.setIcon(icon);
	}
	public void Taikhoan_excel() {
		try {
			   @SuppressWarnings("resource")
			XSSFWorkbook wordkbook = new XSSFWorkbook();
		        XSSFSheet sheet=wordkbook.createSheet("DSTKSV");
		        XSSFRow row =null;
		        Cell cell=null;
		        row=sheet.createRow(2);
		        
		        cell=row.createCell(0,CellType.STRING);
		        cell.setCellValue("DANH SACH DIEM DANH SINH VIEN");
		        
		        cell=row.createCell(0,CellType.STRING);
		        cell.setCellValue("STT");
		        
		        row=sheet.createRow(3);
		        cell=row.createCell(1,CellType.STRING);
		        cell.setCellValue("masinhvien");
		        
		        cell=row.createCell(2,CellType.STRING);
		        cell.setCellValue("tensinhvien");
		        
		        cell=row.createCell(3,CellType.STRING);
		        cell.setCellValue("email");
		        
		        cell=row.createCell(4,CellType.STRING);
		        cell.setCellValue("matkhau");
		        
		        cell=row.createCell(5,CellType.STRING);
		        cell.setCellValue("anh");
		        
		        for(int i=0; i<listtaikhoan.size(); i++) {
		         
		            //Modelbook book =arr.get(i);
		            row=sheet.createRow(4+i);
		            
		            
		            cell=row.createCell(0,CellType.NUMERIC);
		            cell.setCellValue(i+1);
		            
		            cell=row.createCell(1,CellType.STRING);
		            cell.setCellValue(listtaikhoan.get(i).getMasinhvien());
		            cell=row.createCell(2,CellType.STRING);
		            cell.setCellValue(listtaikhoan.get(i).getTensinhvien());
		            cell=row.createCell(3,CellType.STRING);
		            cell.setCellValue(listtaikhoan.get(i).getEmail());
		            cell=row.createCell(4,CellType.STRING);
		            cell.setCellValue(listtaikhoan.get(i).getPassword());
		            cell=row.createCell(5,CellType.STRING);
		            cell.setCellValue(listtaikhoan.get(i).getAnh());
		            
		          
		            
		        }
		        File f = new File("C:\\Users\\Admin\\.vscode\\Desktop\\java3\\QLSV\\exceltaikhoan.xlsx");
		        try 
		        {
		            FileOutputStream fis = new FileOutputStream(f);
		            wordkbook.write(fis);
		            fis.close();
}
		        catch (FileNotFoundException ex) {
		            ex.printStackTrace();
		       
		        }
		        catch (IOException ex)
		        {
		          ex.printStackTrace();
		        }
		        
		        
			
		} catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
		}
		
	}
	public void Taikhoan_updateemail() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection c = null;
			c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=QLSV;username=phat;password=123");
			PreparedStatement ps = c.prepareStatement("use QLSV; Update SINHVIEN set email = ? where masinhvien = ? ");
			ps.setString(1, PN_Admin_Taikhoan.txtemail.getText());
			ps.setString(2, PN_Admin_Taikhoan.txtmasv.getText());
			ps.executeUpdate();
			Taikhoan_filltbtaikhoan();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
// ----------- Lich hoc
	public void excel() {
		try {
			   XSSFWorkbook wordkbook = new XSSFWorkbook();
		        XSSFSheet sheet=wordkbook.createSheet("DSBDSV");
		        XSSFRow row =null;
		        Cell cell=null;
		        row=sheet.createRow(2);
		        cell=row.createCell(0,CellType.STRING);
		        cell.setCellValue("Lịch Học");
		        row=sheet.createRow(3);
		         
		        
		        
		        cell=row.createCell(0,CellType.STRING);
		        cell.setCellValue("STT");
		        
		        
		        cell=row.createCell(1,CellType.STRING);
		        cell.setCellValue("Mã sinh viên");
		        
		        cell=row.createCell(2,CellType.STRING);
		        cell.setCellValue("Ngày học");
		        
		        cell=row.createCell(3,CellType.STRING);
		        cell.setCellValue("Ca học");
		        
		        cell=row.createCell(4,CellType.STRING);
		        cell.setCellValue("Thời gian");
		        
		        cell=row.createCell(5,CellType.STRING);
		        cell.setCellValue("Mã môn");
		        
		        cell=row.createCell(6,CellType.STRING);
		        cell.setCellValue("Phòng học");
		        
		        cell=row.createCell(7,CellType.STRING);
		        cell.setCellValue("Mã môn học");
		     
		        
	          
		        
		        
		        for(int i=0; i<listlichhoc.size(); i++) {
		         
		            //Modelbook book =arr.get(i);
		            row=sheet.createRow(4+i);
		           
		            cell=row.createCell(0,CellType.NUMERIC);
		            cell.setCellValue(i+1);
		            
		            cell=row.createCell(1,CellType.STRING);
		            cell.setCellValue(listlichhoc.get(i).getMasv());
		            
		            
		         
		            
		            cell=row.createCell(2,CellType.STRING);
		            cell.setCellValue(listlichhoc.get(i).getNgayhoc());
		            
		            cell=row.createCell(3,CellType.STRING);
		            cell.setCellValue(listlichhoc.get(i).getCahoc());
		            
		            cell=row.createCell(4,CellType.STRING);
		            cell.setCellValue(listlichhoc.get(i).getThoigian());
		            
		            cell=row.createCell(5,CellType.STRING);
		            cell.setCellValue(listlichhoc.get(i).getMalichhoc());
		            
		            
		            cell=row.createCell(6,CellType.STRING);
		            cell.setCellValue(listlichhoc.get(i).getPhongHoc());
		           
		            
		            
		            
		           
		          
		            
		        }
		        File f = new File("D:\\Eclipse\\excel123.xlsx");
		        try 
		        {
		            FileOutputStream fis = new FileOutputStream(f);
		            wordkbook.write(fis);
		            fis.close();
		        }
		        catch (FileNotFoundException ex) {
		            ex.printStackTrace();
		       
		        }
		        catch (IOException ex)
		        {
		          ex.printStackTrace();
		        }
		        
		        
		      JOptionPane.showMessageDialog(null, "In  file excel thành công ");
} catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
		}
	
	
	}
//	public void  delete() {
//		
//		 String idxoa = PN_Admin_Lichhoc.txtmasv.getText();
//		 try {
//			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
//			            + "databaseName=QLSV;user=sa;password=0869175277;encrypt=false");
//				PreparedStatement ptmt  = con.prepareStatement("DELETE FROM LICHHOC  WHERE masv = ?");
//				ptmt.setString(1, idxoa);
//				ptmt.executeUpdate();
//				
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		 
//	}
//	 public void  addupdate(){
//		 try {
//			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
//			            + "databaseName=QLSV;user=phat;password=123;encrypt=false");
//	           String ma =  PN_Admin_Lichhoc.txtmasv.getText();
//	            PreparedStatement ps = con.prepareStatement("UPDATE  lICHHOC SET ngayhoc=?,cahoc=?,thoigian=?,malichhoc=?, PhongHoc = ? , mamonhoc =? WHERE masv=? ");    
//	              ps.setString(1, PN_Admin_Lichhoc.txtngayhoc.getText());
//	              ps.setString(2, PN_Admin_Lichhoc.txtcahoc.getText());
//	              ps.setString(3, PN_Admin_Lichhoc.txtthoigian.getText());
//	              ps.setString(4, PN_Admin_Lichhoc.txtmalich.getText());
//	              ps.setString(5, PN_Admin_Lichhoc.txtphonghoc.getText());
//	              ps.setString(6, PN_Admin_Lichhoc.txtmamonhoc.getText());
//	              ps.setString(7,ma);
//	             ps.executeUpdate();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	 }
//	 public void update() {
//	
//		     index = PN_Admin_Lichhoc.tablel_admin_lichhoc.getSelectedRow();
//	       if (index == -1) {
//	            JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng cập nhật");
//	       } else {
//	    	   listlichhoc.remove(index);
//	    	    addupdate();
//	            OOP_Lichhoc lh = new OOP_Lichhoc();
//	            lh.masv = String.valueOf( PN_Admin_Lichhoc.txtmasv.getText());
//	            lh.ngayhoc = String.valueOf( PN_Admin_Lichhoc.txtngayhoc.getText());
//	            lh.cahoc = String.valueOf( PN_Admin_Lichhoc.txtcahoc.getText());
//	            lh.thoigian = String.valueOf( PN_Admin_Lichhoc.txtthoigian.getText());
//	            lh.malichhoc= String.valueOf( PN_Admin_Lichhoc.txtmalich.getText());
//	            lh.PhongHoc = String.valueOf( PN_Admin_Lichhoc.txtphonghoc.getText());
//	            lh.mamonhoc = String.valueOf( PN_Admin_Lichhoc.txtmamonhoc.getText());
//	            listlichhoc.add(lh);
//				filldatafromtable();
//				clean();
//	            JOptionPane.showMessageDialog(null, "Update thành công");
//	   	}
//	 }
//	
//	public void addform() {
//		masv = PN_Admin_Lichhoc.txtmasv.getText();
//		ngayhoc =	PN_Admin_Lichhoc.txtngayhoc.getText();      
//		cahoc =	PN_Admin_Lichhoc.txtcahoc.getText();
//	    thoigian =	PN_Admin_Lichhoc.txtthoigian.getText();
//malichhoc=	PN_Admin_Lichhoc.txtmalich.getText();
//		phonghoc=	PN_Admin_Lichhoc.txtphonghoc.getText();
//	
//		
//
//		OOP_Lichhoc  lh = new OOP_Lichhoc (masv,ngayhoc,cahoc,thoigian,malichhoc,phonghoc);
//		listlichhoc.add(lh);
//		    
//	}
//	
//	public void Save() {
//		  addform();
//         try {
//        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
//			            + "databaseName=QLSV;user=phat;password=123;encrypt=false");
//             PreparedStatement ps = con.prepareStatement("  INSERT INTO LICHHOC(masv, ngayhoc ,cahoc, thoigian,malichhoc,PhongHoc,mamonhoc) VALUES ( ?, ?, ?, ?,?,?,?)");
//              ps.setString(1, PN_Admin_Lichhoc.txtmasv.getText());
//              ps.setString(2, PN_Admin_Lichhoc.txtngayhoc.getText());
//              ps.setString(3, PN_Admin_Lichhoc.txtcahoc.getText());
//              ps.setString(4, PN_Admin_Lichhoc.txtthoigian.getText());
//              ps.setString(5, PN_Admin_Lichhoc.txtmalich.getText());
//              ps.setString(6, PN_Admin_Lichhoc.txtphonghoc.getText());
//              ps.setString(7, PN_Admin_Lichhoc.txtmamonhoc.getText());
//              ps.executeUpdate();
//         
//        } catch (Exception e) {
//             e.printStackTrace();
//        }
//         filldatafromtable();
//         clean();
//		}
//	 public void search() {
//			try {
//				listlichhoc.clear();
//				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
//			            + "databaseName=QLSV;user=phat;password=123;encrypt=false");
//				String query =  "select * from LICHHOC where masv=? ";		
//				Statement stt = conn.createStatement();
//				PreparedStatement pst = conn.prepareStatement(query);
//				pst.setString(1,  PN_Admin_Lichhoc.txtmatimkiem.getText());
//				
//				ResultSet rs = pst.executeQuery();
//				tblModel = (DefaultTableModel)  PN_Admin_Lichhoc.tablel_admin_lichhoc.getModel();
//				tblModel.setRowCount(0);
//				while(rs.next())
//				{
//					masv=rs.getString(1);
//					ngayhoc=rs.getString(2);
//					cahoc=rs.getString(3);
//					thoigian=rs.getString(4);	
//					malichhoc=rs.getString(5);
//					phonghoc=rs.getString(6);
//					String[] row = {masv,ngayhoc,cahoc,thoigian,malichhoc,phonghoc};
//					tblModel.addRow(row);
//					JOptionPane.showMessageDialog(null, "Tìm kiếm thành công");
//				}
//				stt.close();
//				rs.close();
//				
//			} catch (Exception e2) {
//				
//			}
//			filldatatotextfield();
//  }
//	
//	public void clean() {
//		 PN_Admin_Lichhoc.txtmatimkiem.setText(null);
//		 PN_Admin_Lichhoc.txtmasv.setText(null);
//		 PN_Admin_Lichhoc.txtngayhoc.setText(null);
//		 PN_Admin_Lichhoc.txtcahoc.setText(null);
//		 PN_Admin_Lichhoc.txtmalich.setText(null);
//		 PN_Admin_Lichhoc.txtthoigian.setText(null);
//		 PN_Admin_Lichhoc.txtphonghoc.setText(null);	
//	}
//	public void fillcbo() {
//			try {
//				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				con = DriverManager
//.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;user=phat;password=123");
//				PreparedStatement ps = con.prepareStatement("use QLSV;select masv,ngayhoc,cahoc,thoigian , malichhoc , PhongHoc from LICHHOC where mamonhoc= ?");
//				ps.setString(1,PN_Admin_Lichhoc.combo.getSelectedItem()+"");
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					OOP_Lichhoc op = new OOP_Lichhoc(rs.getString("masv"), rs.getString("ngayhoc"), rs.getString("cahoc"), rs.getString("thoigian"),rs.getString("malichhoc"), rs.getString("PhongHoc"));
//					listlichhoc.add(op);
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//			
//}
//	public void cleanlist() {
//		listlichhoc.clear();
//	}
//	public void table() {
//		listlichhoc.clear();
//		fillcbo();
//		DefaultTableModel model = (DefaultTableModel) PN_Admin_Lichhoc.tablel_admin_lichhoc.getModel();
//		model.setRowCount(0);
//		for (OOP_Lichhoc oop : listlichhoc) {
//			Object[] o = new Object[] {oop.getMasv(),oop.getNgayhoc(),oop.getCahoc(),oop.getThoigian(),oop.getMalichhoc(),oop.getPhongHoc(),oop.getCahoc(),oop.getMamonhoc()};
//			model.addRow(o);
//		}
//
//	}
//	
//	public void filldataall() {
//	try {
//		con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
//		PreparedStatement ps = con.prepareStatement("use QLSV; select * from LICHHOC");
//		ResultSet rs = ps.executeQuery();
//		while(rs.next()) {
//			OOP_Lichhoc op = new OOP_Lichhoc(rs.getString("masv"), rs.getString("ngayhoc"), rs.getString("cahoc"), rs.getString("thoigian"),rs.getString("malichhoc"), rs.getString("PhongHoc"),rs.getString("mamonhoc"));
//			listlichhoc.add(op);
//		}
//		filldatafromtable();
//	
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//
//	
//	
//}
//	
//	public void filldatafromtable() {
// 		DefaultTableModel model = (DefaultTableModel) PN_Admin_Lichhoc.tablel_admin_lichhoc.getModel();
//         model.setRowCount(0);
//         for(OOP_Lichhoc ds : listlichhoc) {
//         	Object[] lh  = new Object[]{ds.getMasv(),ds.getNgayhoc(),ds.getCahoc(),ds.getThoigian(),ds.getMalichhoc(),ds.getPhongHoc(),ds.getMamonhoc(), ds.getMamonhoc()}; 
//         	model.addRow(lh);
//         }
// 	}
//	public void filldatatotextfield() {
// 		int index =  PN_Admin_Lichhoc.tablel_admin_lichhoc.getSelectedRow();
// 		 PN_Admin_Lichhoc.txtmasv.setText(listlichhoc.get(index).getMasv());
// 		 PN_Admin_Lichhoc.txtngayhoc.setText(listlichhoc.get(index).getNgayhoc());
// 		 PN_Admin_Lichhoc.txtcahoc.setText(listlichhoc.get(index).getCahoc());
// 		 PN_Admin_Lichhoc.txtthoigian.setText(listlichhoc.get(index).getThoigian());
// 		 PN_Admin_Lichhoc.txtmalich.setText(listlichhoc.get(index).getMalichhoc());
// 		 PN_Admin_Lichhoc.txtphonghoc.setText(listlichhoc.get(index).getPhongHoc());
// 		PN_Admin_Lichhoc.txtmamonhoc.setText(PN_Admin_Lichhoc.combo.getSelectedItem().toString());
//	}
// --------
	public void exit() {
		int i = JOptionPane.showConfirmDialog(null,"Bạn có muốn thoát","Yes",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(i==JOptionPane.YES_OPTION) {
			UI_Sinhvien.frame.setVisible(false);
			UI_Login.frame.setVisible(true);
		}
	}
}

