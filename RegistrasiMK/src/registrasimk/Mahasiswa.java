/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasimk;

import java.util.ArrayList;

/**
 *
 * @author PRAKTIKUM
 */
public class Mahasiswa extends Orang {
    private ArrayList<Kelas> pilihan = new ArrayList<Kelas>();
    private String usernameMhs;
    private String passwordMhs;
    private int semester;
    private int indexKelas;
    
    public void setUsernameMhs(String usernameMhs) {
        this.usernameMhs = usernameMhs;
    }
    
    public void setPasswordMhs(String passwordMhs) {
        this.passwordMhs = passwordMhs;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public void addKelas(Kelas k) {
        pilihan.add(k);
    }
    
    public void removeKelas(String namaKelas) {
        for (int i = 0; i < pilihan.size(); i++) {
            if ( pilihan.get(i).getNamaKelas().equals(namaKelas) ) {
                pilihan.remove(i);
            }
        }
    }
    
    public Kelas getKelas(String namaKelas) {
        Kelas kelas = null;
        for (int i = 0; i < pilihan.size(); i++) {
            if ( pilihan.get(i).getNamaKelas().equals(namaKelas) ) {
                kelas = pilihan.get(i);
            }
        }
        return kelas;
    }
}
