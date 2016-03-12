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
    
    public Mahasiswa(String nama, String id, String usernameMhs, String passwordMhs, int semester) {
        super(nama, id);
        this.usernameMhs = usernameMhs;
        this.passwordMhs = passwordMhs;
        this.semester = semester;
    }
    
    public void setUsernameMhs(String usernameMhs) {
        this.usernameMhs = usernameMhs;
    }
    
    public String getUsernameMhs() {
        return usernameMhs;
    }
    
    public void setPasswordMhs(String passwordMhs) {
        this.passwordMhs = passwordMhs;
    }
    
    public String getPasswordMhs() {
        return passwordMhs;
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
    
    public String display() {
        return ("Nama Mahasiswa : " + getNama() + "\n" + "ID Mahasiswa : " + getID());
    }
}
