import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ElementListener;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class Talaba_asosiy {

	public Talaba_asosiy(String []talaba)
	{
		JFrame frame=new JFrame();
		frame.setTitle("Talaba asosiy oynasi");
		Umumiy_service service=new Umumiy_service();
		String title[]={"<html>"+"<font size='6' color='black'>Talaba haqida ma'lumot</font>"+"</html>",
				"<html>"+"<font size='4' color='black'>F.I.O.: "+"</html>",
				"<html>"+"<font size='4' color='black'>Yo'nalish: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Kurs: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>Tabaqa: </font>"+"</html>",
				"<html>"+"<font size='4' color='black'>O'quv yili: </font>"+"</html>",
				"<html>"+"<font size='4' color='blue'>Kontrakt summasi: </font>"+"</html>",
				"<html>"+"<font size='4' color='green'>To'langan kontrakt summasi: </font>"+"</html>",
				"<html>"+"<font size='4' color='red'>Qarzdorlik: </font>"+"</html>"};
		
		double k_summa=Double.parseDouble(service.get_k_summa_id(talaba[0]));
		double t_summa=Double.parseDouble(service.get_t_summa_id(talaba[0]));
		double qarzdorlik=k_summa-t_summa;
		String answer[]= {
				"<html>"+"<font size='4' color='black'>"+talaba[2]+" "+talaba[1]+" "+talaba[3]+"</html>",
				"<html>"+"<font size='4' color='black'>"+service.get_yunalish_by_id(talaba[4])+"</html>",
				"<html>"+"<font size='4' color='black'>"+talaba[6]+"</html>",
				"<html>"+"<font size='4' color='black'>"+service.get_tabaqa_by_id(talaba[0])+"</html>",
				"<html>"+"<font size='4' color='black'>"+service.get_uquv_yili_by_id(talaba[0])+"</html>",
				"<html>"+"<font size='4' color='black'>"+service.get_k_summa_id(talaba[0])+" so'm</html>",
				"<html>"+"<font size='4' color='black'>"+String.valueOf(t_summa)+" so'm</html>",
				"<html>"+"<font size='4' color='black'>"+String.valueOf(qarzdorlik)+" so'm</html>"
		};
				frame.add(Label_style(title[0],60,-70,500,200));
				
				frame.add(Label_style(title[1],40,0,200,200));
				frame.add(Label_style(answer[0],120,0,400,200));
				
				frame.add(Label_style(title[2],40,40,200,200));
				frame.add(Label_style(answer[1],120,40,200,200));
				
				frame.add(Label_style(title[3],40,80,200,200));
				frame.add(Label_style(answer[2],120,80,200,200));
				
				frame.add(Label_style(title[4],40,120,200,200));
				frame.add(Label_style(answer[3],120,120,200,200));
				
				frame.add(Label_style(title[5],40,160,200,200));
				frame.add(Label_style(answer[4],120,160,200,200));
				
				frame.add(Label_style(title[6],40,200,200,200));
				frame.add(Label_style(answer[5],180,200,200,200));
				
				frame.add(Label_style(title[7],40,240,400,200));
				frame.add(Label_style(answer[6],250,240,400,200));
				
				frame.add(Label_style(title[8],40,280,200,200));
				frame.add(Label_style(answer[7],130,280,200,200));
				
				JButton shartnoma=new JButton("Yuklash");
				shartnoma.setBounds(140,430,100,30);
				if(qarzdorlik>0)
				{
					shartnoma.setEnabled(true);
					shartnoma.addActionListener(new ActionListener() {  
				        public void actionPerformed(ActionEvent e) {
				        	String path="";
				        	JFileChooser j=new JFileChooser();
				        	j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				        	int x=j.showSaveDialog(shartnoma);
				        	
				        	if(x==JFileChooser.APPROVE_OPTION)
				        	{
				        		path=j.getSelectedFile().getPath();
				        	}
				        	
				        	Document doc=new Document();
				        	try {
								PdfWriter.getInstance(doc, new FileOutputStream(path+"shartnoma.pdf")); 
								PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("shartnoma.pdf"));
						         doc.open();
						         doc.add(new Paragraph("Talabaning shartnoma qog'ozi"));						            
						         doc.add(new Paragraph("Talabaning ismi:"+answer[0]));
						         doc.close();
						         writer.close();
							} catch (FileNotFoundException | DocumentException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				}});
				}
				else
					shartnoma.setEnabled(false);
				frame.add(shartnoma);
				

				frame.setSize(400,530);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null); // set form to center
				frame.setLayout(null);
				frame.setVisible(true);
	}
	protected PdfPTable PdfPTable(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	private static JLabel Label_style(String text,int x,int y,int w,int h) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, w, h);
        return label;
    }
	
	public static void main(String[] args) {
		new Talaba_asosiy(args);
	}

}
