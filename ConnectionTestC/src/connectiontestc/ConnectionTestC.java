package connectiontestc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionTestC {
    static String d;

    public static void main(String[] args) throws IOException {
        Socket con;
        String serv ="localhost";
        int porta = 3500;
        con=new Socket(serv,porta); //richiesta di connessione
        System.out.println("connessione aperta");
        BufferedReader b = new BufferedReader(new InputStreamReader(con.getInputStream()));
        BufferedWriter w= new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
        System.out.println("1");
        w.write("Che ore sono?");
        w.flush();
        System.out.println("2");
        d=b.readLine();
        System.out.println(d);
        
        con.close(); //chiusura della connessione
        System.out.println("connessione chiusa");
                
    }
    
}
