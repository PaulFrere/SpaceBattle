package ru.geekbrains.zsa.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.zsa.base.BaseButton;
import ru.geekbrains.zsa.screen.GameScreen;

public class NewGame extends BaseButton {
    private static final float HEIGHT = 0.05f;
    private static final float TOP = -0.012f;
    private GameScreen gameScreen;


    public NewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
        setHeightProportion(HEIGHT);
        setTop(TOP);
    }


    @Override
    public void action() {

        gameScreen.startNewGame();
    }
}