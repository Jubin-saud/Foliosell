package com.saharia.notesell.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.saharia.notesell.Fragments.AddFragment;
import com.saharia.notesell.Fragments.FavouriteFragment;
import com.saharia.notesell.Fragments.HomeFragment;
import com.saharia.notesell.Fragments.TrendingFragment;
import com.saharia.notesell.Fragments.userProfileFragment;
import com.saharia.notesell.R;
import com.saharia.notesell.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
      ActivityHomeBinding binding;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        FragmentTransaction homeFrag= getSupportFragmentManager().beginTransaction();
        homeFrag.replace(R.id.container,new HomeFragment());
        homeFrag.commit();

        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()){

                    case R.id.home:
                        transaction.replace(R.id.container,new HomeFragment());
                        break;

                    case R.id.profile:

                        transaction.replace(R.id.container,new userProfileFragment());
                        break;
                    case R.id.add:
                        transaction.replace(R.id.container,new AddFragment());
                        break;
                    case R.id.com:
                        transaction.replace(R.id.container,new TrendingFragment());
                        break;
                    case R.id.chats:
                        transaction.replace(R.id.container,new FavouriteFragment());
                        break;
                }
                transaction.commit();
                return  true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.u_profile:
                Toast.makeText(this, "Feature Under Construction", Toast.LENGTH_SHORT).show();
                break;
            case R.id.log:
                mAuth.signOut();
                Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(this, "Logged out succesfully", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}