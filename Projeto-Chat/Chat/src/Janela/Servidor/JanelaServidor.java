package Janela.Servidor;

import java.net.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.io.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class JanelaServidor extends JFrame {
	static ServerSocket servidor;
	static ObjectInputStream ois;
	static ObjectOutputStream ops;
	static Socket conection;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaServidor frame = new JanelaServidor();
					frame.setVisible(true);
					servidor = new ServerSocket(12345);
					conection = servidor.accept();
					
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaServidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblMensagen = new JLabel("Mensagen:");
		panel.add(lblMensagen);
		
		JTextField txtHello = new JTextField();
		panel.add(txtHello);
		txtHello.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		panel.add(btnEnviar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblChatServerS = new JLabel("Chat Server s2");
		panel_1.add(lblChatServerS);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JScrollBar scrollBar = new JScrollBar();
		contentPane.add(scrollBar, BorderLayout.EAST);
	}

}
