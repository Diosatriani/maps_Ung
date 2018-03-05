package dio.satriani.maps_ung;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;
import dio.satriani.maps_ung.AppController.AppController;

public class MenuActivity extends AppCompatActivity {

    String arrayName[]={"maps",
                        "list",
                        "profil",
                        "exit"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final CircleMenu circleMenu = (CircleMenu)findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#21edb0"),R.drawable.ng,R.drawable.ic_close_light)
                .addSubMenu(Color.parseColor("#258CFF"),R.drawable.maps)
                .addSubMenu(Color.parseColor("#FF40FF4A"),R.drawable.listvieww)
                .addSubMenu(Color.parseColor("#ff0000"),R.drawable.tseruu)
                .addSubMenu(Color.parseColor("#FFF7DD1A"),R.drawable.exitt)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {


                                               @Override
                                               public void onMenuSelected(int index) {

                                                   switch (index) {
                                                       case 0:
                                                           Intent intent = new Intent(MenuActivity.this,MainActivity.class);
                                                           Toast.makeText(MenuActivity.this, "kamu pilih menu " +arrayName[index], Toast.LENGTH_SHORT).show();
                                                           startActivity(intent);

                                                           circleMenu.performClick();
                                                           break;
                                                       case 1:
                                                           Intent intent2 = new Intent(MenuActivity.this,ListActivity.class);
                                                           Toast.makeText(MenuActivity.this, "Kamu pilih menu" +arrayName[index], Toast.LENGTH_SHORT).show();;
                                                           startActivity(intent2);
                                                           break;
                                                       case 2:
                                                           Intent inten3 = new Intent(MenuActivity.this,biodataActivity.class);
                                                           Toast.makeText(MenuActivity.this, "Kamu pilih menu" +arrayName[index], Toast.LENGTH_SHORT).show();;
                                                           startActivity(inten3);
                                                           break;
                                                       case 3:
                                                           AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                                                           builder.setTitle("RS.Ungaran");
                                                           builder.setMessage("Jika anda Ingin Keluar Tekan (YA)!!!")
                                                                   .setIcon(R.drawable.exit)
                                                                   .setCancelable(false)
                                                                   .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                                                       @Override
                                                                       public void onClick(DialogInterface dialogInterface, int index) {
                                                                           finishAffinity();
                                                                       }
                                                                   })
                                                                   .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                                                       @Override
                                                                       public void onClick(DialogInterface dialog, int index) {
                                                                           dialog.cancel();
                                                                       }
                                                                   });AlertDialog alert =builder.create();
                                                                   alert.show();
                                                           break;
                                                       case 4:
                                                           Toast.makeText(MenuActivity.this, "GPS button Clicked", Toast.LENGTH_SHORT).show();
                                                           break;
                                                   }

                                               }
                                           }

                );
    }


}