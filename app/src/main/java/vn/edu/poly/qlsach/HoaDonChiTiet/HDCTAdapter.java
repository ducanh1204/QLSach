package vn.edu.poly.qlsach.HoaDonChiTiet;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.R;

public class HDCTAdapter extends RecyclerView.Adapter<HDCTAdapter.HDCTHolder> implements Filterable {

    private Context context;
    private List<HDCT> hdctList;
    private List<HDCT> hdctList2;

    public HDCTAdapter(Context context, List<HDCT> hdctList) {
        this.context = context;
        this.hdctList = hdctList;
        this.hdctList2 = new ArrayList<>(hdctList);
    }


    private HDCTDAO hdctdao;
    @NonNull
    @Override
    public HDCTHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_hdct, parent, false);
        return new HDCTHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HDCTHolder holder, final int position) {

        hdctdao = new HDCTDAO(context);
        holder.tvmaHDCT.setText(hdctList.get(position).getMaHDCT());
        holder.tvSoluong.setText(hdctList.get(position).getSoLuong() + "");
        holder.imgDeleteHDCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Bạn có chắc chắn muốn xóa hóa đơn chi tiết này?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        hdctdao.deleteHDCT(hdctList.get(position).getMaHDCT());
                        hdctList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showInforHDCT(position);
            }
        });
    }
    public void showInforHDCT(int i){
        Intent intent = new Intent(context, ThongtinHDCTActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("HDCT_maHDCT",hdctList.get(i).getMaHDCT());
        bundle.putString("HDCT_maHD",HDCTActivity.maHD);
        bundle.putString("HDCT_maSach",hdctList.get(i).getMaSach());
        bundle.putString("HDCT_soLuong",hdctList.get(i).getSoLuong()+"");
        intent.putExtra("HDCT",bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return hdctList.size();
    }

    public class HDCTHolder extends RecyclerView.ViewHolder {
        TextView tvmaHDCT, tvSoluong;
        ImageView imgDeleteHDCT;

        public HDCTHolder(@NonNull View itemView) {
            super(itemView);
            tvmaHDCT = itemView.findViewById(R.id.tvMaHDCT);
            tvSoluong = itemView.findViewById(R.id.tvSoluong);
            imgDeleteHDCT = itemView.findViewById(R.id.imgDeleteHDCT);
        }
    }


    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<HDCT> hdctFillter = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                hdctFillter.addAll(hdctList2);
            } else {
                String fillterParent = constraint.toString().toLowerCase().trim();
                for (HDCT item : hdctList2) {
                    if (item.getMaHDCT().toLowerCase().contains(fillterParent)) {
                        hdctFillter.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = hdctFillter;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            hdctList.clear();
            hdctList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        return filter;
    }
}
