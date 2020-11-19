package gui;

import java.awt.BorderLayout; 
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FrameDashboard extends JFrame {
	private Image img_logo = new ImageIcon(FrameDashboard.class.getResource("2.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image x = new ImageIcon(FrameDashboard.class.getResource("x.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private intro introduction ;
	private JPanel contentPane;
	public command_list Commande_list ; 
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDashboard frame = new FrameDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameDashboard() {
		

		setBackground(new Color(47, 79, 79));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 430);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 2));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		introduction = new intro () ;
		
		
		
		
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(new Color(47, 79, 79));
		paneMenu.setBounds(2, 2, 224, 428);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(10, 11, 204, 135);
		lblIconLogo.setIcon(new ImageIcon(img_logo)); 
		paneMenu.add(lblIconLogo);
		
		JPanel paneIntro = new JPanel();
		paneIntro.addMouseListener(new PanelButtonMouseAdapter(paneIntro)
				{
			
			@Override
			public void mouseClicked (MouseEvent e)
			{
				 dispose();
                 intro ah = new intro();
                 ah.setTitle("Welcome");
                 ah.setVisible(true);
			}
				}	
				);
		paneIntro.setBackground(new Color(47, 79, 79));
		paneIntro.setBounds(0, 140, 224, 40);
		paneMenu.add(paneIntro);
		
		paneIntro.setLayout(null);
		
		JLabel lblIntro = new JLabel("INTRO");
		lblIntro.setForeground(new Color(255, 255, 255));
		lblIntro.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntro.setFont(new Font("Dialog", Font.BOLD, 14));
		lblIntro.setBounds(85, 0, 53, 40);
		paneIntro.add(lblIntro);
		
		JPanel paneListC = new JPanel();
		paneListC.addMouseListener(new PanelButtonMouseAdapter(paneListC)
{
			
			@Override
			public void mouseClicked (MouseEvent e)
			{
				 dispose();
				 try {
					new command_list().setVisible(true) ;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
				});
		paneListC.setBackground(new Color(47, 79, 79));
		paneListC.setBounds(0, 180, 224, 40);
		paneMenu.add(paneListC);
		
		paneListC.setLayout(null);
		
		JLabel lblListCommande = new JLabel("LIST COMMANDE");
		lblListCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblListCommande.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListCommande.setForeground(new Color(255, 255, 255));
		lblListCommande.setBounds(57, 11, 122, 14);
		paneListC.add(lblListCommande);
		
		JPanel paneAjoutC = new JPanel();
		paneAjoutC.addMouseListener(new PanelButtonMouseAdapter(paneAjoutC)
{
			
			@Override
			public void mouseClicked (MouseEvent e)
			{
				 dispose();
				 try {
					new ajout_commande().setVisible(true) ;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
				});
		paneAjoutC.setBackground(new Color(47, 79, 79));
		paneAjoutC.setBounds(0, 220, 224, 40);
		paneMenu.add(paneAjoutC);
		paneAjoutC.setLayout(null);
		
		JLabel lblAjoutCommande = new JLabel("AJOUT COMMANDE");
		lblAjoutCommande.setForeground(new Color(255, 255, 255));
		lblAjoutCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjoutCommande.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAjoutCommande.setBounds(41, 11, 156, 14);
		paneAjoutC.add(lblAjoutCommande);
		
		JPanel paneInsertion = new JPanel();
		paneInsertion.addMouseListener(new PanelButtonMouseAdapter(paneInsertion)
{
			
			@Override
			public void mouseClicked (MouseEvent e)
			{
				 dispose();
				 new insertion_livre().setVisible(true) ;
				 
			}
				});
		paneInsertion.setBackground(new Color(47, 79, 79));
		paneInsertion.setBounds(0, 260, 224, 40);
		paneMenu.add(paneInsertion);
		paneInsertion.setLayout(null);
		
		JLabel lblInsertionLivre = new JLabel("INSERTION LIVRE");
		lblInsertionLivre.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertionLivre.setForeground(new Color(255, 255, 255));
		lblInsertionLivre.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInsertionLivre.setBounds(52, 11, 126, 14);
		paneInsertion.add(lblInsertionLivre);
		
		JPanel paneWelcome = new JPanel();
		paneWelcome.addMouseListener(new PanelButtonMouseAdapter(paneWelcome)
{
			
			@Override
			public void mouseClicked (MouseEvent e)
			{
				 dispose();
				 try {
					new welcome().setVisible(true) ;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
				});
		paneWelcome.setBackground(new Color(47, 79, 79));
		paneWelcome.setBounds(0, 300, 224, 40);
		paneMenu.add(paneWelcome);
		paneWelcome.setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setBounds(36, 11, 139, 14);
		paneWelcome.add(lblWelcome);
		
		JPanel paneLogout = new JPanel();
		paneLogout.addMouseListener(new PanelButtonMouseAdapter(paneLogout));
		paneLogout.setBackground(new Color(47, 79, 79));
		paneLogout.setBounds(0, 340, 224, 40);
		paneMenu.add(paneLogout);
		paneLogout.setLayout(null);
		
		JLabel lblLogout = new JLabel("LOGOUT");
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLogout.setForeground(new Color(255, 255, 255));
		lblLogout.setBounds(67, 11, 84, 14);
		paneLogout.add(lblLogout);
		
		JLabel lblNewLabel = new JLabel("exit");
		lblNewLabel.setBounds(562, 2, 53, 29);
		lblNewLabel.setIcon(new ImageIcon(x));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "are you sure you want to close","config",JOptionPane.YES_NO_CANCEL_OPTION)==0)
				{FrameDashboard.this.dispose();}
			}
		});
		
		contentPane.add(lblNewLabel);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBounds(236, 21, 379, 398);
		contentPane.add(paneMainContent);
		
	
		
		
	}
	
	
	
	
	
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		
		JPanel panel ; 
		
		public PanelButtonMouseAdapter (JPanel panel) {
			this.panel = panel ; 
		}
		
		@Override
		public void mouseEntered (MouseEvent e) {
			panel.setBackground(new Color (112,128,144));
			
		}
		@Override
		public void mouseExited (MouseEvent e) {
			panel.setBackground(new Color (47,79,79));
		}
		@Override
		public void mousePressed (MouseEvent e) {
			panel.setBackground(new Color (112,128,144));
		}
		@Override
		public void mouseReleased (MouseEvent e) {
			panel.setBackground(new Color (112,128,144));
		}
	}
	
	
	
	
	
}
