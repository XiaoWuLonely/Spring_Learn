package cla.Ja251128;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button");
        JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() {
            private int clickCount = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++;
                System.out.print(clickCount);
                JOptionPane.showMessageDialog(frame, "点击了" + clickCount + "次");
            }
        });
        frame.add(button);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
