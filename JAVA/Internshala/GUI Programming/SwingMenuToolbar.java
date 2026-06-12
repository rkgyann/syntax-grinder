import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class SwingMenuToolbar {
    public static void main(String[] args) {
        
        //menubar
        JFrame frame = new JFrame("Swing Menu and Toolbar");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create a menu bar
        JMenuBar menubar = new JMenuBar();

        //menu- filemenu
        JMenu filemenu = new JMenu("File");

        //menu items
        JMenuItem newitem = new JMenuItem("New");
        JMenuItem openitem = new JMenuItem("Open");
        JMenuItem saveitem = new JMenuItem("Save");
        JMenuItem exititem = new JMenuItem("Exit");

        //add-> filemenu
        filemenu.add(newitem);
        filemenu.add(openitem);
        filemenu.add(saveitem);
        filemenu.addSeparator();
        filemenu.add(exititem);

        //create edit menu
        JMenu editmenu = new JMenu("Edit");
        JMenuItem cutitem = new JMenuItem("Cut");
        JMenuItem copyitem = new JMenuItem("Copy");
        JMenuItem pasteitem = new JMenuItem("Paste");

        JMenu submenu = new JMenu("Submenu");
        JCheckBoxMenuItem checkitem = new JCheckBoxMenuItem("Checkable Item");

        submenu.add(checkitem);
        editmenu.add(cutitem);
        editmenu.add(copyitem);
        editmenu.add(pasteitem);
        editmenu.addSeparator();
        editmenu.add(submenu);

        //add to menu bar
        menubar.add(filemenu);
        menubar.add(editmenu);

        //add menubar to frame
        frame.setJMenuBar(menubar);

        //toolbar
        JToolBar toolbar = new JToolBar("Toolbar");
        JButton newbtn = new JButton(new ImageIcon("new.png"));
        JButton openbtn = new JButton(new ImageIcon("open.png"));
        JButton savebtn = new JButton(new ImageIcon("save.png"));
        JButton cutbtn = new JButton(new ImageIcon("cut.png"));

        newbtn.addActionListener(e -> showMessage("New Button Clicked"));
        openbtn.addActionListener(e -> showMessage("Open Button Clicked"));
        savebtn.addActionListener(e -> showMessage("Save Button Clicked"));
        cutbtn.addActionListener(e -> showMessage("Cut Button Clicked"));

        //add to toolbar
        toolbar.add(newbtn);
        toolbar.add(openbtn);
        toolbar.add(savebtn);
        toolbar.add(cutbtn);

        frame.add(toolbar,BorderLayout.NORTH);

        frame.setVisible(true);


    }

    private static void showMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.INFORMATION_MESSAGE);

    }
}
