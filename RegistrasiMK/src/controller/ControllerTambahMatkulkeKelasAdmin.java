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
import model.Matakuliah;
import view.HomeAdmin;
import view.TambahMatkulkeKelasAdmin;

/**
 *
 * @author Rona
 */
public class ControllerTambahMatkulkeKelasAdmin implements ActionListener{
    private Aplikasi app;
    private TambahMatkulkeKelasAdmin view;
    
    
    public ControllerTambahMatkulkeKelasAdmin(){
        view = new TambahMatkulkeKelasAdmin();
        app = new Aplikasi();
        view.setVisible(true);
        view.addListener(this);
        
        for (int i = 0; i < app.getListKelasFromFile().size(); i++) {
            if (app.getListKelasFromFile().get(i).getMatakuliah()==null){
                view.setIsiNamaKelas(app.getListKelasFromFile().get(i).getNamaKelas());
            }
        }
        
        for (int i = 0; i < app.getListMatkulFromFile().size(); i++) {
            for (int j = 0; j < app.getListKelasFromFile().size(); j++) {
                if (app.getListMatkulFromFile().get(i).getnamaMK().equals(app.getListKelasFromFile().get(j).getMatakuliah().getnamaMK())) {
                    
                }
                else {
                    view.setIsiMatakuliah(app.getListMatkulFromFile().get(i).getnamaMK());
                }
            }
        }
     
    }
    
    public Matakuliah getMatakuliah(String nama){
            for (int i = 0; i < app.getListMatkulFromFile().size(); i++) {
                if (app.getListMatkulFromFile().get(i).getnamaMK().equals(nama)) {
                    return app.getListMatkulFromFile().get(i);
                }
            }
            return null;
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        ArrayList<Kelas> ak = app.getListKelasFromFile();
        
        if (source.equals(view.getBtnCancel())){
            ArrayList<Kelas> ka = new ArrayList<>();
            HomeAdmin ha = new HomeAdmin();
            ha.inputData(ka);
            ha.inputData(app.getListKelasFromFile());
            view.dispose();
        }
        
        if (source.equals(view.getBtnAdd())) {
            for (int i = 0; i < app.getListKelasFromFile().size(); i++) {
                if (ak.get(i).getNamaKelas().equals(view.getIsiNamaKelas())){
                    ak.get(i).setMatakuliah(getMatakuliah(view.getIsiMatakuliah()));
                    app.saveListKelasToFile(ak);
                    JOptionPane.showMessageDialog(null, "Mata Kuliah Berhasil Ditambahkan!");
                }
                
            }
        }
    }
    
}
