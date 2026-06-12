import java.awt.*;
import java.awt.event.*;

public class AWTLayoutApplication {
    public static void main(String[] args) {
        Frame frame = new Frame("AWT Layout Manager Application");

       /* //flow layout
        FlowLayout flowobj = new FlowLayout();

        //Panel -> simplest container
        Panel flowpanel = new Panel(flowobj);

        //add components
        flowpanel.add(new Button("Button 1"));
        flowpanel.add(new Button("Button 2"));
        flowpanel.add(new Button("Button 3"));
        flowpanel.add(new Button("Button 4"));
        flowpanel.add(new Button("Button 5"));

        frame.add(flowpanel);

        //border layout 
        BorderLayout boarderobj = new BorderLayout();
        frame.setLayout(boarderobj);

        Button button6 = new Button("Button 6"); 
        Button button7 = new Button("Button 7");
        Button button8 = new Button("Button 8");

        //add components
        frame.add(button6,BorderLayout.NORTH);
        frame.add(button7,BorderLayout.CENTER);
        frame.add(button8,BorderLayout.SOUTH);
        */

        //grid layout
        GridLayout gridobj= new GridLayout(3,2);
        Panel gridpanel = new Panel(gridobj);

        gridpanel.add(new Button("Buutton 9"));
        gridpanel.add(new Button("Buutton 10"));
        gridpanel.add(new Button("Buutton 11"));
        gridpanel.add(new Button("Buutton 12"));

        frame.add(gridpanel);
      
        // Handle window closing
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
 