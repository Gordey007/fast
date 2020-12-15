package com.example.fast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.gson.JsonObject;

import java.util.LinkedList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private Button submit;
    private ProgressDialog progressDialog;
    private String baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.submit);
        baseUrl = "http://educationctf.ru:8080/api/educ/";

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitData();
            }
        });
    }

    private void submitData() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.show();
        //Defining retrofit api service
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String user = "4bc69b6a-da17-ea11-80c9-000c292e71d0";

        LinkedList<String> myList = new LinkedList<String>();

        myList.add("{ \"Id\": 4, \"TextProgramm\": \"Off()\" }");
        myList.add("{ \"Id\": 13, \"TextProgramm\": \"On()\" }");
        myList.add("{ \"Id\": 6, \"TextProgramm\": \"On()\" }");
        myList.add("{ \"Id\": 7, \"TextProgramm\": \"On()\" }");
        myList.add("{ \"Id\": 3, \"TextProgramm\": \"On()\" }");
        myList.add("{ \"Id\": 2, \"TextProgramm\": \"Off()\" }");
        myList.add("{ \"Id\": 12, \"TextProgramm\": \"Off()\" }");
        myList.add("{ \"Id\": 17, \"TextProgramm\": \"Off()\" }");
        myList.add("{ \"Id\": 18, \"TextProgramm\": \"Off()\" }");
        myList.add("{ \"Id\": 14, \"TextProgramm\": \"Off()\" }");
        myList.add("{ \"Id\":10, \"TextProgramm\": \"On()\" }");
        myList.add("{ \"Id\": 0, \"TextProgramm\": \"On()\" }");
        myList.add("{ \"Id\": 15, \"TextProgramm\": \"On()\" }");
        myList.add("{ \"Id\": 9, \"TextProgramm\": \"On()\" }");
        myList.add("{ \"Id\": 11, \"TextProgramm\": \"On()\" }");
        myList.add("{ \"Id\": 19, \"TextProgramm\": \"Off()\" }");
        myList.add("{ \"Id\": 16, \"TextProgramm\": \"Off()\" }");
        myList.add("{ \"Id\": 8, \"TextProgramm\": \"On()\" }");
        myList.add("{ \"Id\": 1, \"TextProgramm\": \"On()\" }");
        myList.add("{ \"Id\": 5, \"TextProgramm\": \"On()\" }");

        for (int i = 0; i < 20; i++){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("guid", user);
            jsonObject.addProperty("answer", myList.get(i));
            ApiService service = retrofit.create(ApiService.class);
            Call<PostResponse> call = service.postData(jsonObject);

            //calling the api

            call.enqueue(new Callback<PostResponse>() {
                @Override
                public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                    //hiding progress dialog
                    progressDialog.dismiss();
                    if (response.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Команда выполнена!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<PostResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }







    }
}