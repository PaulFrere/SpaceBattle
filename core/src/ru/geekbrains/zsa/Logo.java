package ru.geekbrains.zsa;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.zsa.base.Sprite;
import ru.geekbrains.zsa.math.Rect;

public class Logo extends Sprite {

        private static final float V_LEN = 0.01f;

        private Vector2 v;
        private Vector2 tmp;
        private Vector2 touch;

        public Logo(Texture region) {
            super(new TextureRegion(region));
            touch = new Vector2();
            v = new Vector2();
            tmp = new Vector2();
        }

    @Override
    public void update(float delta) {
        tmp.set(touch);
        if (tmp.sub(pos).len() <= V_LEN){
            pos.set(touch);
        }else{
            pos.add(v);
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.3f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
            this.touch.set(touch);
            v.set(touch.sub(pos).setLength(V_LEN));
        return false;
    }

}
