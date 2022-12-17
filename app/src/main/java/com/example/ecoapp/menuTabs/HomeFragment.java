package com.example.ecoapp.menuTabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ecoapp.ExpiredProductsFolder.AdapterForExpiredProducts;
import com.example.ecoapp.ExpiredProductsFolder.ExpiredProducts;
import com.example.ecoapp.R;
import com.example.ecoapp.SettingsFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


    View view;
    private List<ExpiredProducts> expiredProductsList;
    ImageButton buttonSettings;
    Button buttonOpenExpiredProducts;
    ChipNavigationBar bottomNav;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public HomeFragment(ChipNavigationBar bottomNav) {
        this.bottomNav = bottomNav;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        buttonSettings = (ImageButton) view.findViewById(R.id.img_button_settings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFragment settingsFragment= new SettingsFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.constraint_layout_home, settingsFragment)
                        .commit();
            }
        });

        buttonOpenExpiredProducts = view.findViewById(R.id.buttonOpenExpiredProducts);
        buttonOpenExpiredProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecipesFragment recipesFragment= new RecipesFragment(3);
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.constraint_layout_home, recipesFragment)
                        .commit();
            }
        });

        RecyclerView rv = view.findViewById(R.id.recyclerViewExpiredFood);
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(llm);

        initializeDataExpiredFood();

        AdapterForExpiredProducts adapter = new AdapterForExpiredProducts(expiredProductsList);
        rv.setAdapter(adapter);

        return view;
    }

    //составление списка продуктов
    private void initializeDataExpiredFood(){
        expiredProductsList = new ArrayList<>();
        expiredProductsList.add(new ExpiredProducts(1,"Морковь", "01.01.2022"));
        expiredProductsList.add(new ExpiredProducts(2,"Картошка", "01.01.2022"));
    }



}