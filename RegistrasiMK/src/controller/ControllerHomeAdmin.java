/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        
        view.inputData(app.getListKelasFromFile());
        
        view.setTxFieldNIP(app.getAdminFromFile().getID());
        view.setTxFieldNama(app.getAdminFromFile().getNama());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if(source.equals(view.getBtnTambahKelas())) {
            ControllerTambahKelasAdmin tka = new ControllerTambahKelasAdmin();
        } else if(source.equals(view.getBtnTambahMatkul())) {
            ControllerTambahMatkulAdmin tma = new ControllerTambahMatkulAdmin();
        } else if(source.equals(view.getBtnTambahDsnKls())) {
            ControllerTambahDosenkeKelasAdmin tdka = new ControllerTambahDosenkeKelasAdmin();
        } else if(source.equals(view.getBtnTambahMatkulKls())) {
            ControllerTambahMatkulkeKelasAdmin tmka = new ControllerTambahMatkulkeKelasAdmin();
        } else if(source.equals(view.getBtnLogout())) {
            ControllerLoginAdmin cla = new ControllerLoginAdmin();
            view.dispose();
        }
    }
    
    
}
