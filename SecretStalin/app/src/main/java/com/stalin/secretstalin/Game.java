package com.stalin.secretstalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by IasdsadfasdSchueler on 17.03.2018.
 */

public class Game {
    private int PlayerCount;
    private int StalinCount;
    private int CommunistCount;
    private int LiberalCount;
    private Person[] persons;
    public List<Person> personsList;
    public Stack<Integer> cardStack=new Stack<>();
    private int communistCardCount=15;
    private int liberalCardCount=15;
    private int presidentIndex;
    public int failCounter;
    public int numberOfAktiveLiberalLaws = 0;
    public int numberOfAktiveCommunistLaws = 0;


    public Game(int playerCount, int stalinCount, int communistCount, int liberalCount) {
        PlayerCount = playerCount;
        StalinCount = stalinCount;
        CommunistCount = communistCount;
        LiberalCount = liberalCount;
        persons = new Person[playerCount];
        personsList = new ArrayList<>();
        newStack(30);
    }

    public int getPresidentIndex() {
        return presidentIndex;
    }

    private void newStack(int number){
        ArrayList<Integer> cardHelpArray = new ArrayList<Integer>();

        for (int i = 0; i < communistCardCount; i++){
            cardHelpArray.add(0);
        }

        for (int i = 0; i < liberalCardCount; i++){
            cardHelpArray.add(1);
        }

        for (int i = 0; i < liberalCardCount+communistCardCount; i++){

            int tempInt = (int)Math.random()*(cardHelpArray.size()-1);

            cardStack.push(cardHelpArray.get(tempInt));

            cardHelpArray.remove(tempInt);

        }
    }

    public int randomPresidentIndex(){
        int newpresidentIndex =  (int)Math.random()*(PlayerCount-1);
        presidentIndex = newpresidentIndex;
        return presidentIndex;
    }

    public int nextPresidentIndex(){
        int newpresidentIndex =  presidentIndex + 1;
        presidentIndex = newpresidentIndex;
        return presidentIndex;
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

    public int getLaw(){
        if(cardStack.isEmpty()){
            newStack(communistCardCount+liberalCardCount);
        }
        return cardStack.pop();
    }

    public void setNumberOfAktiveLiberalLaws(int numberOfAktiveLiberalLaws) {
        this.numberOfAktiveLiberalLaws = numberOfAktiveLiberalLaws;
    }

    public void setNumberOfAktiveCommunistLaws(int numberOfAktiveCommunistLaws) {
        this.numberOfAktiveCommunistLaws = numberOfAktiveCommunistLaws;
    }

    public int getNumberOfAktiveLiberalLaws() {
        return numberOfAktiveLiberalLaws;
    }

    public int getNumberOfAktiveCommunistLaws() {
        return numberOfAktiveCommunistLaws;
    }
}
