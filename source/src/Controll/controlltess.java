package Controll;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import OOP.OOP_DiemDanhAdmin;
import UI.PN_Admin_Diemdanh;

public class controlltess {
	List<OOP_DiemDanhAdmin> listdiemdanhct = new ArrayList<>();
	public void Diemdanh_filllistdiemdanhchitiet() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection cn = null;
			cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV;username=phat;password=123");
			CallableStatement call = cn.prepareCall("{call sp_filldataddct (?)}");
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
	
	public void filldatafromindextb() {
		int index = PN_Admin_Diemdanh.table.getSelectedRow();
		PN_Admin_Diemdanh.txtmasv.setText(listdiemdanhct.get(index).getMasv());
		PN_Admin_Diemdanh.txtlichhoc.setText(PN_Admin_Diemdanh.table.getValueAt(index, 1).toString());
		PN_Admin_Diemdanh.cbocahoc.setSelectedItem(listdiemdanhct.get(index).getCahoc());
		if(listdiemdanhct.get(index).isTinhtrang() == false) {
			PN_Admin_Diemdanh.rdovangmat.setSelected(true);
		}else {
			PN_Admin_Diemdanh.rdocomat.setSelected(true);
		}
		PN_Admin_Diemdanh.cbolophoc.setSelectedItem(listdiemdanhct.get(index).getMalop());
		
		PN_Admin_Diemdanh.lblanh.setIcon(new ImageIcon("C:\\\\Users\\\\DUC CODER SERVER\\\\Desktop\\\\eclipse java\\\\QLSV\\\\src\\\\image\\\\" + listdiemdanhct.get(index).getAnh()));
	}
	

}
