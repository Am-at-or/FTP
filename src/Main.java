
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;

public class Main {
	
	public static void ftpConn(String hostAddress,int port, String log, String password) throws FileNotFoundException {      
        FTPClient fClient = new FTPClient();
        try {
            fClient.connect(hostAddress,port);
            fClient.enterLocalPassiveMode();
            fClient.login(log, password);
            String[] RESULT = fClient.listNames(); 
            
            FileInputStream fInput = new FileInputStream("/home/amator/Стільниця/kod.txt");
            String fs = "/device/sm.txt";
            fClient.storeFile(fs, fInput);
            
            for (int i = 0; i < RESULT.length; i++) {
            	 System.out.println(RESULT[i]);
			}
           
            fClient.logout();
            fClient.disconnect();           
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
    try {
        ftpConn("192.168.1.100", 4601, "", "");
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }     
    }    

}
