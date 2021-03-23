import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelActivity extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelActivity() {

		setBounds(0,0,732,546);
		setLayout(null);
		
		JLabel lblThisIsActivity = new JLabel("THIS IS ACTIVITY");
		lblThisIsActivity.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThisIsActivity.setBounds(144, 208, 233, 85);
		add(lblThisIsActivity);
	}

}
