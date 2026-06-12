import javax.swing.*;
import java.awt.*;

class CustomPaintComponents extends JPanel{
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //custom pint logic
        g.setColor(Color.BLUE);
        g.fillRect(50,50,100,100);
        g.setColor(Color.RED);
        g.fillOval(150,50,100,100);
    }
}

//custom look & feel
class CustomLookAndFeel{
    public static void setCustomLookAndFeel() {
        try{
            UIManager.setLookAndFeel(null);
        }
    }
}

public class SwingPaint {
    
}
