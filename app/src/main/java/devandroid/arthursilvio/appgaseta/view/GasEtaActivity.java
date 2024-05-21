package devandroid.arthursilvio.appgaseta.view;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.arthursilvio.appgaseta.R;
import devandroid.arthursilvio.appgaseta.apoio.UtilGasEta;
import devandroid.arthursilvio.appgaseta.model.Fuel;

public class GasEtaActivity extends AppCompatActivity {

    Fuel fuelEta;
    Fuel fuelGas;
    EditText editEta;
    EditText editGas;
    Button buttonCalc;
    TextView txtResult;
    Button buttonClean;
    Button buttonSave;
    Button buttonFinish;

    double mGas;
    double mEta;
    String recommendation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        editEta = findViewById(R.id.editEta);
        editGas = findViewById(R.id.editGas);
        buttonCalc = findViewById(R.id.buttonCalc);
        txtResult = findViewById(R.id.txtResult);
        buttonClean = findViewById(R.id.buttonClean);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);

        buttonCalc.setOnClickListener(v -> {
            boolean isDataOk = true;

            if (TextUtils.isEmpty(editEta.getText())){
                editEta.setError("* OBRIGATÓRIO");
                editEta.requestFocus();
                isDataOk = false;
            }

            if (TextUtils.isEmpty(editGas.getText())){
                editGas.setError("* OBRIGATÓRIO");
                editGas.requestFocus();
                isDataOk = false;
            }

            if (isDataOk){

                mEta = Double.parseDouble(editEta.getText().toString());
                mGas = Double.parseDouble(editGas.getText().toString());

                recommendation = UtilGasEta.calculateBestOption(mEta, mGas);

                txtResult.setText(recommendation);
            }else{
                Toast.makeText(GasEtaActivity.this, "Digite os dados corretamente...",
                        Toast.LENGTH_LONG).show();
            }

        });

        buttonClean.setOnClickListener(v -> {
            editGas.setText("");
            editEta.setText("");
        });

        buttonFinish.setOnClickListener(v -> {
            Toast.makeText(GasEtaActivity.this, "Finalizado",
                    Toast.LENGTH_LONG).show();
            finish();
        });

        buttonSave.setOnClickListener(v -> {

            //TODO: DESABILITAR  O BOTÃO SALVAR

            fuelGas = new Fuel();
            fuelEta = new Fuel();

            fuelGas.setNameFuel("Gasolina");
            fuelGas.setPriceFuel(mGas);
            fuelGas.setRecommendation(UtilGasEta.calculateBestOption(mEta, mGas));

            fuelEta.setNameFuel("Etanol");
            fuelEta.setRecommendation(UtilGasEta.calculateBestOption(mEta, mGas));
            fuelEta.setPriceFuel(mEta);

        });

    }
}
