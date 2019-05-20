package com.example.pankaj.extraaedge_assignment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   @BindView(R.id.tv)
   TextView tv;
    public static String API_KEY="c68637ca4bfb6d76405ed48c72c74c83";

    boolean connected = false;
    String m="";
    Abc obj=new Abc();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String CATEGORY="weather";
        String Q="Pune,india";
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Please wait :) ");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(true);

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;



        if (API_KEY.isEmpty()){
            Toast.makeText(MainActivity.this,"api_key is empty",Toast.LENGTH_SHORT).show();
        }

        ApiInterface apiInterface=ApiClient.getClient().create(ApiInterface.class);
        Call<Abc> call=apiInterface.aaa(CATEGORY,Q,API_KEY);

        call.enqueue(new Callback<Abc>() {
            @Override
            public void onResponse(Call<Abc> call, Response<Abc> response) {

                obj=response.body();
                Float t=obj.getMain().getTemp();
                m=t.toString();
                if(connected){
                    tv.setText("temperature of Pune is :" + m + " " + "F");
            }else if(!connected){
                    progress.show();
                }
            }

            @Override
            public void onFailure(Call<Abc> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}
