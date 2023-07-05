import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Asosiy_menu extends JFrame{
	int x=50;
	public Asosiy_menu()
	{
		setTitle("Talabalar uchun shartnoma tizimi");
		
		String title="<html>"+"<font size='6' color='blue'>Talabalar uchun shartnoma tizimi</font>"+"</html>";
		add(Label_style(title,20,-60,1000,200));
		
		String [] entity= {"SHARTNOMA","SHARTNOMA SUMMASI","SHARTNOMA TARIXI","TALABA"};
		
		JButton btn_shartnoma = new JButton("SHARTNOMA");
		btn_shartnoma.setBounds(60,80,300,35);
		btn_shartnoma.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {  	        	
	        	Shartnoma shartnoma=new Shartnoma();
	        }});  
		add(btn_shartnoma);
		
		JButton btn_shartnoma_summasi = new JButton("SHARTNOMA SUMMASI");
		btn_shartnoma_summasi.setBounds(60,80+x,300,35);
		btn_shartnoma_summasi.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {  	        	
	        	Shartnoma_summasi shs=new Shartnoma_summasi();
	        }});  
		add(btn_shartnoma_summasi);
		
		JButton btn_shartnoma_tarixi = new JButton("SHARTNOMA TARIXI");
		btn_shartnoma_tarixi.setBounds(60,80+2*x,300,35);
		btn_shartnoma_tarixi.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {  	        	
	        	Shartnoma_tarixi sht=new Shartnoma_tarixi();
	        }});  
		add(btn_shartnoma_tarixi);
		
		JButton btn_talaba = new JButton("TALABA");
		btn_talaba.setBounds(60,80+3*x,300,35);
		btn_talaba.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {  	        	
	        	Admin_talaba at=new Admin_talaba();
	        }});  
		add(btn_talaba);
		
		JButton btn_ms = new JButton("Murakkab so'rov");
		btn_ms.setBounds(60,80+5*x,300,35);
		btn_ms.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {  	        	
	        	Murakkab_surov at=new Murakkab_surov();
	        }});  
		add(btn_ms);
		
		
		setSize(440,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // set form to center
		setLayout(null);
		setVisible(true);
	}
	
	private JLabel Label_style(String text,int x,int y,int w,int h) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, w, h);
        return label;
    }
	
	private JButton button_style(String text,int x,int y,int w,int h) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, w, h);
        return btn;
    }
	
	public static void main(String[] args) {
		new Asosiy_menu();
	}

}
