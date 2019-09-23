package com.kevin.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Category {
    private IntegerProperty ID;
    private StringProperty nama;
	
	@Override
    public String toString() {
        return nama;
    }

    public int getID() {
        return ID.get();
    }

    public IntegerProperty IDProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public String getNama() {
        return nama.get();
    }

    public StringProperty namaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }
}
