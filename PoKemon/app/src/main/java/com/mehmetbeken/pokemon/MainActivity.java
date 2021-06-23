package com.mehmetbeken.kerim;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mehmetbeken.kerim.retro.Model;
import com.mehmetbeken.kerim.retro.Servis;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    NavController navController=Navigation.findNavController(this,R.id.fragment);
    AppBarConfiguration appBarConfiguration=new AppBarConfiguration.Builder(navController.getGraph()).build();
    Toolbar toolbar=findViewById(R.id.toolbar);
    NavigationUI.setupWithNavController(toolbar,navController,appBarConfiguration);















    }

}
//BASE_URL="https://gist.githubusercontent.com/";

//"Pokémon"