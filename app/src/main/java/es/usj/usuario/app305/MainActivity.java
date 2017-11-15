package es.usj.usuario.app305;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private VideoView vv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText);
        vv1=(VideoView)findViewById(R.id.videoView);
    }
    public void tomarVideo(View v) {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File video = new File(getExternalFilesDir(null), et1.getText().toString());
        Uri photoURI = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".provider", video);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        startActivity(intent);
    }
    public void recuperarVideo(View v) {

        vv1.setVideoURI(Uri.parse(getExternalFilesDir(null)+"/"+et1.getText().toString())
        );
        vv1.start();
    }
    public void ver(View v) {
        Intent intent=new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
