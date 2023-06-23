package UI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controll.controlltess;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class PN_Admin_Diemdanh extends JPanel{
	public static JTable table;
	public static JTextField txtmasv;
	public static JTextField txtlichhoc;
	public static JComboBox cbocahoc;
	public static JComboBox cbolophoc;
	public static JLabel lblanh;
	public static JRadioButton rdocomat;
	public static JRadioButton rdovangmat;
	controlltess cl = new controlltess();
	private JTable table_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public PN_Admin_Diemdanh() {
		setBackground(new Color(255, 255, 255));
		setSize(803,644);
		setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.filldatafromindextb();
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(25, 344, 748, 160);
		add(table);
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 57, 118, 14);
		add(lblNewLabel);
		
		txtmasv = new JTextField();
		txtmasv.setEnabled(false);
		txtmasv.setBounds(135, 55, 91, 20);
		add(txtmasv);
		txtmasv.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(541, 32, 158, 211);
		add(panel);
		panel.setLayout(null);
		
		lblanh = new JLabel("");
		lblanh.setBounds(10, 11, 138, 189);
		panel.add(lblanh);
		lblanh.setBackground(new Color(255, 255, 255));
		
		JLabel lblngayhoc = new JLabel("Mã lịch học :");
		lblngayhoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblngayhoc.setBounds(25, 105, 107, 17);
		add(lblngayhoc);
		
		txtlichhoc = new JTextField();
		txtlichhoc.setBounds(135, 104, 158, 20);
		add(txtlichhoc);
		txtlichhoc.setColumns(10);
		
		JLabel lblcahoc = new JLabel("Ca học:");
		lblcahoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblcahoc.setBounds(25, 155, 107, 14);
		add(lblcahoc);
		
		String[] cahoc = new String[] {"1","2","3","4"};
		cbocahoc = new JComboBox(cahoc);
		cbocahoc.setBackground(new Color(255, 255, 255));
		cbocahoc.setBounds(135, 152, 46, 22);
		add(cbocahoc);
		
		JLabel lbltinhtrang = new JLabel("Tình trạng:");
		lbltinhtrang.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbltinhtrang.setBounds(25, 196, 118, 14);
		add(lbltinhtrang);
		
		JButton btnExcel = new JButton("Excel");
		btnExcel.setForeground(new Color(255, 255, 255));
		btnExcel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExcel.setBackground(new Color(0, 255, 64));
		btnExcel.setBounds(683, 540, 89, 23);
		add(btnExcel);
		
		JButton btnNewButton_1 = new JButton("Sửa");
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(0, 153, 204));
		btnNewButton_1.setBounds(340, 40, 129, 50);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Lớp học:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 241, 107, 14);
		add(lblNewLabel_1);
		
		String[] lophoc = new String[] {"SD18202","SD18203","SP18202","KT18201"};
		cbolophoc = new JComboBox(lophoc);
		cbolophoc.setBackground(new Color(255, 255, 255));
		cbolophoc.setBounds(135, 238, 91, 22);
		cbolophoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.filltbdiemdanhchitiet();
				
			}
		});
		add(cbolophoc);
		
		JButton btnNewButton_1_1 = new JButton("Xóa");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(new Color(0, 153, 204));
		btnNewButton_1_1.setBounds(340, 110, 129, 50);
		add(btnNewButton_1_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"M\u00E3 Sinh Vi\u00EAn", "M\u00E3 L\u1ECBch H\u1ECDc", "T\u00ECnh Tr\u1EA1ng", "Ca h\u1ECDc", "M\u00E3 Lpp"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setRowHeight(20);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_1.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(0, 0, 0)));
		table_1.setBackground(new Color(102, 153, 204));
		table_1.setBounds(25, 323, 748, 20);
		add(table_1);
		
		rdocomat = new JRadioButton("Có mặt");
		buttonGroup.add(rdocomat);
		rdocomat.setBackground(Color.WHITE);
		rdocomat.setBounds(135, 193, 71, 23);
		add(rdocomat);
		
		rdovangmat = new JRadioButton("Vắng mặt");
		buttonGroup.add(rdovangmat);
		rdovangmat.setBackground(Color.WHITE);
		rdovangmat.setBounds(222, 193, 89, 23);
		add(rdovangmat);
		
		setVisible(true);
	}
}
