package br.com.accera.internaltimesheet;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.thekhaeng.pushdownanim.PushDownAnim;

import br.com.accera.internaltimesheet.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.getCadastro();

        PushDownAnim.setPushDownAnimTo(binding.start)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(MainActivity.this, DashboardActivity.class);
                        MainActivity.this.startActivity(myIntent);
                    }

                });
    }
}

