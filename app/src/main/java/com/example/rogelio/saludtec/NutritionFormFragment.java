package com.example.rogelio.saludtec;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hugo on 11/15/15.
 */
public class NutritionFormFragment extends Fragment {

//    public static final String ARG_IMAGE_ID = "image_id_arg";

    public static final String ARG_POS = "nutrition_form_pos";
    public static final String ARG_MAIN = "main_question_arg";
    public static final String ARG_SUB = "sub_question_arg";
//    ImageView optionIV;
    TextView mainTV;
    TextView subTV;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragmento_formulario_nutricion, container, false);

        mainTV = (TextView)rootView.findViewById(R.id.mainNutTV);
        subTV = (TextView)rootView.findViewById(R.id.subNutTV);


        Bundle args = getArguments();
        if(args != null) {
            String mainQ = args.getString(ARG_MAIN);
            String subQ = args.getString(ARG_SUB);
            setValues(rootView, mainQ, subQ);
        }
        return rootView;
    }


    //  le pone la imagen al imageView
    private void setValues(View rootView, String mainQ, String subQ) {
        mainTV.setText(mainQ);
        subTV.setText(subQ);
    }
}
