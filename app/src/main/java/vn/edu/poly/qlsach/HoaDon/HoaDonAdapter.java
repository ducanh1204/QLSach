package vn.edu.poly.qlsach.HoaDon;

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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.HoaDonChiTiet.HDCT;
import vn.edu.poly.qlsach.HoaDonChiTiet.HDCTActivity;
import vn.edu.poly.qlsach.HoaDonChiTiet.HDCTAdapter;
import vn.edu.poly.qlsach.HoaDonChiTiet.HDCTDAO;
import vn.edu.poly.qlsach.R;

public class HoaDonAdapter extends RecyclerView.Adapter<HoaDonAdapter.HoaDonHolder> implements Filterable {

    private Context context;
    private List<Hoadon> hoadonList;
    private List<Hoadon> hoadonList2;

    public HoaDonAdapter(Context context, List<Hoadon> hoadonList) {
        this.context = context;
        this.hoadonList = hoadonList;
        this.hoadonList2 = new ArrayList<>(hoadonList);
    }

    @NonNull
    @Override
    public HoaDonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_hoadon, parent, false);
        return new HoaDonHolder(view);
    }

    private HoaDonDAO hoaDonDAO;
    private HDCTDAO hdctdao;
    private List<HDCT> hdctList;

    @Override
    public void onBindViewHolder(@NonNull HoaDonHolder holder, final int position) {
        hoaDonDAO = new HoaDonDAO(context);
        hdctdao = new HDCTDAO(context);
        hdctList = hdctdao.show_HDCT(hoadonList.get(position).getMaHoaDon());
        holder.tvmaHD.setText(hoadonList.get(position).getMaHoaDon());
        holder.tvngayMua.setText(hoadonList.get(position).getNgayMua());
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInforHD(position);
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Bạn có chắc chắn muốn xóa hóa đơn này?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(int i=0;i<hdctList.size();i++){
                            if(hoadonList.get(position).getMaHoaDon().equals(hdctList.get(i).getMaHD())){
                                hdctdao.deleteHDCT(hdctList.get(i).getMaHDCT());
                            }
                        }
                        hoaDonDAO.deleteHD(hoadonList.get(position).getMaHoaDon());
                        hoadonList.remove(position);
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
                Intent intent = new Intent(context, HDCTActivity.class);
                HDCTActivity.maHD = hoadonList.get(position).getMaHoaDon();
                context.startActivity(intent);
            }
        });
    }

    public void showInforHD(int i) {
        Intent intent = new Intent(context, ThongTinHDActivityActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("maHD", hoadonList.get(i).getMaHoaDon());
        bundle.putString("ngayMua", hoadonList.get(i).getNgayMua());
        intent.putExtra("HD", bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return hoadonList.size();
    }

    public class HoaDonHolder extends RecyclerView.ViewHolder {
        TextView tvmaHD, tvngayMua;
        ImageView imgEdit, imgDelete;

        public HoaDonHolder(@NonNull View itemView) {
            super(itemView);
            tvmaHD = itemView.findViewById(R.id.tvMaHD);
            tvngayMua = itemView.findViewById(R.id.tvNgayMua);
            imgDelete = itemView.findViewById(R.id.imgDeleteHD);
            imgEdit = itemView.findViewById(R.id.imgEditHD);

        }
    }


    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Hoadon> hoadonFillter = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                hoadonFillter.addAll(hoadonList2);
            } else {
                String fillterParent = constraint.toString().toLowerCase().trim();
                for (Hoadon item : hoadonList2) {
                    if (item.getMaHoaDon().toLowerCase().contains(fillterParent)) {
                        hoadonFillter.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = hoadonFillter;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            hoadonList.clear();
            hoadonList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        return filter;
    }

}
