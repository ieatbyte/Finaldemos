package com.wh.finaldemos.demos.system.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
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
        sendNotificationWithBigImg();
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

    private void sendNotificationWithBigImg() {
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
        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        style.setBigContentTitle("big title");
        style.setSummaryText("summery text");
        style.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.lenna));
        BitmapFactory.Options ops = new BitmapFactory.Options();
        ops.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.lenna, ops);
        Log.e("SendNotificationActivity", ", outWidth:" + ops.outWidth + ", outHeight:" + ops.outHeight + ", sys width:" + getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_width));
        //int sampleSize = ops.outHeight / getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_height);
        int sampleSize = ops.outWidth / getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_width);
        ops = new BitmapFactory.Options();
        ops.inJustDecodeBounds = false;
        ops.inSampleSize = sampleSize;
        ops.inDensity = getResources().getDisplayMetrics().densityDpi; //DisplayMetrics.DENSITY_HIGH;
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.lenna, ops);
        Log.e("SendNotificationActivity", "dpi:" + getResources().getDisplayMetrics().densityDpi + ", sampleSize:" + sampleSize + ", outWidth:" + ops.outWidth + ", outHeight:" + ops.outHeight + ", sys width:" + getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_width) + ", realWidth:" + largeIcon.getWidth() + ", realHeight:" + largeIcon.getHeight());
        builder.setSmallIcon(R.drawable.v2_loading).setLargeIcon(largeIcon)
                .setContentTitle("My notification")
                .setContentText("Hello World!").setDefaults(NotificationCompat.DEFAULT_ALL).setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_MAX)
                .setContentIntent(resultPendingIntent).setStyle(style);
        Notification notification =  builder.build();
        //notification.defaults &= ~android.support.v7.app.NotificationCompat.DEFAULT_VIBRATE;
        //notification.defaults &= ~android.support.v7.app.NotificationCompat.DEFAULT_SOUND;
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(id, notification);

    }
}
