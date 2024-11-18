import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class NameEnter extends JFrame implements ActionListener {

    JButton button;
    JTextField textField;

    public NameEnter() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("Consolas", Font.PLAIN, 35));

        button = new JButton("Enter");
        button.addActionListener(this);
        textField.setForeground(Color.GREEN);
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.GREEN);

        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button && !Objects.equals(textField.getText(), "")) {
            Menu.playerName = textField.getText();
            this.setVisible(false);
        }
    }
}
