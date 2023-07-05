import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;

public class Umumiy_service extends Service {

	public Umumiy_service() {}
	
	public JTable getTalaba()
	{		
	     String query = "SELECT * FROM talaba";
	     try {
		    	Statement statement = connection.createStatement();
		        ResultSet result = statement.executeQuery(query);
	            
		        List<String> ism = new ArrayList<>();
		 		List<String> familiya = new ArrayList<>();
		 		List<String> sharif = new ArrayList<>();
		 		List<String> kurs = new ArrayList<>();
		 		List<String> seriya = new ArrayList<>();
		 		List<String> raqam = new ArrayList<>();
		 		List<String> fakultet = new ArrayList<>();
		 		List<String> yunalish = new ArrayList<>();
	         
		 	  while(result.next())
	         {
	        	 ism.add(result.getString("Ism"));
	        	 familiya.add(result.getString("Familiya"));
	        	 sharif.add(result.getString("Sharif"));
	        	 kurs.add(result.getString("Kurs"));
	        	 seriya.add(result.getString("Passport_seriya"));
	        	 raqam.add(result.getString("Passport_raqami"));
	        	 fakultet.add(result.getString("id_fakultet"));
	        	 yunalish.add(result.getString("id_yunalish"));
	         }
		 	  
	         Object[]isma=ism.toArray();
	         Object[]familiyaa=familiya.toArray();
	         Object[]sharifa=sharif.toArray();
	         Object[]kursa=kurs.toArray();
	         Object[]seriyaa=seriya.toArray();
	         Object[]raqama=raqam.toArray();
	         Object[]fakulteta=fakultet.toArray();
	         Object[]yunalisha=yunalish.toArray();
	         
	         for(int i=0;i<fakulteta.length;i++)
	         {
	        	 fakulteta[i]=get_fakultet_by_id((String) fakulteta[i]);
	        	 yunalisha[i]=get_yunalish_by_id((String) yunalisha[i]);
	         }
	         
	         String [][]matrix=new String [isma.length][8];
	         for(int i=0;i<isma.length;i++)
	         {
	        	 matrix[i][0]=(String) isma[i];
	        	 matrix[i][1]=(String) familiyaa[i];
	        	 matrix[i][2]=(String) sharifa[i];
	        	 matrix[i][3]=(String) kursa[i];
	        	 matrix[i][4]=(String) seriyaa[i];
	        	 matrix[i][5]=(String) raqama[i];
	        	 matrix[i][6]=(String) fakulteta[i];
	        	 matrix[i][7]=(String) yunalisha[i];
	        	 
	        	 System.out.println(matrix[i][0]+" "+matrix[i][1]+" "+matrix[i][2]+" "+matrix[i][3]+" "+matrix[i][4]+" "+matrix[i][5]+" "+matrix[i][6]+" "+matrix[i][7]);
	         }
	         
	         String []title= {"Ism","Familiya","Sharif","Kurs","Passport_seriya","Passport_raqam","Fakultet","Yunalish"};
	         JTable jt=new JTable(matrix,title);
	         return jt;
	     } 
	     
	     catch (SQLException ex) {
	         return null;
	     }
	}
	
