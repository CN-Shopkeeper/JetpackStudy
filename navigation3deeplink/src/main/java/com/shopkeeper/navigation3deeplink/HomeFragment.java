package com.shopkeeper.navigation3deeplink;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.shopkeeper.navigation3deeplink.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    private int notificationId = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.setFragment(this);
        return binding.getRoot();
    }

    public void jumpToDetailFragment(View view) {
        sendNotification();
    }

    private void sendNotification() {
//        通知渠道
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(getActivity().getPackageName(), "my_channel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("my notification channel");
            NotificationManager manager = getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        Notification notification = new NotificationCompat.Builder(getActivity(), getActivity().getPackageName())
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("deep link")
                .setContentText("点击我试试...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(getPendingIntent())
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getActivity());
        notificationManagerCompat.notify(notificationId++, notification);
    }

    private PendingIntent getPendingIntent() {
        Bundle args = new HomeFragmentArgs.Builder()
                .setAge(18)
                .setName("shopkeeper")
                .build()
                .toBundle();
        return Navigation.findNavController(binding.getRoot())
                .createDeepLink()
                .setGraph(R.navigation.my_nav_graph)
                .setDestination(R.id.detailFragment)
                .setArguments(args)
                .createPendingIntent();
    }
}