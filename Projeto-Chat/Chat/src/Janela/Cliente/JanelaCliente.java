package Janela.Cliente;

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

import Servidor.Usuario;
import Cliente.Texto;

public class JanelaCliente extends javax.swing.JFrame{

	private JFrame frame;
	private JLabel lblMensagem;
	private JComboBox cbSalas;
	private static JTextField textField;
	static Socket conexao;
	private JTextField txtMensagem ;
	private Usuario usu;
	private ObjectOutputStream ops;
	private ObjectInputStream ois;
	private Texto text;
	private JComboBox cbxRemetentes;
	private JTextArea txtArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCliente window = new JanelaCliente();
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
	public JanelaCliente() {
		 initialize();	
		 try {
			//conexao = new Socket ("192.168.15.5", 12345);
			usu = null;
			usu = new Usuario(cbSalas.getSelectedItem().toString(),conexao);
			usu.setNick("Bianquinhaaa");
			txtMensagem.setText(usu.nickUsuario());						
		}
		catch(Exception erro)
		{
			textField.setText("Erro:"+erro.getMessage());
		}
		 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 601, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNick = new JLabel("Qual sera seu nick s2?");
		panel.add(lblNick);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblMensagem = new JLabel("Mensagem");
		panel_1.add(lblMensagem);
		
		txtMensagem = new JTextField();
		panel_1.add(txtMensagem);
		txtMensagem.setColumns(10);
		
		Label lbSalas = new Label("Salas:");
		panel_1.add(lbSalas);
		
		cbSalas = new JComboBox();		
		
		cbSalas.setModel(new DefaultComboBoxModel(new String[] {"Dinalva", "Claudio", "Lapa", "Lina ", "Lasi", ""}));
		cbSalas.setMaximumRowCount(9);
		panel_1.add(cbSalas);
		
		JLabel lblRemetente = new JLabel("Remetente:");
		panel_1.add(lblRemetente);
		
		cbxRemetentes = new JComboBox();
		cbxRemetentes.setModel(new DefaultComboBoxModel(new String[] {"Bianca", "Elisa", "Emannuel", "Rojas", "Miguel", "Prato", "Tales"}));
		cbxRemetentes.setMaximumRowCount(9);
		panel_1.add(cbxRemetentes);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					text = new Texto("Biancaaa", cbxRemetentes.getSelectedItem().toString(), txtMensagem.getText().trim().toString());
					ops = null;
					ops = new ObjectOutputStream(new FileOutputStream("D:\\testando.txt"));
					ops.writeObject(text);					
					lblMensagem.setText("Foiiii");
				
				}
				catch(Exception erro)
				{
	
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
		
		txtArea = new JTextArea();
		txtArea.setBackground(SystemColor.window);
		txtArea.setEnabled(false);
		panel_2.add(txtArea, BorderLayout.CENTER);
		
		cbSalas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblMensagem.setText(cbSalas.getSelectedItem().toString());
				if(cbSalas.getSelectedItem().equals("Dinalva"))
				{
					cbxRemetentes.addItem("Teste");
				}
			}
		});
		
	}
}
