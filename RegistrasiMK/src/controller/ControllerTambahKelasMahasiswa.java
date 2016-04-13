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
import view.TambahKelasMahasiswa;

/**
 *
 * @author M. Yuslan Abubakar
 */
public class ControllerTambahKelasMahasiswa implements ActionListener {
    private Aplikasi app;
    private TambahKelasMahasiswa view;
    
    public ControllerTambahKelasMahasiswa() {
        app = new Aplikasi();
        view = new TambahKelasMahasiswa();
        view.setVisible(true);
        view.addListener(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        ArrayList<String> listKelas = new ArrayList();
        for (int i = 0; i < app.getListKelasFromFile().size(); i++) {
            String s = (i+1) + ". " + app.getListKelasFromFile().get(i).getNamaKelas()
                    + " - " + app.getListKelasFromFile().get(i).getMatakuliah().getnamaMK()
                    + " - " + app.getListKelasFromFile().get(i).getDosen().getNama();
            listKelas.add(s);
        }
        view.setListKelas(listKelas.toArray(new String[0]));
        view.setComboPilihan(listKelas.toArray(new String[0]));
        
        if (source.equals(view.getBtnSave())) {
            
        }
    }
}
