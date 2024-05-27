package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JButton {
    public ExitButton () {
        setLayout(null);
        setBackground(null);
        setBorder(null);
        setContentAreaFilled(false);
        setOpaque(false);

        JLabel title = new JLabel("X");
        
        title.setForeground(Color.white);
        title.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        title.setBounds(0,2,35,35);
        add(title);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            
            Page_nhaplieu page = new Page_nhaplieu();
            page.thoatAES();
                
                /// OK
            }
        });

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#111111"), w, h, Color.decode("#111111"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,40,40);
    }
}
