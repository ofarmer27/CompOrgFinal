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

public class ApplicationDriver extends JPanel {
    public static boolean isRunning = true;
    private JFrame frame;
    private Timer timer; 
    private JPanel btnPanel;
    private JButton btnStart;
    private JButton btnStop;
    public static String color;
    
    // public Color lightColor;

    private String[][] lightStrings = { { "NB", "NBLT" }, { "SB", "SBLT" }, { "EB", "EBLT" }, { "WB", "WBLT" } };
    private String[] directions = { "NORTH", "SOUTH", "EAST", "WEST" };
    public static TrafficLightPanel[] lights = new TrafficLightPanel[8];

    static String[] stateSequences = { "12a34a", "56a78a" };

    ApplicationDriver() {

        frame = new JFrame("Traffic Light Simulation");
        frame.setBounds(100, 100, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel lightDisplayPanel = new JPanel();
        lightDisplayPanel.setLayout(new BorderLayout());

        JPanel nLights = new JPanel();
        nLights.setLayout(new BoxLayout(nLights, BoxLayout.Y_AXIS));
        nLights.setAlignmentX(CENTER_ALIGNMENT);
        nLights.setMinimumSize(new Dimension(getWidth(), 100));

        JPanel sLights = new JPanel();
        sLights.setLayout(new BoxLayout(sLights, BoxLayout.Y_AXIS));
        sLights.setAlignmentX(Component.CENTER_ALIGNMENT);
        sLights.setMinimumSize(new Dimension(getWidth(), 100));

        JPanel eLights = new JPanel();
        eLights.setLayout(new BoxLayout(eLights, BoxLayout.X_AXIS));
        eLights.setAlignmentX(Component.CENTER_ALIGNMENT);
        eLights.setMinimumSize(new Dimension(30, getHeight() - 200));

        JPanel wLights = new JPanel();
        wLights.setLayout(new BoxLayout(wLights, BoxLayout.X_AXIS));
        wLights.setAlignmentX(Component.CENTER_ALIGNMENT);
        wLights.setAlignmentY(Component.CENTER_ALIGNMENT);
        wLights.setMinimumSize(new Dimension(30, getHeight() - 200));

        int index = 0;
        for (int i = 0; i < lightStrings.length; i++) {
            for (int j = 0; j < lightStrings[i].length; j++) {
                lights[index] = new TrafficLightPanel(lightStrings[i][j], directions[i]);
                
                index++;
            }
        }
        index = 0;
        for (int i = 0; i < lights.length; i++) {
            switch (lights[i].direction) {
                case "NORTH":
                    nLights.add(lights[i]);
                    break;
                case "SOUTH":
                    sLights.add(lights[i]);
                    break;
                case "EAST":
                    eLights.add(lights[i]);
                    if (i % 2 == 0) eLights.add(Box.createVerticalStrut(10)); // spacing
                    break;
                case "WEST":
                    wLights.add(lights[i]);
                    if (i % 2 == 0) wLights.add(Box.createVerticalStrut(10)); // spacing
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
        btnStart.addActionListener(e -> {
            Thread thread = new Thread(() -> {
                LightController controller = new LightController(stateSequences);
                controller.startCycle();
            });
            thread.start();
        });


        btnStop = new JButton("Stop");
        btnStop.addActionListener(e -> {
            stop();
        });

        btnPanel.add(btnStart);
        btnPanel.add(btnStop);

       

    }

    public static class TrafficLightPanel extends JPanel {
        String currColor;
        Color lightColor;
        String ID;
        String direction;

        public TrafficLightPanel(String ID, String direction) {
            this.lightColor = Color.RED;
            this.ID = ID;
            this.direction = direction;

            setPreferredSize(new Dimension(50, 50)); // Proper sizing
            setMaximumSize(new Dimension(50, 50));
            setMinimumSize(new Dimension(50, 50));
            setBackground(Color.WHITE);

        }

        public void changeLightColor(Color color) {
            lightColor = color;
            repaint();
        }

        public String getID() {
            return this.ID;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Fill background with white
            setBackground(Color.WHITE);
        
            // Draw the circle
            int diameter = Math.min(getWidth(), getHeight()) - 10;
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;
        
            g.setColor(lightColor);
            g.fillOval(x, y, diameter, diameter);
        
            // Draw the label text inside the circle
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 12));
        
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(ID);
            int textHeight = fm.getAscent();
        
            int textX = x + (diameter - textWidth) / 2;
            int textY = y + (diameter + textHeight) / 2 - 3;
        
            g.drawString(ID, textX, textY);
        }
    }

   

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                ApplicationDriver window = new ApplicationDriver();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void start() {
        LightController controller = new LightController(stateSequences);
        controller.startCycle();
        isRunning = true;

    }

    public void stop() 
    {
        isRunning = false; 
    }

}