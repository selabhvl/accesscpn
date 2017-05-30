package no.hvl.cpntools.accesscpn;
import javax.swing.JFileChooser;
import java.io.*;

import org.cpntools.accesscpn.model.ModelPrinter;
import org.cpntools.accesscpn.engine.highlevel.InstancePrinter;
import org.cpntools.accesscpn.model.PetriNet;
import org.cpntools.accesscpn.model.importer.DOMParser;

public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String[] args) throws Exception {
		final JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			load(chooser.getSelectedFile());
		}

	}

	private static void load(final File selectedFile) throws Exception {
		final PetriNet petriNet = DOMParser.parse(selectedFile.toURI().toURL());
		System.out.println(ModelPrinter.printModel(petriNet));
		System.out.println("=======================================================");
		System.out.println(InstancePrinter.printModel(petriNet));
		System.out.println("=======================================================");
		System.out.println(InstancePrinter.printMonitors(petriNet));
	}

}


