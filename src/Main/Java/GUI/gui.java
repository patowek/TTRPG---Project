package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;

/***************************************************
 ***Name:gui.java***********************************
 ***Author:Hayley King******************************
 ***Purpose: To create a visualization of the*******
 ************game for the players of the text*******
 ************based adventure game*******************
 */

public class gui implements ActionListener {
	
	private static JTextField textBox;
	private static JButton rollAtk;
	private static JButton rollMag;
	private static JButton submit;
	private static JLabel readArmorClass;
	private static JLabel readGold;
	private static JProgressBar healthBar;
	private static JLabel roomBackground;
	private static JLabel outputTxt;
	
	
	
	public static String backgrounds(String myRoom) {
		//placeholder values to be replaced with proper variables from other classes
		String hero = "human";
		int room = 1;
		
		//decides background visual based on race & current room number
		//test to be sure image will change when room changes
		
		try {
			//elf rooms
			if (hero.equals("elf")) {
				if (room == 1) {
					myRoom = "src/Resources/images/room1_elf.png";
					return myRoom;
				} else if (room == 2) {
					myRoom = "src/Resources/images/room2_elf.png";
					return myRoom;
				} else if (room == 3) {
					myRoom = "src/Resources/images/room3_elf.png";
					return myRoom;
				} else if (room == 4) {
					myRoom = "src/Resources/images/room4_elf.png";
					return myRoom;
				} else if (room == 5) {
					myRoom = "src/Resources/images/room5_elf.png";
					return myRoom;
				} else {
					myRoom = "src/Resources/images/room5_elf.png";
					return myRoom;
				}
				
			//human rooms
			} else if (hero.equals("human")) {
				if (room == 1) {
					myRoom = "src/Resources/images/room1_human.png";
					return myRoom;
				} else if (room == 2) {
					myRoom = "src/Resources/images/room2_human.png";
					return myRoom;
				} else if (room == 3) {
					myRoom = "src/Resources/images/room3_human.png";
					return myRoom;
				} else if (room == 4) {
					myRoom = "src/Resources/images/room4_human.png";
					return myRoom;
				} else if (room == 5) {
					myRoom = "src/Resources/images/room5_human.png";
					return myRoom;
				} else {
					myRoom = "src/Resources/images/room5_elf.png";
					return myRoom;
				}
				
			//dwarf rooms
			} else if (hero.equals("dwarf")) {
				if (room == 1) {
					myRoom = "src/Resources/images/room1_dwarf.png";
					return myRoom;
				} else if (room == 2) {
					myRoom = "src/Resources/images/room2_dwarf.png";
					return myRoom;
				} else if (room == 3) {
					myRoom = "src/Resources/images/room3_dwarf.png";
					return myRoom;
				} else if (room == 4) {
					myRoom = "src/Resources/images/room4_dwarf.png";
					return myRoom;
				} else if (room == 5) {
					myRoom = "src/Resources/images/room5_dwarf.png";
					return myRoom;
				} else {
					myRoom = "src/Resources/images/room5_elf.png";
					return myRoom;
				}
			} else {
				return "There is no image for that room and race.";
			}
		} catch (Exception e) {
			return "An error has occured.";
		}
	}
	
	
	
	public static void main(String [ ] args) {
		// add frame and panel
		JFrame frame = new JFrame("Tabletop Role-Playing Game");
		JPanel panel = new JPanel();
		
		//Text field for actions
		textBox = new JTextField(50);
		textBox.setBounds(20,460,575,25);
		panel.add(textBox);
		
		//Atk button
		rollAtk = new JButton("ATK: 0");
		rollAtk.setBounds(20,10,80,25);
		rollAtk.addActionListener(new gui());
		rollAtk.setActionCommand("Atk");
		panel.add(rollAtk);
		
		//Mag button
		rollMag = new JButton("MAG: 0");
		rollMag.setBounds(115,10,80,25);
		rollMag.addActionListener(new gui());
		rollMag.setActionCommand("Mag");
		panel.add(rollMag);
		
		//armor class; read amount is placeholder
		readArmorClass = new JLabel("AC: 0");
		readArmorClass.setBounds(622,20,80,25);
		readArmorClass.setHorizontalAlignment(JLabel.CENTER);
		readArmorClass.setForeground(Color.white);
		panel.add(readArmorClass);
		
		//gold; read amount is placeholder
		readGold = new JLabel("G: 0");
		readGold.setBounds(622,73,80,25);
		readGold.setHorizontalAlignment(JLabel.CENTER);
		readGold.setForeground(Color.white);
		panel.add(readGold);
		
		//health bar; progress values are placeholders
		//want to fix HP text colors, but not priority
		healthBar = new JProgressBar(0,10);
		healthBar.setValue(10);
		healthBar.setString("HP");
		healthBar.setStringPainted(true);
		BasicProgressBarUI ui = new BasicProgressBarUI() {
		    protected Color getSelectionBackground() {
		        return Color.BLACK; // string color over the background
		    }
		    protected Color getSelectionForeground() {
		        return Color.BLACK; // string color over the foreground
		    }
		};
		healthBar.setUI(ui);
		healthBar.setBounds(475,10,150,25);
		healthBar.setForeground(Color.green);
		panel.add(healthBar);
		
		//submit button for text field
		submit = new JButton("SUBMIT");
		submit.setBounds(600, 460, 80, 25);
		submit.addActionListener(new gui());
		submit.setActionCommand("Sub");
		panel.add(submit);
		
		//output text to box above text field
		outputTxt = new JLabel("");
		outputTxt.setVerticalAlignment(JLabel.BOTTOM);
		outputTxt.setBounds(25, 310, 650, 135);
		outputTxt.setForeground(Color.white);
		panel.add(outputTxt);
		
		//background image set
		roomBackground = new JLabel("",new ImageIcon(backgrounds(null)), JLabel.CENTER);
				
		//set image
		roomBackground.setBounds(0,0,700,500);
		panel.add(roomBackground);
		
		// change frame size and set it to exit on close
		frame.setSize(710, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add panel... again!
		frame.add(panel);
		panel.setLayout(null);
		
		//centers frame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//attack roll; currently placeholder
		if(e.getActionCommand().equals("Atk")) {
			int result = ThreadLocalRandom.current().nextInt(1, 20+1);
			outputTxt.setText("Rolled ATK! A "+result+"!");
			
		//magic roll; currently placeholder
		} else if (e.getActionCommand().equals("Mag")) {
			int result = ThreadLocalRandom.current().nextInt(1, 20+1);
			outputTxt.setText("Rolled MAG! A "+result+"!");
	
		//text response; currently placeholder
		} else if (e.getActionCommand().equals("Sub")){
			String userInput = textBox.getText();
			outputTxt.setText("<html>"+userInput+"<html>");
		}
		
	}
}
