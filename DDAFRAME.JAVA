import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DDAFrame extends JFrame implements ActionListener {
    JTextField t1, t2, t3, t4;
    JButton b;
    int x1, y1, x2, y2;
    boolean draw = false;

    public DDAFrame() {
        setTitle("DDA Line Drawing");
        setSize(500, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("x1 ="));
        t1 = new JTextField(3); add(t1);
        add(new JLabel("y1 ="));
        t2 = new JTextField(3); add(t2);
        add(new JLabel("x2 ="));
        t3 = new JTextField(3); add(t3);
        add(new JLabel("y2 ="));
        t4 = new JTextField(3); add(t4);

        b = new JButton("Draw");
        b.addActionListener(this);
        add(b);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            x1 = Integer.parseInt(t1.getText());
            y1 = Integer.parseInt(t2.getText());
            x2 = Integer.parseInt(t3.getText());
            y2 = Integer.parseInt(t4.getText());
            draw = true;
            repaint();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid integers!");
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (!draw) return;

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
    }

    public static void main(String[] args) {
        new DDAFrame();
    }
}
