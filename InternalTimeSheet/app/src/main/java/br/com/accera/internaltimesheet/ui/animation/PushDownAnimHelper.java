package br.com.accera.internaltimesheet.ui.animation;

import android.view.View;

import com.thekhaeng.pushdownanim.PushDown;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

/**
 * Created by Rafael Spitaliere on 08/06/18.
 */
public class PushDownAnimHelper {

    public static PushDown createDefault(View viewElement, View.OnClickListener onClickListener){
        return PushDownAnim.setPushDownAnimTo(viewElement)
                .setScale( MODE_SCALE, 0.60f )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setOnClickListener(onClickListener);
    }
}
