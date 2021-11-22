package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    private String username;
    private String password;
    double balance;
    public CasinoAccount(){
        this.username = "";
        this.password = "";
        this.balance = 0;
    }
    public CasinoAccount(String username, String password){
        this.username = username;
        this.password = password;
        balance = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
