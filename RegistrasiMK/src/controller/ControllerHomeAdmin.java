/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Aplikasi;
import view.HomeAdmin;

/**
 *
 * @author dhivazhr
 */
public class ControllerHomeAdmin implements ActionListener{
    private HomeAdmin view;
    private Aplikasi app;

    public ControllerHomeAdmin() {
        view = new HomeAdmin();
        app = new Aplikasi();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
    }
    
    
}
