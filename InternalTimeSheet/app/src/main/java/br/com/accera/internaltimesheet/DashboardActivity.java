package br.com.accera.internaltimesheet;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.joaquimley.faboptions.FabOptions;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.Calendar;

import br.com.accera.internaltimesheet.databinding.ActivityDashboardBinding;
import br.com.accera.internaltimesheet.databinding.ActivityMainBinding;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;
import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class DashboardActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private Runnable mRunnable;
    private boolean mRunnableStopped = false;
    ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);

        PushDownAnim.setPushDownAnimTo(binding.imgClock)
        .setScale( MODE_SCALE,
                0.60f)
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick( View view ){
                        Toast.makeText( DashboardActivity.this, "PUSH DOWN !!", Toast.LENGTH_SHORT ).show();
                    }
                } );
    }

    @Override
    public void onResume() {
        this.mRunnableStopped = false;
        this.startBedside();
        super.onResume();

    }

    @Override
    public void onStop() {
        super.onStop();
        this.mRunnableStopped = true;
    }

    private void startBedside() {


        final Calendar calendar = Calendar.getInstance(); //instanciou o calendario do android
        // Runnable é uma interface. Consegue fazer interface pq no java é uma classe anônima. Uma classe anonima não precisa explicitamente escrever Runnable
        this.mRunnable = new Runnable() {
            @Override
            public void run() {

                if (mRunnableStopped) return;


                calendar.setTimeInMillis(System.currentTimeMillis()); //pegou o equivalente da hora em millisegundos

                String hourMinutesFormat = String.format("%02d:%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND)); //HOUR_OF_DAY é a hora no formato de 24 horas.

              //  mViewHolder.mTextHourMinute.setText(hourMinutesFormat);
              //  mViewHolder.mTextSeconds.setText(secondsFormat);

                binding.horaMolde.setText(hourMinutesFormat);

                long now = SystemClock.uptimeMillis();
                long next = now + (1000 - (now % 1000)); //este calculo faz cair no milisegundo 0 do proximo segundo.

                mHandler.postAtTime(mRunnable, next);
            }
        };
        this.mRunnable.run();
    }

}
