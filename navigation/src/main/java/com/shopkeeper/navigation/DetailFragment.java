package com.shopkeeper.navigation;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shopkeeper.navigation.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {

    FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false);
        binding.setFragment(this);
        HomeFragmentArgs args=HomeFragmentArgs.fromBundle(getArguments());
        String userName=args.getUserName();
        int age=args.getAge();
        Log.i("shopkeeperTag", "onCreateView: user_name: "+userName+" age: "+age);
        return binding.getRoot();
    }

    public void jumpToHomeFragment(View view){
        NavController navController= Navigation.findNavController(view);
        navController.navigate(R.id.action_detailFragment_to_homeFragment);
    }
}