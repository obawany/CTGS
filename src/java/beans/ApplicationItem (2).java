/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package beans;

/**
 *
 * @author Lucas
 */
public final class ApplicationItem {
    
    private String appID;
    private String shortDescription;
    private String longDescription;
    private String zone;
    private double cost;
    
    
    public ApplicationItem(String appID, String shortDescription,
            String longDescription, double cost, String zone){
        
        setAppID(appID);
        setShortDescription(shortDescription);
        setLongDescription(longDescription);
        setZone(zone);
        setCost(cost);
    }
    
    // Getters & Setters
    
    public String getAppID(){
        return appID;
    }
    
    public void setAppID(String appID){
        this.appID = appID;
    }
    
    public String getShortDescription(){
        return shortDescription;
    }
    
    public void setShortDescription(String shortDescription){
        this.shortDescription = shortDescription;
    }
    
    public String getLongDescription(){
        return longDescription;
    }
    
    public void setLongDescription(String longDescription){
        this.longDescription = longDescription;
    }
    
    public String getZone(){
        return zone;
    }
    
    public void setZone(String zone){
        this.zone = zone;
    }
    
    public double getCost(){
        return cost;
    }
    
    public void setCost(double cost){
        this.cost = cost;
    }
    
}

