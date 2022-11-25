package predictivegui;
/*
 * Quiz 2
 * 
 * Made by Irsyad Fikriansyah Ramadhan
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
// This is the View 
// Its only job is to display what the user sees 
// It performs no calculations, but instead passes 
// information entered by the user to whomever needs 
// it.

import java.awt.event.ActionListener; 
import javax.swing.*;

public class KeypadView{
   /**
	 * Class to implement interactive GUI
	 */

    // initialize object
	private KeypadPanel panel = new KeypadPanel();

	// method for initialize the frame
	public void init(String title) {

        // frame
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(panel);
		frame.pack();
        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
        frame.setResizable(false);
    }

    void addListener0(ActionListener listenForCalcButton){
        panel.b0.addActionListener(listenForCalcButton);
    }
    void addListener1(ActionListener listenForCalcButton){
        panel.b1.addActionListener(listenForCalcButton);
    }
    void addListener2(ActionListener listenForCalcButton){
        panel.b2.addActionListener(listenForCalcButton);
    }
    void addListener3(ActionListener listenForCalcButton){
        panel.b3.addActionListener(listenForCalcButton);
    }
    void addListener4(ActionListener listenForCalcButton){
        panel.b4.addActionListener(listenForCalcButton);
    }
    void addListener5(ActionListener listenForCalcButton){
        panel.b5.addActionListener(listenForCalcButton);
    }
    void addListener6(ActionListener listenForCalcButton){
        panel.b6.addActionListener(listenForCalcButton);
    }
    void addListener7(ActionListener listenForCalcButton){
        panel.b7.addActionListener(listenForCalcButton);
    }
    void addListener8(ActionListener listenForCalcButton){
        panel.b8.addActionListener(listenForCalcButton);
    }
    void addListener9(ActionListener listenForCalcButton){
        panel.b9.addActionListener(listenForCalcButton);
    }
    void addListenerStar(ActionListener listenForCalcButton){
        panel.bStar.addActionListener(listenForCalcButton);
    }
    void addListenerHash(ActionListener listenForCalcButton){
        panel.bHash.addActionListener(listenForCalcButton);
    }
        

    public void setTextArea(String str){
        panel.text.setText(str);
    }

}
