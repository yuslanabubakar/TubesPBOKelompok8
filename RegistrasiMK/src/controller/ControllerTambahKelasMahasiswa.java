/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Aplikasi;
import model.Kelas;
import model.Mahasiswa;
import view.HomeMahasiswa;
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
    
    public boolean cekKelas(String namaKelas) {
        for (int i = 0; i < view.getMahasiswa().getAllKelas().size(); i++) {
            if (view.getMahasiswa().getAllKelas().get(i).getNamaKelas().equals(namaKelas)) {
                return false;
            }
        }
        return true;
    }
    
    public int getIndexMahasiswa(Mahasiswa m) {
        for (int i = 0; i < app.getListMahasiswaFromFile().size(); i++) {
            if (app.getListMahasiswaFromFile().get(i).equals(m)) {
                return i;
            }
        }
        return 0;
    }
    
    public Kelas getKelas(String namaKelas) {
        for (int i = 0; i < app.getListKelasFromFile().size(); i++) {
            if (app.getListKelasFromFile().get(i).getNamaKelas().equals(namaKelas)) {
                return app.getListKelasFromFile().get(i);
            }
        }
        return null;
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
            view.setIsiComboBox(app.getListKelasFromFile().get(i).getNamaKelas());
        }
        view.setListKelas(listKelas.toArray(new String[0]));
        
        if (source.equals(view.getBtnSave())) {
            if (cekKelas(view.getIsiComboBox()) == true) {
                ArrayList<Mahasiswa> mhs = app.getListMahasiswaFromFile();
                mhs.get(getIndexMahasiswa(view.getMahasiswa())).addKelas(getKelas(view.getIsiComboBox()));
                app.saveListMahasiswaToFile(mhs);
                JOptionPane.showMessageDialog(null, "Kelas Berhasil Ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Kelas Sudah Diambil");
            }
        }
        else if (source.equals(view.getBtnCancel())) {
            HomeMahasiswa viewHome = new HomeMahasiswa();
            viewHome.setVisible(true);
            viewHome.addListener(this);
            view.dispose();
        }
    }
}
