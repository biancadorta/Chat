package Janela;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import Servidor.Texto;
import javax.swing.SwingConstants;

//import Janela.JanelaCliente;

public class Cliente extends javax.swing.JFrame{

	private JFrame frame;
	private JLabel lblMensagem;
	private JComboBox cbxSalas;
	private static JTextField txtNick;
	static Socket conexao;
	private JTextField txtMensagem ;
	private ObjectOutputStream saida_dados;
	private ObjectInputStream entrada_dados;
	private Texto text;
	private JComboBox cbxDestinatarios;
	private JTextArea txaMensagens;
	private JTextField txtIp;
	private JTextField txtPorta;
	private String[] listaSalas;
	private boolean controle = false;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente window = new Cliente();
					window.frame.setVisible(true);										
				    			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public Cliente(){
		 initialize();		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 675, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ip servidor");
		panel.add(lblNewLabel);
		
		txtIp = new JTextField();
		panel.add(txtIp);
		txtIp.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Porta servidor");
		panel.add(lblNewLabel_1);
		
		txtPorta = new JTextField();
		panel.add(txtPorta);
		txtPorta.setColumns(10);
		
		JLabel lblNick = new JLabel("Nick");
		panel.add(lblNick);
		
		txtNick = new JTextField();
		txtNick.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(txtNick);
		txtNick.setColumns(10);
		
		Label lbSalas = new Label("Sala:");
		panel.add(lbSalas);
		
		cbxSalas = new JComboBox();
		panel.add(cbxSalas);
		cbxSalas.setEnabled(false);
		cbxSalas.setMaximumRowCount(9);
		
		JButton btnConectar = new JButton("Conectar");
		panel.add(btnConectar);
		btnConectar.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent arg0) 
		{							
			if (txtIp.getText().equals("") || txtPorta.getText().equals("") || txtNick.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Alerta", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			txaMensagens.setText("");//limpa as mensagens caso o usuário vá entrar em outro servidor
			
			try 
			{
				conexao = new Socket (txtIp.getText(), Integer.parseInt(txtPorta.getText()));
				txaMensagens.setText("Conectado. Selecione uma sala");
				//cbxSalas.removeAllItems();
									
				entrada_dados = new ObjectInputStream(conexao.getInputStream());
				saida_dados   = new ObjectOutputStream(conexao.getOutputStream());	
				
				/*Texto Lista_salas = (Texto) entrada_dados.readObject();
				
				if (Lista_salas.getTipo().equals("Lista_De_Salas"))
				{
					listaSalas = (String[]) Lista_salas.getComp1();
					
					for(int i = 0; i < listaSalas.length; i++)
					{
						cbxSalas.addItem(listaSalas[i]);
					}
					//btnSelecionarSala.setEnabled(true);					
				}
				
				cbxSalas.setEnabled(true);
				String[] lista_destinatarios = (String[])entrada_dados.readObject(); //esta rebendo os nicks de tal
				
				for(int i = 0; i <= lista_destinatarios.length-1; i++)
				{
					cbxDestinatarios.addItem(lista_destinatarios[i]); 
				}*/
				cbxDestinatarios.setEnabled(true);
				txtMensagem.setEnabled(true);
				btnEnviar.setEnabled(true);
	
				
			}
			catch(Exception erro)
			{
				JOptionPane.showMessageDialog(null, "Erro de conexão. Verifique o Ip/porta e o servidor.--"+erro.getMessage(),
						"Erro de conexão", JOptionPane.INFORMATION_MESSAGE);
				txtMensagem.setEnabled(false);
				cbxSalas.setEnabled(false);
				cbxDestinatarios.setEnabled(false);
				btnEnviar.setEnabled(false);
				erro.printStackTrace();
				return;
			}				

		}
		
	});				
		
	cbxSalas.addActionListener (new ActionListener () {

		public void actionPerformed(ActionEvent e) 
	    {	        
	        try
	        {
	        	if (controle == true)
	        	{
				//mando pro servidor a sala solicitada
				saida_dados.writeObject(new Texto("info_usuario",txtNick.getText(),cbxSalas.getSelectedItem().toString(), null, null));
				//ele me manda os usuários daquela sala para a escolha
				cbxSalas.setEnabled(false);
				txaMensagens.setEnabled(true);
	        	}
	        	else
	        	{
	        		controle = true;
	        	}
				
				//txaMensagens.append("Sala trocada");
	        }
	        catch (Exception erro)
	        {
	        	JOptionPane.showMessageDialog(null, "Erro.--"+erro.getMessage(),
						"Erro", JOptionPane.INFORMATION_MESSAGE);
	        }	        
	    }
	    
	}); 
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblMensagem = new JLabel("Mensagem");
		panel_1.add(lblMensagem);
		
		txtMensagem = new JTextField();
		txtMensagem.setEnabled(false);
		panel_1.add(txtMensagem);
		txtMensagem.setColumns(10);
		
		JLabel lblRemetente = new JLabel("Destinatario");
		panel_1.add(lblRemetente);
		
		cbxDestinatarios = new JComboBox();
		cbxDestinatarios.setEnabled(false);
		cbxDestinatarios.setMaximumRowCount(9);
		panel_1.add(cbxDestinatarios);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				try 
				{	
					/*VALIDACOESSSSS
					 * if(txtMensagem.equals(""))
						txaMensagens.append("Mensagem invalida");
						*/
						
					//saida_dados = new ObjectOutputStream(conexao.getOutputStream());
					//mando pro servidor a mensagem, mas antes escolho qual a sala
					//saida_dados.flush();
					Texto mensagem_enviada = new Texto("MSG",txtNick.getText().toString(),cbxDestinatarios.getSelectedItem().toString(),txtMensagem.getText(),null);
					saida_dados.writeObject(mensagem_enviada);
					
					Texto txt = (Texto)entrada_dados.readObject();
					if(txt.getTipo().equals("msg"))
						System.out.println("Recebido do servidor.");
					else
						System.out.println(":////");
					//saida_dados.flush();
					//saida_dados.close();
					
					txaMensagens.setText("para "+ cbxDestinatarios.getSelectedItem().toString() + " : " + txtMensagem.getText());					
				}
				catch(Exception erro)
				{
					txaMensagens.append("Erro:"+erro.getMessage());	
				}
			}
			
		});
		panel_1.add(btnEnviar);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();  
		panel_2.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollBar scrollBar = new JScrollBar();
		panel_3.add(scrollBar, BorderLayout.WEST);
		
		Panel panel_4 = new Panel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		txaMensagens = new JTextArea();
		txaMensagens.setBackground(SystemColor.window);
		txaMensagens.setEnabled(false);
		panel_2.add(txaMensagens, BorderLayout.CENTER);}
	
	private void receber_mensagens() throws IOException, ClassNotFoundException
	{
		entrada_dados = new ObjectInputStream(conexao.getInputStream());
		Texto recebido = (Texto) entrada_dados.readObject();
		
		while(recebido.getTipo().equals("mensagem"))
		{
			//complemento1 vai ser o remetente
			//complemento2 vai ser a mensagem
			txaMensagens.append((String) recebido.getComplemento1() + 
					(String) recebido.getComplemento2());
			recebido = (Texto) entrada_dados.readObject();
		}
		txaMensagens.append("Comunicação encerrada");
		entrada_dados.close();		
	}
}
		


	
