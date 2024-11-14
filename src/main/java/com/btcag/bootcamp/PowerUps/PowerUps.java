package com.btcag.bootcamp.PowerUps;

import com.btcag.bootcamp.Robots.Robot;

public class PowerUps {
    protected DmgPowerUp dmgPowerUp;
    protected RangePowerup rangePowerUp;
    protected ShieldPowerup shieldPowerUp;


    public PowerUps(Robot robot1, Robot robot2) {
        this.dmgPowerUp = new DmgPowerUp();
        this.rangePowerUp = new RangePowerup();
        this.shieldPowerUp = new ShieldPowerup();

        DmgPowerUpController.rerollXY (robot1, robot2, this);
        RangePowerUpController.rerollXY(robot1, robot2, this);
        ShieldPowerUpController.rerollXY(robot1, robot2, this);

    }


    public DmgPowerUp getDmgPowerUp() {
        return dmgPowerUp;

    }


    public ShieldPowerup getShieldPowerUp() {
        return shieldPowerUp;
    }

    public RangePowerup getRangePowerUp() {
        return rangePowerUp;
    }
}
