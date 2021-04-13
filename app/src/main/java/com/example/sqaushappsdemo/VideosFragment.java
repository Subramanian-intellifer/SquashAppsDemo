package com.example.sqaushappsdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.android.material.textview.MaterialTextView;


public class VideosFragment extends Fragment {

    GridView gridView;

    int[] thumbNailImages={
      R.drawable.sample_one,R.drawable.sample_two,R.drawable.sample_three,
            R.drawable.sample_one,R.drawable.sample_two,R.drawable.sample_three
    };

    String[] thumbNailTitles={
            "1000","1039","908","1000","1039","908"
    };

    public VideosFragment() {
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
        View root= inflater.inflate(R.layout.fragment_videos, container, false);
        gridView=root.findViewById(R.id.gridViewVideosFragment);
        gridView.setAdapter(new GridAdapter(getContext(),thumbNailImages,thumbNailTitles));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent=new Intent(getActivity(),VideoPlayerActivity.class);
                playerIntent.putExtra("POSITION",position);
                getActivity().startActivity(playerIntent);
            }
        });

        return root;
    }

    public class GridAdapter extends BaseAdapter{

        public Context mContext;
        int[] timageThumbNails;
        String[] nameThumbNails;
        public GridAdapter(Context context , int[] imageThumbNail,String[] thumbNailTitles )
        {
            this.mContext=context;
            this.timageThumbNails=imageThumbNail;
            this.nameThumbNails=thumbNailTitles;
        }

        @Override
        public int getCount() {
            return thumbNailImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View girdView_View;
            LayoutInflater layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView==null)
            {
                girdView_View=new View(mContext);
                girdView_View=layoutInflater.inflate(R.layout.grid_view_layout,null);
                MaterialTextView titleThumbNail=girdView_View.findViewById(R.id.imageTitleTextView);
                ImageView imageViewThumbNail=girdView_View.findViewById(R.id.thumbNailImageView);
                titleThumbNail.setText(thumbNailTitles[position]);
                imageViewThumbNail.setImageResource(thumbNailImages[position]);
            }
            else
            {
                girdView_View=convertView;
            }

            return girdView_View;
        }
    }






















}