	public JTable shartnoma_filter(String talaba,String yunalish,String fakultet,String yil,String tabaqa,String k_summa,String kod)
	{
		String query="Select * from shartnoma ";
		String []sub_query=new String[7];
		if(!talaba.equals(""))
			sub_query[0]="id_talaba=(Select id_talaba from talaba where lower(Familiya) Like '"+talaba+"%')";
		
		if(!yunalish.equals(""))
			sub_query[1]="id_yunalish=(Select id_yunalish from yunalishlar where yunalish_nomi='"+yunalish+"')";
		
		if(!fakultet.equals(""))
			sub_query[2]="id_fakultet=(Select id_fakultet from fakultet where nomi='"+fakultet+"')";
		
		if(!yil.equals(""))
			sub_query[3]="id_uquv_yili=(Select id_uquv_yili from uquv_yili where uquv_yili_nomi='"+yil+"')";
		
		if(!tabaqa.equals(""))
			sub_query[4]="id_tabaqa=(Select id_tabaqa from tabaqa where tabaqa_nomi='"+tabaqa+"')";
		
		if(!k_summa.equals(""))
			sub_query[5]="Kontrakt_summasi="+k_summa;
		
		if(!kod.equals(""))
			sub_query[6]="Shartnoma_kodi="+kod;
		
		if(true)
		{
			query+="where ";
			if(!(sub_query[0]==null))
				query+=sub_query[0]+" and ";
			if(!(sub_query[1]==null))
				query+=sub_query[1]+" and ";
			if(!(sub_query[2]==null))
				query+=sub_query[2]+" and ";
			if(!(sub_query[3]==null))
				query+=sub_query[3]+" and ";
			if(!(sub_query[4]==null))
				query+=sub_query[4]+" and ";
			if(!(sub_query[5]==null))
				query+=sub_query[5]+" and ";
			if(!(sub_query[6]==null))
				query+=sub_query[6]+" and ";
			
			if(query.endsWith(" and "))
			{
				query=query.substring(0, query.length()-5);		
			}
		}

		try {
	    	Statement statement = connection.createStatement();
	        ResultSet result = statement.executeQuery(query);
            
	        List<String> summa = new ArrayList<>();
	 		List<String> id_ism = new ArrayList<>();
	 		List<String> id_familiya = new ArrayList<>();
	 		List<String> id_sharif = new ArrayList<>();
	 		List<String> id_yunalish = new ArrayList<>();
	 		List<String> id_fakultet = new ArrayList<>();
	 		List<String> id_uquv_yili = new ArrayList<>();
	 		List<String> id_tabaqa = new ArrayList<>();
	 		List<String> kodx = new ArrayList<>();
         
	 	  while(result.next())
         {
        	 summa.add(result.getString("Kontrakt_summasi"));
        	 id_ism.add(by_id_fio(result.getString("id_talaba")).split(" ")[0]);
        	 id_familiya.add(by_id_fio(result.getString("id_talaba")).split(" ")[1]);
        	 id_sharif.add(by_id_fio(result.getString("id_talaba")).split(" ")[2]);
        	 id_yunalish.add(result.getString("id_yunalish"));
        	 id_fakultet.add(result.getString("id_fakultet"));
        	 id_uquv_yili.add(result.getString("id_uquv_yili"));
        	 id_tabaqa.add(result.getString("id_tabaqa"));
        	 kodx.add(result.getString("Shartnoma_kodi"));
         }
	 	  
	 	 Object[] asumma = summa.toArray();
	 	 Object[] ism = id_ism.toArray();
	 	 Object[] familiya = id_familiya.toArray();
	 	 Object[] sharif = id_sharif.toArray();
	 	 Object[] aid_yunalish = id_yunalish.toArray();
	 	 Object[] aid_fakultet = id_fakultet.toArray();
	 	 Object[] aid_uquv_yili = id_uquv_yili.toArray();
	 	 Object[] aid_tabaqa = id_tabaqa.toArray();
	 	 Object[] akod = kodx.toArray();
         
         for(int i=0;i<aid_fakultet.length;i++)
         {
        	 ism[i]=ism[i]+" "+familiya[i]+" "+sharif[i];
        	 aid_yunalish[i]=get_yunalish_by_id((String) aid_yunalish[i]);
        	 aid_fakultet[i]=get_fakultet_by_id((String) aid_fakultet[i]);
        	 aid_uquv_yili[i]=get_uquv_yili_by_id((String)aid_uquv_yili[i]);
        	 aid_tabaqa[i]=get_tabaqa_by_id((String)aid_tabaqa[i]); 
         }
         
         String [][]matrix=new String [ism.length][7];
         for(int i=0;i<aid_fakultet.length;i++)
         {
        	 matrix[i][0]=(String) ism[i];
        	 matrix[i][1]=(String) aid_yunalish[i];
        	 matrix[i][2]=(String) aid_fakultet[i];
        	 matrix[i][3]=(String) aid_uquv_yili[i];
        	 matrix[i][4]=(String) aid_tabaqa[i];
        	 matrix[i][5]=(String) asumma[i];
        	 matrix[i][6]=(String) akod[i];	        	 
         }
         
		 String []title= {"Talaba","Yo'nalish","Fakultet","O'quv yili","Tabaqa","Kontrakt summasi","Shartnoma kodi"};

         JTable jt=new JTable(matrix,title);
         return jt;
     } 
     
     catch (SQLException ex) {
         return null;
     }
		
	}		
	public JTable getshartnoma()
	{		
	     String query = "SELECT * FROM shartnoma";
	     try {
		    	Statement statement = connection.createStatement();
		        ResultSet result = statement.executeQuery(query);
	            
		        List<String> summa = new ArrayList<>();
		 		List<String> id_ism = new ArrayList<>();
		 		List<String> id_familiya = new ArrayList<>();
		 		List<String> id_sharif = new ArrayList<>();
		 		List<String> id_yunalish = new ArrayList<>();
		 		List<String> id_fakultet = new ArrayList<>();
		 		List<String> id_uquv_yili = new ArrayList<>();
		 		List<String> id_tabaqa = new ArrayList<>();
		 		List<String> kod = new ArrayList<>();
	         
		 	  while(result.next())
	         {
	        	 summa.add(result.getString("Kontrakt_summasi"));
	        	 id_ism.add(by_id_fio(result.getString("id_talaba")).split(" ")[0]);
	        	 id_familiya.add(by_id_fio(result.getString("id_talaba")).split(" ")[1]);
	        	 id_sharif.add(by_id_fio(result.getString("id_talaba")).split(" ")[2]);
	        	 id_yunalish.add(result.getString("id_yunalish"));
	        	 id_fakultet.add(result.getString("id_fakultet"));
	        	 id_uquv_yili.add(result.getString("id_uquv_yili"));
	        	 id_tabaqa.add(result.getString("id_tabaqa"));
	        	 kod.add(result.getString("Shartnoma_kodi"));
	         }
		 	  
		 	 Object[] asumma = summa.toArray();
		 	 Object[] ism = id_ism.toArray();
		 	 Object[] familiya = id_familiya.toArray();
		 	 Object[] sharif = id_sharif.toArray();
		 	 Object[] aid_yunalish = id_yunalish.toArray();
		 	 Object[] aid_fakultet = id_fakultet.toArray();
		 	 Object[] aid_uquv_yili = id_uquv_yili.toArray();
		 	 Object[] aid_tabaqa = id_tabaqa.toArray();
		 	 Object[] akod = kod.toArray();
	         
	         for(int i=0;i<aid_fakultet.length;i++)
	         {
	        	 ism[i]=ism[i]+" "+familiya[i]+" "+sharif[i];
	        	 aid_yunalish[i]=get_yunalish_by_id((String) aid_yunalish[i]);
	        	 aid_fakultet[i]=get_fakultet_by_id((String) aid_fakultet[i]);
	        	 aid_uquv_yili[i]=get_uquv_yili_by_id((String)aid_uquv_yili[i]);
	        	 aid_tabaqa[i]=get_tabaqa_by_id((String)aid_tabaqa[i]); 
	         }
	         
	         String [][]matrix=new String [ism.length][7];
	         for(int i=0;i<aid_fakultet.length;i++)
	         {
	        	 matrix[i][0]=(String) ism[i];
	        	 matrix[i][2]=(String) aid_fakultet[i];
	        	 matrix[i][1]=(String) aid_yunalish[i];
	        	 matrix[i][3]=(String) aid_uquv_yili[i];
	        	 matrix[i][4]=(String) aid_tabaqa[i];
	        	 matrix[i][5]=(String) asumma[i];
	        	 matrix[i][6]=(String) akod[i];	        	 
	         }
	         
			 String []title= {"Talaba","Fakultet","Yo'nalish","O'quv yili","Tabaqa","Kontrakt summasi","Shartnoma kodi"};

	         JTable jt=new JTable(matrix,title);
	         return jt;
	     } 
	     
	     catch (SQLException ex) {
	         return null;
	     }
	}
	
