package ru.geekbrains.zsa.sprite;

import ru.geekbrains.zsa.base.Ship;
import ru.geekbrains.zsa.base.EnemySettingsDto;;
import ru.geekbrains.zsa.math.Rect;
import ru.geekbrains.zsa.pool.BulletPool;
import ru.geekbrains.zsa.pool.ExplosionPool;

public class EnemyShip extends Ship {

    private static final float START_V_Y = -0.3f;

    public EnemyShip(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.explosionPool = explosionPool;
    }


    @Override
    public void update(float delta) {
        super.update(delta);
        bulletPos.set(pos.x, getBottom());
        if (getTop() < worldBounds.getTop()) {
            v.set(v0);
        } else {
            reloadTimer = reloadInterval - delta * 2;
        }
        if (getBottom() < worldBounds.getBottom()) {
            destroy();
        }
    }

    public void set(EnemySettingsDto settings) {
        this.regions = settings.getRegions();
        this.v0.set(settings.getV0());
        this.bulletRegion = settings.getBulletRegion();
        this.bulletHeight = settings.getBulletHeight();
        this.bulletV.set(settings.getBulletV());
        this.bulletSound = settings.getBulletSound();
        this.damage = settings.getDamage();
        this.reloadInterval = settings.getReloadInterval();
        setHeightProportion(settings.getHeight());
        this.hp = settings.getHp();
        this.v.set(0, START_V_Y);
        this.reloadTimer = 0f;
        this.reloadTimer = 0f;
    }

    public boolean isBulletCollision(Rect bullet) {
        return !(
                bullet.getRight() < getLeft()
                        || bullet.getLeft() > getRight()
                        || bullet.getBottom() > getTop()
                        || bullet.getTop() < pos.y
        );
    }
}
