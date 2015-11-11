package com.example.rogelio.saludtec;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by hugo on 11/11/15.
 */
public class MenuFragment extends Fragment {
    public static final String ARG_IMAGE_ID = "image_id_arg";
    ImageView optionIV;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragmento_imagen_principal, container, false);

        Bundle args = getArguments();
        if(args != null) {
            int imageId = args.getInt(ARG_IMAGE_ID);
            setValues(rootView, imageId);

        }
        return rootView;
    }


//  le pone la imagen al imageView
    private void setValues(View rootView, int imageId) {
        optionIV = (ImageView)rootView.findViewById(R.id.imageViewer);
        optionIV.setImageResource(imageId);
    }
}
