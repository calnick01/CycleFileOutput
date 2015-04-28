/**
Modify your application such that the properties will be written to a text file called “CycleOut.txt” instead of to the screen.   

Directions
	- Examine your application for the class called Cycle
	- Add an appropriate throws statement in the main method
	- Create a reference to a File class with the appropriate name of a text file (Cycle.txt)
	- Use appropriate code to ensure that the text file exist.
	- Output the values of the variables to the text file.
	- Close the file.
	- Document each statement concisely.
	- Post your Java source code file and output text file in Blackboard using the Assignment Upload area below.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Cycle {
	static double numberOfWheels;
	static double weight;
		
	public Cycle(double numberOfWheels,  double weight) { // constructor
			this.numberOfWheels=numberOfWheels;
			this.weight=weight;
	}
		
	public String toString() { // to string
		return "Cycle [numberOfWheels=" + numberOfWheels + ", weight=" + weight + "]";
	}

	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		String fileName = "Cycle.txt";
		PrintWriter output = null;
		
		try { // try catch methods
			output = new PrintWriter(fileName);
			}
		catch(FileNotFoundException e){
			System.out.println("File does not exist");
			throw e;
		}
		
		JTextField NumberOfWheels = new JTextField(10); // set up panel and textfields
		JTextField Weight = new JTextField(10);
		JLabel label = new JLabel("Please enter the number of wheels and weight of cycle.");
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // sets layout
		panel.add(label);
		panel.add(NumberOfWheels);
		panel.add(Weight);
		
		JOptionPane.showMessageDialog(null, panel); //prompts user to enter the number of wheels and weight
		numberOfWheels = Double.parseDouble(NumberOfWheels.getText());
		weight = Double.parseDouble(Weight.getText());
		Cycle c = new Cycle(numberOfWheels, weight); //sets new cycle
		
		output.println(c.toString());
		output.close(); //closes file
		
		}
	}