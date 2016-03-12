/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasimk;

/**
 *
 * @author M. Yuslan Abubakar
 */
public class RegistrasiMK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dosen d1 = new Dosen("Pa Aji","dsn1");
        Dosen d2 = new Dosen("Pa Bams","dsn2");
        
        Matakuliah m1 = new Matakuliah();
        m1.setnamaMK("KalkulusII");
        Matakuliah m2 = new Matakuliah();
        m2.setnamaMK("FisikaII");
        
        Kelas k1 = new Kelas("Kelas 01",d1,m1);
        Kelas k2 = new Kelas("Kelas 02",d2,m2);
        
        Mahasiswa mhs1 = new Mahasiswa("Ucok Baba","mahasiswa1","ucokbaba","123456",4);
        
        mhs1.addKelas(k1);
        mhs1.addKelas(k2);
        
        System.out.println("Data Mahasiswa :");
        System.out.println();
        System.out.println("Nama Mahasiswa : " + mhs1.getNama());
        System.out.println("Semester : " + mhs1.getSemester());
        System.out.println("Daftar Kelas Yang Diambil :");
        for (int i = 0; i < mhs1.getTotalKelas(); i++) {
            System.out.println("Kelas ke-" + (i+1) + " : ");
            System.out.println("Nama Kelas : " + mhs1.getKelas(i).getNamaKelas());
            System.out.println("Nama Dosen : " + mhs1.getKelas(i).getDosen().getNama());
            System.out.println("Nama Matakuliah : " + mhs1.getKelas(i).getMatakuliah().getnamaMK());
            System.out.println();
        }
    }
}
