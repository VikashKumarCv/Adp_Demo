package com.example.adap_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.adap_demo.Classes.RecyclerItemClickListener;
import com.example.adap_demo.Fragments.FirstFragment;

import java.util.ArrayList;

import Adapters.ResAdapt;
import Models.ResMdl;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linear_Layout);

        recyclerView = findViewById(R.id.recyclerview);

        ArrayList<ResMdl> list = new ArrayList<>();
        list.add(new ResMdl(R.drawable.f2 , "Manis") );
        list.add(new ResMdl(R.drawable.f3 , "Kanis") );
        list.add(new ResMdl(R.drawable.f2 , "Sanis") );
        list.add(new ResMdl(R.drawable.f4 , "Danis") );
        list.add(new ResMdl(R.drawable.f2 , "Nanis") );

        ResAdapt adapter = new ResAdapt(list , this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener
                (this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {


                        switch (position){
                            case 0:
                               // FirstFragment firstFragment = new FirstFragment();
                                //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                //transaction.replace(R.id.linear_Layout , firstFragment);
                                //transaction.commit();


                                Intent intent = new Intent(MainActivity.this , ScrollingActivity.class);
                                startActivity(intent);


                                break;
                                default:
                        }
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }


                ));

      //Horizontal scroll: //  LinearLayoutManager layoutManager = new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL, false);
        //recyclerView.setLayoutManager(layoutManager);

    }
}