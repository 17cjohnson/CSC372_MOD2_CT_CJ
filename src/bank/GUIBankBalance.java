package bank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIBankBalance {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        String startText = JOptionPane.showInputDialog("Make your first deposit here");
        if (startText == null || startText.trim().isEmpty()) {
            startText = "0";
        }

        try {
            double startBalance = Double.parseDouble(startText);
            account.deposit(startBalance);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid number.");
        }

        JFrame frame = new JFrame("GUI for Bank Balance");
        frame.setSize(420, 160);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel balanceLabel = new JLabel("Balance: $" + account.getBalance());
        JTextField amountField = new JTextField(10);

        JButton depositButton = new JButton("Deposit Funds");
        JButton withdrawButton = new JButton("Withdraw Funds");
        JButton exitButton = new JButton("Exit");

        panel.add(balanceLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == exitButton) {
                    JOptionPane.showMessageDialog(frame, "Your Remaining Balance Is: $" + account.getBalance());
                    System.exit(0);
                }

                String text = amountField.getText().trim();
                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Enter an amount first.");
                    return;
                }

                double amount;
                try {
                    amount = Double.parseDouble(text);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Enter a valid number.");
                    return;
                }

                if (e.getSource() == depositButton) {
                    account.deposit(amount);
                } else if (e.getSource() == withdrawButton) {
                    account.withdrawal(amount);
                }

                balanceLabel.setText("Balance: $" + account.getBalance());
                amountField.setText("");
            }
        };

        depositButton.addActionListener(listener);
        withdrawButton.addActionListener(listener);
        exitButton.addActionListener(listener);
    }
}
