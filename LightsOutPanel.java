/**
 * 
 */
package weber_straeszler_steinwender_A08;

import java.awt.*;

import javax.swing.*;

/**
 * View Klasse des Spieles Lights Out
 * 
 * @author Jan-Philipp Steinwender
 * @version 10.12.2014
 */
public class LightsOutPanel extends JPanel {

	private LightsOutController con;
	private JButton[][] buttons;
	private JPanel mitte;
	private final int MAX_SIZE = 5;		//konstante f�r die felder

	/**
	 * Standardkonstruktor
	 * @param c Controller
	 */
	public LightsOutPanel(LightsOutController c) {
		this.con = c;
		this.setLayout(new BorderLayout());
		this.buttons = new JButton[MAX_SIZE][MAX_SIZE];

		// label oben
		JLabel textOben = new JLabel("Lights Out Game");
		textOben.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(textOben, BorderLayout.NORTH);

		// Buttons generieren und einfuegen
		initial();

		// button neustart
		JButton restart = new JButton("New Game");
		restart.addActionListener(con);
		restart.setActionCommand("neu");
		this.add(restart, BorderLayout.SOUTH);
	}

	/**
	 * Methode zum generieren der Buttons
	 */
	public void initial() {
		mitte = new JPanel(new GridLayout(MAX_SIZE, MAX_SIZE, 5, 5));

		// alle buttons / lichter aus
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < MAX_SIZE; j++) {
				this.buttons[i][j] = new JButton(); // neue buttons
				this.buttons[i][j].setBackground(Color.BLACK);
				this.buttons[i][j].addActionListener(con); // add actionlistener
				this.buttons[i][j].setActionCommand(i + 1 + "/" + j);
				mitte.add(buttons[i][j], BorderLayout.CENTER); // add buttons ins label
			}
		}

		this.add(mitte, BorderLayout.CENTER);
	}

	/**
	 * Getter Methode der buttons
	 * @return the buttons
	 */
	public JButton[][] getButtons() {
		return buttons;
	}

	/**
	 * aendert den zustand der buttons / lichter
	 * 
	 * @param position array mit den gekenzeichneten feldern
	 */
	public void press(boolean[][] position) {
		// geht alle buttons / lichter durch
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < MAX_SIZE; j++) {

				// schaut ob es geaendert wurde
				if (position[i][j] == true) {
					buttons[i][j].setBackground(Color.WHITE);
				}
				// aendert es
				else
					buttons[i][j].setBackground(Color.BLACK);

			}
		}
	}
	
	/**
	 * Methode die ein Gewinn Popup �ffnet
	 */
	public void win(){
		JOptionPane.showMessageDialog(this, "Gewonnen!", "Gewonnen", JOptionPane.INFORMATION_MESSAGE);
	}

}
