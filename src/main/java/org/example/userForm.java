package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userForm extends JFrame {
    private JTextField Enteredusername;
    private JPasswordField Enteredpassword;
    private JButton se_connecter;

    public userForm() {

        Enteredusername = new JTextField(100);
        Enteredpassword = new JPasswordField(255);
        se_connecter = new JButton("Se connecter");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Nom utilisateur :"));
        panel.add(Enteredusername);
        panel.add(new JLabel("Mot de passe : "));
        panel.add(Enteredpassword);
        panel.add(se_connecter);

        setContentPane(panel);

        se_connecter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = Enteredusername.getText();
                String password = new String(Enteredpassword.getPassword());

                user user = new UserDAO().getUser(username, password);

                if (user != null) {

                    JOptionPane.showMessageDialog(null, "Welcome " + user.getUsernName() + "\n Gender : " + user.getGender() );
                }
            }
        });

        setTitle("User login form");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
