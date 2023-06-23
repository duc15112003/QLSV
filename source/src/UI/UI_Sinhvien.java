package UI;

import java.awt.Color;
import OOP.*;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import UI.*;
import Controll.*;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class UI_Sinhvien {
	
	public static JFrame frame;
	public static JLabel ten;
	public static String id;
	CL_Sinhvien cl = new CL_Sinhvien();
	public static JLabel lblNewLabel;
	public JPanel panel;
	public JPanel thanhmenu;
	public JLabel logouser;
	public JLabel lblhello;
	public static JLabel name;
	public JPanel khungmenupanel;
	public JPanel pnbangdiem;
	public JLabel logobangdiem;
	public JLabel lblbangdiem;
	public static JPanel pntrangchu;
	public JLabel logotrangchu;
	public static JLabel lbltrangchu;
	public JPanel pnlichhoc;
	public JLabel logolichhoc;
	public JLabel lbllichhoc;
	public JPanel pndiemdanh;
	public JLabel logodiemdanh;
	public JLabel lbldiemdanh;
	public JPanel pndangxuat;
	public JLabel logodangxuat;
	public JLabel lbldangxuat;
	public static JPanel manhinh;
	public static JLabel idchuatam;
	public UI_Sinhvien() {
		init();
		Chuyenmanhinh control=new Chuyenmanhinh(manhinh);
        control.setView(pntrangchu,lbltrangchu );
        List<DanhMuc> listItem= new ArrayList<>();
        
        listItem.add(new DanhMuc("trangchu", pntrangchu,lbltrangchu ));
        listItem.add(new DanhMuc("lichhoc",pnlichhoc,lbllichhoc ));
		listItem.add(new DanhMuc("diemdanh", pndiemdanh,lbldiemdanh ));
		listItem.add(new DanhMuc("bangdiem",pnbangdiem,lblbangdiem ));
		listItem.add(new DanhMuc("dangxuat",pndangxuat,lbldangxuat ));
        control.setEventNV(listItem);
        cl.fillngayhoc();
	}
	private void init() {
		frame = new JFrame("Thông tin sinh viên");
		frame.setSize(937, 531);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 921, 509);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		thanhmenu = new JPanel();
		thanhmenu.setBackground(new Color(100, 149, 237));
		thanhmenu.setBounds(0, 0, 921, 45);
		panel.add(thanhmenu);
		thanhmenu.setLayout(null);
		
		logouser = new JLabel("");
		logouser.setIcon(new ImageIcon(getClass().getResource("/icons8-user-24.png")));
		logouser.setBounds(732, 0, 46, 45);
		thanhmenu.add(logouser);
		
		lblhello = new JLabel("Hello");
		lblhello.setBounds(774, 11, 46, 23);
		thanhmenu.add(lblhello);
		
		name = new JLabel("POh");
		name.setBounds(806, 0, 115, 45);
		thanhmenu.add(name);
		
		khungmenupanel = new JPanel();
		khungmenupanel.setBackground(new Color(100, 149, 237));
		khungmenupanel.setBounds(0, 45, 145, 464);
		panel.add(khungmenupanel);
		khungmenupanel.setLayout(null);
		
		pnbangdiem = new JPanel();
		pnbangdiem.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		pnbangdiem.setBackground(SystemColor.text);
		pnbangdiem.setBounds(0, 279, 145, 82);
		khungmenupanel.add(pnbangdiem);
		pnbangdiem.setLayout(null);
		
		logobangdiem = new JLabel("");
		logobangdiem.setIcon(new ImageIcon(getClass().getResource("/scoreboard.png")));
		logobangdiem.setBounds(7, 25, 46, 39);
		pnbangdiem.add(logobangdiem);
		
		lblbangdiem = new JLabel("Bảng điểm");
		lblbangdiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblbangdiem.setBounds(54, 14, 91, 50);
		pnbangdiem.add(lblbangdiem);
		
		pntrangchu = new JPanel();
		pntrangchu.setBorder(new MatteBorder(2, 0, 1, 1, (Color) new Color(0, 0, 0)));
		pntrangchu.setBackground(SystemColor.text);
		pntrangchu.setBounds(0, 0, 145, 82);
		khungmenupanel.add(pntrangchu);
		pntrangchu.setLayout(null);
		
		logotrangchu = new JLabel("");
		logotrangchu.setIcon(new ImageIcon(getClass().getResource("/Home.png")));
		logotrangchu.setBounds(10, 21, 23, 37);
		pntrangchu.add(logotrangchu);
		
		lbltrangchu = new JLabel("Trang chủ");
		lbltrangchu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltrangchu.setBounds(53, 11, 92, 60);
		pntrangchu.add(lbltrangchu);
		
		pnlichhoc = new JPanel();
		pnlichhoc.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		pnlichhoc.setBackground(SystemColor.text);
		pnlichhoc.setBounds(0, 93, 145, 82);
		khungmenupanel.add(pnlichhoc);
		pnlichhoc.setLayout(null);
		
		logolichhoc = new JLabel("");
		logolichhoc.setIcon(new ImageIcon(getClass().getResource("/schedule.png")));
		logolichhoc.setBounds(10, 23, 35, 48);
		pnlichhoc.add(logolichhoc);
		
		lbllichhoc = new JLabel("Lịch Học");
		lbllichhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbllichhoc.setBounds(54, 23, 91, 48);
		pnlichhoc.add(lbllichhoc);
		
		pndiemdanh = new JPanel();
		pndiemdanh.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		pndiemdanh.setBackground(SystemColor.text);
		pndiemdanh.setBounds(0, 186, 145, 82);
		khungmenupanel.add(pndiemdanh);
		pndiemdanh.setLayout(null);
		
		logodiemdanh = new JLabel("");
		logodiemdanh.setIcon(new ImageIcon(getClass().getResource("/attendance.png")));
		logodiemdanh.setBounds(10, 11, 52, 60);
		pndiemdanh.add(logodiemdanh);
		
		lbldiemdanh = new JLabel("Điểm danh");
		lbldiemdanh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldiemdanh.setBounds(54, 11, 91, 60);
		pndiemdanh.add(lbldiemdanh);
		
		pndangxuat = new JPanel();
		pndangxuat.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		pndangxuat.setLayout(null);
		pndangxuat.setBackground(SystemColor.text);
		pndangxuat.setBounds(0, 372, 145, 82);
		khungmenupanel.add(pndangxuat);
		
		logodangxuat = new JLabel("");
		logodangxuat.setIcon(new ImageIcon(getClass().getResource("/dangxuat.png")));
		logodangxuat.setBounds(10, 21, 23, 37);
		pndangxuat.add(logodangxuat);
		
		lbldangxuat = new JLabel("Đăng Xuất");
		lbldangxuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldangxuat.setBounds(53, 11, 92, 60);
		lbldangxuat.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				cl.exit();
			}
		});
		pndangxuat.add(lbldangxuat);
		
		manhinh = new JPanel();
		manhinh.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		manhinh.setBackground(new Color(255, 255, 255));
		manhinh.setBounds(143, 45, 778, 453);
		panel.add(manhinh);
		manhinh.setLayout(null);
		
		idchuatam = new JLabel("New label");
		idchuatam.setBounds(865, 11, 46, 14);
		panel.add(idchuatam);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		new UI_Sinhvien();
	}
}