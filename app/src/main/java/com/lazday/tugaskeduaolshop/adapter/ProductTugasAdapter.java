package com.lazday.tugaskeduaolshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.lazday.tugaskeduaolshop.R;
import com.lazday.tugaskeduaolshop.data.Model.productTugas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductTugasAdapter extends RecyclerView.Adapter<ProductTugasAdapter.ViewHolder> {

    private List<productTugas.Result> products;
    Context context;
    String url;

    public ProductTugasAdapter(Context context, List<productTugas.Result> data){
        this.context = context;
        this.products = data;
    }


    @NonNull
    @Override
    public ProductTugasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_main, null);


        return new ProductTugasAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtName.setText(products.get(i).getDescription());
        viewHolder.txtPrice.setText(products.get(i).getTitle());
        String rawDate = convertTime(products.get(i).getRelease_date()) ;
        viewHolder.txtDate.setText(rawDate);
        url=products.get(i).getCheckout();

//        int price = products.get(i).getPrice();

//        String cur ="IDR " + converter.rupiah(price);

//        viewHolder.txtPrice.setText(cur);

        RequestOptions options =new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.lazdayblue)
                .error(R.drawable.no_file_foundl)
                .priority(Priority.HIGH);

        Glide.with(context)
                .load(products.get(i).getImage())
                .apply(options)
                .into(viewHolder.imgProduct);

        viewHolder.imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: FIX THE PROBLEM
                //why the url cannot be reached

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                Log.i("intent:",url);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProduct;
        TextView txtPrice, txtName, txtDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct =itemView.findViewById(R.id.imageProduct);

            txtName =itemView.findViewById(R.id.txtName);

            txtPrice =itemView.findViewById(R.id.txtPrice);

            txtDate = itemView.findViewById(R.id.txtDate);

        }
    }

    private String convertTime(String time) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = null;

        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String convertedDate = format1.format(date);

        return convertedDate;
    }


}
