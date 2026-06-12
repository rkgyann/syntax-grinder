import java.awt.*;
import java.awt.event.*;
public class AWT_Application {
    public static void main(String[] args) {
        
        //frame
        final Frame frame = new Frame("AWT Appliaction");

        //label
        Label label = new Label("Name: ");
        label.setBounds(50,50,50,20);

        //text field
        TextField text = new TextField(); //inut area
        text.setBounds(110,50,150,20);

        //button
        Button btn = new Button("Submit");
        btn.setBounds(110,90,100,20);

        //check box
        Checkbox chk = new Checkbox("I agree to terms and condition");
        chk.setBounds(110,120,200,20);

        //RadioButtons
        CheckboxGroup chk_group = new CheckboxGroup();
        Checkbox radio1 = new Checkbox("Optiona1",chk_group, false);
        Checkbox radio2 = new Checkbox("Optiona2",chk_group, false);
        radio1.setBounds(110,150,100,20);
        radio2.setBounds(220,150,100,20);

        //list
        List lst = new List();
        lst.setBounds(110,180,120,80);
        lst.add("Laptop");
        lst.add("Mouse");
        lst.add("SmartPhone");

        //Scroll Bar
        Scrollbar sb = new Scrollbar();
        sb.setBounds(250,180,20,80);


        frame.add(label);
        frame.add(text);
        frame.add(btn);
        frame.add(chk);
        frame.add(radio1);
        frame.add(radio2);
        frame.add(lst);
        frame.add(sb);

        frame.setSize(400,400);
        //window listener - interface window event.
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                //close the frame
                frame.dispose();
            }
        });
        frame.setVisible(true);

    }
}
