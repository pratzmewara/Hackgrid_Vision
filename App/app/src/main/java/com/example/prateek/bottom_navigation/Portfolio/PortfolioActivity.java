package com.example.prateek.bottom_navigation.Portfolio;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.prateek.bottom_navigation.PasswordChangeStatus;
import com.example.kartikbhardwaj.bottom_navigation.R;


public class PortfolioActivity extends AppCompatActivity {

    TextView toolBarTitle;
    String stockName;
    String newStockName;
    String  buttonStatus;
    String rvStatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        toolBarTitle=findViewById(R.id.tool_bar_title);
        androidx.appcompat.widget.Toolbar toolbar =findViewById(R.id.tool_bar1);

        stockName = getIntent().getStringExtra("stock_name");
        newStockName=getIntent().getStringExtra("newStockName");

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);






        if(PasswordChangeStatus.rvCardstatus)
        {
            toolBarTitle.setText(stockName);


        }

        if(PasswordChangeStatus.buttonstatus)
        {
            toolBarTitle.setText(newStockName);

        }


        AvailableStocksFragment fragment=new AvailableStocksFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container1,fragment);
        fragmentTransaction.commit();



        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.stockanalysis:

                AvailableStocksFragment fragment1=new AvailableStocksFragment();
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container1,fragment1);
                fragmentTransaction.commit();
                return true;

            case R.id.portfoliopositions:

                PortfolioPositionsFragment fragment=new PortfolioPositionsFragment();
                FragmentManager fragmentManager1=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.container1,fragment);
                fragmentTransaction1.commit();
                item.setChecked(true);
                return true;

            case R.id.orderspending:

                PendingOrdersFragment fragment3=new PendingOrdersFragment();
                FragmentManager fragmentManager3=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                fragmentTransaction3.replace(R.id.container1,fragment3);
                fragmentTransaction3.commit();
                item.setChecked(true);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.portfolioappbaritems,menu);
        MenuItem item=menu.findItem(R.id.stockanalysis);
        item.setChecked(true);

        return true;
    }

}
