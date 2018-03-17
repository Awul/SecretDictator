package com.schmu.secretdictator;

/**
 * Created by InfoSphereSchueler on 17.03.2018.
 */

public class Person {
    public enum Rolle {
        STALIN, LIBERAL, KOMMUNIST
    }
    String name;
    Rolle rolle;
    boolean Kanzler;
    boolean Präsident;
    boolean Cooldown;

    public Person(String name, Rolle rolle, boolean kanzler, boolean präsident, boolean cooldown) {
        this.name = name;
        this.rolle = rolle;
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

    public Rolle getRolle() {
        return rolle;
    }

    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
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
