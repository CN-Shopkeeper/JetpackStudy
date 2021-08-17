package com.shopkeeper.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.shopkeeper.navigation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
//        FragmentContainerView的问题，此时NavController还没有构建完成
        binding.getRoot().post(()->{
            NavController controller=Navigation.findNavController(binding.fragmentContainerView);
            NavigationUI.setupActionBarWithNavController(this,controller);
        });
    }
//  接管返回键
    @Override
    public boolean onSupportNavigateUp() {
        NavController controller=Navigation.findNavController(binding.fragmentContainerView);
        return controller.navigateUp();
    }
}