package com.example.ecoapp.menuTabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ecoapp.R;
import com.example.ecoapp.FoodAndRecycleRecipesFolder.RecycleItemFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecycleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecycleFragment extends Fragment {

    private static final String TAG = "RecycleFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecycleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecycleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecycleFragment newInstance(String param1, String param2) {
        RecycleFragment fragment = new RecycleFragment();
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

        View view = inflater.inflate(R.layout.fragment_recycle, container, false);

        ImageButton imageButtonGlass, imageButtonMetal, imageButtonPaper, imageButtonPlastic;
        imageButtonGlass = view.findViewById(R.id.imageButtonGlass);
        imageButtonMetal = view.findViewById(R.id.imageButtonMetal);
        imageButtonPaper = view.findViewById(R.id.imageButtonPaper);
        imageButtonPlastic = view.findViewById(R.id.imageButtonPlastic);

        //если выбрали переработку стекла
        imageButtonGlass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"Выбрана переработка стекла");
                RecycleItemFragment recycleItemFragment= new RecycleItemFragment("Стекло");
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, recycleItemFragment)
                        .commit();
            }
        });

        //если выбрали переработку металла
        imageButtonMetal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"Выбрана переработка металла");
                RecycleItemFragment recycleItemFragment= new RecycleItemFragment("Металл");
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, recycleItemFragment)
                        .commit();
            }
        });

        //если выбрали переработку бумаги
        imageButtonPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"Выбрана переработка бумаги");
                RecycleItemFragment recycleItemFragment= new RecycleItemFragment("Бумага");
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, recycleItemFragment)
                        .commit();
            }
        });

        //если выбрали переработку пластика
        imageButtonPlastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"Выбрана переработка пластика");
                RecycleItemFragment recycleItemFragment= new RecycleItemFragment("Пластик");
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, recycleItemFragment)
                        .commit();
            }
        });

        return view;
    }
}