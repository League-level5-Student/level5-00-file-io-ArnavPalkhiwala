package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addTask = new JButton("Add Task");
	JButton viewTasks = new JButton("View Tasks");
	JButton removeTask = new JButton("Remove Task");
	JButton saveList = new JButton("Save List");
	JButton loadList = new JButton("Load List");

	ArrayList<String> tasks = new ArrayList<String>();

	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.run();
	}

	void run() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/file.txt"));

			String line = br.readLine();
			while (line != null) {
				
				tasks.add(line);
//				System.out.println(line);
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		frame.add(panel);
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		addTask.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == addTask) {
			String task = JOptionPane.showInputDialog("Enter a  task here...");
			tasks.add(task);

		}

		if (e.getSource() == viewTasks) {
			JOptionPane.showMessageDialog(null, tasks);

		}

		if (e.getSource() == removeTask) {
			String remove = JOptionPane.showInputDialog("What task do you want to remove?");
			tasks.remove(remove);

		}

		if (e.getSource() == saveList) {

			String loading = "";

			for (int i = 0; i < tasks.size(); i++) {
				if (i != 0) {
					loading += " " + tasks.get(i);

				}

				else {
					loading += tasks.get(i);
				}

			}

			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/file.txt");
				fw.write(loading);
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
		
		if (e.getSource() == loadList) {
			
			String location = JOptionPane.showInputDialog("Enter the location of the file");
			JOptionPane.showMessageDialog(null, "The contents in the file will be printed in the console");
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(location));

				String line = br.readLine();
				while (line != null) {
					System.out.println(line);
					line = br.readLine();
				}

				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}

	}

}
