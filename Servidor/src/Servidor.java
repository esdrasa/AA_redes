import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.*;
import static javax.swing.JOptionPane.showMessageDialog;
// video legal https://www.youtube.com/watch?v=lqSEpj517Qc
public class Servidor {
    
    public static void main(String[] args){
        
        String mensagemRecebida;
        
        ChatServidor chatS;
        
        
        try{
            ServerSocket servidor = new ServerSocket(5001);
            chatS = new ChatServidor();
            chatS.setVisible(true);
                    
            Socket socket;  
            
            while(true){
                socket = servidor.accept();
                showMessageDialog(null,"Conectou");
                
                InputStreamReader reader = new InputStreamReader(socket.getInputStream());
                BufferedReader buffer = new BufferedReader(reader);
                
                while((mensagemRecebida = buffer.readLine()) != null){
                    chatS.getMensagemServer().setText(chatS.getMensagemServer().getText() +"\n" + "Esdras diz: " + mensagemRecebida);
                }
                
            }
            
        } 
        catch(IOException e){
            showMessageDialog(null, "Nao e possivel conectar");
        }
          
        
    }
    
}
