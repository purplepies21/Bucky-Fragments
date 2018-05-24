package com.example.ashmint.buckyfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import  android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class TopSectionFragment extends Fragment {


    private static EditText topTextInput;
    private static EditText bottomTextInput;


    TopSectionListener activityCommander;
    public interface TopSectionListener{

        public void createMeme(String top, String bottom);

    }

    @Override
    public void onAttach(Context context) {

        try{
          activityCommander = (TopSectionListener) context;

        }catch(ClassCastException e){
            throw new ClassCastException(context.toString());

        }
        super.onAttach(context);

    }

    private Button button;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view= inflater.inflate(R.layout.top_section_fragment, container, false);
        topTextInput=view.findViewById(R.id.topTextInput);
        bottomTextInput=view.findViewById(R.id.bottomTextInput);
        button=view.findViewById(R.id.button);


        button.setOnClickListener( new View.OnClickListener(){

          public void onClick(View view){
              buttonClicked(view);

          }
        });

    return view;

    }
//calls this when button is clicked
    public void buttonClicked(View view){
    activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());

    }
}
