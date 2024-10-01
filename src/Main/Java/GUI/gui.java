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
	private static JButton submit;
	private static JLabel readAtk;
	private static JLabel readSpd;
	private static JLabel readDef;
	private static JLabel readArmorClass;
	private static JLabel readGold;
	private static JProgressBar healthBar;
	private static JLabel roomBackground;
	private static JTextArea outputTxt;
	private static JScrollPane scroll;
	public String userInput;
	private GameLogic game;
	private Attributes atk;
	private Attributes def;
	private Attributes spd;
	private int armor;
	private Attributes gold;
	private Attributes health;
	
	public gui() {
 		
 		//Add Panel
 		JPanel panel = new JPanel();
 		panel.setLayout(null);

 		//Text field for actions
 		textBox = new JTextField(50);
 		textBox.setBounds(20,460,575,25);
 		textBox.addActionListener(this);
 		textBox.setActionCommand("Sub");
 		panel.add(textBox);
 		
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
 		
 		//submit button for text field
 		submit = new JButton("SUBMIT");
 		submit.setBounds(600, 460, 80, 25);
 		submit.addActionListener(this);
 		submit.setActionCommand("Sub");
 		panel.add(submit);
     		
 		//Attack label
 		readAtk = new JLabel("Attack: ");
 		readAtk.setBounds(20,10,80,25);
 		readAtk.setHorizontalAlignment(JLabel.CENTER);
 		readAtk.setForeground(Color.white);
 		panel.add(readAtk);
 		
 		//Speed label
 		readSpd = new JLabel("Speed: ");
 		readSpd.setBounds(120,10,80,25);
 		readSpd.setHorizontalAlignment(JLabel.CENTER);
 		readSpd.setForeground(Color.white);
 		panel.add(readSpd);
 		
 		//Defense label
 		readDef = new JLabel("Defense: ");
 		readDef.setBounds(220,10,80,25);
 		readDef.setHorizontalAlignment(JLabel.CENTER);
 		readDef.setForeground(Color.white);
 		panel.add(readDef);
     		
 		//armor class
 		readArmorClass = new JLabel("AC: ");
 		readArmorClass.setBounds(622,20,80,25);
 		readArmorClass.setHorizontalAlignment(JLabel.CENTER);
 		readArmorClass.setForeground(Color.white);
 		panel.add(readArmorClass);
     		
 		//gold
 		readGold = new JLabel("G: ");
 		readGold.setBounds(622,73,80,25);
 		readGold.setHorizontalAlignment(JLabel.CENTER);
 		readGold.setForeground(Color.white);
 		panel.add(readGold);
     		
 		//health bar  	
 		healthBar = new JProgressBar(0, 100);
     		
 		healthBar.setValue(100);
 		healthBar.setString("HP: ");
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
 		if (healthBar.getValue() < 20) {
 			healthBar.setForeground(Color.red);
 		} else if (healthBar.getValue() < 60) {
 			healthBar.setForeground(Color.yellow);
 		} else {
 			healthBar.setForeground(Color.green);
 		}
 		panel.add(healthBar);
     		
 		//background image set
 		roomBackground = new JLabel("", null , JLabel.CENTER);
 		roomBackground.setBounds(0,0,700,500);
 		panel.add(roomBackground);
     		
        // add Frame
 		JFrame frame = new JFrame("Tabletop Role-Playing Game");
 		frame.setSize(710, 535);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setLocationRelativeTo(null);
 		frame.setVisible(true);
 		frame.add(panel);
}

	public String backgrounds(String hero, int room) {
		
		//decides background visual based on race & current room number
		//test to be sure image will change when room changes
		return "src/Resources/images/room" + room + "_" + hero + ".png";
	}
	
	private void update(GameLogic game) {
		Adventurer player = game.getPlayer();
		
		// Update health bar
		health = player.getStat(Attributes.HP);
        healthBar.setValue(health.getValue()/player.getMaxHP());
        healthBar.setString(health.toString() + "/" + player.getMaxHP());

        // Update statistics
        atk = player.getStat(Attributes.ATK);
        spd = player.getStat(Attributes.SPD);
        def = player.getStat(Attributes.DEF);
        armor = player.getArmor();
        gold = player.getStat(Attributes.GP);
        
        // Update UI elements
        readAtk = new JLabel(atk.toString());
        readSpd = new JLabel(spd.toString());
        readDef = new JLabel(def.toString());
        readArmorClass.setText("AC: " + armor);
        readGold.setText(gold.toString());

        // Update background image based on current room
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom != null) {
        	roomBackground = new JLabel("",new ImageIcon(this.backgrounds(player.getRace(), currentRoom.getName())), JLabel.CENTER);
        }

        // Show room description
        outputTxt.append(currentRoom.getDescription() + "\n");
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//text response; currently placeholder
		if (e.getActionCommand().equals("Sub")){
			userInput = textBox.getText();
			textBox.setText("");
			game.processInput(userInput);
			update(game);
		}
		
	}
}
