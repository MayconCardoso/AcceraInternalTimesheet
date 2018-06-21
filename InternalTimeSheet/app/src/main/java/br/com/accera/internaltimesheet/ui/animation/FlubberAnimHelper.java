package br.com.accera.internaltimesheet.ui.animation;

import android.view.View;

import com.appolica.flubber.Flubber;

/**
 * Created by Rafael Spitaliere on 14/06/18.
 */
public class FlubberAnimHelper {

    public static void create(View view, int i, Flubber.AnimationPreset anim){
        Flubber.with()
                .animation(anim) // Slide up animation
                .repeatCount(0)                             // Repeat once
                .delay(i)
                .duration(1000)                              // Last for 1000 milliseconds(1 second)
                .createFor(view)                            // Apply it to the vie
                .start();
    }
}
