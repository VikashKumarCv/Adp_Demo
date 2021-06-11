package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adap_demo.MainActivity;
import com.example.adap_demo.R;
import com.example.adap_demo.ScrollingActivity;

import java.util.ArrayList;

import Models.ResMdl;

public class ResAdapt extends RecyclerView.Adapter<ResAdapt.viewHolder> {
    ArrayList<ResMdl> list;
    Context context;

    public ResAdapt(ArrayList<ResMdl> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recy , parent , false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        ResMdl model = list.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.textView.setText(model.getText());

        switch (position){
            case 0:
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Intent intent = new Intent(MainActivity.this , ScrollingActivity.class);
                        //startActivity(intent);

                        Toast.makeText(context, "image one is clcked", Toast.LENGTH_SHORT).show();
                    }
                });

                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Text clicked", Toast.LENGTH_SHORT).show();
                    }
                });


                break;

            default:


        }


       // holder.imageView.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
             //   Toast.makeText(context, "item clicked" , Toast.LENGTH_SHORT).show();
            //}
        //});


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.textView);



        }
    }
}
