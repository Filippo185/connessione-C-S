package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException{
        String x;
        int cifra;
        int soluzione;
        try {
            Socket con;
            String serv ="localhost";
            int porta = 3500;
            con=new Socket(serv,porta);
            System.out.println("Connessione aperta");
            PrintWriter pw = new PrintWriter(con.getOutputStream(),true);
            BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
            BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
            
             soluzione=Integer.parseInt(br.readLine());
             System.out.println("Inserisci una cifra: ");
             while(true){
                
                x=kb.readLine();
                if(x!=""){
                    cifra=Integer.parseInt(x);

                    if(cifra>0 && cifra <10){
                        if(cifra!=soluzione){
                            System.out.println("Inserisci un altra cifra: ");
                    }else{
                        System.out.println("Bravo! Hai vinto"); 
                        break;
                    }
                    }else{
                        System.out.println("Inserisci una cifra valida! ");
                    }
                 }
                 else {
                     System.out.println("Inserisci una cifra! ");
                 }
             }
             
           
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }
    
}
