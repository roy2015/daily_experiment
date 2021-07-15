package com.roy.miscellaneous.proxy;

import com.roy.miscellaneous.proxy.AircraftCarrier;
import com.roy.miscellaneous.proxy.Destroyer;
import com.roy.miscellaneous.proxy.Warship;
import com.roy.miscellaneous.proxy.plugin.SeawayMyInterceptor;
import com.roy.miscellaneous.proxy.plugin.WarFireMyInterceptor;
import com.roy.miscellaneous.proxy.plugin.frame.MyInterceptorChain;

/**
 * @author guojun
 * @date 2021/3/8 上午10:47
 */
public class MyPluginTest {

    static class Solution {
        public void testMyPlugin() {
            MyInterceptorChain chain = new MyInterceptorChain();
            chain.addInterceptor(new SeawayMyInterceptor(27));
            chain.addInterceptor(new WarFireMyInterceptor(1));

            Warship warship1 = new AircraftCarrier("山东舰");
            Warship warship2 = new Destroyer("055");

            warship1 = (Warship) chain.pluginAll(warship1);
            warship2 = (Warship) chain.pluginAll(warship2);

            for (int i = 1; i < 10; i++) {
                warship1.seaway(20 + i);
                warship2.seaway(25 + i);
            }

            warship1.fire(3);
            warship2.fire(3);
        }
    }

    public static void main(String[] args) {
        new Solution().testMyPlugin();
    }

}