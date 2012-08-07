import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ShowPropertyChangeSupport {
	@SuppressWarnings("serial")
	void createAndShowGui() {
		final MainGUI mainGui = new MainGUI("Title goes here");
		final ObservedClass observedClass = new ObservedClass();
		observedClass.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent pcEvt) {
				if (pcEvt.getPropertyName()
						.equals(ObservedClass.BOUND_PROPERTY)) {
					mainGui.setTitle(pcEvt.getNewValue().toString());
					// mainGui.setStringForDispaly(pcEvt.getNewValue().toString());
				}
			}
		});

		mainGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGui.pack();
		mainGui.setLocationRelativeTo(null);
		mainGui.setVisible(true);

		int timerDelay = 9000; // every 9 seconds
		new Timer(timerDelay, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String result = JOptionPane.showInputDialog(mainGui,
						"Please enter a String", "Set GUI title",
						JOptionPane.PLAIN_MESSAGE);
				if (result != null) {
					observedClass.setBoundProperty(result);
				}
			}
		}) {
			{
				setInitialDelay(1000);
			}
		}.start();
	}

}
