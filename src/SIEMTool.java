import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SIEMTool extends JFrame implements ActionListener {
    private JTextArea eventLogTextArea;
    private JButton logEventButton;

    public SIEMTool() {
        setTitle("SIEM Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        eventLogTextArea = new JTextArea();
        eventLogTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(eventLogTextArea);

        logEventButton = new JButton("Log Event");
        logEventButton.addActionListener(this);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(logEventButton, BorderLayout.SOUTH);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logEventButton) {
            String event = JOptionPane.showInputDialog(this, "Enter Event Description:");
            logEvent(event);
        }
    }

    private void logEvent(String event) {
        // Perform necessary operations to log the event, such as storing in a database or writing to a log file.
        // You can implement the required code to handle event logging based on your specific requirements.

        eventLogTextArea.append(event + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SIEMTool siemTool = new SIEMTool();
            siemTool.setVisible(true);
        });
    }
}
