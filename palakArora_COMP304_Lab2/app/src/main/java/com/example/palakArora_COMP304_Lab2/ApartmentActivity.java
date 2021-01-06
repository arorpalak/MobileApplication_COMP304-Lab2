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

public class ApartmentActivity extends AppCompatActivity {

    ListView homeList;
    HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment);

        homeList= (ListView)findViewById(R.id.listView3);
        setTitle("Apartments");
        ArrayList<Home> homesArrayList= new ArrayList<>();
        homesArrayList.add(new Home( R.drawable.apartment1, "19 Emily Street, Toronto, Ontario", "$1,111,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.apartment2, "1111 Futura Drive, Aurora, Ontario", "$999,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.apartment3, "45 Clark Road, Brampton, Ontario", "$444,500 CAD" ));
        homesArrayList.add(new Home( R.drawable.apartment4, "222 Progress Street, Cambridge, Ontario", "$333,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.apartment5, "77 Yonge Street, Toronto, Ontario", "$222,000 CAD" ));

        homeAdapter = new HomeAdapter(this,homesArrayList);
        homeList.setAdapter(homeAdapter);


        homeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ApartmentActivity.this, "Welcome", Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        Intent intent = new Intent(ApartmentActivity.this,ApartmentActivity.class);
                        startActivity(intent);
                }
            }
        });
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        menu.getItem(0).setEnabled(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;


            switch (item.getItemId()) {

                case R.id.detached_home:
                    Toast.makeText(this, "Detached home Screen", Toast.LENGTH_SHORT).show();
                    intent = new Intent(ApartmentActivity.this, DetachedActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.semiDetached_home:
                    Toast.makeText(this, "Semi-detached home Screen", Toast.LENGTH_SHORT).show();
                    intent = new Intent(ApartmentActivity.this, SemiDetachedActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.condominium_apartment:
                    Toast.makeText(this, "Condominium Screen", Toast.LENGTH_SHORT).show();
                    intent = new Intent(ApartmentActivity.this, CondominiumActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.town_house:
                    Toast.makeText(this, "Town House Screen", Toast.LENGTH_SHORT).show();
                    intent = new Intent(ApartmentActivity.this, TownHouseActivity.class);
                    startActivity(intent);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        public void goToSelectedHomes(View view)
        {
            Intent intent = new Intent(getApplicationContext(), SelectedHomes.class);
            startActivity(intent);
        }

    }
