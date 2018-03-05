package dio.satriani.maps_ung;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by user on 12/15/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.product_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        Picasso.with(mCtx)
                .load("http://warganet.ml/map/images/foto/"+ product.getImage())
                .into(holder.imageView);

        Log.d("tesss", product.getImage());
        holder.textViewNama.setText(product.getNama());
        holder.textViewAlamat.setText(product.getAlamat());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNama, textViewAlamat;  ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewNama = itemView.findViewById(R.id.textViewNama);
            textViewAlamat = itemView.findViewById(R.id.textViewAlamat);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
