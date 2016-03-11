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
public abstract class Orang {
    private String nama;
    private String id;
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNama() {
        return nama;
    }
    public void setID(String id){
        this.id = id;
    }
    public String getID() {
        return id;
    }
    public void display() {
        
    }
} 
