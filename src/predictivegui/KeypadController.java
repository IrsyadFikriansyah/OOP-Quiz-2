package predictivegui;
/*
 * Quiz 2
 * 
 * Made by Irsyad Fikriansyah Ramadhan
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
// The Controller coordinates interactions
// between the View and Model

import java.awt.event.*;

public class KeypadController{
    
    private KeypadView theView;
    private KeypadModel theModel;
    
    public KeypadController(KeypadView theView, KeypadModel theModel){
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addListener0(new Listener());
        this.theView.addListener1(new Listener());
        this.theView.addListener2(new Listener());
        this.theView.addListener3(new Listener());
        this.theView.addListener4(new Listener());
        this.theView.addListener5(new Listener());
        this.theView.addListener6(new Listener());
        this.theView.addListener7(new Listener());
        this.theView.addListener8(new Listener());
        this.theView.addListener9(new Listener());
        this.theView.addListenerStar(new Listener());
        this.theView.addListenerHash(new Listener());
    }

    public void initView(String title) {
        this.theView.init(title);
    }

    class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            theView.setTextArea(theModel.press(s.charAt(0)));
        }       
    }
}
