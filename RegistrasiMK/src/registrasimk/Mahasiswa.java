/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrasimk;

/**
 *
 * @author PRAKTIKUM
 */
public class Mahasiswa extends Orang {
   private Kelas[] pilihan = new Kelas[10];
   private String usernameMhs;
   private String passwordMhs;
   private int semester;
   private int idKelas;
   
   public void setNama(String nama) {
       super.setNama(nama);
   }
   
   public void setID(String id) {
       super.setID(id);
   }
}
