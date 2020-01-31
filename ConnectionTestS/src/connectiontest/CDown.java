package connectiontest;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CDown implements Runnable{
    private int time;
    private Socket s;
    private boolean flag=true;
    
    public CDown(int time){
        this.time=time;
        time= time/1000;
    }

    @Override
    public void run() {
        int i= time;
        while(i>0 && flag==true){
            try {
                Thread.sleep(1000);
                System.out.println("La connessione scade tra: "+ i/1000);
                i= i-1000;
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(CDown.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    public void setFlag(){
        this.flag=false;
    }
    
}