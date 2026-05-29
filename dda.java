import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class dda extends Applet implements ActionListener {
    TextField t1, t2, t3, t4;
    Button b;
    Label L1, L2, L3, L4;

    public void init() {
        L1 = new Label("x1 = ");
        L2 = new Label("x2 = ");
        L3 = new Label("y1 = ");
        L4 = new Label("y2 = ");

        t1 = new TextField(3);
        t2 = new TextField(3);
        t3 = new TextField(3);
        t4 = new TextField(3);

        b = new Button("Draw");
        b.addActionListener(this);

        add(L1); add(t1);
        add(L2); add(t2);
        add(L3); add(t3);
        add(L4); add(t4);
        add(b);
    }

    public void paint(Graphics g) {
        try {
            int x1 = Integer.parseInt(t1.getText());
            int y1 = Integer.parseInt(t3.getText());
            int x2 = Integer.parseInt(t2.getText());
            int y2 = Integer.parseInt(t4.getText());

            int dx = x2 - x1;
            int dy = y2 - y1;
            int step = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);

            float xinc = (float) dx / step;
            float yinc = (float) dy / step;

            float x = x1;
            float y = y1;

            for (int i = 0; i <= step; i++) {
                g.drawString(".", Math.round(x), Math.round(y));
                x += xinc;
                y += yinc;
            }
        } catch (Exception e) {
            g.drawString("Enter valid integers!", 50, 50);
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

/* 
<applet code="dda.class" width="500" height="500"></applet>
*/
