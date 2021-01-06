package com.example.palakArora_COMP304_Lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class MenuDisplayer extends AppCompatActivity {

    ListView homeList;
    HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_displayer);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.apartment:
                Toast.makeText(this, "Apartment Screen", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(this,ApartmentActivity.class);
                startActivity(intent);
                return true;
            case R.id.detached_home:
                Toast.makeText(this, "Detached-home Screen", Toast.LENGTH_SHORT).show();
                 intent= new Intent( MenuDisplayer.this,DetachedActivity.class);
                startActivity(intent);
                return true;
            case R.id.semiDetached_home:
                Toast.makeText(this, "Semi-detached home Screen", Toast.LENGTH_SHORT).show();
                intent= new Intent(MenuDisplayer.this, SemiDetachedActivity.class);
                startActivity(intent);
                return true;
            case R.id.condominium_apartment:
                Toast.makeText(this, "Condominium Screen", Toast.LENGTH_SHORT).show();
                intent= new Intent(MenuDisplayer.this,CondominiumActivity.class);
                startActivity(intent);
                return true;
            case R.id.town_house:
                Toast.makeText(this, "Town House Screen", Toast.LENGTH_SHORT).show();
                intent= new Intent(MenuDisplayer.this,TownHouseActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
