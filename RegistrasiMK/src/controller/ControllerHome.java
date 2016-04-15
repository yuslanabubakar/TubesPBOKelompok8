/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Home;

/**
 *
 * @author Rona
 */
public class ControllerHome implements ActionListener{
    private Home view;

    public ControllerHome (){
        view = new Home();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(view.getBtnAdmin())) {
            ControllerLoginAdmin cla = new ControllerLoginAdmin();
            view.dispose();
        }
        else if (source.equals(view.getBtnMhs())) {
            ControllerLoginMahasiswa clm = new ControllerLoginMahasiswa();
            view.dispose();
        }
        else if (source.equals(view.getBtnKeluar())) {
            JOptionPane.showMessageDialog(null, "Thank you");
            System.exit(0);
        }
    }
    
}
