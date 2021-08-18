package com.shopkeeper.navigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shopkeeper.navigation.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false);
        binding.setFragment(this);
        return binding.getRoot();
    }

    public void jumpToDetailFragment(View view){
        Bundle args=new HomeFragmentArgs.Builder()
                .setAge(18)
                .setUserName("shopkeeper")
                .build().toBundle();
        NavController navController= Navigation.findNavController(view);
        navController.navigate(R.id.action_homeFragment_to_detailFragment,args);
    }
}