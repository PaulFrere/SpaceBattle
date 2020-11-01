package ru.geekbrains.zsa.sprite;

import ru.geekbrains.zsa.base.Ship;
import ru.geekbrains.zsa.base.EnemySettingsDto;;
import ru.geekbrains.zsa.math.Rect;
import ru.geekbrains.zsa.pool.BulletPool;

public class EnemyShip extends Ship {

    private enum State { DESCENT, FIGHT }
    private State state;

    public EnemyShip(BulletPool bulletPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
    }


    @Override
    public void update(float delta) {
        super.update(delta);
        bulletPos.set(pos.x, getBottom());
        pos.mulAdd(v, delta);
        switch (state) {
            case DESCENT:
                if (getTop() <= worldBounds.getTop()) {
                    v.set(v0);
                    state = State.FIGHT;
                }
                break;
            case FIGHT:
                reloadTimer += delta;
                if (reloadTimer >= reloadInterval) {
                    reloadTimer = 0f;
                    shoot();
                }
        }
    }

    public void set(EnemySettingsDto settings) {
        this.regions = settings.getRegions();
        this.v.set(settings.getV0());
        this.bulletRegion = settings.getBulletRegion();
        this.bulletHeight = settings.getBulletHeight();
        this.bulletV.set(settings.getBulletV());
        this.bulletSound = settings.getBulletSound();
        this.damage = settings.getDamage();
        this.reloadInterval = settings.getReloadInterval();
        setHeightProportion(settings.getHeight());
        this.hp = settings.getHp();
    }

}
