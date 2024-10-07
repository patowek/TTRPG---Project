package GUI;

import java.awt.Color;
import java.awt.Dimension;

import Classes.Adventurer;
import Classes.Attributes;
import Items.Item;
import Logic.GameLogic;
import Map.Room;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

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
	private static List<JButton> equipmentButtons;
	private static List<JButton> inventoryButtons;
	public String userInput;
	private GameLogic game;
	private Attributes atk;
	private Attributes def;
	private Attributes spd;
	private int armor;
	private Attributes gold;
	private Attributes health;
	private Consumer<String> inputCallback = null;
	
	public gui(GameLogic game) {
 		
		this.game = game;
		
 		//Add Panel
 		JPanel panel = new JPanel();
 		panel.setLayout(null);
 		panel.setOpaque(false);
 		panel.setBounds(0, 0, 1400, 500);

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
 		outputTxt.setBounds(20, 10, 660, 435);
 		outputTxt.setBackground(Color.black);
 		outputTxt.setForeground(Color.white);
 		outputTxt.setEditable(false);
 		panel.add(outputTxt);
     		
 		TextAreaOutputStream textAreaOutputStream = new TextAreaOutputStream(outputTxt);
         	PrintStream printStream = new PrintStream(textAreaOutputStream);
         	System.setOut(printStream);
     		
 		scroll = new JScrollPane(outputTxt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
 		scroll.setBounds(20, 10, 660, 435);
 		panel.add(scroll);
 		
 		//submit button for text field
 		submit = new JButton("SUBMIT");
 		submit.setBounds(600, 460, 80, 25);
 		submit.addActionListener(this);
 		submit.setActionCommand("Sub");
 		panel.add(submit);
     		
 		//Attack label
 		readAtk = new JLabel("Attack: ");
 		readAtk.setBounds(720,10,80,25);
 		readAtk.setHorizontalAlignment(JLabel.CENTER);
 		readAtk.setForeground(Color.white);
 		readAtk.setBackground(Color.gray);
 		readAtk.setOpaque(true);
 		panel.add(readAtk);
 		
 		//Speed label
 		readSpd = new JLabel("Speed: ");
 		readSpd.setBounds(820,10,80,25);
 		readSpd.setHorizontalAlignment(JLabel.CENTER);
 		readSpd.setForeground(Color.white);
 		readSpd.setBackground(Color.gray);
 		readSpd.setOpaque(true);
 		panel.add(readSpd);
 		
 		//Defense label
 		readDef = new JLabel("Defense: ");
 		readDef.setBounds(920,10,80,25);
 		readDef.setHorizontalAlignment(JLabel.CENTER);
 		readDef.setForeground(Color.white);
 		readDef.setBackground(Color.gray);
 		readDef.setOpaque(true);
 		panel.add(readDef);
     		
 		//armor class
 		readArmorClass = new JLabel("AC: ");
 		readArmorClass.setBounds(1322,20,80,25);
 		readArmorClass.setHorizontalAlignment(JLabel.CENTER);
 		readArmorClass.setForeground(Color.white);
 		panel.add(readArmorClass);
     		
 		//gold
 		readGold = new JLabel("G: ");
 		readGold.setBounds(1322,73,80,25);
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
 		healthBar.setBounds(1175,10,150,25);
 		if (healthBar.getValue() < 20) {
 			healthBar.setForeground(Color.red);
 		} else if (healthBar.getValue() < 60) {
 			healthBar.setForeground(Color.yellow);
 		} else {
 			healthBar.setForeground(Color.green);
 		}
 		panel.add(healthBar);
 		
 		//Equipment buttons
 		equipmentButtons = new ArrayList<>();
 		for (int i = 0; i < 5; i++) {
 			JButton button = new JButton();
 			button.setBounds(725 + i * 130, 310, 120, 30);
 			panel.add(button);
 			equipmentButtons.add(button);
 			//button.addActionListener(this);
 			//button.setActionCommand("inv");
 		}
 		
 		//Inventory buttons
 		inventoryButtons = new ArrayList<>();
 		for (int i = 0; i < 4; i++) {
 			JButton button = new JButton();
 			button.setBounds(730 + i * 160, 360, 150, 30);
 			panel.add(button);
 			inventoryButtons.add(button);
 			//button.addActionListener(this);
 			//button.setActionCommand("inv");
 		}
 		for (int i = 0; i < 4; i++) {
 			JButton button = new JButton();
 			button.setBounds(730 + i * 160, 400, 150, 30);
 			panel.add(button);
 			inventoryButtons.add(button);
 			//button.addActionListener(this);
 			//button.setActionCommand("inv");
 		}
     	
 		//Create layered pane
 		JLayeredPane layerPane = new JLayeredPane();
 		layerPane.setPreferredSize(new Dimension(1400, 500));
 		layerPane.add(panel, JLayeredPane.PALETTE_LAYER);
 		
 		//background image set
 		roomBackground = new JLabel("", new ImageIcon("src/Resources/images/StartRoom.png") , JLabel.CENTER);
 		roomBackground.setBounds(700,0,700,500);
 		layerPane.add(roomBackground, JLayeredPane.DEFAULT_LAYER);
     		
        // add Frame
 		JFrame frame = new JFrame("Tabletop Role-Playing Game");
 		frame.setSize(1410, 535);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setLocationRelativeTo(null);
 		frame.setVisible(true);
 		frame.add(layerPane);
}

	public String backgrounds(String hero, int room) {
		
		//decides background visual based on race & current room number
		//test to be sure image will change when room changes
		return "src/Resources/images/room" + room + "_" + hero + ".png";
	}
	
	public void update() {
		Adventurer player = game.getPlayer();
		
		// Update health bar
		health = player.getStat(Attributes.HP);
        healthBar.setValue(health.getValue() * 100 /player.getMaxHP());
        healthBar.setString(health.toString() + "/" + player.getMaxHP());

        // Update statistics
        atk = player.getStat(Attributes.ATK);
        spd = player.getStat(Attributes.SPD);
        def = player.getStat(Attributes.DEF);
        armor = player.getArmor();
        gold = player.getStat(Attributes.GP);
        
        // Update UI elements
        readAtk.setText(atk.toString());
        readSpd.setText(spd.toString());
        readDef.setText(def.toString());
        readArmorClass.setText("AC: " + armor);
        readGold.setText(gold.toString());
        
        Item[] equipmentList = player.getGear();
        for (int i = 0; i < 5; i++) {
        	if (equipmentList[i] != null) {
        		equipmentButtons.get(i).setText(equipmentList[i].getName()); 
        	} else {
        		equipmentButtons.get(i).setText("Empty");
        	}
        }
        
        Item[] inventoryList = player.getItems();
        for (int i = 0; i < 8; i++) {
        	if (inventoryList[i] != null) {
        		inventoryButtons.get(i).setText(inventoryList[i].getName());
        	} else {
        		inventoryButtons.get(i).setText("Empty");
        	}
        }

        // Update background image based on current room
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom != null) {
        	roomBackground.setIcon(new ImageIcon(this.backgrounds(player.getRace(), currentRoom.getName())));
        }
        
        roomBackground.revalidate();
        roomBackground.repaint();
        
        outputTxt.setCaretPosition(outputTxt.getDocument().getLength());
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//text response; currently placeholder
		if (e.getActionCommand().equals("Sub")){
			userInput = textBox.getText();
			outputTxt.append(userInput + "\n");
			textBox.setText("");
			if (inputCallback != null) {
	            // We are in "question mode", process the answer
	            inputCallback.accept(userInput); // Pass input to callback
	            inputCallback = null; // Reset callback
	        } else {
	            // Normal processing mode
	            game.processInput(userInput); // Continue with regular input processing
	        }
		}
		
	}
	
	public CompletableFuture<String> requestAnswer(String question) {
	    // Output the question
	    outputTxt.append(question + "\n");
	    outputTxt.setCaretPosition(outputTxt.getDocument().getLength());
	    
	    CompletableFuture<String> answer = new CompletableFuture<>();

	    // Set up to receive the next input as an answer
	    inputCallback = input -> {
	    	answer.complete(input);
	    };
	    
	    return answer;
	}
}
