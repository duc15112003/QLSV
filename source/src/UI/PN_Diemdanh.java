package UI;


import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;

import Controll.CL_Sinhvien;

import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PN_Diemdanh extends JPanel{
	public static JTable table;
	public static JComboBox comboBox;
	CL_Sinhvien cl = new CL_Sinhvien();
public PN_Diemdanh() {
	setBackground(new Color(255, 255, 255));
	setSize(778,453);
	setLayout(null);
	JSeparator separator = new JSeparator();
	separator.setBorder(new LineBorder(Color.black));
	separator.setBackground(Color.BLACK);
	separator.setForeground(new Color(0, 0, 0));
	separator.setBounds(10, 130, 2, 300);
	add(separator);
	JSeparator separator_1 = new JSeparator();
	separator_1.setForeground(Color.BLACK);
	separator_1.setBorder(new LineBorder(Color.black));
	separator_1.setBackground(Color.BLACK);
	separator_1.setBounds(116, 79, 2, 352);
	add(separator_1);
	
	JSeparator separator_2 = new JSeparator();
	separator_2.setForeground(Color.BLACK);
	separator_2.setBorder(new LineBorder(Color.black));
	separator_2.setBackground(Color.BLACK);
	separator_2.setBounds(222, 77, 2, 353);
	add(separator_2);
	
	JSeparator separator_3 = new JSeparator();
	separator_3.setForeground(Color.BLACK);
	separator_3.setBorder(new LineBorder(Color.black));
	separator_3.setBackground(Color.BLACK);
	separator_3.setBounds(330, 77, 2, 353);
	add(separator_3);
	
	JSeparator separator_4 = new JSeparator();
	separator_4.setForeground(Color.BLACK);
	separator_4.setBorder(new LineBorder(Color.black));
	separator_4.setBackground(Color.BLACK);
	separator_4.setBounds(482, 77, 2, 353);
	add(separator_4);
	JSeparator separator_4_1_1 = new JSeparator();
	separator_4_1_1.setForeground(Color.BLACK);
	separator_4_1_1.setBorder(new LineBorder(Color.black));
	separator_4_1_1.setBackground(Color.BLACK);
	separator_4_1_1.setBounds(10, 429, 474, 2);
	add(separator_4_1_1);
	JPanel panel = new JPanel();
	panel.setBorder(new MatteBorder(2, 2, 2, 0, (Color) new Color(0, 0, 0)));
	panel.setBackground(SystemColor.textHighlight);
	panel.setBounds(10, 77, 107, 101);
	add(panel);
	panel.setLayout(null);
	JLabel malichhoc = new JLabel("Mã Lịch");
	malichhoc.setForeground(new Color(255, 255, 255));
	malichhoc.setBounds(20, 40, 63, 19);
	panel.add(malichhoc);
	malichhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)));
	panel_1.setBackground(SystemColor.textHighlight);
	panel_1.setLayout(null);
	panel_1.setBounds(116, 77, 107, 101);
	add(panel_1);
	
	JLabel lblNewLabel_1 = new JLabel("Môn Học");
	lblNewLabel_1.setForeground(new Color(255, 255, 255));
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_1.setBounds(20, 40, 63, 19);
	panel_1.add(lblNewLabel_1);
	
	JPanel panel_2 = new JPanel();
	panel_2.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)));
	panel_2.setBackground(SystemColor.textHighlight);
	panel_2.setLayout(null);
	panel_2.setBounds(222, 77, 108, 101);
	add(panel_2);
	
	JLabel lblNewLabel_2 = new JLabel("Ca học");
	lblNewLabel_2.setForeground(new Color(255, 255, 255));
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_2.setBounds(20, 40, 63, 19);
	panel_2.add(lblNewLabel_2);
	
	JPanel panel_3 = new JPanel();
	panel_3.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)));
	panel_3.setBackground(SystemColor.textHighlight);
	panel_3.setLayout(null);
	panel_3.setBounds(330, 77, 154, 101);
	add(panel_3);
	
	JLabel lblNewLabel_3 = new JLabel("Trạng thái");
	lblNewLabel_3.setForeground(new Color(255, 255, 255));
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_3.setBounds(20, 40, 113, 19);
	panel_3.add(lblNewLabel_3);
	
	table = new JTable();
	table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	table.setColumnSelectionAllowed(true);
	table.setCellSelectionEnabled(true);
	table.setRowHeight(50);
	table.setGridColor(Color.black);
	table.setBounds(10, 177, 474, 250);
	table.setModel(new DefaultTableModel(
		new Object[][] {
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
		},
		new String[] {
			"New column", "New column", "New column", "New column"
		}
	));
	table.getColumnModel().getColumn(3).setPreferredWidth(122);
	table.setEnabled(false);
	add(table);
	
	JSeparator separator_4_1_1_1 = new JSeparator();
	separator_4_1_1_1.setForeground(Color.BLACK);
	separator_4_1_1_1.setBorder(new LineBorder(Color.black));
	separator_4_1_1_1.setBackground(Color.BLACK);
	separator_4_1_1_1.setBounds(10, 130, 474, 2);
	add(separator_4_1_1_1);
	
	JLabel lblNewLabel_5 = new JLabel("");
	lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\DUC CODER SERVER\\Desktop\\eclipse java\\QLSV\\src\\image\\onggia.jpg"));
	lblNewLabel_5.setBounds(589, 226, 189, 216);
	add(lblNewLabel_5);
	String[] cbomonhoc = new String[] {"Java 2","SQL Server","Java 3","Dự án agile"};
	comboBox = new JComboBox(cbomonhoc);
	comboBox.setModel(new DefaultComboBoxModel(new String[] {"Java 2", "SQL Server", "Java 3", "Dự án agile", "Java1"}));
	comboBox.setBackground(SystemColor.text);
	comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
	comboBox.setBounds(10, 28, 118, 22);
	comboBox.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cl.findmamon();
		}
	});
	add(comboBox);
	setVisible(true);
	}
}