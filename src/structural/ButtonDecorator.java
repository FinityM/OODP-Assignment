package structural;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonDecorator extends Decorator {
    boolean mouse_over;
    JComponent thisComp;

    public ButtonDecorator(JComponent c) {
        super(c);
        mouse_over = false;
        thisComp = this;

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouse_over = true;
                thisComp.repaint();
            }

            public void mouseExited(MouseEvent e) {
                mouse_over = false;
                thisComp.repaint();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);

        if (mouse_over) {
            Dimension d = super.getSize();
            g.setColor(Color.RED);
            g.drawRect(0, 0, d.width - 1, d.height - 1);
            g.drawLine(d.width - 2, 0, d.width - 2, d.height - 1);
            g.drawLine(0, d.height - 2, d.width - 2, d.height - 2);
        }

    }

}
