import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// ** note that I don't like extending JFrame,
// but will do this for sake of example simplicity
public class MainGUI extends JFrame {

	private String arrayDisplayString;

	public MainGUI(String title) {
		super(title);

		arrayDisplayString = "change me";
		panelToDisplayString();
		setStringForDispaly(arrayDisplayString);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 300);
	}

	public void setStringForDispaly(String s) {

		arrayDisplayString = s;
		System.out.println(arrayDisplayString);

	}

	public void panelToDisplayString() {
		JPanel panelForString = new JPanel();
		panelForString.setBackground(Color.black);
		add(panelForString, BorderLayout.CENTER);

		JTextArea displayOutput = new JTextArea(22, 18);
		displayOutput.setText(arrayDisplayString);
		displayOutput.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Array Display Area"));
		panelForString.add(displayOutput);
	}

}
