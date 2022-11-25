package predictivegui;
/*
 * Quiz 2
 * 
 * Made by Irsyad Fikriansyah Ramadhan
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
import java.awt.*;
import javax.swing.*;

public class KeypadPanel extends JPanel{
    /**
	 * Class for the GUI design
	 */

    protected JTextArea text = new JTextArea();
    protected JButton b1 = new JButton("1");
    protected JButton b2 = new JButton("2 abc");
    protected JButton b3 = new JButton("3 def");
    protected JButton b4 = new JButton("4 ghi");
    protected JButton b5 = new JButton("5 jkl");
    protected JButton b6 = new JButton("6 mno");
    protected JButton b7 = new JButton("7 pqrs");
    protected JButton b8 = new JButton("8 tuv");
    protected JButton b9 = new JButton("9 wxyz");
    protected JButton bStar = new JButton("*");;
    protected JButton b0 = new JButton("0 _");;
    protected JButton bHash = new JButton("#");;

    public KeypadPanel(){
        // grid for the layout
        GridLayout layout = new GridLayout(5, 1);

        // set layout 
        setLayout(layout);
        
        // 5 container for the grid layout
        JPanel row1 = new JPanel();
        JPanel row2 = new JPanel();
        JPanel row3 = new JPanel();
        JPanel row4 = new JPanel();
        JPanel row5 = new JPanel();

		// size of the button and text field
        b0.setPreferredSize(new java.awt.Dimension(90, 70));
        b1.setPreferredSize(new java.awt.Dimension(90, 70));
        b2.setPreferredSize(new java.awt.Dimension(90, 70));
        b3.setPreferredSize(new java.awt.Dimension(90, 70));
        b4.setPreferredSize(new java.awt.Dimension(90, 70));
        b5.setPreferredSize(new java.awt.Dimension(90, 70));
        b6.setPreferredSize(new java.awt.Dimension(90, 70));
        b7.setPreferredSize(new java.awt.Dimension(90, 70));
        b8.setPreferredSize(new java.awt.Dimension(90, 70));
        b9.setPreferredSize(new java.awt.Dimension(90, 70));
        bStar.setPreferredSize(new java.awt.Dimension(90, 70));
        bHash.setPreferredSize(new java.awt.Dimension(90, 70));
        text.setColumns(23);
        text.setRows(5);
        text.setText("predictive text: enter text with 8 keys.");


        // adding each components to certain container
        row1.add(text);
        row2.add(b1); row2.add(b2); row2.add(b3);
        row3.add(b4); row3.add(b5); row3.add(b6);
        row4.add(b7); row4.add(b8); row4.add(b9); 
        row5.add(bStar); row5.add(b0); row5.add(bHash);

		// adding each container to the grid
        add(row1);
        add(row2);
        add(row3);
        add(row4);
        add(row5);

        // set uneditable and warp text to the text field
		text.setEditable(false);
        text.setLineWrap(true);
    }
    
    // method to initialize the text on the text field 
	public void setText(String value) {
		text.setText(value);
	}

}
