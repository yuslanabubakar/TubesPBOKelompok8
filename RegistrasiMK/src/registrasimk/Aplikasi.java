/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasimk;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author M. Yuslan Abubakar
 */
public class Aplikasi {
    private ArrayList<Dosen> daftarDosen = new ArrayList<Dosen>();
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<Mahasiswa>();
    private ArrayList<Kelas> daftarKelas = new ArrayList<Kelas>();
    private ArrayList<Matakuliah> daftarMatakuliah = new ArrayList<Matakuliah>();
    
    public void addDosen(Dosen d) {
        daftarDosen.add(d);
    }
    
    public void addMahasiswa(Mahasiswa m) {
        daftarMahasiswa.add(m);
    }
    
    public void addKelas(Kelas k) {
        daftarKelas.add(k);
    }
    
    public void addMatakuliah(Matakuliah mk) {
        daftarMatakuliah.add(mk);
    }
    
    public Dosen getDosen(int id) {
        return daftarDosen.get(id);
    }
    
    public Mahasiswa getMahasiswa(int id) {
        return daftarMahasiswa.get(id);
    }
    
    public Kelas getKelas(int id) {
        return daftarKelas.get(id);
    }
    
    public Matakuliah getMatakuliah(int id) {
        return daftarMatakuliah.get(id);
    }
    
    public void deleteDosen(int id) {
        daftarDosen.remove(id);
    }
    
    public void deleteMahasiswa(int id) {
        daftarMahasiswa.remove(id);
    }
    
    public void deleteKelas(int id) {
        daftarKelas.remove(id);
    }
    
    public void deleteMatakuliah(int id) {
        daftarMatakuliah.remove(id);
    }
    
    public void addMatakuliahToKelas(Kelas k, Matakuliah mk) {
        k.setMatakuliah(mk);
    }
    
    public void addDosenToKelas(Kelas k, Dosen d) {
        k.setDosen(d);
    }
    
    public void removeKelasByMahasiswa(Mahasiswa m, Kelas k) {
        String namaKelas = k.getNamaKelas();
        m.removeKelas(namaKelas);
    }
    
    public ArrayList<Kelas> viewDataKelasMahasiswa(Mahasiswa m) {
        return m.getAllKelas();
    }
    
    public void mainMenu() {
        int pilihan = 1;
        while (pilihan != 0) {
            Scanner input = new Scanner(System.in);
            int menu = input.nextInt();
            
            System.out.println("SELAMAT DATANG DI APLIKASI REGISTRASI MK");
            System.out.println();
            System.out.println("1. Login Admin");
            System.out.println("2. Login Mahasiswa");
            System.out.println("0. Keluar Aplikasi");
            System.out.println("Pilih Menu : ");
        }
    }
    
}
