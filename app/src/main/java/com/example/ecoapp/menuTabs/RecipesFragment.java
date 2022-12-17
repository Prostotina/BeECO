package com.example.ecoapp.menuTabs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecoapp.R;
import com.example.ecoapp.tabsForFoodRecipes.ViewPagerAdapter;
import com.example.ecoapp.tabsForFoodRecipes.ViewPagerFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipesFragment extends Fragment {


    int tabCount;
    final String LOG_TAG = "myLogs";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public RecipesFragment() {
        tabCount =0;
    }

    public RecipesFragment(int tabCount) {
        this.tabCount = tabCount;
    }


    // TODO: Rename and change types and number of parameters
    public static RecipesFragment newInstance(String param1, String param2) {
        RecipesFragment fragment = new RecipesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TabLayout tabLayout;
        TabLayout.Tab tab;
        ViewPager2 viewPager;

        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        tabLayout = view.findViewById(R.id.tabLayoutRecipes);

        viewPager = view.findViewById(R.id.viewPagerRecipes);
        Log.d(LOG_TAG, "Создание ViewPagerAdapter");
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);


        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch(position){
                            case(0):
                                tab.setText("Продукты");
                                break;
                            case(1):
                                tab.setText("Рецепты");
                                break;
                            case(2):
                                tab.setText("Холодильник");
                                break;
                        }
                    }
                }).attach();

        if(tabCount == 3)
        {
            tab = tabLayout.getTabAt(tabCount -1);
            tab.select();
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(LOG_TAG, "position: " + tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return view;
    }

    private RecyclerView.Adapter createAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        return adapter;
    }


}