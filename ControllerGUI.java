import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ControllerGUI extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(100, 0, 100, 100);
        g.fillRect(300, 100, 100, 100);
        g.fillRect(200, 300, 100, 100);
        g.fillRect(0, 200, 100, 100);

    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Lights");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ControllerGUI());
        frame.setSize(400, 425);
        frame.setVisible(true);
    }
}
