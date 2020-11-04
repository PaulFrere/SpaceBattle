package ru.geekbrains.zsa.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.zsa.base.BaseButton;
import ru.geekbrains.zsa.screen.GameScreen;

public class NewGame extends BaseButton {
    private static final float HEIGHT = 0.05f;
    private static final float TOP = -0.012f;
    private final Game game;


    public NewGame(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("button_new_game"));
        this.game = game;
        setHeightProportion(HEIGHT);
        setTop(TOP);
    }


    @Override
    public void action() {
        game.setScreen(new GameScreen());
    }
}
