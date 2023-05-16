import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Chatbot extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextArea chatArea = new JTextArea();
    private JTextField userInputField = new JTextField();
    private JButton sendButton = new JButton("SEND");

    Chatbot() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 400);
        getContentPane().setBackground(Color.CYAN);
        setTitle("ChatBot");
        setLayout(null);

        chatArea.setSize(300, 310);
        chatArea.setLocation(1, 1);
        chatArea.setBackground(Color.BLACK);
        chatArea.setForeground(Color.GREEN);
        chatArea.setEditable(false);
        add(chatArea);

        userInputField.setSize(300, 20);
        userInputField.setLocation(1, 320);
        add(userInputField);

        sendButton.setSize(400, 20);
        sendButton.setLocation(300, 320);
        add(sendButton);

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userText = userInputField.getText().toLowerCase();
                chatArea.append("You --> " + userText + "\n");
                userInputField.setText("");

                if (userText.contains("hi")) {
                    replyMethod("Hi there! How may I assist you today?");
                } else if (userText.contains("how are you")) {
                    replyMethod("I'm good :) Thank you for asking. How are you?");
                } else if (userText.contains("I have a problem with my login")) {
                    replyMethod("I can help you with that. Please tell me what is the problem that you're having.");
                } else if (userText.contains("I can't log into my account")) {
                    replyMethod("Sorry to hear that. Would you like to reset your password?");
                } else if (userText.contains("yes")) {
                    replyMethod("Okay, Please enter your email address so I can send you the password reset link.");
                } else if (userText.contains("thank you, I have received the link")) {
                    replyMethod("You're welcome! Is there anything else I can help you with today?");
                } else if (userText.contains("No, Thank you")) {
                
                } else {
                    replyMethod("Have a great day!");
                }
            }
        });
    }

    public void replyMethod(String reply) {
        chatArea.append("ChatBot --> " + reply + "\n");
    }
}

public class ChatBotDemo {
    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot();
        chatbot.setVisible(true);
    }
}
