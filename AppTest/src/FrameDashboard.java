import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

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
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class FrameDashboard extends JFrame {

	private JPanel contentPanel;

	private Image img_company = new ImageIcon(FrameDashboard.class.getResource("images/company.png")).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
	private Image img_profile = new ImageIcon(FrameDashboard.class.getResource("images/profile.png")).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
	private Image img_tasks = new ImageIcon(FrameDashboard.class.getResource("images/task.png")).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
	private Image img_chart = new ImageIcon(FrameDashboard.class.getResource("images/chart.png")).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
	private Image img_depart = new ImageIcon(FrameDashboard.class.getResource("images/depart.png")).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
	private Image img_osut = new ImageIcon(FrameDashboard.class.getResource("images/OSUT.jpeg")).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
	private Image img_calendar = new ImageIcon(FrameDashboard.class.getResource("images/calendar.png")).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
	private PanelProfile panelProfile;
	private PanelActivity panelActivity;
	private PanelDepartments panelDepartments;
	private PanelOrga panelOrga;
	private PanelCalendar panelCalendar;
	private PanelAbout panelAbout;
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
		
		Connection connection = null;
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/workhub", "root", "admin");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Autentificare a= new Autentificare();
		
		
		setBackground(new Color(47, 79, 79));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 610);
		setUndecorated(true);
		contentPanel = new JPanel();
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPanel.setBackground(new Color(128, 0, 128));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		panelProfile = new PanelProfile();
		panelActivity = new PanelActivity();
		panelDepartments = new PanelDepartments();
		panelOrga = new PanelOrga();
		panelCalendar = new PanelCalendar();
		panelAbout = new PanelAbout();
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		paneMenu.setBackground(new Color(255, 255, 255));
		paneMenu.setBounds(0, 0, 248, 610);
		contentPanel.add(paneMenu);
		paneMenu.setLayout(null);
		
		/*
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select companie from users where username=? and companie=?");
            st.setString(1, a.user);
            st.setString(2, a.companie);
            //st.setString(3, a.parola);
            String string1 = new String("OSUT"); 
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
				JLabel lblCompany = new JLabel("");
				lblCompany.setHorizontalAlignment(SwingConstants.CENTER);
				lblCompany.setBounds(10, 30, 228, 160);
				//if(stringCompare((rs.getString(2)), string1)==0)
				if(string1.equals(rs.getString(2))==true)
					lblCompany.setIcon(new ImageIcon(img_osut));
				paneMenu.add(lblCompany);
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }	
        */
		
		JLabel lblCompany = new JLabel("");
		lblCompany.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompany.setBounds(10, 30, 228, 160);
		//if(stringCompare((rs.getString(2)), string1)==0)
		lblCompany.setIcon(new ImageIcon(img_osut));
		paneMenu.add(lblCompany);
		
		//JPanel paneProfile;
		JPanel paneProfile = new JPanel();
		paneProfile.addMouseListener(new PanelButtonMouseAdapter(paneProfile){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelProfile);
			}
		});
		paneProfile.setBackground(new Color(221, 160, 221));
		paneProfile.setBounds(10, 310, 228, 35);
		paneMenu.add(paneProfile);
		paneProfile.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PROFIL");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(88, 11, 130, 14);
		paneProfile.add(lblNewLabel);
		
		JLabel lblimgProfile = new JLabel("");
		lblimgProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgProfile.setBounds(43, 0, 35, 35);
		lblimgProfile.setIcon(new ImageIcon(img_profile));
		paneProfile.add(lblimgProfile);
		
		/*
		JPanel paneActivity = new JPanel();
		paneActivity.addMouseListener(new PanelButtonMouseAdapter(paneActivity) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelActivity);
			}
		});
		paneActivity.setBackground(new Color(221, 160, 221));
		paneActivity.setBounds(10, 264, 228, 35);
		paneMenu.add(paneActivity);
		paneActivity.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ACTIVITATI");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(88, 11, 130, 14);
		paneActivity.add(lblNewLabel_1);
		
		JLabel lblimgTasks = new JLabel("");
		lblimgTasks.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgTasks.setBounds(43, 0, 35, 35);
		lblimgTasks.setIcon(new ImageIcon(img_tasks));
		paneActivity.add(lblimgTasks);
		*/
		
		
		JPanel paneDepartments = new JPanel();
		paneDepartments.addMouseListener(new PanelButtonMouseAdapter(paneDepartments) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelDepartments);
			}
		});
		paneDepartments.setBackground(new Color(221, 160, 221));
		paneDepartments.setBounds(10, 356, 228, 35);
		paneMenu.add(paneDepartments);
		paneDepartments.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("DEPARTAMENTE");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(88, 11, 130, 14);
		paneDepartments.add(lblNewLabel_2);
		
		JLabel lblimgDepart = new JLabel("");
		lblimgDepart.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgDepart.setBounds(43, 0, 35, 35);
		lblimgDepart.setIcon(new ImageIcon(img_depart));
		paneDepartments.add(lblimgDepart);
		
		JPanel paneOrga = new JPanel();
		paneOrga.addMouseListener(new PanelButtonMouseAdapter(paneOrga) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelOrga);
			}
		});
		paneOrga.setBackground(new Color(221, 160, 221));
		paneOrga.setBounds(10, 399, 228, 35);
		paneMenu.add(paneOrga);
		paneOrga.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("ORGANIGRAMA");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_3.setBounds(88, 11, 130, 14);
		paneOrga.add(lblNewLabel_3);
		
		JLabel lblimgChart = new JLabel("");
		lblimgChart.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgChart.setBounds(43, 0, 35, 35);
		lblimgChart.setIcon(new ImageIcon(img_chart));
		paneOrga.add(lblimgChart);
		
		JPanel paneCalendar = new JPanel();
		paneCalendar.addMouseListener(new PanelButtonMouseAdapter(paneCalendar) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCalendar);
			}
		});
		paneCalendar.setBackground(new Color(221, 160, 221));
		paneCalendar.setBounds(10, 442, 228, 35);
		paneMenu.add(paneCalendar);
		paneCalendar.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("CALENDAR");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_4.setBounds(88, 11, 130, 14);
		paneCalendar.add(lblNewLabel_4);
		
		JLabel lblimgCalendar = new JLabel("");
		lblimgCalendar.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgCalendar.setBounds(43, 0, 35, 35);
		lblimgCalendar.setIcon(new ImageIcon(img_calendar));
		paneCalendar.add(lblimgCalendar);
		
		/*
		JPanel paneAbout = new JPanel();
		paneAbout.addMouseListener(new PanelButtonMouseAdapter(paneAbout) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelAbout);
			}
		});
		paneAbout.setBackground(new Color(221, 160, 221));
		paneAbout.setBounds(10, 534, 228, 35);
		paneMenu.add(paneAbout);
		paneAbout.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("DESPRE");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_6.setBounds(88, 11, 130, 14);
		paneAbout.add(lblNewLabel_6);
		*/
		
		JPanel paneLogOut = new JPanel();
		paneLogOut.addMouseListener(new PanelButtonMouseAdapter(paneLogOut)
			{@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?")==0) {
					FrameLogin frameLogin = new FrameLogin();
					frameLogin.setVisible(true);
					FrameDashboard.this.dispose();
				}
			}
		});
		paneLogOut.setBackground(new Color(221, 160, 221));
		paneLogOut.setBounds(10, 488, 228, 35);
		paneMenu.add(paneLogOut);
		paneLogOut.setLayout(null);
		
		JLabel lblLogOut = new JLabel("LOG OUT");
		lblLogOut.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLogOut.setBounds(88, 11, 130, 14);
		paneLogOut.add(lblLogOut);
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select companie from users where username=?");
            st.setString(1, a.user);
            //st.setString(2, a.user);
            //st.setString(3, a.parola);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
				JLabel lblNumComp = new JLabel("Nume Companie");
				lblNumComp.setText(String.valueOf(rs.getString(1)));
				lblNumComp.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNumComp.setHorizontalAlignment(SwingConstants.CENTER);
				lblNumComp.setBounds(10, 200, 228, 55);
				paneMenu.add(lblNumComp);
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }	
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Sigur doresti sa inchizi Work Hub?","Confirmation",JOptionPane.YES_NO_OPTION)==0)
					FrameDashboard.this.dispose();
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBackground(new Color(0, 0, 0));
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(969, 0, 31, 28);
		contentPanel.add(lblX);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBounds(258, 39, 732, 546);
		contentPanel.add(paneMainContent);
		paneMainContent.setLayout(null);
		
		paneMainContent.add(panelProfile);
		paneMainContent.add(panelActivity);
		paneMainContent.add(panelDepartments);
		paneMainContent.add(panelOrga);
		paneMainContent.add(panelCalendar);
		paneMainContent.add(panelAbout);
		
		menuClicked(panelProfile);
	}
	
	public void menuClicked(JPanel panel) {
		panelProfile.setVisible(false);
		panelActivity.setVisible(false);
		panelDepartments.setVisible(false);
		panelOrga.setVisible(false);
		panelCalendar.setVisible(false);
		panelAbout.setVisible(false);
		
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panell) {
			this.panel=panell;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(230,230,250));
			//egala cu mouseReleased
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(221,160,221));
			//culoarea la fel ca originalul
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(128,0,128));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(230,230,250));
		}
	}
}
