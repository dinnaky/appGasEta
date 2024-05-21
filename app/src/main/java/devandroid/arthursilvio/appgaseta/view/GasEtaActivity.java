package devandroid.arthursilvio.appgaseta.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.arthursilvio.appgaseta.R;
import devandroid.arthursilvio.appgaseta.apoio.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        Toast.makeText(GasEtaActivity.this,
                UtilGasEta.calculateBestOption(5.12, 3.90),
                Toast.LENGTH_LONG).show();
    }
}
