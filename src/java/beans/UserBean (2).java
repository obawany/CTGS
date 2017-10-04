package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import persistence.Users;

/**
 *
 * @author Lucas
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

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

    @PersistenceContext(unitName = "CTGSysPU")
    private EntityManager entity;
    @Resource
    private javax.transaction.UserTransaction utx;
    private List<Users> userLookup;


    // Class declaration
    public UserBean() {
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


    // Other methods

    public void setLookupResults(List<Users> results) {
        this.userLookup = results;
    }

    public List<Users> getLookupResults() {
        return userLookup;
    }

    public boolean getResults() {
        return (userLookup != null) && !userLookup.isEmpty();
    }

    public boolean getMessage() {
        return (userLookup != null) && userLookup.isEmpty();
    }


    // Add user to database

    public String registerUsers(ActionEvent action){
      Users user =
        new Users(
          username, password, firstName, lastName, studNumber, academicUnit,
          program, sessionNumber, supervisor, thesisTopic, bankAccountNumber
        );

        try {
           persist(user);
           String msg = "The user was created!";
           FacesContext.getCurrentInstance().addMessage(
            null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
           FacesContext.getCurrentInstance().getExternalContext()
                .getFlash().setKeepMessages(true);
           FacesContext.getCurrentInstance().getExternalContext().
            invalidateSession();
           FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
        } catch(RuntimeException e) {
           String msg = "Yeah no, LOL, try again.";
           FacesContext.getCurrentInstance().addMessage(
            null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
           FacesContext.getCurrentInstance().getExternalContext()
                .getFlash().setKeepMessages(true);
        }
        return null;
    }


    // Newly created user profile methods

    private Users profile;

    public Users getUsers() {
        return profile;
    }

    public void setUsers(Users profile) {
        this.profile = profile;
    }

    public String search(){
        profile = entity.find(Users.class, username);
        return "Display";
    }

    private static List performQuery(final Query query) {
        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        ArrayList<UserBean> results = new ArrayList<>();
        results.addAll(resultList);
        return results;
    }

    public void persist(Object object) {
        try {
            utx.begin();
            entity.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(
              Level.SEVERE, "Exception", e);
            throw new RuntimeException(e);
        }
    }



}
