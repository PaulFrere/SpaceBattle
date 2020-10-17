package ru.geekbrains.zsa;

import com.badlogic.gdx.Game;

import ru.geekbrains.zsa.screen.MenuScreen;

public class SpaceBattle  extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen());
    }

}
