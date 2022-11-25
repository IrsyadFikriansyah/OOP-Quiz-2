package predictivegui;
/*
 * Quiz 2
 * 
 * Made by Irsyad Fikriansyah Ramadhan
 * -- 24 November 2022
 * IF184301 Object Oriented Programming (E)
 * 
 */
public class MVCKeypad{

    public static void main(String[] args) {
        
        // model view
        KeypadView theView = new KeypadView();

        // model object
        KeypadModel theModel = new KeypadModel();

        // controller object
        KeypadController theController = new KeypadController(theView, theModel);

        // init GUI frame
        theController.initView("Predictive Text");
        
    }

}