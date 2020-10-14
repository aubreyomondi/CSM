package com.example.csm;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    // harmless comment
    private static final String TAG = MainActivity.class.getSimpleName();
    Toast toast;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.textView);

        CmInterface cmInterface = RetrofitInstance.getRetrofitInstance().create(CmInterface.class);
        Call<List<Currencies>> call= cmInterface.getCurrencies();
        call.enqueue(new Callback<List<Currencies>>() {
            @Override
            public void onResponse(Call<List<Currencies>> call, @NotNull Response<List<Currencies>> response) {



                if(!response.isSuccessful()){
                    textViewResult.setText( response.code());
                    return;
                }
                List<Currencies> mCurrencies = response.body();

                assert mCurrencies != null;
                Log.d(TAG,"list is full");
               /** for(Currencies currencies:mCurrencies){
                    String content = "";
                    content += "Base:" + currencies.getBase() + "/n";
                    content +=  "Quote" + currencies.getQuote()  + "/n";
                    content += "rates"  + currencies.getRates()  + "/n";
                    content += "Date"  + currencies.getDate()  + "/n/n";

                    textViewResult.append(content);

                }**/

            }

            @Override
            public void onFailure(Call<List<Currencies>> call, Throwable t) {
             textViewResult.setText("FAILED ");
             Log.d(TAG, "REQUEST FAILED");

            }
        });
    }
}