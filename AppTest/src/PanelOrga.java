import java.sql.DatabaseMetaData;
import java.sql.Statement;



import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;


import java.awt.Color;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PanelOrga extends JPanel {
	private JLabel lblPhOrga1;
	private JLabel lblN1;
	private JLabel lblD1;
	private JLabel lblE1;
	private JPanel panelOrga2;
	private JLabel lblPhOrga2;
	private JLabel lblN2;
	private JLabel lblD2;
	private JLabel lblE2;
	private JPanel panelOrga3;
	private JLabel lblPhOrga3;
	private JLabel lblN3;
	private JLabel lblD3;
	private JLabel lblE3;
	private JPanel panelOrga4;
	private JLabel lblPhOrga4;
	private JLabel lblN4;
	private JLabel lblD4;
	private JLabel lblE4;
	private JPanel panelOrga5;
	private JLabel lblPhOrga5;
	private JLabel lblN5;
	private JLabel lblD5;
	private JLabel lblE5;
	private JPanel panelOrga6;
	private JLabel lblPhOrga6;
	private JLabel lblN6;
	private JLabel lblD6;
	private JLabel lblE6;
	private JPanel panelOrga7;
	private JLabel lblPhOrga7;
	private JLabel lblN7;
	private JLabel lblD7;
	private JLabel lblE7;
	private JPanel panelOrga8;
	private JLabel lblPhOrga8;
	private JLabel lblN8;
	private JLabel lblD8;
	private JLabel lblE8;
	private JPanel panelOrga9;
	private JLabel lblPhOrga9;
	private JLabel lblN9;
	private JLabel lblD9;
	private JLabel lblE9;

	/**
	 * Create the panel.
	 */
	public PanelOrga() {

		Image img_company = new ImageIcon(PanelOrga.class.getResource("images/company.png")).getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
		Image o1 = new ImageIcon(PanelOrga.class.getResource("images/o1.jpg")).getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
		Image o2 = new ImageIcon(PanelOrga.class.getResource("images/o2.jpg")).getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
		Image o3 = new ImageIcon(PanelOrga.class.getResource("images/o3.jpeg")).getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
		Image o4 = new ImageIcon(PanelOrga.class.getResource("images/o4.jpg")).getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
		Image o5 = new ImageIcon(PanelOrga.class.getResource("images/o5.jpg")).getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
		Image o6 = new ImageIcon(PanelOrga.class.getResource("images/o6.jpg")).getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
		Image o7 = new ImageIcon(PanelOrga.class.getResource("images/o7.jpg")).getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
		Image o8 = new ImageIcon(PanelOrga.class.getResource("images/o8.jpeg")).getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
		Image o9 = new ImageIcon(PanelOrga.class.getResource("images/o9.jpg")).getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
		setBounds(0,0,732,546);
		setLayout(null);
		
		JPanel panelOrga1 = new JPanel();
		panelOrga1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrga1.setBounds(278, 11, 187, 127);
		add(panelOrga1);
		panelOrga1.setLayout(null);
		
		
		Connection connection = null;
	
		try {
			connection  = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/workhub", "root", "admin");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		    
		lblPhOrga1 = new JLabel("");
		lblPhOrga1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhOrga1.setBounds(57, 0, 70, 70);
		lblPhOrga1.setIcon(new ImageIcon(o1));
		panelOrga1.add(lblPhOrga1);
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select name,job,email from organigrama where id=1");
            //st.setString(1, userName);
			int k=0;
            ResultSet rs=st.executeQuery();
            while((rs.next()) & (k==0)) {
            	System.out.print(rs.getString(1));
   	         	System.out.print(rs.getString(2));
   	         	System.out.print(rs.getString(3));
   	         	System.out.println();
   	         	lblN1 = new JLabel("");
   	         	lblN1.setText(String.valueOf(rs.getString(1)));
   	         	lblN1.setFont(new Font("Tahoma", Font.BOLD, 11));
   	         	lblN1.setHorizontalAlignment(SwingConstants.CENTER);
   	         	lblN1.setBounds(10, 75, 165, 20);
   	         	panelOrga1.add(lblN1);
   	         	
   	         	lblD1 = new JLabel("");
   	         	lblD1.setText(String.valueOf(rs.getString(2)));
   	         	lblD1.setHorizontalTextPosition(SwingConstants.CENTER);
   	         	lblD1.setHorizontalAlignment(SwingConstants.CENTER);
   	         	lblD1.setFont(new Font("Tahoma", Font.PLAIN, 11));
   	         	lblD1.setBounds(10, 90, 165, 20);
   	         	panelOrga1.add(lblD1);
   	         	
   	         	lblE1 = new JLabel("");
	         	lblE1.setText(String.valueOf(rs.getString(3)));
	         	lblE1.setFont(new Font("Tahoma", Font.ITALIC, 10));
	    		lblE1.setHorizontalAlignment(SwingConstants.CENTER);
	    		lblE1.setBounds(10, 105, 165, 20);
	    		panelOrga1.add(lblE1);
   	         	k=1;
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }

		panelOrga2 = new JPanel();
		panelOrga2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrga2.setLayout(null);
		panelOrga2.setBounds(154, 145, 187, 127);
		add(panelOrga2);
		
		lblPhOrga2 = new JLabel("");
		lblPhOrga2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhOrga2.setBounds(57, 0, 70, 70);
		lblPhOrga2.setIcon(new ImageIcon(o2));
		panelOrga2.add(lblPhOrga2);
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select name,job,email from organigrama where id=2");
            //st.setString(1, userName);
			int k=0;
            ResultSet rs=st.executeQuery();
            while((rs.next()) & (k==0)) {
            	System.out.print(rs.getString(1));
   	         	System.out.print(rs.getString(2));
   	         	System.out.print(rs.getString(3));
   	         	System.out.println();
				lblN2 = new JLabel("");
				lblN2.setText(String.valueOf(rs.getString(1)));
				lblN2.setHorizontalAlignment(SwingConstants.CENTER);
				lblN2.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblN2.setBounds(10, 75, 165, 20);
				panelOrga2.add(lblN2);
		
				lblD2 = new JLabel("");
				lblD2.setText(String.valueOf(rs.getString(2)));
				lblD2.setHorizontalTextPosition(SwingConstants.CENTER);
				lblD2.setHorizontalAlignment(SwingConstants.CENTER);
				lblD2.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lblD2.setBounds(10, 90, 165, 20);
				panelOrga2.add(lblD2);
				
				lblE2 = new JLabel("");
				lblE2.setText(String.valueOf(rs.getString(3)));
				lblE2.setHorizontalAlignment(SwingConstants.CENTER);
				lblE2.setFont(new Font("Tahoma", Font.ITALIC, 10));
				lblE2.setBounds(10, 105, 165, 20);
				panelOrga2.add(lblE2);
				k=1;
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
		
		panelOrga3 = new JPanel();
		panelOrga3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrga3.setLayout(null);
		panelOrga3.setBounds(402, 145, 187, 127);
		add(panelOrga3);
		
		lblPhOrga3 = new JLabel("");
		lblPhOrga3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhOrga3.setBounds(57, 0, 70, 70);
		lblPhOrga3.setIcon(new ImageIcon(o3));
		panelOrga3.add(lblPhOrga3);
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select name,job,email from organigrama where id=3");
            //st.setString(1, userName);
			int k=0;
            ResultSet rs=st.executeQuery();
            while((rs.next()) & (k==0)) {
            	System.out.print(rs.getString(1));
   	         	System.out.print(rs.getString(2));
   	         	System.out.print(rs.getString(3));
   	         	System.out.println();
				lblN3 = new JLabel("");
				lblN3.setText(String.valueOf(rs.getString(1)));
				lblN3.setHorizontalAlignment(SwingConstants.CENTER);
				lblN3.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblN3.setBounds(10, 75, 165, 20);
				panelOrga3.add(lblN3);
				
				lblD3 = new JLabel("");
				lblD3.setText(String.valueOf(rs.getString(2)));
				lblD3.setHorizontalTextPosition(SwingConstants.CENTER);
				lblD3.setHorizontalAlignment(SwingConstants.CENTER);
				lblD3.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lblD3.setBounds(10, 90, 165, 20);
				panelOrga3.add(lblD3);
				
				lblE3 = new JLabel("");
				lblE3.setText(String.valueOf(rs.getString(3)));
				lblE3.setHorizontalAlignment(SwingConstants.CENTER);
				lblE3.setFont(new Font("Tahoma", Font.ITALIC, 10));
				lblE3.setBounds(10, 105, 165, 20);
				panelOrga3.add(lblE3);
				k=1;
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
		
		panelOrga4 = new JPanel();
		panelOrga4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrga4.setLayout(null);
		panelOrga4.setBounds(54, 278, 187, 127);
		add(panelOrga4);
		
		lblPhOrga4 = new JLabel("");
		lblPhOrga4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhOrga4.setBounds(57, 0, 70, 70);
		lblPhOrga4.setIcon(new ImageIcon(o4));
		panelOrga4.add(lblPhOrga4);
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select name,job,email from organigrama where id=4");
            //st.setString(1, userName);
			int k=0;
            ResultSet rs=st.executeQuery();
            while((rs.next()) & (k==0)) {
            	System.out.print(rs.getString(1));
   	         	System.out.print(rs.getString(2));
   	         	System.out.print(rs.getString(3));
		   	    System.out.println();
				lblN4 = new JLabel("");
				lblN4.setText(String.valueOf(rs.getString(1)));
				lblN4.setHorizontalAlignment(SwingConstants.CENTER);
				lblN4.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblN4.setBounds(10, 75, 165, 20);
				panelOrga4.add(lblN4);
				
				lblD4 = new JLabel("");
				lblD4.setText(String.valueOf(rs.getString(2)));
				lblD4.setHorizontalTextPosition(SwingConstants.CENTER);
				lblD4.setHorizontalAlignment(SwingConstants.CENTER);
				lblD4.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lblD4.setBounds(10, 90, 165, 20);
				panelOrga4.add(lblD4);
				
				lblE4 = new JLabel("");
				lblE4.setText(String.valueOf(rs.getString(3)));
				lblE4.setHorizontalAlignment(SwingConstants.CENTER);
				lblE4.setFont(new Font("Tahoma", Font.ITALIC, 10));
				lblE4.setBounds(10, 105, 165, 20);
				panelOrga4.add(lblE4);
				k=1;
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
		
		panelOrga5 = new JPanel();
		panelOrga5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrga5.setLayout(null);
		panelOrga5.setBounds(278, 278, 187, 127);
		add(panelOrga5);
		
		lblPhOrga5 = new JLabel("");
		lblPhOrga5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhOrga5.setBounds(57, 0, 70, 70);
		lblPhOrga5.setIcon(new ImageIcon(o5));
		panelOrga5.add(lblPhOrga5);
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select name,job,email from organigrama where id=5");
            //st.setString(1, userName);
			int k=0;
            ResultSet rs=st.executeQuery();
            while((rs.next()) & (k==0)) {
            	System.out.print(rs.getString(1));
   	         	System.out.print(rs.getString(2));
   	         	System.out.print(rs.getString(3));
		   	    System.out.println();
				lblN5 = new JLabel("");
				lblN5.setText(String.valueOf(rs.getString(1)));
				lblN5.setHorizontalAlignment(SwingConstants.CENTER);
				lblN5.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblN5.setBounds(10, 75, 165, 20);
				panelOrga5.add(lblN5);
				
				lblD5 = new JLabel("");
				lblD5.setText(String.valueOf(rs.getString(2)));
				lblD5.setHorizontalTextPosition(SwingConstants.CENTER);
				lblD5.setHorizontalAlignment(SwingConstants.CENTER);
				lblD5.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lblD5.setBounds(10, 90, 165, 20);
				panelOrga5.add(lblD5);
				
				lblE5 = new JLabel("");
				lblE5.setText(String.valueOf(rs.getString(3)));
				lblE5.setHorizontalAlignment(SwingConstants.CENTER);
				lblE5.setFont(new Font("Tahoma", Font.ITALIC, 10));
				lblE5.setBounds(10, 105, 165, 20);
				panelOrga5.add(lblE5);
				k=1;
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
		
		panelOrga6 = new JPanel();
		panelOrga6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrga6.setLayout(null);
		panelOrga6.setBounds(506, 278, 187, 127);
		add(panelOrga6);
		
		lblPhOrga6 = new JLabel("");
		lblPhOrga6.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhOrga6.setBounds(57, 0, 70, 70);
		lblPhOrga6.setIcon(new ImageIcon(o6));
		panelOrga6.add(lblPhOrga6);
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select name,job,email from organigrama where id=6");
            //st.setString(1, userName);
			int k=0;
            ResultSet rs=st.executeQuery();
            while((rs.next()) & (k==0)) {
            	System.out.print(rs.getString(1));
   	         	System.out.print(rs.getString(2));
   	         	System.out.print(rs.getString(3));
		   	    System.out.println();
				lblN6 = new JLabel("");
				lblN6.setText(String.valueOf(rs.getString(1)));
				lblN6.setHorizontalAlignment(SwingConstants.CENTER);
				lblN6.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblN6.setBounds(10, 75, 165, 20);
				panelOrga6.add(lblN6);
				
				lblD6 = new JLabel("");
				lblD6.setText(String.valueOf(rs.getString(2)));
				lblD6.setHorizontalTextPosition(SwingConstants.CENTER);
				lblD6.setHorizontalAlignment(SwingConstants.CENTER);
				lblD6.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lblD6.setBounds(10, 90, 165, 20);
				panelOrga6.add(lblD6);
				
				lblE6 = new JLabel("");
				lblE6.setText(String.valueOf(rs.getString(3)));
				lblE6.setHorizontalAlignment(SwingConstants.CENTER);
				lblE6.setFont(new Font("Tahoma", Font.ITALIC, 10));
				lblE6.setBounds(10, 105, 165, 20);
				panelOrga6.add(lblE6);
				k=1;
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
		
		panelOrga7 = new JPanel();
		panelOrga7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrga7.setLayout(null);
		panelOrga7.setBounds(54, 410, 187, 127);
		add(panelOrga7);
		
		lblPhOrga7 = new JLabel("");
		lblPhOrga7.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhOrga7.setBounds(57, 0, 70, 70);
		lblPhOrga7.setIcon(new ImageIcon(o7));
		panelOrga7.add(lblPhOrga7);
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select name,job,email from organigrama where id=7");
            //st.setString(1, userName);
			int k=0;
            ResultSet rs=st.executeQuery();
            while((rs.next()) & (k==0)) {
            	System.out.print(rs.getString(1));
   	         	System.out.print(rs.getString(2));
   	         	System.out.print(rs.getString(3));
		   	    System.out.println();
				lblN7 = new JLabel("");
				lblN7.setText(String.valueOf(rs.getString(1)));
				lblN7.setHorizontalAlignment(SwingConstants.CENTER);
				lblN7.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblN7.setBounds(10, 75, 165, 20);
				panelOrga7.add(lblN7);
				
				lblD7 = new JLabel("");
				lblD7.setText(String.valueOf(rs.getString(2)));
				lblD7.setHorizontalTextPosition(SwingConstants.CENTER);
				lblD7.setHorizontalAlignment(SwingConstants.CENTER);
				lblD7.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lblD7.setBounds(10, 90, 165, 20);
				panelOrga7.add(lblD7);
				
				lblE7 = new JLabel("");
				lblE7.setText(String.valueOf(rs.getString(3)));
				lblE7.setHorizontalAlignment(SwingConstants.CENTER);
				lblE7.setFont(new Font("Tahoma", Font.ITALIC, 10));
				lblE7.setBounds(10, 105, 165, 20);
				panelOrga7.add(lblE7);
				k=1;
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
		
		panelOrga8 = new JPanel();
		panelOrga8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrga8.setLayout(null);
		panelOrga8.setBounds(278, 410, 187, 127);
		add(panelOrga8);
		
		lblPhOrga8 = new JLabel("");
		lblPhOrga8.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhOrga8.setBounds(57, 0, 70, 70);
		lblPhOrga8.setIcon(new ImageIcon(o8));
		panelOrga8.add(lblPhOrga8);
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select name,job,email from organigrama where id=8");
            //st.setString(1, userName);
			int k=0;
            ResultSet rs=st.executeQuery();
            while((rs.next()) & (k==0)) {
            	System.out.print(rs.getString(1));
   	         	System.out.print(rs.getString(2));
   	         	System.out.print(rs.getString(3));
		   	    System.out.println();
				lblN8 = new JLabel("");
				lblN8.setText(String.valueOf(rs.getString(1)));
				lblN8.setHorizontalAlignment(SwingConstants.CENTER);
				lblN8.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblN8.setBounds(10, 75, 165, 20);
				panelOrga8.add(lblN8);
				
				lblD8 = new JLabel("");
				lblD8.setText(String.valueOf(rs.getString(2)));
				lblD8.setHorizontalTextPosition(SwingConstants.CENTER);
				lblD8.setHorizontalAlignment(SwingConstants.CENTER);
				lblD8.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lblD8.setBounds(10, 90, 165, 20);
				panelOrga8.add(lblD8);
				
				lblE8 = new JLabel("");
				lblE8.setText(String.valueOf(rs.getString(3)));
				lblE8.setHorizontalAlignment(SwingConstants.CENTER);
				lblE8.setFont(new Font("Tahoma", Font.ITALIC, 10));
				lblE8.setBounds(10, 105, 165, 20);
				panelOrga8.add(lblE8);
				k=1;
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
		
		panelOrga9 = new JPanel();
		panelOrga9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrga9.setLayout(null);
		panelOrga9.setBounds(506, 410, 187, 127);
		add(panelOrga9);
		
		lblPhOrga9 = new JLabel("");
		lblPhOrga9.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhOrga9.setBounds(57, 0, 70, 70);
		lblPhOrga9.setIcon(new ImageIcon(o9));
		panelOrga9.add(lblPhOrga9);
		
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select name,job,email from organigrama where id=9");
            //st.setString(1, userName);
			int k=0;
            ResultSet rs=st.executeQuery();
            while((rs.next()) & (k==0)) {
            	System.out.print(rs.getString(1));
   	         	System.out.print(rs.getString(2));
   	         	System.out.print(rs.getString(3));
		   	    System.out.println();
				lblN9 = new JLabel("");
				lblN9.setText(String.valueOf(rs.getString(1)));
				lblN9.setHorizontalAlignment(SwingConstants.CENTER);
				lblN9.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblN9.setBounds(10, 75, 165, 20);
				panelOrga9.add(lblN9);
				
				lblD9 = new JLabel("");
				lblD9.setText(String.valueOf(rs.getString(2)));
				lblD9.setHorizontalTextPosition(SwingConstants.CENTER);
				lblD9.setHorizontalAlignment(SwingConstants.CENTER);
				lblD9.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lblD9.setBounds(10, 90, 165, 20);
				panelOrga9.add(lblD9);
				
				lblE9 = new JLabel("");
				lblE9.setText(String.valueOf(rs.getString(3)));
				lblE9.setHorizontalAlignment(SwingConstants.CENTER);
				lblE9.setFont(new Font("Tahoma", Font.ITALIC, 10));
				lblE9.setBounds(10, 105, 165, 20);
				panelOrga9.add(lblE9);
				k=1;
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
	}
}
