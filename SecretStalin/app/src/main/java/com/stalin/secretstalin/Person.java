package com.stalin.secretstalin;

/**
 * Created by InfoSphereSchueler on 17.03.2018.
 */

public class Person {

    private int role;
    String name;
    boolean Kanzler;
    boolean Präsident;
    boolean Cooldown;

    public Person(String name, int role, boolean kanzler, boolean präsident, boolean cooldown) {
        this.name = name;
        this.role = role;
        Kanzler = kanzler;
        Präsident = präsident;
        Cooldown = cooldown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRolle() {
        return role;
    }

    public void setRolle(int role) {
        this.role = role;
    }

    public boolean isKanzler() {
        return Kanzler;
    }

    public void setKanzler(boolean kanzler) {
        Kanzler = kanzler;
    }

    public boolean isPräsident() {
        return Präsident;
    }

    public void setPräsident(boolean präsident) {
        Präsident = präsident;
    }

    public boolean isCooldown() {
        return Cooldown;
    }

    public void setCooldown(boolean cooldown) {
        Cooldown = cooldown;
    }
}
