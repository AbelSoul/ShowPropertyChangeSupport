import java.beans.PropertyChangeListener;

import javax.swing.event.SwingPropertyChangeSupport;

public class ObservedClass {
	public static final String BOUND_PROPERTY = "bound property";
	private String boundProperty = "";
	private SwingPropertyChangeSupport spcSupport = new SwingPropertyChangeSupport(
			this);

	public SwingPropertyChangeSupport getSpcSupport() {
		return spcSupport;
	}

	public void setSpcSupport(SwingPropertyChangeSupport spcSupport) {
		this.spcSupport = spcSupport;
	}

	public String getBoundProperty() {
		return boundProperty;
	}

	public void setBoundProperty(String boundProperty) {
		String oldValue = this.boundProperty;
		String newValue = boundProperty;
		this.boundProperty = newValue;
		spcSupport.firePropertyChange(BOUND_PROPERTY, oldValue, newValue);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		spcSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		spcSupport.removePropertyChangeListener(listener);
	}

}
