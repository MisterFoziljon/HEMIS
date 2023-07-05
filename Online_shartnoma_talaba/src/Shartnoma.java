import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

public class Shartnoma {

	private JComboBox Talabalar;
	private JComboBox Uquv_yillar;
	private JComboBox Tabaqalar;
	private JScrollPane jsp;
	private JTable table=new JTable();
	
	private static JLabel Label_style(String text,int x,int y,int w,int h) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, w, h);
        return label;
    }
	
	public Shartnoma()
	{
		NumberFormat formatter = new DecimalFormat("#00000000");
		System.out.println();
		Umumiy_service service=new Umumiy_service();
		JFrame frame=new JFrame();
		frame.setTitle("Talaba");
		String title[]={"<html>"+"<font size='6' color='black'>Shartnoma jadvali</font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Kontrakt summasi: "+"</html>",
				"<html>"+"<font size='4' color='black'>Talaba: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>O'quv yili: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Tabaqa: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Shartnoma kodi: </font>"+"</html>"};
				
				JTextField search_talaba=new JTextField("");
				search_talaba.setBounds(330,93,91,20);
				frame.add(search_talaba);
				String []yun= {""};
				JComboBox search_yunalish=new JComboBox(yun);
	        	search_yunalish.setBounds(515,93,92,20);
	        	frame.add(search_yunalish);
				List<String> fakultetlar = new ArrayList<String>();
				fakultetlar.add("");
				for(String a:service.get_all_fakultetlar())
					fakultetlar.add(a);
			    JComboBox search_fakultet=new JComboBox(fakultetlar.toArray());
				search_fakultet.setSelectedIndex(0);
				search_fakultet.setBounds(422,93,91,20);
				
				search_fakultet.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) {
			        	search_yunalish.removeAllItems();
			        	String str = (String)search_fakultet.getSelectedItem();
			        	List<String> yunalishlar=service.get_current_yunalishlar(str);
			        	boolean x=true;
			            for(String item : yunalishlar){
			            	if(x)
			            	{
			            		search_yunalish.addItem("");
			            		x=false;
			            	}
			                search_yunalish.addItem(item);
			            }
			        }});
				frame.add(search_yunalish);
				frame.add(search_fakultet);

				List<String> yillar=service.get_uquv_yili();
				JComboBox search_yil=new JComboBox(yillar.toArray());
				search_yil.setBounds(607,93,92,20);
				frame.add(search_yil);
				
				String[] tabaqalar= {"","Stipendiyali","Stipendiyasiz"};
				JComboBox search_tabaqa=new JComboBox(tabaqalar);
				search_tabaqa.setBounds(700,93,92,20);
				search_tabaqa.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) {
			        	
			        }});
				frame.add(search_tabaqa);
				
				JTextField search_summa=new JTextField();
				search_summa.setBounds(793,93,92,20);
				search_summa.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) {
			        	
			        }});
				frame.add(search_summa);
				
				JTextField search_kod=new JTextField();
				search_kod.setBounds(886,93,92,20);
				
				search_kod.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) {
			        	
			        }});
				frame.add(search_kod);
				
				frame.add(Label_style(title[0],370,-70,400,200));
								
				frame.add(Label_style(title[2],20,0,200,200));
				Talabalar=new JComboBox(service.get_talaba_fio().toArray());
				Talabalar.setBounds(80,93,230,20);
				frame.add(Talabalar);
				
				frame.add(Label_style(title[3],20,40,200,200));
				Uquv_yillar=new JComboBox(service.get_uquv_yili().toArray());
				Uquv_yillar.setBounds(100,133,150,20);
				frame.add(Uquv_yillar);
				
				frame.add(Label_style(title[4],20,80,200,200));
				String []tabaqa= {"","Stipendiyali","Stipendiyasiz"};
				Tabaqalar=new JComboBox(tabaqa);
	        	Tabaqalar.setBounds(90,173,150,20);
	        	frame.add(Tabaqalar);
	        	
	        	frame.add(Label_style(title[1],20,120,200,200));
				JTextField K_summa=new JTextField();
				K_summa.setBounds(160,213,130,20);
				frame.add(K_summa);
				
				frame.add(Label_style(title[5],20,160,200,200));
				JTextField kod=new JTextField();
				kod.setBounds(140,253,130,20);
				frame.add(kod);
				
				table.setModel(DbUtils.resultSetToTableModel((ResultSet) service.getshartnoma()));
				jsp=new JScrollPane(table);
				jsp.setBounds(330,120,650,180);
				
				JButton insert=new JButton("Insert");
				insert.setBounds(20,300,80,30);
				insert.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) { 
			        	String talaba=(String) Talabalar.getSelectedItem();
			        	String uquv_yil=(String) Uquv_yillar.getSelectedItem();
			        	String tabaqa=(String) Tabaqalar.getSelectedItem();
			        	String summa=(String) formatter.format(Double.parseDouble(K_summa.getText()));
			        	String skod=(String) kod.getText();
			        	
			        	String ism=talaba.split(" ")[0];
			        	String familiya=talaba.split(" ")[1];
			        	String sharif=talaba.split(" ")[2];
			        	
			        	String id=service.id(ism, familiya, sharif);
			        	String id_yun=service.id_yunalish(id);
			        	String id_fak=service.id_fakultet(id);
			        	String id_yil=service.get_id_by_uquv_yili(uquv_yil);
			        	String id_tabaqa="1";
			        	if(tabaqa=="Stipendiyasiz")
			                id_tabaqa="2";
			        	String []data= {summa,id,id_yun,id_fak,id_yil,id_tabaqa,skod};
			        	
			        	if(service.insertshartnoma(data))
			        	{
			   			 String []title= {"Talaba","Fakultet","Yo'nalish","O'quv yili","Tabaqa","Kontrakt summasi","Shartnoma kodi"};
			        	 String [][]matrix=service.getshartnoma1();
			   			 table=service.getshartnoma();
			   			 jsp = new JScrollPane(table);

	        				JOptionPane.showMessageDialog(null,"Ma'lumotlar muvaffaqiyatli qo'shildi");
	        				
			        	}
			        	else
			        	{
			        		JOptionPane.showMessageDialog(null,"Ma'lumotlar kiritishda xatolikka yo'l qo'yildi");
			        	}
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
				
				table.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		            	TableModel model = table.getModel();
		                Object talaba = model.getValueAt(table.getSelectedRow(), 0);
		                Object uquv_yil = model.getValueAt(table.getSelectedRow(), 3);
		                Object tabaqa = model.getValueAt(table.getSelectedRow(), 4);
		                Object kontrakt = model.getValueAt(table.getSelectedRow(), 5);
		                Object shartnoma_kod = model.getValueAt(table.getSelectedRow(), 6);
		                
		                Talabalar.setSelectedItem(talaba.toString());
		                Uquv_yillar.setSelectedItem(uquv_yil.toString());
		                Tabaqalar.setSelectedItem(tabaqa.toString());		
		                K_summa.setText(kontrakt.toString());
			        	kod.setText(shartnoma_kod.toString());
		            }
		        });
				
				JButton filtr=new JButton("Filtrlash");
				filtr.setBounds(330,300,650,30);
				filtr.addActionListener(new ActionListener() {  
			        public void actionPerformed(ActionEvent e) { 
			        	String talaba=search_talaba.getText();
			        	String yunalish=(String) search_yunalish.getSelectedItem();
			        	String fakultet=(String) search_fakultet.getSelectedItem();
			        	String yil=(String) search_yil.getSelectedItem();
			        	String tabaqa=(String) search_tabaqa.getSelectedItem();
			        	String k_summa=search_summa.getText();
			        	String kod=search_kod.getText();
			        	System.out.println(service.shartnoma_filter(talaba,yunalish,fakultet,yil,tabaqa,k_summa,kod));
			        	//table=service.shartnoma_filter(talaba,yunalish,fakultet,yil,tabaqa,k_summa,kod);
			        }});
				frame.add(filtr);
				
				frame.add(jsp);
				frame.setSize(1000,450);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null); 
				frame.setLayout(null);
				frame.setVisible(true);
	}
		
	public static void main(String[] args) {
		new Shartnoma();
	}

}
