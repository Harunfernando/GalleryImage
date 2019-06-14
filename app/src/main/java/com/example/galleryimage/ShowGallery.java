package com.example.galleryimage;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.agus.gallery.R;

public class ShowGallery extends Activity
{
    Integer[] list_image = {
            R.drawable.raisa,
            R.drawable.rizky,
            R.drawable.brisia_jodie,
            R.drawable.maria,
            R.drawable.ran,
            R.drawable.tulus,
    };
    String[] fruit_name = {"Indonesia: Apel \nInggris: Apple","Indonesia:Pisang \nInggris:Banana","Indonesia: Ceri \nInggris: Cherry","Indonesia: Mangga \nInggris: Mango","Indonesia: Mangga \nInggris: Orange","Indonesia: Pir \nInggris: Pear","Indonesia: Semangka \nInggris: Water Melon"};

    @Override
    public void onCreate(Bundle savedInstanceState)

    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        gallery.setAdapter(new ImageAdapter(this));

        gallery.setOnItemClickListener(new OnItemClickListener()

        {
            public void onItemClick(AdapterView parent,

                                    View v, int position, long id)

            {

                Toast.makeText(getBaseContext(),
                        fruit_name[position],

                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ImageAdapter extends BaseAdapter
    {
        private Context context;
        private int itemBackground;

        public ImageAdapter(Context c)

        {

            context = c;
            TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);

            itemBackground = a.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 0);

            a.recycle();

        }
        public int getCount() {
            return list_image.length;
        }
        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView = new ImageView(context);
            imageView.setImageResource(list_image[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(150, 150));
            imageView.setBackgroundResource(itemBackground);

            return imageView;

        }

    }

}
