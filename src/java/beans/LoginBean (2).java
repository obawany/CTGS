/**
*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import persistence.Users;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sam_chen
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    private String username;
    private String firstName;
    private String lastName; 
    private String password;
    private String response;
    @PersistenceContext(unitName = "CTGSysPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getResponse() {
        return response;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setResponse(String response) {
        this.response = response;
    }
      
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public void login() {
        Users user = em.find(Users.class, username);
        if(user != null) {
            try {
                if (user.getPassword() == password) {
                    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                    session.setAttribute("User", user);
                    response = "YEA BITCH!"; 

                    //if(user.getAdmin()){
                      //  externalContext.redirect("");
                    //}else
                }else {
                    response = "Incorrect Username and/or Password"; 
                }
            } catch (Exception e) {
            }
        }else {
            response = "Incorrect Username and/or Password";
        }
    }

    public void logout() {
        
    }
    
}