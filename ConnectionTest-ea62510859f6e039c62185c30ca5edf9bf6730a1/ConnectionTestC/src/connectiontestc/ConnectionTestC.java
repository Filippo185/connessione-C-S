/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectiontestc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

/**
 *
 * @author informatica
 */
public class ConnectionTestC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            Socket con;
            String serv ="localhost";
            int porta = 3500;
            con=new Socket(serv,porta);
            System.out.println("connessione aperta");
            PrintWriter pw = new PrintWriter(con.getOutputStream(),true);
            BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
            BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Invia un messaggio: ");
            pw.println(kb.readLine());
            
            System.out.println("Attesa di un messaggio: ");
            System.out.println(br.readLine());
            
            
            
            /*
            bw= new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
            bw.write("Ciao!");
            bw.flush();
            con.close();
            System.out.println("connessione chiusa");*/
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }
    
}
