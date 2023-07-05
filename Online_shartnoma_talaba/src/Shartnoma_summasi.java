import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Shartnoma_summasi {
	

	private JComboBox Yunalishlar;
	private JComboBox Uquv_yillar;
	private JComboBox Tabaqalar;
	
	private JTable table=new JTable();
	
	private static JLabel Label_style(String text,int x,int y,int w,int h) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, w, h);
        return label;
    }
	
	public Shartnoma_summasi()
	{
		Umumiy_service service=new Umumiy_service();
		JFrame frame=new JFrame();
		frame.setTitle("Talaba");
		String title[]={"<html>"+"<font size='6' color='black'>Shartnoma summasi jadvali</font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Yo'nalish: "+"</html>",
				"<html>"+"<font size='4' color='black'>Tabaqa: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>O'quv yili: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Kontrakt summasi: </font>"+"</html>"};
				
		
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
				Yunalishlar=new JComboBox();
				Yunalishlar.setBounds(100,93,150,20);
				frame.add(Yunalishlar);
				
				frame.add(Label_style(title[3],20,40,200,200));
				Uquv_yillar=new JComboBox();
				Uquv_yillar.setBounds(100,133,150,20);
				frame.add(Uquv_yillar);
				
				frame.add(Label_style(title[2],20,80,200,200));
				Tabaqalar=new JComboBox();
	        	Tabaqalar.setBounds(90,173,150,20);
	        	frame.add(Tabaqalar);
	        	
	        	frame.add(Label_style(title[4],20,120,200,200));
				JTextField K_summa=new JTextField();
				K_summa.setBounds(160,213,130,20);
				frame.add(K_summa);
				
				String []tittles= {"Yo'nalishlar","O'quv yili","Tabaqa","Kontrakt summasi"};
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
		new Shartnoma_summasi();
	}
}
