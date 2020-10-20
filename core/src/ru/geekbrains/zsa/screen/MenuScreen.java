package ru.geekbrains.zsa.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.zsa.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private static final float V_LEN = 0.5f;

    private Texture img;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 vec;
    private Vector2 touch;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        v = new Vector2(1, 1);
        vec = new Vector2();
        touch = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        vec.set(touch);
        if (vec.sub(pos).len() <= v.len()) {
            pos.set(touch);
        } else {
            pos.add(v);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v = touch.cpy().sub(pos).setLength(V_LEN);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Input.Keys.SPACE != keycode) {
            return super.keyDown(keycode);
        }
        if (v.isZero()) {
            v.set(1, 1);
        } else {
            v.setZero();
        }
        return super.keyDown(keycode);
    }
}