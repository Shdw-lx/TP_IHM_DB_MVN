package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame {
    private JTextField EnteredUserId;
    private JTextField EnteredUsername;
    private JTextField EnteredPassword;
    private JTextField EnteredGender;
    private JButton register;

    public RegisterForm() {

        EnteredUserId = new JTextField(20);
        EnteredUsername = new JTextField(20);
        EnteredPassword = new JTextField(20);
        EnteredGender = new JTextField(20);
        register = new JButton("S'inscrire");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row1.add(new JLabel("ID Utilisateur : "));
        row1.add(EnteredUserId);
        panel.add(row1);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row2.add(new JLabel("Nom Utilisateur : "));
        row2.add(EnteredUsername);
        panel.add(row2);

        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row3.add(new JLabel("Mot de passe : "));
        row3.add(EnteredPassword);
        panel.add(row3);

        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row4.add(new JLabel("Genre"));
        row4.add(EnteredGender);
        panel.add(row4);

        JPanel row5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row5.add(register);
        panel.add(row5);

        setContentPane(panel);

        register.addActionListener(e -> {

            int userId = Integer.parseInt(EnteredUserId.getText());
            String username = EnteredUsername.getText();
            String password = EnteredPassword.getText();
            String gender = EnteredGender.getText();

            user user = new user(userId, username, password, gender);

            UserDAO dao = new UserDAO();

            if (dao.createUser(user)) {

                JOptionPane.showMessageDialog(null, username + ", votre compte a été créé avec succès !");
            } else {

                JOptionPane.showMessageDialog(null, "Echec lors de l'inscription !");
            }
        });

        setTitle("Formulaire d'inscription");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
}
