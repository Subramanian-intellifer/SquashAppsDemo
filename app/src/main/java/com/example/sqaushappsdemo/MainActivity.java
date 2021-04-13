package com.example.sqaushappsdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MaterialTextView atProfileNameTextView;
    MaterialButton followButton;
    ImageView followIconImageView;

    Toolbar toolBar;

    int[] tabIcons={
            R.drawable.ic_baseline_videocam_24,R.drawable.heart_icon
    };

    String[] tabTitles={
          "Videos","Liked"
    };

    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolBar=findViewById(R.id.toolBarId);
        setActionBar(toolBar);
//        setSupportActionBar(toolBar);

        viewPager=findViewById(R.id.viewPagerMainActivity);

        setUpViewPager(viewPager);

        tabLayout=findViewById(R.id.tabLayout_MainActivity);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);


        atProfileNameTextView=findViewById(R.id.profileNameIdTextView);
        followButton=findViewById(R.id.followButton);
        followIconImageView=findViewById(R.id.followIconButton);
        atProfileNameTextView.setText("@elenor233");

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Follow Button Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        followIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Follow Icon ImageView Clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void setUpViewPager(ViewPager viewPage)
    {
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragment(new VideosFragment(),"Videos");
        viewPagerAdapter.AddFragment(new LikedFragment(),"Liked");
        viewPager.setAdapter(viewPagerAdapter);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> fragmentList=new ArrayList<>();
        List<String> fragmentListTitle=new ArrayList<>();


        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void AddFragment(Fragment fragment, String titleTab)
        {
            fragmentList.add(fragment);
            fragmentListTitle.add(titleTab);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            Drawable imageDrawable=getApplicationContext().getResources().getDrawable(tabIcons[position]);
            imageDrawable.setBounds(0,0,imageDrawable.getIntrinsicWidth(),imageDrawable.getIntrinsicHeight());
            SpannableString spannableString=new SpannableString(" "+tabTitles[position]);
            ImageSpan imageSpan=new ImageSpan(imageDrawable,ImageSpan.ALIGN_BOTTOM);
            spannableString.setSpan(imageSpan,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            return spannableString;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.more_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        if(id==0)
        {
            Toast.makeText(getApplicationContext(),"Share Option Clicked",Toast.LENGTH_SHORT).show();
        }
        else if(id==1)
        {
            Toast.makeText(getApplicationContext(),"Report Option Clicked",Toast.LENGTH_SHORT).show();
        }
        return true;
    }















}