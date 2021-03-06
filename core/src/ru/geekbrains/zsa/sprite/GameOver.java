package ru.geekbrains.zsa.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.zsa.base.Sprite;

public class GameOver extends Sprite {
    protected static final float HEIGHT = 0.07f;
    protected static final float BOTTOM_MARGIN = 0.009f;

    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
        setHeightProportion(HEIGHT);
        setBottom(BOTTOM_MARGIN);
    }
}
