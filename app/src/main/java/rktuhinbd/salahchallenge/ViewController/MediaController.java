package rktuhinbd.salahchallenge.ViewController;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.Settings;

public class MediaController {

    private static MediaController sInstance;
    private Context mContext;
    private MediaPlayer mMediaPlayer;

    public MediaController(Context context) {
        mContext = context;
    }

    public static MediaController getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MediaController(context);
        }
        return sInstance;
    }

    public void playMusic() {
        mMediaPlayer = MediaPlayer.create(mContext, Settings.System.DEFAULT_ALARM_ALERT_URI);
        mMediaPlayer.start();
    }

    public void stopMusic() {
        if(mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.seekTo(0);
        }
    }
}