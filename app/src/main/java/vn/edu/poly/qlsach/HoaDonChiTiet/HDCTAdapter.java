package vn.edu.poly.qlsach.HoaDonChiTiet;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.poly.qlsach.R;

public class HDCTAdapter extends RecyclerView.Adapter<HDCTAdapter.HDCTHolder> {

    private Context context;
    private List<HDCT> hdctList;

    public HDCTAdapter(Context context, List<HDCT> hdctList) {
        this.context = context;
        this.hdctList = hdctList;
    }

    @NonNull
    @Override
    public HDCTHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_hdct, parent, false);
        return new HDCTHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HDCTHolder holder, final int position) {

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
                Intent intent = new Intent(context, ThongtinHDCTActivity.class);
                context.startActivity(intent);
            }
        });
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
}
