import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelAbout extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelAbout() {

		setBounds(0,0,732,546);
		setLayout(null);
		
		JLabel lblThisIsAbout = new JLabel("THIS IS ABOUT");
		lblThisIsAbout.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThisIsAbout.setBounds(235, 256, 233, 85);
		add(lblThisIsAbout);
	}

}
