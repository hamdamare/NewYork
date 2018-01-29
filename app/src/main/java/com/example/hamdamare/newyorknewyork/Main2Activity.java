package com.example.hamdamare.newyorknewyork;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hamdamare.newyorknewyork.R;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        //scaling images and letting it fit on any device
        //intent to launch activity
        Intent in = getIntent();
        //index is getting the extra info that we sent activity to indicate which index to display
        //use method to get extra info, you need the name which is our package name followed by
        //default value is -1 because if something is not in an array return -1 because array s dont have negative index volumes
        int index = in.getIntExtra("package com.example.hamdamare", -1);
        if (index > -1) {
            int pic = getimg(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleimg(img, pic);
        }
    }

    private int getimg(int index) {
        switch (index) {
            case 0:
                return R.drawable.famouslandmarks;
            case 1:
                return R.drawable.broadway;
            case 2:
                return R.drawable.halalguys;
            case 3:
                return R.drawable.cafe3;
            case 4:
                return R.drawable.art;
            case 5:
                return R.drawable.livebands2;
            //each case for each picture you have
            default:
                return -1;
        }
    }


    //2.Scaling the image
    //int pic is the image we want to scale
    private void scaleimg(ImageView img, int pic) {
        //determine size of screen, gives us access to the scren
        Display screen = getWindowManager().getDefaultDisplay();
        //gives us access to some javalibrary class that scales images for us
        BitmapFactory.Options options = new BitmapFactory.Options();

        //turn on boundaries to determine the width and height of stuff
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);
        //traces the boundaries
        int imgwidth = options.outWidth;
        int screenwidth = screen.getWidth();

        if (imgwidth > screenwidth) {
            int ratio = Math.round((float) imgwidth / (float) screenwidth);
            options.inSampleSize = ratio;

        }


        options.inJustDecodeBounds = false;
        Bitmap scaledimg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledimg);

    }

}




