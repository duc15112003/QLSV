package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controll.Chuyenmanhinh;
import Controll.Chuyenmanhinhadmin;
//import Controll.Chuyenmanhinhadmin;
import OOP.*;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Color;
import java.awt.Desktop.Action;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JSeparator;

public class UI_TrangChuAdmin  {
	

	public static JFrame frame;
	JPanel panelchuatextvajmenu;
	JPanel panelmenu;
	JPanel trangchu;
	JLabel trangchulb;
	JPanel taikhoan;
	JLabel tkadmin;
	JPanel diem;
	JLabel diemlb;
	JPanel lichhoc;
	JLabel lichhoclb;
	JPanel diemdanh;
	JLabel diemdanhlb;
	JPanel panelmanhinh;
	JPanel danhsachsinhvientoantruong;
	JLabel danhsachsinhvienlb;
	public static JLabel lblidan;
	public static String tentam = "";
	private JLabel lblNewLabel;
	public static JLabel lblten;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	public UI_TrangChuAdmin() {
		init();
		Chuyenmanhinhadmin control=new Chuyenmanhinhadmin(panelmanhinh);
		panelmanhinh.setLayout(null);
		
		
        control.setView(trangchu,trangchulb );
        List<DanhMuc> listItem= new ArrayList<>();
		listItem.add(new DanhMuc("trangchu", trangchu,trangchulb ));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(getClass().getResource("/search.png")));
		lblNewLabel_5.setBounds(18, 19, 46, 46);
		trangchu.add(lblNewLabel_5);
        listItem.add(new DanhMuc("taikhoan",taikhoan,tkadmin ));
        
        JLabel lblNewLabel_5_1 = new JLabel("");
        lblNewLabel_5_1.setIcon(new ImageIcon(getClass().getResource("/DiemDanh-64.png")));
        lblNewLabel_5_1.setBounds(20, 11, 36, 54);
        taikhoan.add(lblNewLabel_5_1);
        listItem.add(new DanhMuc("diemsinhvien",diem,diemlb ));
        
        JLabel lblNewLabel_5_2 = new JLabel("");
        lblNewLabel_5_2.setIcon(new ImageIcon(getClass().getResource("/book.png")));
        lblNewLabel_5_2.setBounds(20, 11, 36, 54);
        diem.add(lblNewLabel_5_2);
        listItem.add(new DanhMuc("lichhoc",lichhoc,lichhoclb ));
        
        JLabel lblNewLabel_5_3 = new JLabel("");
        lblNewLabel_5_3.setIcon(new ImageIcon(getClass().getResource("/schedule.png")));
        lblNewLabel_5_3.setBounds(22, 11, 34, 54);
        lichhoc.add(lblNewLabel_5_3);
		listItem.add(new DanhMuc("diemdanh", diemdanh,diemdanhlb ));
		
		JLabel lblNewLabel_5_4 = new JLabel("");
		lblNewLabel_5_4.setIcon(new ImageIcon(getClass().getResource("/approve.png")));
		lblNewLabel_5_4.setBounds(23, 26, 33, 24);
		diemdanh.add(lblNewLabel_5_4);
		listItem.add(new DanhMuc("danhsachsinhvien",danhsachsinhvientoantruong,danhsachsinhvienlb));
		
