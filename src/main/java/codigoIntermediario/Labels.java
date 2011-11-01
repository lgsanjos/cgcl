package codigoIntermediario;

import java.util.HashMap;

public class Labels {

	private static Labels instance;
	private HashMap<Integer, String> labels;

	private Labels() {
		this.labels = new HashMap<Integer, String>();
	}

	public static Labels getInstancia() {
		if (instance == null)
			instance = new Labels();

		return instance;
	}

	public static String geraLabel() {
		int size = getInstancia().labels.size() + 1;
		String label = "L" + size;
		getInstancia().labels.put(size, label);
		
		return label;
	}
}
