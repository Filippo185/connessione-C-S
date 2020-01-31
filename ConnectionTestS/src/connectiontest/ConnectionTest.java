package connectiontest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionTest {

    public static void main(String[] args) throws IOException{
        ServerSocket sSocket = null;
        int porta=3500;
        int time = 5000;
        Socket con=null;
        CDown cd= null;
        Thread tcd = null;
        
        sSocket = new ServerSocket(porta); //il server si mette ascolto della porta
        
        while(true){
            try{
                sSocket.setSoTimeout(time);  
                System.out.println("in attesa di connessioni...");
                
                cd= new CDown(time);
                tcd = new Thread(cd);
                tcd.start();
                
                con=sSocket.accept(); //il server attende la connessione
                System.out.println("Connessione stabilita");  
                cd.setFlag();
                
                BufferedReader b = new BufferedReader(new InputStreamReader(con.getInputStream()));
                BufferedWriter w= new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
                System.out.println("1");
                System.out.println(b.readLine());
                System.out.println("2");

                w.flush();
            }catch(SocketTimeoutException er){
                System.out.print("Connessione scaduta\n");
                
                
                    
            }catch(IOException ex){
                System.out.println("IOException");
                    
            }finally{
               try {
                    if(con!=null){
                        con.close(); //chiusura della connessione
                    }
                    System.out.println("connessione chiusa");
                    
                } catch (IOException ex) {
                    System.out.println("IOException");
                }
            }
        }
    }
    
}
