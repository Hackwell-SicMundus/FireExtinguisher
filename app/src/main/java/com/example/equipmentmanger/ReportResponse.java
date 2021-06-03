package com.example.equipmentmanger;

public class ReportResponse {

    int idReports;
    int idInventory;
    String Name;
    String Date;
    int Urgency;

    public int getIdReports() {
        return idReports;
    }

    public void setIdReports(int idReports) {
        this.idReports = idReports;
    }

    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getUrgency() {
        return Urgency;
    }

    public void setUrgency(int urgency) {
        Urgency = urgency;
    }
}
