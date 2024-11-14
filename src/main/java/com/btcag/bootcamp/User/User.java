package com.btcag.bootcamp.User;

public class User {
    protected String name;
    //------------------------------------Holt sich Input vom Nutzer, braucht eine Nachricht zum Auffordern-------------------------------------------------------

    public User(String name) {
        setName( UserView.getName(this, name+", geben sie Ihren Nutzernamen an. Der Name muss mindestens 3 sein und nicht mehr als 12 Zeichen lang sein."));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
