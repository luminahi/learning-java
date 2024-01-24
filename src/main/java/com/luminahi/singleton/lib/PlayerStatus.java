package com.luminahi.singleton.lib;

/*
 * lazy initialization
 */
public class PlayerStatus {
    
    private static PlayerStatus instance;

    private String playerName;
    private int playerLevel;

    private PlayerStatus() { }

    public static void init() {
        if (instance != null) return;
        instance = new PlayerStatus();
    }
    
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public static PlayerStatus getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return playerName + " " + playerLevel;
    }
}
