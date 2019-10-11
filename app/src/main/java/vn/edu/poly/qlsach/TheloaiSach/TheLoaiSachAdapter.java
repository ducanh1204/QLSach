package vn.edu.poly.qlsach.TheloaiSach;

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
import vn.edu.poly.qlsach.Sach.Sach;
import vn.edu.poly.qlsach.Sach.SachAdapter;
import vn.edu.poly.qlsach.Sach.SachDAO;

public class TheLoaiSachAdapter extends RecyclerView.Adapter<TheLoaiSachAdapter.TheLoaiSachHolder> {


    Context context;
    List<TheLoaiSach> theLoaiSachList;

    public TheLoaiSachAdapter(Context context, List<TheLoaiSach> theLoaiSachList) {
        this.context = context;
        this.theLoaiSachList = theLoaiSachList;
    }

    @NonNull
    @Override
    public TheLoaiSachHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_theloaisach, parent, false);
        return new TheLoaiSachHolder(view);
    }

    private TheLoaiDAO theLoaiDAO;

    private SachDAO sachDAO;
    private List<Sach> sachList;
    private SachAdapter sachAdapter;

    @Override
    public void onBindViewHolder(@NonNull TheLoaiSachHolder holder, final int position) {

        sachDAO = new SachDAO(context);
        sachList = sachDAO.getAll();
        sachAdapter = new SachAdapter(context, sachList);
        theLoaiDAO = new TheLoaiDAO(context);
        holder.tvMaTL.setText(theLoaiSachList.get(position).getMaTheLoai());
        holder.tvTenTL.setText(theLoaiSachList.get(position).getTenTheLoai());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Bạn có chắc chắn muốn xóa thể loại sách này?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (sachList.size() > 0) {
                            for (int i = 0; i < sachList.size(); i++) {
                                if (sachList.get(i).getMaTLSach().equals(theLoaiSachList.get(position).getMaTheLoai())) {
                                    sachDAO.deleteBook(sachList.get(i).getMaSach());
                                }
                            }
                            theLoaiDAO.deleteTLSach(theLoaiSachList.get(position).getMaTheLoai());
                            theLoaiSachList.remove(position);
                            notifyDataSetChanged();
                        } else {
                            theLoaiDAO.deleteTLSach(theLoaiSachList.get(position).getMaTheLoai());
                            theLoaiSachList.remove(position);
                            notifyDataSetChanged();
                        }
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
                showInforTL(position);
            }
        });
    }

    public void showInforTL(int i) {
        Intent intent = new Intent(context, ThongTinTheLoaiActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("maTL", theLoaiSachList.get(i).getMaTheLoai());
        bundle.putString("tenTL", theLoaiSachList.get(i).getTenTheLoai());
        bundle.putString("vitri", theLoaiSachList.get(i).getVitri() + "");
        bundle.putString("mota", theLoaiSachList.get(i).getMoTa());
        intent.putExtra("TLSach", bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return theLoaiSachList.size();
    }

    public class TheLoaiSachHolder extends RecyclerView.ViewHolder {
        TextView tvMaTL, tvTenTL;
        ImageView imgDelete;

        public TheLoaiSachHolder(@NonNull View itemView) {
            super(itemView);
            tvMaTL = itemView.findViewById(R.id.tvMaTL);
            tvTenTL = itemView.findViewById(R.id.tvTenTL);
            imgDelete = itemView.findViewById(R.id.imgDeleteTL);
        }
    }
}
