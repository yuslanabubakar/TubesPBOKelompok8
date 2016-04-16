/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import controller.ControllerHome;
import java.io.IOException;
import model.Aplikasi;

/**
 *
 * @author M. Yuslan Abubakar
 */
public class DriverGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Aplikasi apps = new Aplikasi();
        ControllerHome home = new ControllerHome();
        apps.cekFile();
    }
}
