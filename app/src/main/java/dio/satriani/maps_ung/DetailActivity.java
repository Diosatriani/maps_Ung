package dio.satriani.maps_ung;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    TextView namatxt, alamattxt, lattxt, lngtxt, jenistxt;
    Toolbar mActionToolbar;
    ImageView imaget;
    String image;

    public static final String IMAGE = "image";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mActionToolbar = (Toolbar) findViewById(R.id.tabs);
        setSupportActionBar(mActionToolbar);
        getSupportActionBar().setTitle("Informasi Detail");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        imaget = (ImageView) findViewById(R.id.imageView);
        namatxt = (TextView) findViewById(R.id.namat);
//        alamattxt = (TextView) findViewById(R.id.alamatt);
        lattxt = (TextView) findViewById(R.id.latt);
        lngtxt = (TextView) findViewById(R.id.lngt);
        jenistxt = (TextView) findViewById(R.id.jenist);

        Intent intent = this.getIntent();


        String image = intent.getExtras().getString("IMAGE");
//        Toast.makeText(this, "imageee"+image, Toast.LENGTH_SHORT).show();
        Picasso.with(getApplication())
                .load("http://warganet.ml/map/images/foto/"+image)
                .into(imaget);
        String nama =intent.getExtras().getString("TAG_NAMA_DEALER");
//        String alamat =intent.getExtras().getString("TAG_ALAMAT");
        String lat =intent.getExtras().getString("TAG_LATITUDE");
        String lng =intent.getExtras().getString("TAG_LONGITUDE");
        String jenis= intent.getExtras().getString("Jenis");


        namatxt.setText(nama);
//        alamattxt.setText(alamat);
        jenistxt.setText(jenis);
        lattxt.setText(lat);
        lngtxt.setText(lng);

//        imaget.setImageURI(Uri.parse("http://172.20.10.5/map/images/foto/"+image));

    }
    //button back toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}


