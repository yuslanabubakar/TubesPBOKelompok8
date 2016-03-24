/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasimk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
    
    public void menuSatuAdmin(Kelas k) {
        daftarKelas.add(k);
    }
    
    public void menuDuaAdmin(Matakuliah mk) {
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
    
    public void menuTigaAdmin(Kelas k, Matakuliah mk) {
        k.setMatakuliah(mk);
    }
    
    public void menuSatuMhs(Mahasiswa m, Kelas k) {
        m.addKelas(k);
    }
    
    public void menuEmpatAdmin(Kelas k, Dosen d) {
        k.setDosen(d);
    }
    
    public void menuDuaMhs(Mahasiswa m, Kelas k) {
        String namaKelas = k.getNamaKelas();
        m.removeKelas(namaKelas);
    }
    
    public ArrayList<Kelas> menuTigaMhs(Mahasiswa m) {
        return m.getAllKelas();
    }
    
    public void createFile() {
        try {
            Mahasiswa mhs1 = new Mahasiswa("Jono","MHS1","jonojono","passwordjono",4,"Informatika");
            Mahasiswa mhs2 = new Mahasiswa("Budi","MHS2","budibudi","passwordbudi",5,"Informatika");
            daftarMahasiswa.add(mhs1);
            daftarMahasiswa.add(mhs2);
            
            Dosen dsn1 = new Dosen("Bambang","DSN1");
            daftarDosen.add(dsn1);
            
            Admin admin = new Admin("Dani","ADM1");
            admin.setusernameAdmin("adminadmin");
            admin.setpasswordAdmin("passwordadmin");
            
            FileOutputStream fos1 = new FileOutputStream("mahasiswa.txt");
            ObjectOutputStream obj1 = new ObjectOutputStream(fos1);

            FileOutputStream fos2 = new FileOutputStream("dosen.txt");
            ObjectOutputStream obj2 = new ObjectOutputStream(fos2);
            
            FileOutputStream fos3 = new FileOutputStream("admin.txt");
            ObjectOutputStream obj3 = new ObjectOutputStream(fos3);

            obj1.writeObject(daftarMahasiswa);
            obj2.writeObject(daftarDosen);
            obj3.writeObject(admin);

            obj1.flush();
            obj2.flush();
            obj3.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void mainMenu() {
        File file1 = new File("mahasiswa.txt");
        File file2 = new File("dosen.txt");
        File file3 = new File("admin.txt");
        if ((file1.exists()) && (file2.exists()) && (file3.exists())) {
            
        }
        else {
            createFile();
        }
        
        int pilihan1 = 1;
        while (pilihan1 != 0) {
            Scanner angka = new Scanner(System.in);
            Scanner huruf = new Scanner(System.in);
            
            System.out.println("APLIKASI REGISTRASI MATA KULIAH");
            System.out.println();
            System.out.println("1. Login Admin");
            System.out.println("2. Login Mahasiswa");
            System.out.println("0. Keluar Aplikasi");
            System.out.print("Pilih Menu : ");
            
            try {
                int menu1 = angka.nextInt();
                String username;
                String password;
                switch (menu1) {
                    case 1 :
                        System.out.print("Masukkan Username Admin : ");
                        username = huruf.next();
                        System.out.print("Masukkan Password Admin : ");
                        password = huruf.next();
                        try {
                            FileInputStream fis = new FileInputStream("admin.txt");
                            ObjectInputStream ois = new ObjectInputStream(fis);

                            Admin admin = (Admin)ois.readObject();
                            if ((admin.getUsernameAdmin().equals(username)) && (admin.getpasswordAdmin().equals(password))) {
                                System.out.println("ADMIN");
                            }
                            else {
                                System.out.println("SALAH");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                        
                    case 2 :
                        System.out.print("Masukkan Username Mahasiswa : ");
                        username = huruf.next();
                        System.out.print("Masukkan Password Mahasiswa : ");
                        password = huruf.next();
                        break;
                        
                    case 0 :
                        System.out.println("TERIMA KASIH");
                        pilihan1 = 0;
                        break;
                        
                    default :
                        System.out.println("Menu tidak ada");
                }
            } catch (InputMismatchException e) {
                System.out.println("Menu Salah. Menu yang benar 1 / 2 / 0");
            }
        }
    }    
}