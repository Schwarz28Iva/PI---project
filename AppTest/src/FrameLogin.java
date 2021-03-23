import java.awt.BorderLayout;
import java.sql.Connection;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class FrameLogin extends JFrame {

	private JPanel contentPane;
	
	private Image img_company = new ImageIcon(FrameDashboard.class.getResource("images/company.png")).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
	
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtCompany;

	private JLabel lblLoginMessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
		
		setBackground(new Color(47, 79, 79));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 610);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.setBackground(new Color(128, 0, 128));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Sigur doresti sa inchizi Work Hub?","Confirmation",JOptionPane.YES_NO_OPTION)==0)
					FrameLogin.this.dispose();
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBackground(new Color(0, 0, 0));
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(969, 0, 31, 28);
		contentPane.add(lblX);
		
		JPanel panel = new JPanel();
		panel.setBounds(338, 324, 300, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Username"))
				{
					txtUsername.setText("");
					
				}
				else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals(""))
					txtUsername.setText("Username");
			}
		});
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 10, 280, 30);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(338, 384, 300, 50);
		contentPane.add(panel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
				txtPassword.setEchoChar('*');
				txtPassword.setText("");
				}
				else {
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setText("Password");
		txtPassword.setEchoChar((char)0);
		txtPassword.setBounds(10, 10, 280, 30);
		panel_1.add(txtPassword);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Connection connection = null;
			try {
				connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/workhub", "root", "admin");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

				String userName;
				String password;
				String company;
				password=txtPassword.getText();
				userName=txtUsername.getText();
				company=txtCompany.getText();
				try {
				PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select company,username, password from login where (company=? and username=?) and password=?");

	                st.setString(1, company);
	                st.setString(2, userName);
	                st.setString(3, password);
	                Autentificare c = new Autentificare(userName, password,company);
	                ResultSet rs = st.executeQuery();
	                if (rs.next()) {
	                	FrameDashboard frameDashboard = new FrameDashboard();
						frameDashboard.setVisible(true);
						FrameLogin.this.dispose();
	                } else {
	                	lblLoginMessage.setText("The company, username and password didn't match!");
	                }
				} catch (Exception sqlException) {
	                sqlException.printStackTrace();
	            }
		}});
		
		
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(386, 469, 214, 50);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 194, 30);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(338, 264, 300, 50);
		contentPane.add(panel_3);
		
		txtCompany = new JTextField();
		txtCompany.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtCompany.getText().equals("Company"))
				{
					txtCompany.setText("");
					
				}
				else {
					txtCompany.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCompany.getText().equals(""))
					txtCompany.setText("Company");
			}
		});
		txtCompany.setText("Company");
		txtCompany.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCompany.setColumns(10);
		txtCompany.setBounds(10, 10, 280, 30);
		panel_3.add(txtCompany);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(338, 63, 300, 163);
		lblNewLabel_1.setIcon(new ImageIcon(img_company));
		contentPane.add(lblNewLabel_1);
		lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginMessage.setHorizontalTextPosition(SwingConstants.CENTER);
		
		lblLoginMessage.setForeground(Color.RED);
		lblLoginMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoginMessage.setBounds(333, 444, 310, 18);
		contentPane.add(lblLoginMessage);
		
		/* MERGE
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(338, 63, 300, 163);
		contentPane.add(lblNewLabel_1);
		*/
		
		/*
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(338, 63, 300, 163);
		lblNewLabel_1.setIcon(new ImageIcon(img_company));
		panel_3.add(lblNewLabel_1);
		*/
	}
}
