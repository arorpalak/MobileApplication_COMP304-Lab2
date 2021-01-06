package com.example.palakArora_COMP304_Lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TownHouseActivity extends AppCompatActivity {

    ListView homeList;
    HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment);

        homeList= (ListView)findViewById(R.id.listView3);
        setTitle("Townhouses");
        ArrayList<Home> homesArrayList= new ArrayList<>();
        homesArrayList.add(new Home( R.drawable.townhouse1, "18 Jane Street, Toronto, Ontario", "$1,111,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.townhouse2, "33 Emily Drive, Aurora, Ontario", "$888,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.townhouse3, "888 North York, Toronto, Ontario", "$333,900 CAD" ));
        homesArrayList.add(new Home( R.drawable.townhouse4, "19 Clark Blvd, Brampton, Ontario", "$454,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.townhouse5, "66 Bay Street, Toronto, Ontario", "$567,000 CAD" ));

        homeAdapter = new HomeAdapter(this,homesArrayList);
        homeList.setAdapter(homeAdapter);


        homeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TownHouseActivity.this, "Main Menu Screen", Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        Intent intent = new Intent(TownHouseActivity.this,ApartmentActivity.class);
                        startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        menu.getItem(5).setEnabled(false);
        return true;
    }
    public void goToSelectedHomes(View view)
    {
        Intent intent = new Intent(getApplicationContext(), SelectedHomes.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;



            switch (item.getItemId()) {
                case R.id.apartment:
                    Toast.makeText(this, "Apartment Screen", Toast.LENGTH_SHORT).show();
                    intent = new Intent(TownHouseActivity.this, ApartmentActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.detached_home:
                    Toast.makeText(this, "Detached-home Screen", Toast.LENGTH_SHORT).show();
                    intent = new Intent(TownHouseActivity.this, DetachedActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.semiDetached_home:
                    Toast.makeText(this, "Semi-detached home Screen", Toast.LENGTH_SHORT).show();
                    intent = new Intent(TownHouseActivity.this, SemiDetachedActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.condominium_apartment:
                    Toast.makeText(this, "Condominium Screen", Toast.LENGTH_SHORT).show();
                    intent = new Intent(TownHouseActivity.this, CondominiumActivity.class);
                    startActivity(intent);
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }

    }
}
