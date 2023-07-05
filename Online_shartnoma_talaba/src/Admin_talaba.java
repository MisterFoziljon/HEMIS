import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.TableModel;

public class Admin_talaba{
	private JComboBox Yunalishlar;
	private JComboBox Fakultet;
	private JTable table;
	public Admin_talaba()
	{
		Umumiy_service service=new Umumiy_service();
		
		JFrame frame=new JFrame();
		frame.setTitle("Talaba");
		String title[]={"<html>"+"<font size='6' color='black'>Talaba jadvali</font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Familiya: "+"</html>",
				"<html>"+"<font size='4' color='black'>Ism: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Sharif: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Yo'nalish: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Fakultet: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Kurs: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Passport seriya: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Passport raqami: </font>"+"</html>"};
				
		JTextField search_ism=new JTextField();
		search_ism.setBounds(330,93,83,20);
		search_ism.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	
	        }});
		frame.add(search_ism);
		
		
		JTextField search_familiya=new JTextField();
		search_familiya.setBounds(413,93,81,20);
		search_familiya.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	
	        }});
		frame.add(search_familiya);
		
		
		JTextField search_sharif=new JTextField();
		search_sharif.setBounds(494,93,81,20);
		search_sharif.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	
	        }});
		frame.add(search_sharif);
		
		
		String [] kurs= {"","1","2","3","4"};
		JComboBox search_kurs=new JComboBox(kurs);
		search_kurs.setBounds(575,93,81,20);
		search_kurs.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	
	        }});
		frame.add(search_kurs);
		
		
		JTextField search_seriya=new JTextField();
		search_seriya.setBounds(656,93,81,20);
		search_seriya.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	
	        }});
		frame.add(search_seriya);
		
		
		JTextField search_raqam=new JTextField();
		search_raqam.setBounds(737,93,81,20);
		search_raqam.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	
	        }});
		frame.add(search_raqam);
		
		List<String> fakultetlar = new ArrayList<String>();
		fakultetlar.add("");
		for(String a:service.get_all_fakultetlar())
			fakultetlar.add(a);
		JComboBox search_fakultet=new JComboBox(fakultetlar.toArray());
		search_fakultet.setBounds(818,93,81,20);
		search_fakultet.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	
	        }});
		frame.add(search_fakultet);
		
		List<String> yunalish = new ArrayList<String>();
		yunalish.add("");
		for(String a:service.get_all_yunalishlar())
			yunalish.add(a);
		JComboBox search_yunalish=new JComboBox(yunalish.toArray());
		search_yunalish.setBounds(899,93,81,20);
		search_yunalish.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	
	        }});
		frame.add(search_yunalish);
		
				frame.add(Label_style(title[0],420,-70,200,200));
								
				frame.add(Label_style(title[1],20,0,200,200));
				JTextField Ism=new JTextField();
				Ism.setBounds(100,93,200,20);
				frame.add(Ism);
				
				frame.add(Label_style(title[2],20,40,200,200));
				JTextField Familiya=new JTextField();
				Familiya.setBounds(100,133,200,20);
				frame.add(Familiya);
				
				frame.add(Label_style(title[3],20,80,200,200));
				JTextField Sharif=new JTextField();
				Sharif.setBounds(100,173,200,20);
				frame.add(Sharif);
				
				frame.add(Label_style(title[4],20,160,200,200));
				Yunalishlar=new JComboBox();
	        	Yunalishlar.setBounds(100,253,200,20);
	        	frame.add(Yunalishlar);
				
				frame.add(Label_style(title[5],20,120,200,200));
				Fakultet=new JComboBox(fakultetlar.toArray());
				Fakultet.setSelectedIndex(0);
				Fakultet.setBounds(100,213,200,20);
				
				Fakultet.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) {
			        	Yunalishlar.removeAllItems();
			        	String str = (String)Fakultet.getSelectedItem();
			        	List<String> yunalishlar=service.get_current_yunalishlar(str);
			            for(String item : yunalishlar){
			                Yunalishlar.addItem(item);
			            }
			        }});
				
				String str = (String)Fakultet.getSelectedItem();
	        	List<String> yunalishlar=service.get_current_yunalishlar(str);
	            for(String item : yunalishlar){
	                Yunalishlar.addItem(item);
	            }
				frame.add(Yunalishlar);
				frame.add(Fakultet);

				frame.add(Label_style(title[6],20,200,200,200));
				String []kurslar= {"1","2","3","4"};
				JComboBox Kurs=new JComboBox(kurslar);
				Kurs.setBounds(100,293,200,20);
				frame.add(Kurs);
				
				frame.add(Label_style(title[7],20,240,200,200));
				JTextField seriya=new JTextField();
				seriya.setBounds(140,333,160,20);
				frame.add(seriya);
				
				frame.add(Label_style(title[8],20,280,200,200));
				JTextField nomer=new JTextField();
				nomer.setBounds(140,373,160,20);
				frame.add(nomer);
				
				table=service.getTalaba();
				JScrollPane jsp=new JScrollPane(table);
				jsp.setBounds(330,120,650,370);
				
				JButton insert=new JButton("Insert");
				insert.setBounds(20,430,80,30);
				insert.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) {  
			        	String familiya=Familiya.getText();
			        	String ism=Ism.getText();
			        	String sharif=Sharif.getText();
			        	String id_Yunalish=(String) Yunalishlar.getSelectedItem();
			        	String id_Fakultet=(String) Fakultet.getSelectedItem();
			        	String kurs=(String) Kurs.getSelectedItem();
			        	String pas_ser=seriya.getText();
			        	String pas_nom=nomer.getText();
			        	String []talaba= {ism,familiya,sharif,id_Yunalish,id_Fakultet,kurs,pas_ser,pas_nom};
			        	
			        	if(pas_ser.length()==2 && pas_nom.length()==7)
			        	{
			        		String harf= "ABCDEFGHIJKLMNOPQRSTUXYZ";
			        		String raqam= "1234567890";
			        		
			        		int harflar_soni=0;
			        		int raqamlar_soni=0;
			        		
			        		for(int i=0;i<harf.length();i++)
			        		{
			        			if(pas_ser.charAt(0)==harf.charAt(i))
			        				harflar_soni++;
			        			
			        			if(pas_ser.charAt(1)==harf.charAt(i))
			        				harflar_soni++;
			        		}
			        		
			        		for(int i=0;i<raqam.length();i++)
			        			for(int j=0;j<pas_nom.length();j++)
									if(pas_nom.charAt(j)==raqam.charAt(i))
			        				raqamlar_soni++;
			        		System.out.println(raqamlar_soni);
			        		
			        		if(raqamlar_soni==7 && harflar_soni==2)
			        		{
			        			if(service.addTalaba(talaba))
					        	{
			        				JOptionPane.showMessageDialog(null,"Ma'lumotlar muvaffaqiyatli qo'shildi");
			        				table=service.getTalaba();
					        	}
					        	
					        	else
					        		JOptionPane.showMessageDialog(null,"Login yoki parol kiritishda xatolikka yo'l qo'yildi");
			        		}
			        		else
				        		JOptionPane.showMessageDialog(null,"ser_len:"+pas_ser.length()+"  nom_len:"+pas_nom.length());
			        	}
			        	
			        	else
			        		JOptionPane.showMessageDialog(null,"Ma'lumotlar kiritishda xatolikka yo'l qo'yildi");
			    }});  
				frame.add(insert);
				
				JButton delete=new JButton("Delete");
				delete.setBounds(120,430,80,30);
				delete.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) { 
			        	TableModel model = table.getModel();
			        	Object pas_ser = model.getValueAt(table.getSelectedRow(), 4);
		                Object pas_nom = model.getValueAt(table.getSelectedRow(), 5);
			        	String id=service.get_id_by_ser_nom((String)pas_ser,(String)pas_nom);
			        	if(service.deleteTalaba(id))
			        	{
			        		JOptionPane.showMessageDialog(null,"Ma'lumotlar muvaffaqiyatli o'chirildi");			        		
			        		table=service.getTalaba();
			        	}
			 	
			        	else
			        		JOptionPane.showMessageDialog(null,"Ma'lumotlar o'chirishda xatolikka yo'l qo'yildi");
			        	
			    }});  
				frame.add(delete);
				
				JButton update=new JButton("Update");
				update.setBounds(220,430,80,30);
				update.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) {  
			        	TableModel model = table.getModel();
		                Object update_login = model.getValueAt(table.getSelectedRow(), 4);
		                Object update_password = model.getValueAt(table.getSelectedRow(), 5);
			        	
			        	String familiya=Familiya.getText();
			        	String ism=Ism.getText();
			        	String sharif=Sharif.getText();
			        	String Yunalish_=(String) Yunalishlar.getSelectedItem();
			        	String Fakultet_=(String) Fakultet.getSelectedItem();
			        	String kurs=(String) Kurs.getSelectedItem();
			        	String pas_ser=seriya.getText();
			        	String pas_nom=nomer.getText();
			        	String id=service.get_id_by_ser_nom((String)update_login,(String)update_password);
			        	String id_Yunalish=service.get_id_by_yunalish(Yunalish_);
			        	String id_Fakultet=service.get_id_by_fakultet(Yunalish_);
			        	String []talaba= {id,ism,familiya,sharif,id_Yunalish,id_Fakultet,kurs,pas_ser,pas_nom};
			        	if(pas_ser.length()==2 && pas_nom.length()==7)
			        	{
			        		String harf= "ABCDEFGHIJKLMNOPQRSTUXYZ";
			        		String raqam= "1234567890";
			        		
			        		int harflar_soni=0;
			        		int raqamlar_soni=0;
			        		
			        		for(int i=0;i<harf.length();i++)
			        		{
			        			if(pas_ser.charAt(0)==harf.charAt(i))
			        				harflar_soni++;
			        			
			        			if(pas_ser.charAt(1)==harf.charAt(i))
			        				harflar_soni++;
			        		}
			        		
			        		for(int i=0;i<raqam.length();i++)
			        			for(int j=0;j<pas_nom.length();j++)
									if(pas_nom.charAt(j)==raqam.charAt(i))
			        				raqamlar_soni++;
			        		
			        		if(raqamlar_soni==7 && harflar_soni==2)
			        		{
			        			if(service.editTalaba(talaba))
					        	{
			        				System.out.println("kirdi");
			        				JOptionPane.showMessageDialog(null,"Ma'lumotlar muvaffaqiyatli yangilandi");
			        				table=service.getTalaba();
			        				frame.add(table);
					        	}
			        		}
			        		
			        		else
				        		JOptionPane.showMessageDialog(null,"Login yoki parol kiritishda xatolikka yo'l qo'yildi");
			        	}
			        	
			        	else
			        		JOptionPane.showMessageDialog(null,"Ma'lumotlar yangilanishda xatolikka yo'l qo'yildi");
			    }});  
				frame.add(update);
				
				table.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		            	TableModel model = table.getModel();
		                Object ism = model.getValueAt(table.getSelectedRow(), 0);
		                Object familiya = model.getValueAt(table.getSelectedRow(), 1);
		                Object sharif = model.getValueAt(table.getSelectedRow(), 2);
		                Object yunalish = model.getValueAt(table.getSelectedRow(), 7);
		                Object fakultet = model.getValueAt(table.getSelectedRow(), 6);
		                Object kurs = model.getValueAt(table.getSelectedRow(), 3);
		                Object pas_ser = model.getValueAt(table.getSelectedRow(), 4);
		                Object pas_nom = model.getValueAt(table.getSelectedRow(), 5);
		                
		                int id_student = service.id_student((String)pas_ser, (String)pas_nom);
		                
		                Familiya.setText(familiya.toString());
		                Ism.setText(ism.toString());
		                Sharif.setText(sharif.toString());		
		                System.out.println(yunalish);
		                Fakultet.setSelectedItem((String)fakultet);
		                Yunalishlar.removeAllItems();
			        	List<String> yunalishlar=service.get_current_yunalishlar((String)fakultet);
			            for(String item : yunalishlar)
			                Yunalishlar.addItem(item);
			            Yunalishlar.setSelectedItem(yunalish);
		                Kurs.setSelectedItem(kurs.toString());
		                seriya.setText(pas_ser.toString());
		                nomer.setText(pas_nom.toString());
		            }
		        });
				
				frame.add(jsp);
				
				frame.setSize(1000,550);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null); 
				frame.setLayout(null);
				frame.setVisible(true);
		}
		
		private static JLabel Label_style(String text,int x,int y,int w,int h) {
	        JLabel label = new JLabel(text);
	        label.setBounds(x, y, w, h);
	        return label;
	    }
	public static void main(String[] args) {
		new Admin_talaba();
	}
}