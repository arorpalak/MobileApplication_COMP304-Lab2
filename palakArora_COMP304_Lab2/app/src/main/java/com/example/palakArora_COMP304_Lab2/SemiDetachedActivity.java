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

public class SemiDetachedActivity extends AppCompatActivity {


    HomeAdapter homeAdapter;
    ListView homeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smi_detached);

        homeList= (ListView)findViewById(R.id.listView3);
        setTitle("Semi-detached homes");
        ArrayList<Home> homesArrayList= new ArrayList<>();
        homesArrayList.add(new Home( R.drawable.semidetached1, "777 Yonge Street, Toronto, Ontario", "$1,222,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.semidetached2, "333 Fairway Drive, Aurora, Ontario", "$555,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.semidetached3, "88 Finch West, Toronto, Ontario", "$444,900 CAD" ));
        homesArrayList.add(new Home( R.drawable.semidetached4, "395 Progress, Tecumseh, Ontario", "$333,000 CAD" ));
        homesArrayList.add(new Home( R.drawable.semidetached5, "111 North York, Toronto, Ontario", "$111,000 CAD" ));

        homeAdapter = new HomeAdapter(this,homesArrayList);
        homeList.setAdapter(homeAdapter);

        Toast.makeText(this, "Hello from  smi_detached", Toast.LENGTH_SHORT).show();

        homeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SemiDetachedActivity.this, "List Menu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        menu.getItem(2).setEnabled(false);
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
                intent = new Intent(SemiDetachedActivity.this, ApartmentActivity.class);
                startActivity(intent);
                return true;

            case R.id.detached_home:
                Toast.makeText(this, "Detached-home Screen", Toast.LENGTH_SHORT).show();
                intent = new Intent(SemiDetachedActivity.this, DetachedActivity.class);
                startActivity(intent);
                return true;

            case R.id.condominium_apartment:
                Toast.makeText(this, "Condominium Screen", Toast.LENGTH_SHORT).show();
                intent = new Intent(SemiDetachedActivity.this, CondominiumActivity.class);
                startActivity(intent);
                return true;
            case R.id.town_house:
                Toast.makeText(this, "Town House Screen", Toast.LENGTH_SHORT).show();
                intent = new Intent(SemiDetachedActivity.this, TownHouseActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
