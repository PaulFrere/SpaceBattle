package ru.geekbrains.zsa.pool;

import ru.geekbrains.zsa.base.SpritesPool;
import ru.geekbrains.zsa.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}