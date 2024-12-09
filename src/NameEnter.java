import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
        try {
            if (e.getSource() == button && !Objects.equals(textField.getText(), "") && !Game.isItThere(textField.getText())) {
                Menu.playerName = textField.getText();
                Game.dbSet(Game.conn, "UPDATE stats SET userName = " + textField.getText() + " WHERE userName = " + Menu.playerName);
                this.setVisible(false);
            } else if (Game.isItThere(textField.getText())) {
                this.setVisible(false);
                Menu.chooseNewName = true;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
