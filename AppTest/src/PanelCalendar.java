import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PanelCalendar extends JPanel {

	private Image img_cake = new ImageIcon(FrameDashboard.class.getResource("images/cake.png")).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
	
	private JTable table;
	private JTable table_1;
	/**
	 * Create the panel.
	 */
	public PanelCalendar() {

		setBounds(0,0,732,546);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 240, 653, 229);
		add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nume", "Prenume", "Data nasterii", "Angajarii", "Email"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		
		Connection connection = null;
		try {
			connection   = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/workhub", "root", "admin");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT nume, prenume, DATE_FORMAT(datan, '%m-%d-%Y') as 'datan', email from users where Datan > DATE_FORMAT(curdate(), '%m-%d-%Y') order by datan limit 10;");
            ResultSet rs=st.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
		
		setBounds(0,0,732,546);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Primele 10 zile nastere care se apropie ale colegilor tai :)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(40, 84, 414, 53);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pregateste ceva dragut!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(40, 126, 358, 41);
		add(lblNewLabel_1);
		
		JLabel lblCake = new JLabel("");
		lblCake.setBounds(479, 11, 206, 216);
		lblCake.setIcon(new ImageIcon(img_cake));
		add(lblCake);
		
		/*
		try {
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("select DATE_FORMAT(curdate(), '%m-%d-%Y');");
            ResultSet rs=st.executeQuery();
            while(rs.next()) {
            	JLabel lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_2.setText("Astazi suntem in data de: "+String.valueOf(st.getString(1)));
				lblNewLabel_2.setBounds(40, 177, 653, 41);
				add(lblNewLabel_2);
            }
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
		*/
		/*
		JLabel lblThisIsCalendar = new JLabel("THIS IS CALENDAR");
		lblThisIsCalendar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThisIsCalendar.setBounds(203, 223, 233, 85);
		add(lblThisIsCalendar);
		*/
	}
}
