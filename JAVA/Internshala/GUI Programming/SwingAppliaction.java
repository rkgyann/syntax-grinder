import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingAppliaction {
    public static void main(String[] args) {
        
        //frame
        JFrame frame = new JFrame("Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        
        
        //JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7,2,10,10));

        //Labels
        JLabel name = new JLabel(" Name: ");
        JLabel email = new JLabel(" Email: ");
        JLabel password = new JLabel(" Password: ");
        JLabel gender = new JLabel(" Gender: ");
        JLabel interest = new JLabel(" Interest: ");

        //TextFeild
        JTextField nametext = new JTextField();
        JTextField emailtext = new JTextField();
        JPasswordField passwordtext = new JPasswordField();

        //radio
        JRadioButton male= new JRadioButton("Male");
        JRadioButton female= new JRadioButton("Female");
        ButtonGroup genderGroup =new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        //Checkbox
        JCheckBox programming = new JCheckBox("Pragramming");
        JCheckBox reading = new JCheckBox("Reading");
        JCheckBox travelling = new JCheckBox("Travelling");

        //button
        JButton submit = new JButton(" Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String name = nametext.getText();
                String email = emailtext.getText();
                char[] password = passwordtext.getPassword();
                String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "Not specified");
                String interest = "";
                if(programming.isSelected())
                    interest += "Programming ";
                if(reading.isSelected())
                    interest += "Reading ";
                if(travelling.isSelected())
                    interest += "Travelling ";

                String message = "Name: "+name+"\nEmail: "+email+"\nGender: "+gender+"\nInterest: "+interest;
                JOptionPane.showMessageDialog(frame, message,"Registration Successfull",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //add
        panel.add(name);
        panel.add(nametext);
        panel.add(email);
        panel.add(emailtext);
        panel.add(password);
        panel.add(passwordtext);
        panel.add(gender);
        panel.add(male);
        panel.add(female);
        
        panel.add(interest);
        panel.add(programming);
        panel.add(reading);
        panel.add(travelling);
        panel.add(submit);

        frame.add(panel);
        frame.setVisible(true);
        
    }
}