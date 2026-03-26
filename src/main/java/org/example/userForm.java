package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userForm {
    private JTextField Enteredusername;
    private JPasswordField Enteredpassword;
    private JButton se_connecter;

    public userForm() {

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
    }
}
