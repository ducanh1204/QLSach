package vn.edu.poly.qlsach.Sach;

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

import vn.edu.poly.qlsach.R;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.SachHolder> {


    Context context;
    List<Sach> sachList;

    public SachAdapter(Context context, List<Sach> sachList) {
        this.context = context;
        this.sachList = sachList;
    }

    @NonNull
    @Override
    public SachHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_sach, parent, false);
        return new SachHolder(view);
    }

    private SachDAO sachDAO;

    @Override
    public void onBindViewHolder(@NonNull SachHolder holder, final int position) {
        sachDAO = new SachDAO(context);
        holder.tvtenSach.setText(sachList.get(position).getTenSach());
        holder.tvsoluong.setText(sachList.get(position).getSoLuong() + "");
        holder.tvgia.setText(sachList.get(position).getGiaBia());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Bạn có chắc chắn muốn xóa Sách này?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sachDAO.deleteBook(sachList.get(position).getMaSach());
                        sachList.remove(position);
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
                showInforBook(position);
            }
        });

    }

    public void showInforBook(int i) {
        Intent intent = new Intent(context, ThongTinSachActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ma", sachList.get(i).getMaSach());
        bundle.putString("maTL", sachList.get(i).getMaTLSach());
        bundle.putString("ten", sachList.get(i).getTenSach());
        bundle.putString("tacgia", sachList.get(i).getTacGia());
        bundle.putString("nxb", sachList.get(i).getNxb());
        bundle.putString("soluong", sachList.get(i).getSoLuong() + "");
        bundle.putString("gia", sachList.get(i).getGiaBia());
        intent.putExtra("Sach", bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return sachList.size();
    }

    public class SachHolder extends RecyclerView.ViewHolder {
        TextView tvtenSach, tvgia, tvsoluong;
        ImageView imgDelete;

        public SachHolder(@NonNull View itemView) {
            super(itemView);
            tvtenSach = itemView.findViewById(R.id.tvTitle_book);
            tvgia = itemView.findViewById(R.id.tv_price_book);
            tvsoluong = itemView.findViewById(R.id.tvbook_count);
            imgDelete = itemView.findViewById(R.id.imgDelete_Book);

        }
    }
}
