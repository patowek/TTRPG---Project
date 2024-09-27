package GUI;

import java.awt.Color;
import Classes.Adventurer;
import Classes.Attributes;
import Logic.GameLogic;
import Map.Room;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
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
	private static JTextArea outputTxt;
	private static JScrollPane scroll;
	public String userInput;
	private GameLogic game;
	
	public gui() {
		// Initialize GameLogic object
        game = new GameLogic();
        try {
			game.startGame(game);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	

        Adventurer player = game.getPlayer();
        
        // add frame and panel
 		JFrame frame = new JFrame("Tabletop Role-Playing Game");
 		JPanel panel = new JPanel();
     		
 		//Text field for actions
 		textBox = new JTextField(50);
 		textBox.setBounds(20,460,575,25);
 		panel.add(textBox);
     		
 		//Atk button
 		rollAtk = new JButton("ATK: "+player.atkPower.getValue());
 		rollAtk.setBounds(20,10,80,25);
 		rollAtk.addActionListener(new gui());
 		rollAtk.setActionCommand("Atk");
 		panel.add(rollAtk);
     		
 		//Mag button
 		rollMag = new JButton("MAG: "+player.magPower.getValue());
 		rollMag.setBounds(115,10,80,25);
 		rollMag.addActionListener(new gui());
 		rollMag.setActionCommand("Mag");
 		panel.add(rollMag);
     		
 		//armor class
 		readArmorClass = new JLabel("AC: "+player.defense.getValue());
 		readArmorClass.setBounds(622,20,80,25);
 		readArmorClass.setHorizontalAlignment(JLabel.CENTER);
 		readArmorClass.setForeground(Color.white);
 		panel.add(readArmorClass);
     		
 		//gold
 		readGold = new JLabel("G: "+player.gold.getValue());
 		readGold.setBounds(622,73,80,25);
 		readGold.setHorizontalAlignment(JLabel.CENTER);
 		readGold.setForeground(Color.white);
 		panel.add(readGold);
     		
 		//health bar
 		//want to fix HP text colors, but not priority
 		String hero = player.getRace();
     		
 		if (hero.equals("human")) {
 			healthBar = new JProgressBar(0, 51);
 		} else if (hero.equals("elf")) {
 			healthBar = new JProgressBar(0, 50);
 		} else if (hero.equals("dwarf")) {
 			healthBar = new JProgressBar(0, 52);
 		} else {
 			healthBar = new JProgressBar(0, 50);
 		}
     		
 		healthBar.setValue(player.health.getValue());
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
 		if (healthBar.getValue()>(player.health.getValue()/2)) {
 			healthBar.setForeground(Color.green);
 		} else {
 			healthBar.setForeground(Color.red);
 		}
 		panel.add(healthBar);
     		
 		//submit button for text field
 		submit = new JButton("SUBMIT");
 		submit.setBounds(600, 460, 80, 25);
 		submit.addActionListener(new gui());
 		submit.setActionCommand("Sub");
 		panel.add(submit);
     		
 		//output text to box above text field
 		outputTxt = new JTextArea("");
 		outputTxt.setLineWrap(true);
 		outputTxt.setWrapStyleWord(true);
 		outputTxt.setBounds(20, 310, 660, 135);
 		outputTxt.setBackground(Color.black);
 		outputTxt.setForeground(Color.white);
 		panel.add(outputTxt);
     		
 		TextAreaOutputStream textAreaOutputStream = new TextAreaOutputStream(outputTxt);
         	PrintStream printStream = new PrintStream(textAreaOutputStream);
         	System.setOut(printStream);
     		
 		scroll = new JScrollPane(outputTxt);
 		scroll.setBounds(20, 310, 660, 135);
 		panel.add(scroll);
     		
 		gui obj = new gui();
 		//background image set
 		roomBackground = new JLabel("",new ImageIcon(obj.backgrounds(null)), JLabel.CENTER);
     				
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
 		
 		update(player);
}

	public String backgrounds(String myRoom) {
		Adventurer adventurer = game.getPlayer();
		
		//placeholder values to be replaced with proper variables from other classes
		String hero = adventurer.getRace();
		Room room = adventurer.getCurrentRoom();
		
		//decides background visual based on race & current room number
		//test to be sure image will change when room changes
		
		try {
			//elf rooms
			if (hero.equals("elf")) {
				if (room.equals("StartRoom")) {
					myRoom = "src/Resources/images/StartRoom.png";
					return myRoom;
				} else if (room.equals("1")) {
					myRoom = "src/Resources/images/room1_elf.png";
					return myRoom;
				} else if (room.equals("2")) {
					myRoom = "src/Resources/images/room2_elf.png";
					return myRoom;
				} else if (room.equals("3")) {
					myRoom = "src/Resources/images/room3_elf.png";
					return myRoom;
				} else if (room.equals("4")) {
					myRoom = "src/Resources/images/room4_elf.png";
					return myRoom;
				} else if(room.equals("5")) {
					myRoom = "src/Resources/images/room5_elf.png";
					return myRoom;
				} else {
					myRoom = "src/Resources/images/StartRoom.png";
					return myRoom;
				}
				
			//human rooms
			} else if (hero.equals("human")) {
				if (room.equals("StartRoom")) {
					myRoom = "src/Resources/images/StartRoom.png";
					return myRoom;
				} else if (room.equals("1")) {
					myRoom = "src/Resources/images/room1_human.png";
					return myRoom;
				} else if (room.equals("2")) {
					myRoom = "src/Resources/images/room2_human.png";
					return myRoom;
				} else if (room.equals("3")) {
					myRoom = "src/Resources/images/room3_human.png";
					return myRoom;
				} else if (room.equals("4")) {
					myRoom = "src/Resources/images/room4_human.png";
					return myRoom;
				} else if(room.equals("5")) {
					myRoom = "src/Resources/images/room5_human.png";
					return myRoom;
				} else {
					myRoom = "src/Resources/images/StartRoom.png";
					return myRoom;
				}
				
			//dwarf rooms
			} else if (hero.equals("dwarf")) {
				if (room.equals("StartRoom")) {
					myRoom = "src/Resources/images/StartRoom.png";
					return myRoom;
				} else if (room.equals("1")) {
					myRoom = "src/Resources/images/room1_dwarf.png";
					return myRoom;
				} else if (room.equals("2")) {
					myRoom = "src/Resources/images/room2_dwarf.png";
					return myRoom;
				} else if (room.equals("3")) {
					myRoom = "src/Resources/images/room3_dwarf.png";
					return myRoom;
				} else if (room.equals("4")) {
					myRoom = "src/Resources/images/room4_dwarf.png";
					return myRoom;
				} else if(room.equals("5")) {
					myRoom = "src/Resources/images/room5_dwarf.png";
					return myRoom;
				} else {
					myRoom = "src/Resources/images/StartRoom.png";
					return myRoom;
				}
			} else {
				return "There is no image for that room and race.";
			}
		} catch (Exception e) {
			return "An error has occured.";
		}
	}
	
	private void update(Adventurer player) {
		// Update health bar
        healthBar.setValue(player.health.getValue());
        healthBar.setString("HP: " + player.health.getValue());

        // Update Armor Class and Gold
        readArmorClass.setText("AC: " + player.defense.getValue());
        readGold.setText("Gold: " + player.gold.getValue());

        // Update background image based on current room
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom != null) {
        	roomBackground = new JLabel("",new ImageIcon(this.backgrounds(null)), JLabel.CENTER);
        }

        // Show room description
        outputTxt.append(currentRoom.getDescription() + "\n");
	}
	
	
	public static void main(String [ ] args) {
		
//		// add frame and panel
//		JFrame frame = new JFrame("Tabletop Role-Playing Game");
//		JPanel panel = new JPanel();
//		
//		//Text field for actions
//		textBox = new JTextField(50);
//		textBox.setBounds(20,460,575,25);
//		panel.add(textBox);
//		
//		//Atk button
//		rollAtk = new JButton("ATK: "+attri.atkPower.getValue());
//		rollAtk.setBounds(20,10,80,25);
//		rollAtk.addActionListener(new gui());
//		rollAtk.setActionCommand("Atk");
//		panel.add(rollAtk);
//		
//		//Mag button
//		rollMag = new JButton("MAG: "+attri.magPower.getValue());
//		rollMag.setBounds(115,10,80,25);
//		rollMag.addActionListener(new gui());
//		rollMag.setActionCommand("Mag");
//		panel.add(rollMag);
//		
//		//armor class
//		readArmorClass = new JLabel("AC: "+attri.defense.getValue());
//		readArmorClass.setBounds(622,20,80,25);
//		readArmorClass.setHorizontalAlignment(JLabel.CENTER);
//		readArmorClass.setForeground(Color.white);
//		panel.add(readArmorClass);
//		
//		//gold
//		readGold = new JLabel("G: "+attri.gold.getValue());
//		readGold.setBounds(622,73,80,25);
//		readGold.setHorizontalAlignment(JLabel.CENTER);
//		readGold.setForeground(Color.white);
//		panel.add(readGold);
//		
//		//health bar
//		//want to fix HP text colors, but not priority
//		String hero = attri.getRace();
//		
//		if (hero.equals("human")) {
//			healthBar = new JProgressBar(0, 51);
//		} else if (hero.equals("elf")) {
//			healthBar = new JProgressBar(0, 50);
//		} else if (hero.equals("dwarf")) {
//			healthBar = new JProgressBar(0, 52);
//		} else {
//			healthBar = new JProgressBar(0, 50);
//		}
//		
//		healthBar.setValue(attri.health.getValue());
//		healthBar.setString("HP");
//		healthBar.setStringPainted(true);
//		BasicProgressBarUI ui = new BasicProgressBarUI() {
//		    protected Color getSelectionBackground() {
//		        return Color.BLACK; // string color over the background
//		    }
//		    protected Color getSelectionForeground() {
//		        return Color.BLACK; // string color over the foreground
//		    }
//		};
//		healthBar.setUI(ui);
//		healthBar.setBounds(475,10,150,25);
//		if (healthBar.getValue()>(attri.health.getValue()/2)) {
//			healthBar.setForeground(Color.green);
//		} else {
//			healthBar.setForeground(Color.red);
//		}
//		panel.add(healthBar);
//		
//		//submit button for text field
//		submit = new JButton("SUBMIT");
//		submit.setBounds(600, 460, 80, 25);
//		submit.addActionListener(new gui());
//		submit.setActionCommand("Sub");
//		panel.add(submit);
//		
//		//output text to box above text field
//		outputTxt = new JTextArea("");
//		outputTxt.setLineWrap(true);
//		outputTxt.setWrapStyleWord(true);
//		outputTxt.setBounds(20, 310, 660, 135);
//		outputTxt.setBackground(Color.black);
//		outputTxt.setForeground(Color.white);
//		panel.add(outputTxt);
//		
//		TextAreaOutputStream textAreaOutputStream = new TextAreaOutputStream(outputTxt);
//        	PrintStream printStream = new PrintStream(textAreaOutputStream);
//        	System.setOut(printStream);
//		
//		scroll = new JScrollPane(outputTxt);
//		scroll.setBounds(20, 310, 660, 135);
//		panel.add(scroll);
//		
//		gui obj = new gui();
//		//background image set
//		roomBackground = new JLabel("",new ImageIcon(obj.backgrounds(null)), JLabel.CENTER);
//				
//		//set image
//		roomBackground.setBounds(0,0,700,500);
//		panel.add(roomBackground);
//		
//		// change frame size and set it to exit on close
//		frame.setSize(710, 535);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		// add panel... again!
//		frame.add(panel);
//		panel.setLayout(null);
//		
//		//centers frame
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
		
		new gui();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//attack roll; currently placeholder
		if(e.getActionCommand().equals("Atk")) {
			userInput = "attack";
			
		//magic roll; currently placeholder
		} else if (e.getActionCommand().equals("Mag")) {
			userInput = "attack";
	
		//text response; currently placeholder
		} else if (e.getActionCommand().equals("Sub")){
			userInput = textBox.getText();
			textBox.setText("");
			game.processInput(userInput);
			update(game.getPlayer());
		}
		
	}
}
