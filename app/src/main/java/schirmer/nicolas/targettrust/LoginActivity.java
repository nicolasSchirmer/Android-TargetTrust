package schirmer.nicolas.targettrust;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class LoginActivity extends AppCompatActivity {

    VideoView videoView;
    Uri videoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setBackgroundVideo();
    }

    // prepara o vídeo do login
    private void setBackgroundVideo(){
        // instancia da view
        videoView = (VideoView) findViewById(R.id.videoView);
        // referencia ao local que o vídeo se encontra
        videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.code_video);
        // alimenta a view
        videoView.setVideoURI(videoUri);
        // começa o vídeo
        videoView.start();
        // vídeo entra em loop
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

    // se o app voltar a ter foco, reinicia vídeo
    @Override
    public void onResume(){
        super.onResume();
        if(!videoView.isPlaying()) setBackgroundVideo();
    }
}
