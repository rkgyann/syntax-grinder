import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class SwingAdvanced {
    public static void main(String[] args) {
        
        // real time - task manager -> tasks, priority, time

        JFrame frame = new JFrame("Task Manager");

        //task table 
        String[] colnames = {"Task", "Category", "Priority","Completion"};
        Object[][] data = {
            {"Task1","Work","High",30},
            {"Task2","Personal","Medium",60},
            {"Task3", "Work","Low",70}
        };

        //JTable 
        JTable tasktable = new JTable(new DefaultTableModel(data, colnames));

        //ScrollPane
        JScrollPane tablescrollpane = new JScrollPane(tasktable);

        //JTree
        //root
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Category");
        DefaultMutableTreeNode worknode = new DefaultMutableTreeNode("Work");
        DefaultMutableTreeNode personalnode = new DefaultMutableTreeNode("Personal");
        root.add(worknode);
        root.add(personalnode);

        JTree tasktree = new JTree(root);
        JScrollPane treescrollpane = new JScrollPane(tasktree);


        //list
        String[] prioritylevels = {"High","Medium","Low"};
        JList<String> prioritylist = new JList<>(prioritylevels);
        JScrollPane listscrollpane = new JScrollPane(prioritylist);

        //tabbed pane
        JTabbedPane tabpane = new JTabbedPane();
        tabpane.add("All Tasks", tablescrollpane);
        tabpane.add("Categories", treescrollpane);
        tabpane.add("Priority List", listscrollpane);

        //JProgressBar
        JProgressBar progress = new JProgressBar();
        progress.setStringPainted(true);

        //JSlider
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // sync slider with progress bar
        slider.addChangeListener(e -> progress.setValue(slider.getValue()));

        // initialize progress with slider's value
        progress.setValue(slider.getValue());

        //spinner
        SpinnerModel spinner = new SpinnerNumberModel(3, 1, 10, 1);
        JSpinner taskspinner = new JSpinner(spinner);

        //layout
        frame.setLayout(new BorderLayout());
        frame.add(tabpane, BorderLayout.CENTER);
        frame.add(createprioritypanel(slider), BorderLayout.SOUTH);
        frame.add(createprogresspanel(progress), BorderLayout.NORTH);
        frame.add(createspinnerpanel(taskspinner), BorderLayout.EAST);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setVisible(true);

    }

    private static JPanel createprioritypanel (JSlider slider){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Task Priority: "));
        panel.add(slider);

        return panel;
    }

    private static JPanel createprogresspanel(JProgressBar progress){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Task Completion: "));
        panel.add(progress);
        
        return panel;
    }

    private static JPanel createspinnerpanel(JSpinner taskspinner){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Number of Tasks: "));
        panel.add(taskspinner);
        
        return panel;
    }
}
