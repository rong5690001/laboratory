package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    val notificationManagerCompat by lazy {
        NotificationManagerCompat.from(this)
    }

    var notificationId = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNotification.setOnClickListener(this)
        tvMessage.movementMethod = ScrollingMovementMethod.getInstance()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnNotification -> {
                val builder =
                    NotificationCompat.Builder(this, "PUSH_NOTIFY_ID")
//设置小图标
                val drawable: Drawable? =
                    ContextCompat.getDrawable(this, R.drawable.bg_login)
                val bitmap = (drawable as BitmapDrawable).bitmap
                //设置小图标
                builder.setSmallIcon(R.drawable.bg_login)
                //设置大图标
                builder.setLargeIcon(bitmap)
                //设置标题
                //设置标题
                builder.setContentTitle("这是标题")
                //设置通知正文
                //设置通知正文
                builder.setContentText("这是正文，当前ID是：$notificationId")
                //设置摘要
                //设置摘要
                builder.setSubText("这是摘要")
                //设置是否点击消息后自动clean
                //设置是否点击消息后自动clean
                builder.setAutoCancel(true)
                //显示指定文本
                //显示指定文本
                builder.setContentInfo("Info")
                //与setContentInfo类似，但如果设置了setContentInfo则无效果
                //用于当显示了多个相同ID的Notification时，显示消息总数
                //与setContentInfo类似，但如果设置了setContentInfo则无效果
                //用于当显示了多个相同ID的Notification时，显示消息总数
                builder.setNumber(2)
                //通知在状态栏显示时的文本
                //通知在状态栏显示时的文本
                builder.setTicker("在状态栏上显示的文本")
                //设置优先级
                //设置优先级
                builder.setPriority(NotificationCompat.PRIORITY_MAX)
                //自定义消息时间，以毫秒为单位，当前设置为比系统时间少一小时
                //自定义消息时间，以毫秒为单位，当前设置为比系统时间少一小时
                builder.setWhen(System.currentTimeMillis() - 3600000)
                //设置为一个正在进行的通知，此时用户无法清除通知
                //设置为一个正在进行的通知，此时用户无法清除通知
//                builder.setOngoing(true)
                //设置消息的提醒方式，震动提醒：DEFAULT_VIBRATE     声音提醒：NotificationCompat.DEFAULT_SOUND
                //三色灯提醒NotificationCompat.DEFAULT_LIGHTS     以上三种方式一起：DEFAULT_ALL
                //设置消息的提醒方式，震动提醒：DEFAULT_VIBRATE     声音提醒：NotificationCompat.DEFAULT_SOUND
                //三色灯提醒NotificationCompat.DEFAULT_LIGHTS     以上三种方式一起：DEFAULT_ALL
                builder.setDefaults(NotificationCompat.DEFAULT_SOUND)
                //设置震动方式，延迟零秒，震动一秒，延迟一秒、震动一秒
                //设置震动方式，延迟零秒，震动一秒，延迟一秒、震动一秒
                builder.setVibrate(longArrayOf(0, 1000, 1000, 1000))

                val remoteView = RemoteViews(packageName, R.layout.layout_notification)
                remoteView.setTextViewText(R.id.tvTitle, "标题")
                remoteView.setTextViewText(R.id.tvMsg, "消息内容")
                builder.setContent(remoteView)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val channel = NotificationChannel(
                        "PUSH_NOTIFY_ID",
                        "PUSH_CHANNEL_NAME",
                        NotificationManager.IMPORTANCE_HIGH
                    )
                    notificationManagerCompat.createNotificationChannel(channel)
                }
                notificationManagerCompat.notify(notificationId++, builder.build())
            }
            else -> {
            }
        }
    }
}
