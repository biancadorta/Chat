package Cliente;

import Janela.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.net.Socket;
public class Cliente
{
    public static void main (String[] args)
    {
        try
        {
            Socket         conexao = new Socket ("192.168.15.5", 12345);
            BufferedReader receptor= new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            //ou ObjectOutPutStream e ObjectInputStream
            //anelaCliente j = new JanelaCliente (new PrintWriter (conexao.getOutputStream()));
            //.setVisible (true);

            //loop
                String remetenteComTexto = receptor.readLine();
                // separa remetente e texto (claro que voce deve
                // ter separado remetente e texto com um separador
                // que sera banido de qualquer nick e/ou de
                // qualquer mensagem
               // j.mostre (remetente,mensagem);
            
        }
        catch (Exception erro)
        {
            //JOptionPane.showMessageDialog ();
        }
    }
}