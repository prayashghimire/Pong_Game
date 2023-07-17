import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Frame extends JFrame {

	Game_Panel panel = new Game_Panel();
	Frame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}


