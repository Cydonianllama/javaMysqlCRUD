package com.mycompany.mytest.models;

/**
 *
 * @author Grandez
 */
public class Cashier {
    
    private String idCashier;
    private String fullname;

    public String getIdCashier() {
        return idCashier;
    }

    public void setIdCashier(String idCashier) {
        this.idCashier = idCashier;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Cashier(String idCashier, String fullname) {
        this.idCashier = idCashier;
        this.fullname = fullname;
    }

    public Cashier() {
    
    }
    
}