	public String [][] getshartnoma1()
	{		
	     String query = "SELECT * FROM shartnoma";
	     try {
		    	Statement statement = connection.createStatement();
		        ResultSet result = statement.executeQuery(query);
	            
		        List<String> summa = new ArrayList<>();
		 		List<String> id_ism = new ArrayList<>();
		 		List<String> id_familiya = new ArrayList<>();
		 		List<String> id_sharif = new ArrayList<>();
		 		List<String> id_yunalish = new ArrayList<>();
		 		List<String> id_fakultet = new ArrayList<>();
		 		List<String> id_uquv_yili = new ArrayList<>();
		 		List<String> id_tabaqa = new ArrayList<>();
		 		List<String> kod = new ArrayList<>();
	         
		 	  while(result.next())
	         {
	        	 summa.add(result.getString("Kontrakt_summasi"));
	        	 id_ism.add(by_id_fio(result.getString("id_talaba")).split(" ")[0]);
	        	 id_familiya.add(by_id_fio(result.getString("id_talaba")).split(" ")[1]);
	        	 id_sharif.add(by_id_fio(result.getString("id_talaba")).split(" ")[2]);
	        	 id_yunalish.add(result.getString("id_yunalish"));
	        	 id_fakultet.add(result.getString("id_fakultet"));
	        	 id_uquv_yili.add(result.getString("id_uquv_yili"));
	        	 id_tabaqa.add(result.getString("id_tabaqa"));
	        	 kod.add(result.getString("Shartnoma_kodi"));
	         }
		 	  
		 	 Object[] asumma = summa.toArray();
		 	 Object[] ism = id_ism.toArray();
		 	 Object[] familiya = id_familiya.toArray();
		 	 Object[] sharif = id_sharif.toArray();
		 	 Object[] aid_yunalish = id_yunalish.toArray();
		 	 Object[] aid_fakultet = id_fakultet.toArray();
		 	 Object[] aid_uquv_yili = id_uquv_yili.toArray();
		 	 Object[] aid_tabaqa = id_tabaqa.toArray();
		 	 Object[] akod = kod.toArray();
	         
	         for(int i=0;i<aid_fakultet.length;i++)
	         {
	        	 ism[i]=ism[i]+" "+familiya[i]+" "+sharif[i];
	        	 aid_yunalish[i]=get_yunalish_by_id((String) aid_yunalish[i]);
	        	 aid_fakultet[i]=get_fakultet_by_id((String) aid_fakultet[i]);
	        	 aid_uquv_yili[i]=get_uquv_yili_by_id((String)aid_uquv_yili[i]);
	        	 aid_tabaqa[i]=get_tabaqa_by_id((String)aid_tabaqa[i]); 
	         }
	         
	         String [][]matrix=new String [ism.length][7];
	         for(int i=0;i<aid_fakultet.length;i++)
	         {
	        	 matrix[i][0]=(String) ism[i];
	        	 matrix[i][2]=(String) aid_fakultet[i];
	        	 matrix[i][1]=(String) aid_yunalish[i];
	        	 matrix[i][3]=(String) aid_uquv_yili[i];
	        	 matrix[i][4]=(String) aid_tabaqa[i];
	        	 matrix[i][5]=(String) asumma[i];
	        	 matrix[i][6]=(String) akod[i];	        	 
	         }
	         
	         return matrix;
	     } 
	     
	     catch (SQLException ex) {
	         return null;
	     }
	}
	
