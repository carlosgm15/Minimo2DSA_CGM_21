package com.example.minimo2dsa_cgm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoUserActivity extends AppCompatActivity {

    List<Follower> listDatos = new ArrayList<>(); //instancia lista
    RecyclerView recycler;
    RecyclerView.Adapter mAdapter;

    TextView repos_text; //llamamos los elemntos.
    TextView following_text;
    ImageView image;

    Retrofit retrofit = new Retrofit.Builder() //l set up de retrofit
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create()) //uso gson para convertir los datos
            .build();
    API api = retrofit.create((API.class));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infouseractivity);

        recycler = findViewById(R.id.my_recycler_view); //referencia del recycler
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)); //como queremos los datos vertical, etc
        recycler.setHasFixedSize(true);

        repos_text = findViewById(R.id.Repos_text); //referencia de los campos de following, imagen etc
        following_text = findViewById(R.id.following_text);
        image = findViewById(R.id.miimagen);

        String tot;
        String tit;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras(); //usamos bundle para pasar datos entre activity
            if(extras == null) {
                tit= null;
            } else {
                tit=extras.getString("User"); //tenemos que pasarle la misma variable User que en el main
            }
        } else {
            tit =(String) savedInstanceState.getSerializable("User");
        }
        tot=tit;

        Call<List<Follower>> call = api.followersInfo(tot); //

        call.enqueue(new Callback<List<Follower>>() { //el callback trae un onresponse de la info en caso de ir bien, y un onfailure en caso e no ecocntrar na
            @Override
            public void onResponse(Call<List<Follower>> call, Response<List<Follower>> response) {
                if (!response.isSuccessful()) { //dara el codigo en caso de ir mal (400,404 etc) para hacerlo haria repos_text.setText("coidgo:" + response,code());
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "No se ha encontrado al man", Toast.LENGTH_SHORT);
                    toast1.show();
                    return;
                }
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "oleole", Toast.LENGTH_SHORT);
                toast1.show();
                listDatos = response.body(); //resspuesta del servidor parseada
                mAdapter = new MyAdapter(listDatos, InfoUserActivity.this);
                recycler.setAdapter(mAdapter);


            }

            @Override
            public void onFailure(Call<List<Follower>> call, Throwable t) {
            }
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Toast onFailure", Toast.LENGTH_SHORT);

        });

        Call<User> call1 = api.userInfo(tot);
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call1, Response<User> response) {
                if (!response.isSuccessful()) {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Datos del man", Toast.LENGTH_SHORT);
                    toast1.show();
                    return;
                }
            User user = response.body();
            repos_text.setText(Integer.toString(user.getPublic_repos()));
            following_text.setText(Integer.toString(user.getFollowing()));
            Picasso.get().load(user.getAvatar_url()).into(image);


            }

            @Override
            public void onFailure(Call<User> call1, Throwable t) {
            }
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Toast onFailure", Toast.LENGTH_SHORT);

        });

    }
}
