import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Shartnoma_tarixi {
	private JComboBox Shartnoma;
	
	private JTable table=new JTable();
	
	private static JLabel Label_style(String text,int x,int y,int w,int h) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, w, h);
        return label;
    }
	
	public Shartnoma_tarixi()
	{
		Umumiy_service service=new Umumiy_service();
		JFrame frame=new JFrame();
		frame.setTitle("Talaba");
		String title[]={"<html>"+"<font size='6' color='black'>Shartnoma tarixi jadvali</font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Shartnoma_raqami: "+"</html>",
				"<html>"+"<font size='4' color='black'>To'langan summa: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Sana: </font>"+"</html>"};
				
		
		JComboBox search_yunalish=new JComboBox();
		search_yunalish.setBounds(330,93,160,20);
		frame.add(search_yunalish);
		
		JComboBox search_yil=new JComboBox();
		search_yil.setBounds(493,93,160,20);
		frame.add(search_yil);
		
		JComboBox search_tabaqa=new JComboBox();
		search_tabaqa.setBounds(657,93,158,20);
		frame.add(search_tabaqa);
		
		JTextField summa=new JTextField();
		summa.setBounds(819,93,160,20);
		frame.add(summa);
				
		frame.add(Label_style(title[0],360,-70,500,200));
				
		frame.add(Label_style(title[1],20,0,200,200));
		Shartnoma=new JComboBox();
		Shartnoma.setBounds(160,93,150,20);
		frame.add(Shartnoma);
				
				frame.add(Label_style(title[2],20,40,200,200));
				JTextField K_summa=new JTextField();
				K_summa.setBounds(160,133,150,20);
				frame.add(K_summa);
				
				frame.add(Label_style(title[3],20,80,200,200));
				// O'quv yili nomiga ko'ra kiritiladi
				JComboBox yil=new JComboBox();
	        	yil.setBounds(70,173,65,20);
	        	frame.add(yil);
	        	
	        	// 
	        	String []oylar= {"Yanvar","Fevral","Mart","Aprel","May","Iyun","Iyul","Avgust","Sentabr","Oktabr","Noyabr","Dekabr"};
	        	JComboBox oy=new JComboBox(oylar);
	        	oy.setBounds(145,173,100,20);
	        	JComboBox kun=new JComboBox();
	        	kun.setBounds(255,173,50,20);
	        	oy.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) {
			        	kun.removeAllItems();
			        	String str = (String)oy.getSelectedItem();
			        	
			        	String [] uttiz= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
			        	String [] uttizbir= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
			        	String [] yigirma_sakkiz= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};
			        	String [] yigirma_toqqiz= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"};

			        	if(str.equals("Yanvar") || str.equals("Mart") || str.equals("May") ||str.equals("Iyul") || str.equals("Avgust") || str.equals("Oktabr") || str.equals("Dekabr"))
			        	{
			        		for(String item:uttizbir)
			                kun.addItem(item);
			            }
			        	
			        	else if(str.equals("Aprel") || str.equals("Iyun") || str.equals("Sentabr") ||str.equals("Noyabr"))
			        	{
			        		for(String item : uttiz)
			                kun.addItem(item);
			            }
			        	
			        	else
			        	{
			        		for(String item : yigirma_sakkiz)
				                kun.addItem(item);
			        	}
			        }});
	        	frame.add(oy);	        	
	        	frame.add(kun);
	        	
				String []tittles= {"Talaba","Shartnoma kodi","Sana","To'langan summa"};
				String [][]data={
					{"","","",""},
					{"","","",""},
					{"","","",""},
					{"","","",""},
					{"","","",""},
					{"","","",""},
					{"","","",""},
					{"","","",""},
					{"","","",""},
					{"","","",""},
					{"","","",""}
				};
				table=new JTable(data,tittles);
				JScrollPane jsp=new JScrollPane(table);
				jsp.setBounds(330,120,650,210);
				frame.add(jsp);
				
				
				JButton insert=new JButton("Insert");
				insert.setBounds(20,300,80,30);
				insert.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) { 
			        	// insert
			        }});
				frame.add(insert);
				
				JButton update=new JButton("Update");
				update.setBounds(120,300,80,30);
				update.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) { 
			        	// update
			        }});
				frame.add(update);
				
				JButton delete=new JButton("Delete");
				delete.setBounds(220,300,80,30);
				delete.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) { 
			        	// delete
			        }});
				frame.add(delete);
				
				frame.setSize(1000,450);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null); 
				frame.setLayout(null);
				frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Shartnoma_tarixi();
	}
}
