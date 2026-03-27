package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userForm extends JFrame {
    private JTextField Enteredusername;
    private JPasswordField Enteredpassword;
    private JButton se_connecter;
    private JButton register;

    public userForm() {

        Enteredusername = new JTextField(20);
        Enteredpassword = new JPasswordField(20);
        se_connecter = new JButton("Se connecter");
        register = new JButton("S'inscrire");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row1.add(new JLabel("Nom d'utilisateur : "));
        row1.add(Enteredusername);
        panel.add(row1);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row2.add(new JLabel("Mot de passe : "));
        row2.add(Enteredpassword);
        panel.add(row2);

        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row3.add(se_connecter);
        row3.add(register);
        panel.add(row3);

        setContentPane(panel);

        se_connecter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = Enteredusername.getText();
                String password = new String(Enteredpassword.getPassword());

                user user = new UserDAO().getUser(username, password);

                if (user != null) {

                    JOptionPane.showMessageDialog(null, "Welcome " + user.getUsernName() + "\n Gender : " + user.getGender() );
                } else {

                    JOptionPane.showMessageDialog(null, "Entrer des informations valides !");
                }
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterForm();
            }
        });

        setTitle("User login form");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
