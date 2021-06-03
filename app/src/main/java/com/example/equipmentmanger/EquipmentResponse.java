package com.example.equipmentmanger;

public class EquipmentResponse {

    int idInventory_Object;
    int idInventory;
    String Name;
    String Floor;
    String Landmark;

    public int getIdInventory_Object() {
        return idInventory_Object;
    }

    public void setIdInventory_Object(int idInventory_Object) {
        this.idInventory_Object = idInventory_Object;
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

    public String getFloor() {
        return Floor;
    }

    public void setFloor(String floor) {
        Floor = floor;
    }

    public String getLandmark() {
        return Landmark;
    }

    public void setLandmark(String landmark) {
        Landmark = landmark;
    }
}
