/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp.health;

import com.codahale.metrics.health.HealthCheck;
import sbp.api.Sneaker;

/**
 *
 * @author Jeffrey
 */
public class DBHealthCheck extends HealthCheck {
private final Sneaker sneaker;
    public DBHealthCheck (Sneaker sneaker) {
        this.sneaker = sneaker;
    }
            @Override
    protected Result check() throws Exception {
       return Result.healthy();
    }
    
}
