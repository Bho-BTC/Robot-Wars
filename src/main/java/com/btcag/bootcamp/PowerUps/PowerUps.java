package com.btcag.bootcamp.PowerUps;

import com.btcag.bootcamp.Robot;

public class PowerUps {
    protected DmgPowerUp dmgPowerUp;
    protected RangePowerup rangePowerUp;
    protected ShieldPowerup shieldPowerUp;


    public PowerUps(Robot robot1, Robot robot2) {
        this.dmgPowerUp = new DmgPowerUp();
        this.rangePowerUp = new RangePowerup();
        this.shieldPowerUp = new ShieldPowerup();

        this.dmgPowerUp.rerollXY(robot1, robot2, this);
        this.rangePowerUp.rerollXY(robot1, robot2, this);
        this.shieldPowerUp.rerollXY(robot1, robot2, this);

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
