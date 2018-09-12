package com.example.redhelicopter07.firebasething;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        String titel = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();
        MyNotificationManager.getInstance(getApplicationContext()).displayNotification(titel,body);
    }


}
