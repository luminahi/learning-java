package com.luminahi.singleton.lib;

/*
 * eager initialization
 */
public class GameStatus {
    
    private static final GameStatus instance = new GameStatus();

    private String levelName;
    private int levelNumber;

    private GameStatus() { }
    
    public void nextLevel(int levelNumber, String levelName) {
        setLevelNumber(levelNumber);
        setLevelName(levelName);
    }

    public int getLevelNumber() {
        return levelNumber;
    }
    
    public String getLevelName() {
        return levelName;
    }
    
    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    
    public static GameStatus getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return levelName + " " + levelNumber;
    }
}
