package dio.satriani.maps_ung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;



public class Splashscreen extends Activity {

    private ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        iv1 = (ImageView) findViewById(R.id.bg);
        Animation myanim = new AnimationUtils().loadAnimation(this,R.anim.mytransitions);
        iv1.startAnimation(myanim);
        final Intent i = new Intent(this, Splashscreen2Activity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000) ;
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }

            }
        };
        timer.start();
    }
}
