/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package registrasimk;

/**
 *
 * @author Rona
 */
public class Admin extends Orang {
    private String usernameAdmin;
    private String passwordAdmin;
	
	public Admin (String nama, String id) {
		super(nama,id);
	}
	
	public void setusernameAdmin (String usernameAdmin) {
		this.usernameAdmin = usernameAdmin;
	}
	
	public String usernameAdmin() {
		return usernameAdmin;
	}
	
	public void setpasswordAdmin (String passwordAdmin) {
		this.setpasswordAdmin = setpasswordAdmin;
	}
	
	public String getpasswordAdmin () {
		return passwordAdmin;
	}
	
}
