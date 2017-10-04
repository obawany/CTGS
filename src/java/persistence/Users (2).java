/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sam_chen
 */
@Entity
@Table(name="Users")
public class Users implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    
    // Variables & co.
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String studNumber;
    private String academicUnit;
    private String program;
    private String sessionNumber;
    private String supervisor;
    private String thesisTopic;
    private String bankAccountNumber;
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public Users(){
        
    }
    
    // Constructor
    public Users(
            String username, String password, String firstname, String lastname,
            String studNumber, String academicUnit, String program, String sessionNumber,
            String supervisor, String thesisTopic, String bankAccountNumber
    ){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studNumber = studNumber;
        this.academicUnit = academicUnit;
        this.program = program;
        this.sessionNumber = sessionNumber;
        this.supervisor = supervisor;
        this.thesisTopic = thesisTopic;
        this.bankAccountNumber = bankAccountNumber;
    }
    
    // Getters & Setters
    
    public String getUsersname(){
        return username;
    }
    
    public void setUsersname(String username){
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getStudNumber(){
        return studNumber;
    }
    
    public void setStudNumber(String studNumber){
        this.studNumber = studNumber;
    }
    
    public String getAcademicUnit(){
        return academicUnit;
    }
    
    public void setAcademicUnit(String academicUnit){
        this.academicUnit = academicUnit;
    }
    
    public String getProgram(){
        return program;
    }
    
    public void setProgram(String program){
        this.program = program;
    }
    
    public String getSessionNumber(){
        return sessionNumber;
    }
    
    public void setSessionNumber(String sessionNumber){
        this.sessionNumber = sessionNumber;
    }
    
    public String getSupervisor(){
        return supervisor;
    }
    
    public void setSupervisor(String supervisor){
        this.supervisor = supervisor;
    }
    
    public String getThesisTopic(){
        return thesisTopic;
    }
    
    public void setThesisTopic(String thesisTopic){
        this.thesisTopic = thesisTopic;
    }
    
    public String getBankAccountNumber(){
        return bankAccountNumber;
    }
    
    public void setBankAccountNumber(String bankAccountNumber){
        this.bankAccountNumber = bankAccountNumber;
    }  
}
