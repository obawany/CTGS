/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lucas
 */
@Named(value = "applicationBean")
@SessionScoped
public class ApplicationBean implements Serializable {

    //@EJB
    //private ItemFacadeLocal itemFacade;
     
    //@EJB
    //private OrderEJBLocal orderEJB;
    
    private String appID;
    private int updateAppID; // Do we need this?
    private String appName;
    private ArrayList<ApplicationItem> apps;
    private double requestAmount;
    
    // Getters & Setters
    
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppID() {
        return appID;
    }

    public void setAAppID(String appID) {
        this.appID = appID;
    }

    public ArrayList<ApplicationItem> getApps() {
        return apps;
    }

    public void setItems(ArrayList<ApplicationItem> apps) {
        this.apps = apps;
    }
    
        /**
     * @return the updateOrderNumber
     */
    public int getUpdateAppID() {
        return updateAppID;
    }

    public void setUpdateAppID(int updateAppID) {
        this.updateAppID = updateAppID;
    }
    
    public ApplicationBean() {
    }
    
    /**
    public String getPendingApplications() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        appName = bundle.getString("pendingApplications");
        apps=new ArrayList<>();
        List<Application> resultList = itemFacade.findByCategory("pending");
        if (resultList != null) {
            for (Application resultList1 : resultList) {
                Application x = (Application) resultList1;
                apps.add(new ApplicationItem(x.getItemID(),x.getShortDescription(),x.getLongDescription(),x.getCost(),x.getCategory()));
            }
        }
        return "catalogPage";
    }
    
    // This stuff is just copy-pasted from the CatalogBean class, with 
    // which uses persistence info from Item.java in Bookstore.ejb
    
    public String getTechBooks() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        catalogTitle = bundle.getString("techCatalogTitle"); 
        items=new ArrayList<>();
        List<Item> resultList = itemFacade.findByCategory("tech");
        if (resultList != null) {
            for (Item resultList1 : resultList) {
                Item x = (Item) resultList1;
                items.add(new CatalogItem(x.getItemID(),x.getShortDescription(),x.getLongDescription(),x.getCost(),x.getCategory()));
            }
        }
        return "catalogPage";
    }
    
    public List getItemsOrdered() {
        return orderEJB.getItemsOrdered();
    }
    
    public void orderBook() {
        orderEJB.addItem(orderBookId);
    }
    public void updateOrder() {
        orderEJB.setNumOrdered(orderBookId, updateOrderNumber);
    }

        /**
     * @return the orderTotal
     
    public double getOrderTotal() {
        return orderTotal;
    }

    /**
     * @param orderTotal the orderTotal to set
     
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     * @return the orderTaxes
     
    public double getOrderTaxes() {
        // apply 13% taxes
        double orderTaxes = orderTotal * 0.13;
        return orderTaxes;
    }

    /**
     * @return the orderShipping
     
    public double getOrderShipping() {
        // shipping is 5% + $10
        double orderShipping = orderTotal * 0.05 + 10.0;
        return orderShipping;
    }

    public double getGrandTotal() {
        return orderTotal + getOrderTaxes() + getOrderShipping();
    }
    
    public String checkout() {
        orderTotal = orderEJB.getOrderTotal();
        return "checkoutPage";
    }
    */
}
