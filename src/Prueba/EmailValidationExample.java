
package Prueba;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class EmailValidationExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Email Validation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            
            
            JTextField emailField = new JTextField(20);
            JLabel validationLabel = new JLabel(" ");
            
            emailField.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    validationEmail();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    validationEmail();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    validationEmail();
                }
                
                private void validationEmail() {
                    String emailText = emailField.getText();
                    if (EmailValidator.validate(emailText)) {
                        validationLabel.setText("Valid email");
                        validationLabel.setForeground(Color.green);
                    } else {
                        validationLabel.setText("Invalid email");
                        validationLabel.setForeground(Color.red);
                    }
                }
            });
            
            frame.add(emailField);
            frame.add(validationLabel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
