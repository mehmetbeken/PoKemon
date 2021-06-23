package com.mehmetbeken.kerim.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mehmetbeken.kerim.R;
import com.squareup.picasso.Picasso;


public class TypeFragment extends Fragment {

    TextView textView;
    ImageView imageView;


    public TypeFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_type, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    textView=view.findViewById(R.id.textDescription2);
    imageView=view.findViewById(R.id.imageView2);


        if (getArguments() !=null){

            String description=TypeFragmentArgs.fromBundle(getArguments()).getDescription();
            textView.setText(description);

            String img=TypeFragmentArgs.fromBundle(getArguments()).getImageUrl();

            Picasso.get().load(img).into(imageView);

            String name=TypeFragmentArgs.fromBundle(getArguments()).getName();














        }
    }
}