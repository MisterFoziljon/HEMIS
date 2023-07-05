import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login_parol extends Service {
	
	public login_parol()
	{
		JFrame frame = new JFrame();
		frame.setTitle("login");
		
		
		
		String title[]={"<html>"+"<font size='6' color='black'>Login to Your Account</font>"+"</html>",
						"<html>"+"<font size='4' color='black'>Enter your username & password to login"+"</html>",
						"<html>"+"<font size='5' color='blue'>Username</font>"+"</html>",
						"<html>"+"<font size='5' color='blue'>Password</font>"+"</html>",
						"<html>"+"<font size='5' color='blue'>Remember me</font>"+"</html>"};
		
		frame.add(Label_style(title[0],110,-40,2000,200));
		frame.add(Label_style(title[1],90,0,2000,200));
		frame.add(Label_style(title[2],50,80,2000,200));
		
		JTextField user=new JTextField();
		user.setBounds(50,205,390,30);
		frame.add(user);
		
		frame.add(Label_style(title[3],50,160,200,200));
		
		JPasswordField pword=new JPasswordField();
		pword.setBounds(50,285,365,30);
		frame.add(pword);
		
		JCheckBox chboxpword=new JCheckBox();
		chboxpword.setBounds(420,290,20,20);
		frame.add(chboxpword);
		
		JCheckBox chbox=new JCheckBox();
		chbox.setBounds(50,330,20,20);
		frame.add(chbox);
		frame.add(Label_style(title[4],80,240,200,200));
		
		JButton login_btn=new JButton("Login");
		login_btn.setBounds(50,400,390,40);
		login_btn.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {  
	        	String login=user.getText();
	        	String parol=pword.getText();
	        	
	    	    Umumiy_service us=new Umumiy_service();  
	        	String [] mavjud=us.Mavjudlik(login,parol);
	        	if(mavjud.length==7)
	        	{
	        		Talaba_asosiy student = new Talaba_asosiy(mavjud);
	        	}
	        	else if(mavjud[0]=="admin")
	        	{
	        		Asosiy_menu asosiy_menu=new Asosiy_menu();
	        	}
	        	else
	        	{
	        		JOptionPane.showMessageDialog(frame,"Login or parol was incorrect");
	        	}	        	
	        	}});  
		
		frame.add(login_btn);
		frame.setSize(500,500);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // set form to center
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	private JLabel Label_style(String text,int x,int y,int w,int h) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, w, h);
        return label;
    }
	
	public static void main(String[] args) {
		new login_parol();
		
	}

}
