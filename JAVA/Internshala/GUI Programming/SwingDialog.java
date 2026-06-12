import javax.swing.*;
import java.awt.*;
import java.io.File;

public class SwingDialog {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Swing Dialog Application");
            frame.setSize(400,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JButton filechooser = new JButton("Show File Chooser Dialog");
            filechooser.addActionListener(e -> showfilechooser(frame));

            JButton colorchooser = new JButton("Show Color Chooser Dialog");
            colorchooser.addActionListener(e -> showcolorchooser(frame));

            JButton dialogbtn = new JButton("Show Custom Dialog");
            dialogbtn.addActionListener(e -> showcustomdialog(frame));

            JPanel panel = new JPanel(new FlowLayout());
            
            panel.add(filechooser);
            panel.add(colorchooser);
            panel.add(dialogbtn);

            frame.add(panel);
            frame.setVisible(true);
        });

    }

    private static void showfilechooser(JFrame frame){
        JFileChooser file = new JFileChooser();
        int result = file.showOpenDialog(frame);

        if(result== JFileChooser.APPROVE_OPTION){
            File selectedfile = file.getSelectedFile();
            JOptionPane.showMessageDialog(frame, "Selected File: "+selectedfile.getAbsolutePath(),"file",JOptionPane.INFORMATION_MESSAGE);
      }
      else
      {
        JOptionPane.showMessageDialog(frame, "File Selection Cancelled ", "file", JOptionPane.WARNING_MESSAGE);
      }
    }

    private static void showcolorchooser(JFrame frame){
        Color selectedColor = JColorChooser.showDialog(frame, "Choose a Color", Color.RED);
        if(selectedColor != null){
            JOptionPane.showMessageDialog(frame,"Selected Color: " +selectedColor,"Color Chooser",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(frame,"Color Selected Cancelled","Color Chooser",JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void showcustomdialog(JFrame frame){

        JDialog customdialog = new JDialog(frame,"Custom Dialog", true);
        customdialog.setSize(100,200);

        JLabel label = new JLabel("This is a custom dialog");
        JButton closebtn = new JButton("Close");
        closebtn.addActionListener(e -> customdialog.dispose());

        customdialog.setLayout(new BorderLayout());
        customdialog.add(label,BorderLayout.CENTER);

        customdialog.add(closebtn,BorderLayout.WEST);

        customdialog.setVisible(true);
    }
}
