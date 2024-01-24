package com.luminahi.singleton;

import com.luminahi.singleton.lib.GameStatus;
import com.luminahi.singleton.lib.PlayerStatus;

public class App {
    
    public static void eagerInit() {
        GameStatus.getInstance();

        GameStatus.getInstance().nextLevel(10, "Town Market");
        GameStatus.getInstance().getLevelName();

        System.out.println(GameStatus.getInstance().getLevelNumber());
        System.out.println(GameStatus.getInstance().getLevelName());
        System.out.println(GameStatus.getInstance());
    }
    
    public static void lazyInit() {
        PlayerStatus.init();

        PlayerStatus.getInstance().setPlayerName("Luminahi");
        PlayerStatus.getInstance().setPlayerLevel(13);
        
        PlayerStatus.init();

        System.out.println(PlayerStatus.getInstance().getPlayerLevel());
        System.out.println(PlayerStatus.getInstance().getPlayerName());
        System.out.println(PlayerStatus.getInstance());
    }

    public static void main(String[] args) {
        eagerInit();
        lazyInit();
    }
}
