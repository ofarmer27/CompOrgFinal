package traffic.controller;

// import src.main.java.traffic.interfaces.LinkedCircularQueue;
// import src.main.java.traffic.interfaces.LinkedQueue;
import traffic.model.LightController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ApplicationDriver extends JPanel
{
    private JFrame frame;

    private JPanel btnPanel; 
    private JButton btnStart;
    private JButton btnStop;
    public static String color; 
    private Color red = Color.RED;
    private Color yellow = Color.YELLOW;
    private Color green = Color.GREEN;
    private Color lightColor;
    
    private String[][] lightStrings= { { "NB", "NBLT" }, { "SB", "SBLT" }, { "EB", "EBLT" }, { "WB", "WBLT" } };
    private String[] directions = { "NORTH", "SOUTH", "EAST", "WEST" };
    private TrafficLightPanel[] lights = new TrafficLightPanel[8];
    
    static String[] stateSequences = { "12a34a", "56a78a" };
    

    ApplicationDriver()
    {
        frame = new JFrame("Traffic Light Simulation");
        frame.setBounds(100, 100, 700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel lightDisplayPanel = new JPanel();
        lightDisplayPanel.setLayout(new BorderLayout());

        JPanel nLights = new JPanel(new GridLayout(1, 2));
        nLights.setMinimumSize(new Dimension(getWidth(), 100));
        JPanel sLights = new JPanel(new GridLayout(1, 2));
        sLights.setMinimumSize(new Dimension(getWidth(), 100));
        JPanel eLights = new JPanel(new GridLayout(2, 1));
        eLights.setMinimumSize(new Dimension(30, getHeight()-200));
        JPanel wLights = new JPanel(new GridLayout(2, 1));
        wLights.setMinimumSize(new Dimension(30, getHeight()-200));

        int index = 0;
        for (int i = 0; i < lightStrings.length; i++)
        {
            for (int j = 0; j < lightStrings[i].length; j++) {
                lights[index] = new TrafficLightPanel(lightStrings[i][j], directions[i]);
                index++;
            }
        }
        index = 0;
        for (int i = 0; i < lights.length; i++)
        {
            switch (lights[i].direction) {
                case "NORTH":
                    nLights.add(lights[i]);
                    break;
                case "SOUTH":
                    sLights.add(lights[i]);
                    break;
                case "EAST":
                    eLights.add(lights[i]);
                    break;
                case "WEST":
                    wLights.add(lights[i]);
                    break;
            
                default:
                    break;
            }
        }



        lightDisplayPanel.add(nLights, BorderLayout.NORTH);
        lightDisplayPanel.add(sLights, BorderLayout.SOUTH);
        lightDisplayPanel.add(eLights, BorderLayout.EAST);
        lightDisplayPanel.add(wLights, BorderLayout.WEST);
        
        frame.getContentPane().add(lightDisplayPanel, BorderLayout.CENTER);

        btnPanel = new JPanel();
        frame.getContentPane().add(btnPanel, BorderLayout.NORTH);

        btnStart = new JButton("Start");
        btnStart.addActionListener(e -> 
        {
            
        }
        );

        btnStop = new JButton("Stop");
        btnStop.addActionListener(e -> {
            
        });

        btnPanel.add(btnStart);
        btnPanel.add(btnStop);

        
    }

    public static class TrafficLightPanel extends JPanel {
        String currColor;
        Color lightColor;
        String ID;
        String direction; 

        public TrafficLightPanel(String ID, String direction)
        {
            this.ID = ID;
            this.direction = direction; 
            setPreferredSize(new Dimension(50, 50));  // Proper sizing
            setMaximumSize(new Dimension(50, 50));
            setMinimumSize(new Dimension(50, 50));

        }
        
        public void start() {
            LightController controller = new LightController(stateSequences);
            controller.startCycle();
        }

        public void stop() {
            lightColor = Color.red;
            repaint();
        }

        public void repaintByID(String ID, Color color)
        {
            switch (currColor) {
                case "RED":
                    lightColor = Color.RED; 
                    break;
                case "YELLOW":
                    lightColor = Color.RED;
                    break;
                case "GREEN":
                    lightColor = Color.GREEN;
                    break; 
            
                default:
                    break;
            }

        } 

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            int diameter = Math.min(getWidth(), getHeight() - 10);
            int x = (getWidth() - diameter) / 2; 
            int y = (getHeight() - diameter) / 2; 
            g.setColor(lightColor);
            g.fillOval(x, y , diameter, diameter);

        }
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            try {
                ApplicationDriver window = new ApplicationDriver();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    
}