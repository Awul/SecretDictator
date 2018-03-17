package com.schmu.secretdictator;

/**
 * Created by IasdsadfasdSchueler on 17.03.2018.
 */

public class Game {
    private int PlayerCount;
    private int StalinCount;
    private int CommunistCount;
    private int LiberalCount;
    private Person[] persons;

    public Game(int playerCount, int stalinCount, int communistCount, int liberalCount) {
        PlayerCount = playerCount;
        StalinCount = stalinCount;
        CommunistCount = communistCount;
        LiberalCount = liberalCount;
        persons = new Person[playerCount];
    }

    public int getPlayerCount() {
        return PlayerCount;
    }

    public void setPlayerCount(int playerCount) {
        PlayerCount = playerCount;
    }

    public int getStalinCount() {
        return StalinCount;
    }

    public void setStalinCount(int stalinCount) {
        StalinCount = stalinCount;
    }

    public int getCommunistCount() {
        return CommunistCount;
    }

    public void setCommunistCount(int communistCount) {
        CommunistCount = communistCount;
    }

    public int getLiberalCount() {
        return LiberalCount;
    }

    public void setLiberalCount(int liberalCount) {
        LiberalCount = liberalCount;
    }
}