		JLabel lblNewLabel_5_5 = new JLabel("");
		lblNewLabel_5_5.setIcon(new ImageIcon(getClass().getResource("/examination.png")));
		lblNewLabel_5_5.setBounds(22, 11, 34, 54);
		danhsachsinhvientoantruong.add(lblNewLabel_5_5);
		lblidan = new JLabel("");
		lblidan.setBounds(863, 72, 66, 12);
		frame.getContentPane().add(lblidan);
		lblidan.setForeground(SystemColor.text);
		lblidan.setFont(new Font("Tahoma", Font.BOLD, 13));
       control.setEventNV(listItem);
	}
	public void init() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setSize(1000,750);
		//frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		panelchuatextvajmenu = new JPanel();
		panelchuatextvajmenu.setBackground(SystemColor.textHighlight);
		panelchuatextvajmenu.setBounds(0, 52, 993, 44);
		frame.getContentPane().add(panelchuatextvajmenu);
		panelchuatextvajmenu.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1000, 51);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/logout.png")));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(941, 3, 32, 40);
		lblNewLabel_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(925, 7, 2, 30);
		separator.setBorder(new LineBorder(new Color(44, 130, 201)));
		panel.add(separator);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/minus.png")));
		lblNewLabel_2.setBounds(880, 7, 32, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("GROUP");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 27));
		lblNewLabel_3.setBounds(10, 11, 137, 36);
		lblNewLabel_3.setForeground(new Color(44, 130, 201));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(getClass().getResource("/number-one.png")));
		lblNewLabel_4.setBounds(128, 3, 48, 48);
		panel.add(lblNewLabel_4);
		
		lblNewLabel = new JLabel("Hello");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(743, 11, 58, 22);
		panelchuatextvajmenu.add(lblNewLabel);
		
		lblten = new JLabel("");
		lblten.setBounds(796, 11, 95, 22);
		panelchuatextvajmenu.add(lblten);
		
		
		panelmenu = new JPanel();
		panelmenu.setBackground(new Color(255, 255, 255));
		panelmenu.setBounds(0, 95, 180, 644);
		frame.getContentPane().add(panelmenu);
		panelmenu.setLayout(null);
		
		
		
		trangchu = new JPanel();
		trangchu.setBackground(new Color(44, 130, 201));
		trangchu.setBounds(0, 26, 180, 76);
		panelmenu.add(trangchu);
		trangchu.setLayout(null);
		
		trangchulb = new JLabel("Trang Chủ");
		trangchulb.setForeground(SystemColor.text);
		trangchulb.setIcon(null);
		trangchulb.setFont(new Font("Tahoma", Font.BOLD, 15));
		trangchulb.setBounds(74, 30, 96, 24);
		trangchu.add(trangchulb);
		
		taikhoan = new JPanel();
		taikhoan.setBackground(new Color(44, 130, 201));
		taikhoan.setBounds(0, 127, 180, 76);
		panelmenu.add(taikhoan);
		taikhoan.setLayout(null);
		
		tkadmin = new JLabel("Tài Khoản");
		tkadmin.setForeground(SystemColor.text);
		tkadmin.setIcon(null);
		tkadmin.setFont(new Font("Tahoma", Font.BOLD, 15));
		tkadmin.setBounds(72, 29, 98, 23);
		taikhoan.add(tkadmin);
		
		diem = new JPanel();
		diem.setForeground(SystemColor.text);
		diem.setBackground(new Color(44, 130, 201));
		diem.setBounds(0, 228, 180, 76);
