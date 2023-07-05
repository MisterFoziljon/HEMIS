import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Service {

	private String url = "jdbc:mysql://localhost:3306/talaba_shartnoma";
    
    private String username = "root";
    
    private String password = "";
    
    protected static Connection connection;
    
    public Service(){
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } 
        
        catch (SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
	public static void main(String[] args) {
		new Service();
	}

}