package UI;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JPanel;

public class UI_Progress {
	
	JFrame frame;
	JProgressBar br;
	JProgressBar progressBar;
	JLabel lblNewLabel_1;
	boolean ret = true;
	public UI_Progress() {
		init();
		
	}
	private void init() {
		frame = new JFrame();
		frame.setSize(655, 377);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.white);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 245, 639, 93);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(578, 11, 61, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Loadding.......");
		lblNewLabel_2.setBounds(10, 11, 71, 24);
		panel_1.add(lblNewLabel_2);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(0, 46, 639, 24);
		panel_1.add(progressBar);
		progressBar.setValue(0);
		progressBar.setStringPainted(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/FPT.png")));
		lblNewLabel.setBounds(0, -48, 639, 341);
		frame.getContentPane().add(lblNewLabel);

		
		frame.setVisible(true);
		fill();
	}
	
	public static void main(String[] args) {
		new UI_Progress();
	}
	private void fill() {
		int i = 0;
        try {
            while (i <= 100) {
            	
                progressBar.setValue(i + 10);
                lblNewLabel_1.setText(String.valueOf(progressBar.getValue())+"%");
                Thread.sleep(5);
                i += 1;
            }
            
            int bar =progressBar.getValue();
            if(ret == false) {
            	bar =0;
            }
    		if(bar==100) {
    			frame.setVisible(false);
    			new UI_Login().frame.setVisible(true);
    		}
        } catch (Exception e) {
        }
	}
	
}