	public boolean insertshartnoma(String []talaba)
	{
        String query = "INSERT INTO shartnoma (Kontrakt_summasi,id_talaba,id_yunalish,id_fakultet,id_uquv_yili,id_tabaqa,Shartnoma_kodi) VALUES ('" + talaba[0] + "'," + talaba[1] + "," + talaba[2]+"," + talaba[3] + "," + talaba[4] + "," + talaba[5] + ",'" + talaba[6]+"');";
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            return true;
        } 
        
        catch (SQLException ex) {
        	System.out.println(ex.getMessage());
            return false;
        }
	}
	
	public String get_yunalish_by_id(String id)
	{
		String query = "SELECT yunalish_nomi FROM yunalishlar where id_yunalish="+id;
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            String yunalish="";
            while (result.next())
    	    	 yunalish=result.getString("yunalish_nomi");
            return yunalish;
		}
		
		catch (SQLException ex) {
            return "";
        }
	}
	
	public String id(String ism,String familiya,String sharif)
    {
		String query = "SELECT id_talaba FROM talaba where Ism='"+ism+"' and Familiya='"+familiya+"' and Sharif='"+sharif+"'";
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            String id="";
            while (result.next())
            	id=result.getString("id_talaba");
            return id;
		}
		
		catch (SQLException ex) {
            return ex.getMessage();
        }
    }
	
	public String by_id_fio(String id)
    {
		String query = "SELECT Ism,Familiya,Sharif FROM talaba where id_talaba="+id;
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            String ism = null;String familiya = null;String sharif = null;
            while (result.next())
            {
            	ism=result.getString("Ism");
            	familiya=result.getString("Familiya");
            	sharif=result.getString("Sharif");
            }
            return ism+" "+familiya+" "+sharif;
		}
		
		catch (SQLException ex) {
            return ex.getMessage();
        }
    }
	public String get_fakultet_by_id(String id)
	{
		String query = "SELECT nomi FROM fakultet where id_fakultet="+id;
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            String fakultet="";
            while (result.next())
            	fakultet=result.getString("nomi");
            return fakultet;
		}
		
		catch (SQLException ex) {
            return "";
        }
	}
	
	public static String[] Mavjudlik(String username,String password)
	{
		String query = "SELECT *FROM talaba";

		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            String []login_data=null;
    	    
    	    String admin_name="admin";
    	    String admin_parol="11062000";
    	    
    	    if(username.equals(admin_name) && password.equals(admin_parol))
    	    {
    	    	login_data=new String [1];
    	    	login_data[0]="admin";

    	    	return login_data;
    	    }
    	    
    	    else 
    	    {
    	    	login_data=new String [7];
	      	      while (result.next())
	      	      {
	      	    	  if(username.equals(result.getString("Passport_seriya")) && password.equals(result.getString("Passport_raqami")))
	      	    	  {
		      	    		login_data[0]=result.getString("id_talaba");
		      	    		login_data[1]=result.getString("Ism");
		      	    		login_data[2]=result.getString("Familiya");
		      	    		login_data[3]=result.getString("Sharif");
		      	    		login_data[4]=result.getString("id_yunalish");
		      	    		login_data[5]=result.getString("id_fakultet");
		      	    		login_data[6]=result.getString("Kurs");
			      	        break;
		      	      }
	        	  }
	      	      return login_data;
    	    }
        } 

        catch (SQLException ex) {
            return null;
        }
	}
	
	//
	public ResultSet get_talaba_lname(String character)
	{
		String query = "SELECT * FROM shartnoma WHERE id_talaba=(Select id_talaba from talaba where lower(Familiya) Like 'A"+character+"%') ";
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            return result;
		}
		
		catch (SQLException ex) {
            return null;
        }
	}
	
	public List get_talaba_fio()
	{
		String query = "SELECT Ism,Familiya,Sharif FROM talaba";
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            List<String> yunalish = new ArrayList<>();
            yunalish.add("");
            while (result.next())
    	    	 yunalish.add(result.getString("Ism")+" "+result.getString("Familiya")+" "+result.getString("Sharif"));
            return yunalish;
		}
		
		catch (SQLException ex) {
            return null;
        }
	}
	
	public List get_uquv_yili()
	{
		String query = "SELECT uquv_yili_nomi FROM uquv_yili";
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            List<String> yil = new ArrayList<>();
            yil.add("");
            while (result.next())
    	    	 yil.add(result.getString("uquv_yili_nomi"));
            return yil;
		}
		
		catch (SQLException ex) {
            return null;
        }
	}
	
	
	public String get_tabaqa_by_id(String id)
	{
		String query = "SELECT tabaqa_nomi FROM tabaqa where id_tabaqa="+id;
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            String tabaqa="";
            while (result.next())
            	tabaqa=result.getString("tabaqa_nomi");
            return tabaqa;
		}
		
		catch (SQLException ex) {
            return "";
        }
	}
	
	public String get_id_by_tabaqa(String tabaqa)
	{
		String query = "SELECT id_tabaqa FROM tabaqa where tabaqa_nomi='"+tabaqa+"'";
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            String tabaqax="";
            while (result.next())
            	tabaqax=result.getString("id_tabaqa");
            return tabaqa;
		}
		
		catch (SQLException ex) {
            return "";
        }
	}
	
	public String get_id_by_uquv_yili(String nom)
	{
		String query = "SELECT id_uquv_yili FROM uquv_yili where uquv_yili_nomi='"+nom+"'";
		
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            String uquv_yili="";
            while (result.next())
            	uquv_yili=result.getString("id_uquv_yili");
            return uquv_yili;
		}
		
		catch (SQLException ex) {
            return "";
        }
	}
	
	public String get_uquv_yili_by_id(String id)
	{
		String query = "SELECT uquv_yili_nomi FROM uquv_yili where id_uquv_yili="+id;
		
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            String uquv_yili="";
            while (result.next())
            	uquv_yili=result.getString("uquv_yili_nomi");
            return uquv_yili;
		}
		
		catch (SQLException ex) {
            return ex.getMessage();
        }
	}
	
	public String get_k_summa_id(String id)
	{
		String query = "SELECT Kontrakt_summasi FROM shartnoma where id_talaba="+id;
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            String ksum="";
            while (result.next())
            	ksum=result.getString("Kontrakt_summasi");
            return ksum;
		}
		
		catch (SQLException ex) {
            return "";
        }
	}
	
	public String get_t_summa_id(String id)
	{
		String query = "SELECT tulangan_summa FROM shartnoma_tarixi where id_talaba="+id;
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            double tsum=0;
            while (result.next())
            	tsum+=Double.parseDouble(result.getString("tulangan_summa"));
            return String.valueOf(tsum);
		}
		
		catch (SQLException ex) {
            return null;
        }
	}
	
	public List<String> get_current_yunalishlar(String nomi)
	{
		String query = "SELECT yunalish_nomi FROM yunalishlar where id_fakultet=(select id_fakultet from fakultet where nomi='"+nomi+"')";
		try {
			List<String> yunalish = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next())
            	yunalish.add(result.getString("yunalish_nomi"));
            
            return yunalish;
		}
		
		catch (SQLException ex) {
            return null;
        }
	}
	
	public List<String> get_all_fakultetlar()
	{
		String query = "SELECT nomi FROM fakultet";
		try {
			List<String> fakultetlar = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next())
            	fakultetlar.add(result.getString("nomi"));
            
            return fakultetlar;
		}
		
		catch (SQLException ex) {
            return null;
        }
	}
	
	public List<String> get_all_yunalishlar()
	{
		String query = "SELECT yunalish_nomi FROM Yunalishlar";
		try {
			List<String> fakultetlar = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next())
            	fakultetlar.add(result.getString("yunalish_nomi"));
            
            return fakultetlar;
		}
		
		catch (SQLException ex) {
            return null;
        }
	}
	
	public int id_student(String seriya, String raqam)
	{
		String query = "SELECT id FROM talaba where Passport_seriya='"+seriya+"' and Passport_raqami='"+raqam+"'";
		int id=-1;
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next())
            	id=Integer.parseInt(result.getString("id"));
            	return id;
      		}
		
		catch (SQLException ex) {
            return id;
        }
	}
	
	public String id_yunalish(String id)
	{
		String query = "SELECT id_yunalish FROM talaba where id_talaba="+id;
		String idx="";
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next())
            	idx=result.getString("id_yunalish");
            	return idx;
      		}
		
		catch (SQLException ex) {
            return "";
        }
	}
	
	public String id_fakultet(String id)
	{
		String query = "SELECT id_fakultet FROM talaba where id_talaba="+id;
		String idx="";
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next())
            	idx=result.getString("id_fakultet");
            	return idx;
      		}
		
		catch (SQLException ex) {
            return null;
        }
	}
	
	public String get_id_by_yunalish(String yunalish)
	{
		String query = "SELECT id_yunalish FROM yunalishlar where yunalish_nomi='"+yunalish+"'";
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            String yunalish_nomi="";
            while (result.next())
    	    	 yunalish_nomi=result.getString("id_yunalish");
            return yunalish_nomi;
		}
		
		catch (SQLException ex) {
            return "";
        }
	}
	
	public String get_id_by_fakultet(String yunalish)
	{
		String query = "SELECT id_fakultet FROM yunalishlar where yunalish_nomi='"+yunalish+"'";
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            String id_fakultet="";
            while (result.next())
            	id_fakultet=result.getString("id_fakultet");
            return id_fakultet;
		}
		
		catch (SQLException ex) {
            return "";
        }
	}

	public String get_id_by_ser_nom(String ser,String nom)
	{
		String query = "SELECT id_talaba FROM talaba where Passport_seriya='"+ser+"' and Passport_raqami='"+nom+"'";
		try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            String id="";
            while (result.next())
            	id=result.getString("id_talaba");
            return id;
		}
		
		catch (SQLException ex) {
            return "";
        }
	}
	public boolean addTalaba(String [] talaba){
	
        String id_yunalish=get_id_by_yunalish(talaba[3]);
        String id_fakultet=get_id_by_fakultet(talaba[3]);
        
        String query = "INSERT INTO talaba (Ism,Familiya,Sharif,id_yunalish,id_fakultet,Kurs,Passport_seriya,Passport_raqami) VALUES ('" + talaba[0] + "','" + talaba[1] + "','" + talaba[2]+"'," + id_yunalish + "," + id_fakultet + "," + talaba[5] + ",'" + talaba[6]+ "','" + talaba[7]+ "');";
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            return true;
        } 
        
        catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean editTalaba(String [] talaba){

        String query = "UPDATE talaba SET "
                + "Ism = '" + talaba[1] + "',"
                + "Familiya = '" + talaba[2] + "',"
                + "Sharif = '" + talaba[3] + "',"
                + "id_yunalish = " + talaba[4]+ ", "
                + "id_fakultet = " + talaba[5]+ ", "
                + "Kurs = " + talaba[6]+ ", "
                + "Passport_seriya = '" + talaba[7] + "',"
                + "Passport_raqami = '" + talaba[8] + "' "
                + " WHERE id_talaba = " + talaba[0];
        System.out.println(query);

       try {
            Statement createStatement = connection.createStatement();
            createStatement.executeUpdate(query);
            return true;
        }
        
        catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean deleteTalaba(String id_talaba){
        String query = "DELETE FROM talaba WHERE id_talaba = " + id_talaba;
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            return true;
        } 
        
        catch (SQLException ex) {
            return false;
        }
    }
    
    
    
    public ResultSet murakkab_surov(String [] data)
    {
    	String query="SELECT DISTINCT t.Ism, t.Familiya, t.id_fakultet, t.id_yunalish,s.id_tabaqa, t.Kurs, s.Kontrakt_summasi, SUM(st.tulangan_summa)"
    			+ " AS tulangan_summa FROM shartnoma s INNER JOIN talaba t USING(id_talaba) INNER JOIN shartnoma_tarixi st USING(id_talaba)";
    	
    	if(data==null)
    	{
    		try {
                Statement statement = connection.createStatement();
                ResultSet resultx = statement.executeQuery(query);
                
                return resultx;
    		}
    		
    		catch (SQLException ex) {
                return null;
            }
    	}
    	else
    	{
    		String []queries=new String [8];
    		boolean surov_ishladi=false;
    		String result=" where ";
    		String id_fak=get_id_by_fakultet(data[3]);
    		String id_yun=get_id_by_yunalish(data[3]);
    		String id_tab=get_id_by_tabaqa(data[4]);
        	if(!data[0].equals(""))
        	{
        		queries[0]="talaba.Familiya='"+data[0]+"'";
        		result+=queries[0];
        		surov_ishladi=true;
        	}
        	
        	if(!data[1].equals(""))
        	{
        		queries[1]="talaba.Ism='"+data[1]+"'";
        		if(surov_ishladi)
        			result+=" and "+queries[1];
        		else
        			result+=queries[1];
        		surov_ishladi=true;
        	}
        	
        	if(!data[2].equals(""))
        	{
        		queries[2]="talaba.id_fakultet="+id_fak+" ";
        		if(surov_ishladi)
        			result+=" and "+queries[2];
        		else
        			result+=queries[2];
        		surov_ishladi=true;
        	}
        	
        	if(!data[3].equals(""))
        	{
        		queries[3]="talaba.id_yunalish="+id_yun+" ";
        		if(surov_ishladi)
        			result+=" and "+queries[3];
        		else
        			result+=queries[3];
        		surov_ishladi=true;
        	}
        	
        	if(!data[4].equals(""))
        	{
        		queries[4]="talaba.id_tabaqa="+id_tab;
        		if(surov_ishladi)
        			result+=" and "+queries[4];
        		else
        			result+=queries[4];
        		surov_ishladi=true;
        	}
        	
        	if(!data[5].equals("") && !data[6].equals("") && !data[7].equals(""))
        	{
        		char qavs1=data[5].charAt(0);
        		char qavs2=data[5].charAt(4);
        		if(qavs1=='(' && qavs2==')')
        			queries[5]=data[6]+"<talaba.Kurs and talaba.Kurs<"+data[7]+" ";
        		
        		if(qavs1=='[' && qavs2==')')
        			queries[5]=data[6]+"<=talaba.Kurs and talaba.Kurs<"+data[7]+" ";
        		
        		if(qavs1=='(' && qavs2==']')
        			queries[5]=data[6]+"<talaba.Kurs and talaba.Kurs<="+data[7]+" ";
        		
        		if(qavs1=='[' && qavs2==']')
        			queries[5]=data[6]+"<=talaba.Kurs and talaba.Kurs<="+data[7]+" ";
        		
        		if(surov_ishladi)
        			result+=" and "+queries[5];
        		else
        			result+=queries[5];
        		
        		surov_ishladi=true;
        	}
        	
        	if(!data[8].equals("") && !data[9].equals(""))
        	{
        		queries[7]="shartnoma_tarixi.tulangan_summa"+data[9]+""+data[8]+"";
        		if(surov_ishladi)
        			result+=" and "+queries[7];
        		else
        			result+=queries[7];
        	}
       	
        	
        	if(result.equals(" where "))
        		result=query;
        	
        	else
        		result=query+result;
        	
        	try {
                Statement statement = connection.createStatement();
                ResultSet resultx = statement.executeQuery(result);
                
                return resultx;
    		}
    		
    		catch (SQLException ex) {
                return null;
            }
    	}
    	
    	
    	
    }
    	
    public static void main(String [] args)
    {}
}
