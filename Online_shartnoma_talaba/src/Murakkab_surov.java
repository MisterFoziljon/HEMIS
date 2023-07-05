import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Murakkab_surov {
	static JComboBox Yunalishlar;
	static JComboBox Fakultet;
	public JTable table=new JTable();
	
	public Murakkab_surov()
	{
		
		JFrame frame=new JFrame();
		frame.setTitle("Talaba asosiy oynasi");
		Umumiy_service service=new Umumiy_service();
		String title[]={"<html>"+"<font size='6' color='black'>Murakkab so'rov oynasi</font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Familiya: "+"</html>",
				"<html>"+"<font size='4' color='black'>Ism: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Fakultet: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Yo'nalish: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Tabaqa: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Kurs: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>{</font>"+"</html>",
				"<html>"+"<font size='4' color='black'>;</font>"+"</html>",
				"<html>"+"<font size='4' color='black'>}</font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Summa:</font>"+"</html>",
				"<html>"+"<font size='4' color='black'>so'm</font>"+"</html>"
};
		/* Asosiy mavzu nomi*/
		frame.add(Label_style(title[0],360,-70,500,200));
		/*--------------------------------------------------*/
		
		/*---------------------Familiya---------------------*/
		frame.add(Label_style(title[1],30,0,200,200));
		JTextField Familiya=new JTextField();
		Familiya.setBounds(110,93,180,20);
		frame.add(Familiya);
		/*---------------------Familiya---------------------*/
		
		/*---------------------Ism---------------------*/
		frame.add(Label_style(title[2],30,40,200,200));
		JTextField Ism=new JTextField();
		Ism.setBounds(110,133,180,20);
		frame.add(Ism);
		/*---------------------Ism---------------------*/
		
		/*---------------------Fakultet va Yo'nalish---------------------*/
		frame.add(Label_style(title[3],30,80,200,200));
		frame.add(Label_style(title[4],30,120,200,200));
		Yunalishlar=new JComboBox();
		Yunalishlar.setBounds(110,213,180,20);
    	frame.add(Yunalishlar);
		
		List<String> fakultetlar=service.get_all_fakultetlar();
		Fakultet=new JComboBox(fakultetlar.toArray());
		Fakultet.setSelectedIndex(0);
		Fakultet.setBounds(110,173,180,20);
		
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
    	/*---------------------Fakultet va Yo'nalish---------------------*/

    	    	
    	/*---------------------Tabaqa---------------------*/
    	frame.add(Label_style(title[5],30,160,200,200));
    	String []tabaqa= {"Stipendiyali","Stipendiyasiz"};
		JComboBox Status=new JComboBox(tabaqa);
    	Status.setBounds(110,253,180,20);
    	frame.add(Status);
    	/*---------------------Tabaqa---------------------*/
    	
    	/*---------------------Kurs---------------------*/
    	String[] kurs= {"(a;b)","[a;b]","(a;b]","[a;b)",};
    	frame.add(Label_style(title[6],30,200,200,200));
    	JComboBox Kurs=new JComboBox();
    	Kurs.setBounds(80,293,50,20);
    	for(int i=0;i<kurs.length;i++)
    	Kurs.addItem(kurs[i]);
    	frame.add(Kurs);
    	
    	String []kurslar= {"1","2","3","4"};
    	frame.add(Label_style(title[7],150,200,200,200));
    	JComboBox a=new JComboBox(kurslar);
		a.setBounds(160,293,50,20);
		frame.add(a);
		
    	frame.add(Label_style(title[8],215,200,200,200));
    	JComboBox b=new JComboBox(kurslar);
		b.setBounds(227,293,50,20);
		frame.add(b);	
		frame.add(Label_style(title[9],280,200,200,200));
		/*---------------------Kurs---------------------*/
		
		
		/*---------------------To'langan summa---------------------*/
		String[] tks= {">","<",">=","<=","="};
		frame.add(Label_style(title[10],30,240,250,200));
		JTextField Summa=new JTextField();
		Summa.setBounds(100,333,95,20);
		frame.add(Label_style(title[11],200,240,250,200));
		frame.add(Summa);	
		JComboBox TKS=new JComboBox();
    	TKS.setBounds(240,333,50,20);
    	for(int i=0;i<tks.length;i++)
    	TKS.addItem(tks[i]);
    	frame.add(TKS);
		/*---------------------To'langan summa---------------------*/
		
    	/*---------------------Table---------------------*/
		table.setModel(DbUtils.resultSetToTableModel(service.murakkab_surov(null)));
		JScrollPane jsp=new JScrollPane(table);
		

		jsp.setBounds(300,90,650,370);
		frame.add(jsp);
    	/*---------------------Table---------------------*/
    	
    	/*---------------------button---------------------*/
    	JButton get=new JButton("Natija");
		get.setBounds(100,370,80,30);
		get.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {  
	        	String familiya=Familiya.getText();
	        	String ism=Familiya.getText();
	        	String fakultet=(String) Fakultet.getSelectedItem();
	        	String yunalish=(String) Yunalishlar.getSelectedItem();
	        	String status=(String) Status.getSelectedItem();
	        	String kurs=(String) Kurs.getSelectedItem(); 
	        	String A=(String) a.getSelectedItem();
	        	String B=(String) b.getSelectedItem();
	        	String summa=Summa.getText();
	        	String tkss=(String) TKS.getSelectedItem(); 
	     
	        	String[]data= {familiya,ism,fakultet,yunalish,status,kurs,A,B,summa,tkss};
	        	table=(JTable) service.murakkab_surov(data);
	        	frame.add(jsp);
	        }
		});
    	frame.add(get);
    	/*---------------------button---------------------*/
    	
    	frame.setSize(1000,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); 
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new Murakkab_surov();
	}

	private static JLabel Label_style(String text,int x,int y,int w,int h) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, w, h);
        return label;
    }
}
