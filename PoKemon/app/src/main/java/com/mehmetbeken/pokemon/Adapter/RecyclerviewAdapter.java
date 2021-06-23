package com.mehmetbeken.kerim.Adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.mehmetbeken.kerim.Fragment.PokemonFragmentDirections;
import com.mehmetbeken.kerim.R;
import com.mehmetbeken.kerim.retro.Model;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.RowHolder> {

    private ArrayList<Model> modelList;


    public RecyclerviewAdapter(ArrayList<Model> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.recyclerview_row,parent,false);


        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {

        holder.textName.setText(modelList.get(position).name);
        holder.textDescription.setText(modelList.get(position).description);

        Picasso.get().load(modelList.get(position).imageUrl).into(holder.imageView);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PokemonFragmentDirections.ActionPokemonFragmentToTypeFragment action=PokemonFragmentDirections.actionPokemonFragmentToTypeFragment(modelList.get(position).description,modelList.get(position).imageUrl,modelList.get(position).name);
                action.setDescription(modelList.get(position).description);
                action.setImageUrl(modelList.get(position).imageUrl);
                action.setName(modelList.get(position).name);

                Navigation.findNavController(view).navigate(action);

            }
        });








    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class RowHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textName;
        TextView textDescription;



        public RowHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textName=itemView.findViewById(R.id.textName);
            textDescription=itemView.findViewById(R.id.textDescription);

        }
    }
}
