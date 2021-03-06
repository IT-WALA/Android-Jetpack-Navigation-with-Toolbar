package com.example.navigationcomponent;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;

public class FragmentTwo extends Fragment {

    private View rootView;
    private NavController navController;
    private ToolbarManager toolbarManager;
    private Toolbar toolbar;
    private Button btnGoToThirdFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_two, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.fragmentContainerView);
        toolbarManager = ToolbarManager.getInstance();

        toolbar = rootView.findViewById(R.id.toolbar2);
        btnGoToThirdFragment = rootView.findViewById(R.id.btnGoToThirdFragment);

        setupToolbar();

        btnGoToThirdFragment.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                navController.navigate(R.id.action_fragmentTwo_to_fragmentThree);
            }
        });

        return rootView;
    }

    private void setupToolbar() {
        toolbarManager.setupToolbar(getActivity(), navController, null, toolbar,
                true);
    }

}