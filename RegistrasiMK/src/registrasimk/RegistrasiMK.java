/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasimk;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author M. Yuslan Abubakar
 */
public class RegistrasiMK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            Mahasiswa mhs1 = new Mahasiswa("Jono","MHS1","jonojono","passwordjono",4,"Informatika");
            Mahasiswa mhs2 = new Mahasiswa("Budi","MHS2","budibudi","passwordbudi",5,"Informatika");

            Admin admin = new Admin("Dani","ADM1");
            admin.setusernameAdmin("adminadmin");
            admin.setpasswordAdmin("passwordadmin");

            Dosen dsn1 = new Dosen("Bambang","DSN1");
            
            FileOutputStream fos1 = new FileOutputStream("akun.txt");
            ObjectOutputStream obj1 = new ObjectOutputStream(fos1);

            FileOutputStream fos2 = new FileOutputStream("dosen.txt");
            ObjectOutputStream obj2 = new ObjectOutputStream(fos2);

            obj1.writeObject(mhs1);
            obj1.writeObject(mhs2);
            obj1.writeObject(admin);

            obj2.writeObject(dsn1);

            obj1.flush();
            obj2.flush();
        } catch(Exception e) {
            
        }
        
        Aplikasi apps = new Aplikasi();
        apps.mainMenu();
        
    }
}
