package vn.edu.poly.qlsach.HoaDon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.poly.qlsach.HoaDonChiTiet.HDCTActivity;
import vn.edu.poly.qlsach.R;

public class HoaDonAdapter extends RecyclerView.Adapter<HoaDonAdapter.HoaDonHolder> {

    Context context;
    List<Hoadon> hoadonList;

    public HoaDonAdapter(Context context, List<Hoadon> hoadonList) {
        this.context = context;
        this.hoadonList = hoadonList;
    }

    @NonNull
    @Override
    public HoaDonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_hoadon,parent,false);
        return new HoaDonHolder(view);
    }

    private HoaDonDAO hoaDonDAO;
    @Override
    public void onBindViewHolder(@NonNull HoaDonHolder holder,final int position) {
        hoaDonDAO = new HoaDonDAO(context);
        holder.tvmaHD.setText(hoadonList.get(position).getMaHoaDon());
        holder.tvngayMua.setText(hoadonList.get(position).getNgayMua());
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ThongTinHDActivityActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("maHD",hoadonList.get(position).getMaHoaDon());
                bundle.putString("ngayMua",hoadonList.get(position).getNgayMua());
                intent.putExtra("HD",bundle);
                context.startActivity(intent);
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
                Bundle bundle = new Bundle();
                bundle.putString("HD_maHD",hoadonList.get(position).getMaHoaDon());
                intent.putExtra("HD",bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hoadonList.size();
    }

    public class HoaDonHolder extends RecyclerView.ViewHolder {
        TextView tvmaHD,tvngayMua;
        ImageView imgEdit,imgDelete;
        public HoaDonHolder(@NonNull View itemView) {
            super(itemView);
            tvmaHD=itemView.findViewById(R.id.tvMaHD);
            tvngayMua=itemView.findViewById(R.id.tvNgayMua);
            imgDelete=itemView.findViewById(R.id.imgDeleteHD);
            imgEdit=itemView.findViewById(R.id.imgEditHD);

        }
    }
}
