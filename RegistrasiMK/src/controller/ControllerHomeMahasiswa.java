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
import view.HapusKelasMahasiswa;
import view.Home;
import view.HomeMahasiswa;
import view.TambahKelasMahasiswa;

/**
 *
 * @author M. Yuslan Abubakar
 */
public class ControllerHomeMahasiswa implements ActionListener {
    private Aplikasi app;
    private HomeMahasiswa view;
    
    public ControllerHomeMahasiswa() {
        app = new Aplikasi();
        view = new HomeMahasiswa();
        view.setVisible(true);
        view.addListener(this);
        ArrayList<String> listKelas = new ArrayList();
        for (int i = 0; i < view.getMahasiswa().getAllKelas().size(); i++) {
            String s = (i+1) + ". " + view.getMahasiswa().getAllKelas().get(i).getNamaKelas()
                    + " - " + view.getMahasiswa().getAllKelas().get(i).getMatakuliah().getnamaMK()
                    + " - " + view.getMahasiswa().getAllKelas().get(i).getDosen().getNama();
            listKelas.add(s);
        }
        view.setListKelas(listKelas.toArray(new String[0]));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        String semester = Integer.toString(view.getMahasiswa().getSemester());
        view.setTxFieldNim(view.getMahasiswa().getID());
        view.setTxFieldNama(view.getMahasiswa().getNama());
        view.setTxFieldJurusan(view.getMahasiswa().getJurusan());
        view.setTxFieldSemester(semester);
        
        if (source.equals(view.getBtnAdd())) {
            TambahKelasMahasiswa viewTambah = new TambahKelasMahasiswa();
            viewTambah.setVisible(true);
            viewTambah.addListener(this);
        }
        else if (source.equals(view.getBtnDelete())) {
            HapusKelasMahasiswa viewHapus = new HapusKelasMahasiswa();
            viewHapus.setVisible(true);
            viewHapus.addListener(this);
        }
        else if (source.equals(view.getBtnLogout())) {
            Home viewHome = new Home();
            viewHome.setVisible(true);
            viewHome.addListener(this);
            view.dispose();
        }
    }
    
}
