import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

//import FrameDashboard.PanelButtonMouseAdapter;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDepartments extends JPanel {
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public PanelDepartments() {

		
		setBounds(0,0,732,546);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 167, 653, 302);
		add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nume", "Prenume", "Departament", "Statut", "Email"
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
			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select nume,prenume,departament,statut,email from users");
            ResultSet rs=st.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
	
	
            JPanel paneTot = new JPanel();
            paneTot.addMouseListener(new PanelButtonMouseAdapter(paneTot) {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		try {
            			Connection connection = null;
            			try {
            				connection   = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/workhub", "root", "admin");
            			} catch (SQLException e1) {
            				// TODO Auto-generated catch block
            				e1.printStackTrace();
            			}
            			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select nume,prenume,departament,statut,email from users");
                        ResultSet rs=st.executeQuery();
                        table_1.setModel(DbUtils.resultSetToTableModel(rs));
            	} catch (Exception sqlException) {
                    sqlException.printStackTrace();
                }}
            });
            paneTot.setLayout(null);
            paneTot.setBackground(new Color(221, 160, 221));
            paneTot.setBounds(267, 11, 200, 35);
            add(paneTot);
            
            JLabel lblNewLabel = new JLabel("TOATE DEPARTAMENTELE");
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
            lblNewLabel.setBounds(10, 11, 180, 14);
            paneTot.add(lblNewLabel);
            
            JPanel paneIT = new JPanel();
            paneIT.addMouseListener(new PanelButtonMouseAdapter(paneIT) {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		try {
            			Connection connection = null;
            			try {
            				connection   = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/workhub", "root", "admin");
            			} catch (SQLException e1) {
            				// TODO Auto-generated catch block
            				e1.printStackTrace();
            			}
            			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select nume,prenume,departament,statut,email from users where departament='IT'");
                        ResultSet rs=st.executeQuery();
                        table_1.setModel(DbUtils.resultSetToTableModel(rs));
            	} catch (Exception sqlException) {
                    sqlException.printStackTrace();
                }}
            });
            paneIT.setLayout(null);
            paneIT.setBackground(new Color(221, 160, 221));
            paneIT.setBounds(40, 57, 200, 35);
            add(paneIT);
            
            JLabel lblNewLabel_4 = new JLabel("IT");
            lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 14));
            lblNewLabel_4.setBounds(10, 11, 180, 14);
            paneIT.add(lblNewLabel_4);
            
            JPanel paneHR = new JPanel();
            paneHR.addMouseListener(new PanelButtonMouseAdapter(paneHR) {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		try {
            			Connection connection = null;
            			try {
            				connection   = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/workhub", "root", "admin");
            			} catch (SQLException e1) {
            				// TODO Auto-generated catch block
            				e1.printStackTrace();
            			}
            			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select nume,prenume,departament,statut,email from users where departament='HR'");
                        ResultSet rs=st.executeQuery();
                        table_1.setModel(DbUtils.resultSetToTableModel(rs));
            	} catch (Exception sqlException) {
                    sqlException.printStackTrace();
                }}
            });
            paneHR.setLayout(null);
            paneHR.setBackground(new Color(221, 160, 221));
            paneHR.setBounds(267, 57, 200, 35);
            add(paneHR);
            
            JLabel lblNewLabel_1 = new JLabel("Human Resources");
            lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
            lblNewLabel_1.setBounds(10, 11, 180, 14);
            paneHR.add(lblNewLabel_1);
            
            JPanel paneFR = new JPanel();
            paneFR.addMouseListener(new PanelButtonMouseAdapter(paneFR) {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		try {
            			Connection connection = null;
            			try {
            				connection   = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/workhub", "root", "admin");
            			} catch (SQLException e1) {
            				// TODO Auto-generated catch block
            				e1.printStackTrace();
            			}
            			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select nume,prenume,departament,statut,email from users where departament='FR'");
                        ResultSet rs=st.executeQuery();
                        table_1.setModel(DbUtils.resultSetToTableModel(rs));
            	} catch (Exception sqlException) {
                    sqlException.printStackTrace();
                }}
            });
            paneFR.setLayout(null);
            paneFR.setBackground(new Color(221, 160, 221));
            paneFR.setBounds(493, 57, 200, 35);
            add(paneFR);
            
            JLabel lblNewLabel_2 = new JLabel("Fundraising");
            lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
            lblNewLabel_2.setBounds(10, 11, 180, 14);
            paneFR.add(lblNewLabel_2);
            
            JPanel paneRE = new JPanel();
            paneRE.addMouseListener(new PanelButtonMouseAdapter(paneRE) {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		try {
            			Connection connection = null;
            			try {
            				connection   = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/workhub", "root", "admin");
            			} catch (SQLException e1) {
            				// TODO Auto-generated catch block
            				e1.printStackTrace();
            			}
            			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select nume,prenume,departament,statut,email from users where departament='RE'");
                        ResultSet rs=st.executeQuery();
                        table_1.setModel(DbUtils.resultSetToTableModel(rs));
            	} catch (Exception sqlException) {
                    sqlException.printStackTrace();
                }}
            });
            paneRE.setLayout(null);
            paneRE.setBackground(new Color(221, 160, 221));
            paneRE.setBounds(40, 105, 200, 35);
            add(paneRE);
            
            JLabel lblNewLabel_3 = new JLabel("Relatii Externe");
            lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
            lblNewLabel_3.setBounds(10, 11, 180, 14);
            paneRE.add(lblNewLabel_3);
            
            JPanel paneIM = new JPanel();
            paneIM.addMouseListener(new PanelButtonMouseAdapter(paneIM) {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		try {
            			Connection connection = null;
            			try {
            				connection   = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/workhub", "root", "admin");
            			} catch (SQLException e1) {
            				// TODO Auto-generated catch block
            				e1.printStackTrace();
            			}
            			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select nume,prenume,departament,statut,email from users where departament='IM'");
                        ResultSet rs=st.executeQuery();
                        table_1.setModel(DbUtils.resultSetToTableModel(rs));
            	} catch (Exception sqlException) {
                    sqlException.printStackTrace();
                }}
            });
            paneIM.setLayout(null);
            paneIM.setBackground(new Color(221, 160, 221));
            paneIM.setBounds(267, 105, 200, 35);
            add(paneIM);
            
            JLabel lblNewLabel_5 = new JLabel("Imagine");
            lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 14));
            lblNewLabel_5.setBounds(10, 11, 180, 14);
            paneIM.add(lblNewLabel_5);
            
            JPanel panePR = new JPanel();
            panePR.addMouseListener(new PanelButtonMouseAdapter(panePR) {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		try {
            			Connection connection = null;
            			try {
            				connection   = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/workhub", "root", "admin");
            			} catch (SQLException e1) {
            				// TODO Auto-generated catch block
            				e1.printStackTrace();
            			}
            			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select nume,prenume,departament,statut,email from users where departament='PR'");
                        ResultSet rs=st.executeQuery();
                        table_1.setModel(DbUtils.resultSetToTableModel(rs));
            	} catch (Exception sqlException) {
                    sqlException.printStackTrace();
                }}
            });
            panePR.setLayout(null);
            panePR.setBackground(new Color(221, 160, 221));
            panePR.setBounds(493, 105, 200, 35);
            add(panePR);
            
            JLabel lblNewLabel_6 = new JLabel("PR");
            lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 14));
            lblNewLabel_6.setBounds(10, 11, 180, 14);
            panePR.add(lblNewLabel_6);
            /*while(rs.next()) {
            	
            }*/
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