panelmenu.add(diem);
		diem.setLayout(null);
		
		diemlb = new JLabel("Bảng Điểm");
		diemlb.setForeground(SystemColor.text);
		diemlb.setIcon(null);
		diemlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		diemlb.setBounds(73, 29, 131, 23);
		diem.add(diemlb);
		
		lichhoc = new JPanel();
		lichhoc.setBackground(new Color(44, 130, 201));
		lichhoc.setBounds(0, 327, 180, 76);
		panelmenu.add(lichhoc);
		lichhoc.setLayout(null);
		
		lichhoclb = new JLabel("Lịch Học");
		lichhoclb.setForeground(new Color(255, 255, 255));
		lichhoclb.setIcon(null);
		lichhoclb.setFont(new Font("Tahoma", Font.BOLD, 15));
		lichhoclb.setBounds(77, 28, 75, 23);
		lichhoc.add(lichhoclb);
		diemdanh = new JPanel();
		diemdanh.setBackground(new Color(44, 130, 201));
		diemdanh.setBounds(0, 427, 180, 76);
		panelmenu.add(diemdanh);
		diemdanh.setLayout(null);
		
		diemdanhlb = new JLabel("Điểm Danh");
		diemdanhlb.setForeground(new Color(255, 255, 255));
		diemdanhlb.setIcon(null);
		diemdanhlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		diemdanhlb.setBounds(77, 26, 93, 23);
		diemdanh.add(diemdanhlb);
		
		danhsachsinhvientoantruong = new JPanel();
		danhsachsinhvientoantruong.setBackground(new Color(44, 130, 201));
		danhsachsinhvientoantruong.setLayout(null);
		danhsachsinhvientoantruong.setBounds(0, 528, 180, 76);
		panelmenu.add(danhsachsinhvientoantruong);
		
		danhsachsinhvienlb = new JLabel("DS Sinh Viên");
		danhsachsinhvienlb.setForeground(new Color(255, 255, 255));
		danhsachsinhvienlb.setIcon(null);
		danhsachsinhvienlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		danhsachsinhvienlb.setBounds(76, 26, 104, 23);
		danhsachsinhvientoantruong.add(danhsachsinhvienlb);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(getClass().getResource("/zigzag.png")));
		lblNewLabel_7.setBounds(34, 96, 46, 32);
		panelmenu.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(getClass().getResource("/zigzag.png")));
		lblNewLabel_7_1.setBounds(114, 96, 32, 32);
		panelmenu.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("");
		lblNewLabel_7_1_1.setIcon(new ImageIcon(getClass().getResource("/zigzag.png")));
		lblNewLabel_7_1_1.setBounds(121, 202, 32, 32);
		panelmenu.add(lblNewLabel_7_1_1);
		
		JLabel lblNewLabel_7_1_2 = new JLabel("");
		lblNewLabel_7_1_2.setIcon(new ImageIcon(getClass().getResource("/zigzag.png")));
		lblNewLabel_7_1_2.setBounds(34, 202, 32, 32);
		panelmenu.add(lblNewLabel_7_1_2);
		
		JLabel lblNewLabel_7_1_3 = new JLabel("");
		lblNewLabel_7_1_3.setIcon(new ImageIcon(getClass().getResource("/zigzag.png")));
		lblNewLabel_7_1_3.setBounds(121, 301, 32, 32);
		panelmenu.add(lblNewLabel_7_1_3);
		
		JLabel lblNewLabel_7_1_4 = new JLabel("");
		lblNewLabel_7_1_4.setIcon(new ImageIcon(getClass().getResource("/zigzag.png")));
		lblNewLabel_7_1_4.setBounds(38, 301, 32, 32);
		panelmenu.add(lblNewLabel_7_1_4);
		
		JLabel lblNewLabel_7_1_5 = new JLabel("");
		lblNewLabel_7_1_5.setIcon(new ImageIcon(getClass().getResource("/zigzag.png")));
		lblNewLabel_7_1_5.setBounds(38, 398, 32, 32);
		panelmenu.add(lblNewLabel_7_1_5);
		
		JLabel lblNewLabel_7_1_6 = new JLabel("");
		lblNewLabel_7_1_6.setIcon(new ImageIcon(getClass().getResource("/zigzag.png")));
		lblNewLabel_7_1_6.setBounds(121, 398, 32, 32);
		panelmenu.add(lblNewLabel_7_1_6);
		
		JLabel lblNewLabel_7_1_7 = new JLabel("");
		lblNewLabel_7_1_7.setIcon(new ImageIcon(getClass().getResource("/zigzag.png")));
		lblNewLabel_7_1_7.setBounds(34, 500, 32, 32);
		panelmenu.add(lblNewLabel_7_1_7);
		
		JLabel lblNewLabel_7_1_8 = new JLabel("");
		lblNewLabel_7_1_8.setIcon(new ImageIcon(getClass().getResource("/zigzag.png")));
		lblNewLabel_7_1_8.setBounds(121, 500, 32, 32);
		panelmenu.add(lblNewLabel_7_1_8);
		JLabel lblNewLabel_7_1_9 = new JLabel("");
		lblNewLabel_7_1_9.setIcon(new ImageIcon(getClass().getResource("/zigzag.png")));
		lblNewLabel_7_1_9.setBounds(34, 0, 46, 32);
		panelmenu.add(lblNewLabel_7_1_9);
		
		JLabel lblNewLabel_7_1_10 = new JLabel("");
		lblNewLabel_7_1_10.setIcon(new ImageIcon(getClass().getResource("/zigzag.png")));
		lblNewLabel_7_1_10.setBounds(114, 0, 32, 32);
		panelmenu.add(lblNewLabel_7_1_10);
		panelmanhinh = new JPanel();
		panelmanhinh.setBackground(SystemColor.text);
		panelmanhinh.setBounds(190, 95, 803, 611);
		frame.getContentPane().add(panelmanhinh);
		
		frame.setVisible(true);
		
	}
}