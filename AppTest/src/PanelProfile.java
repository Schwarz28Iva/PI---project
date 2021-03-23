import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PanelProfile extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelProfile() {

		
		Image profile = new ImageIcon(PanelOrga.class.getResource("images/pozaprofile.jpg")).getImage().getScaledInstance(150,200,Image.SCALE_SMOOTH);
		
		Connection connection = null;
		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/workhub", "root", "admin");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Autentificare a= new Autentificare();
		setBounds(0,0,732,546);
		setLayout(null);
		setVisible(true);
		System.out.println("Hello!");
		JButton button = new JButton("<html><b><u>T</u>wo</b><br>lines</html>");
		
		JLabel lblPoza = new JLabel("");
		lblPoza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoza.setBounds(83, 58, 150, 200);
		lblPoza.setIcon(new ImageIcon(profile));
		add(lblPoza);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(275, 80, 169, 40);
		add(lblNewLabel_1);
		
		
		try {
				PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select nume from users where username=?");
                st.setString(1, a.user);
                //st.setString(2, a.user);
                //st.setString(3, a.parola);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                	JLabel lblNewLabel_2 = new JLabel("");
                	lblNewLabel_2.setText("NUME: "+String.valueOf(rs.getString(1)));
                	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
            		lblNewLabel_2.setBounds(273, 40, 400, 100);
            		add(lblNewLabel_2);
                }
			} catch (Exception sqlException) {
                sqlException.printStackTrace();
            }
	
		/*
		JLabel lblNewLabel_2 = new JLabel("Nume");
		lblNewLabel_2.setBounds(273, 41, 196, 45);
		add(lblNewLabel_2);
		*/
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select prenume from users where username=?");
            st.setString(1, a.user);
            //st.setString(2, a.user);
            //st.setString(3, a.parola);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setText("PRENUME: " + String.valueOf(rs.getString(1)));
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel_3.setBounds(273, 80, 400, 100);
				add(lblNewLabel_3);
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select departament from users where username=?");
            st.setString(1, a.user);
            //st.setString(2, a.user);
            //st.setString(3, a.parola);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
				JLabel lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setText("DEPARTAMENT: " + String.valueOf(rs.getString(1)));
				lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel_4.setBounds(273, 120, 400, 100);
				add(lblNewLabel_4);
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select statut from users where username=?");
            st.setString(1, a.user);
            //st.setString(2, a.user);
            //st.setString(3, a.parola);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
				JLabel lblNewLabel_5 = new JLabel("");
				lblNewLabel_5.setText("STATUT: " + String.valueOf(rs.getString(1)));
				lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel_5.setBounds(273, 160, 400, 100);
				add(lblNewLabel_5);
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }	
		/*
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select  from users where username=?");
            st.setString(1, a.user);
            //st.setString(2, a.user);
            //st.setString(3, a.parola);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
		JLabel lblNewLabel_6 = new JLabel("Data de nastere");
		lblNewLabel_6.setBounds(264, 149, 116, 54);
		add(lblNewLabel_6);
		*/
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select sex from users where username=?");
            st.setString(1, a.user);
            //st.setString(2, a.user);
            //st.setString(3, a.parola);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
				JLabel lblNewLabel_7 = new JLabel("");
				lblNewLabel_7.setText("SEX: " + String.valueOf(rs.getString(1)));
				lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel_7.setBounds(273, 200, 400, 100);
				add(lblNewLabel_7);
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }	
		/*
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select statut from users where username=?");
            st.setString(1, a.user);
            //st.setString(2, a.user);
            //st.setString(3, a.parola);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
				JLabel lblNewLabel_8 = new JLabel("Data de angajare");
				lblNewLabel_8.setBounds(264, 316, 116, 74);
				add(lblNewLabel_8);
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }	
		*/
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select aptitudini from users where username=?");
            st.setString(1, a.user);
            //st.setString(2, a.user);
            //st.setString(3, a.parola);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
				JLabel lblNewLabel_9 = new JLabel("");
				lblNewLabel_9.setText("APTITUDINI: " + String.valueOf(rs.getString(1)));
				lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel_9.setBounds(273, 240, 400, 100);
				add(lblNewLabel_9);
	}
		 }
    		 catch (Exception sqlException) {
                sqlException.printStackTrace();
            }	
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select datan from users where username=?");
            st.setString(1, a.user);
            //st.setString(2, a.user);
            //st.setString(3, a.parola);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
				JLabel lblNewLabel_5 = new JLabel("");
				lblNewLabel_5.setText("DATA DE NASTERE: " + String.valueOf(rs.getString(1)));
				lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel_5.setBounds(273, 280, 400, 100);
				add(lblNewLabel_5);
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }	
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select dataa from users where username=?");
            st.setString(1, a.user);
            //st.setString(2, a.user);
            //st.setString(3, a.parola);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
				JLabel lblNewLabel_5 = new JLabel("");
				lblNewLabel_5.setText("DATA ANGAJARII: " + String.valueOf(rs.getString(1)));
				lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel_5.setBounds(273, 320, 400, 100);
				add(lblNewLabel_5);
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }	
}}
