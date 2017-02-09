package com.wh.finaldemos.demos.system.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Button;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.id;

public class SendNotificationActivity extends BaseDemoActivity {

    @BindView(R.id.send_noti)
    Button sendBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.send_noti)
    void onSendClick() {
        sendNotification();
    }

    private void sendNotification() {
        Intent resultIntent = new Intent(this, SendNotificationActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack
        stackBuilder.addParentStack(SendNotificationActivity.class);
// Adds the Intent to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
// Gets a PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.v2_loading)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(id, builder.build());

    }
}
