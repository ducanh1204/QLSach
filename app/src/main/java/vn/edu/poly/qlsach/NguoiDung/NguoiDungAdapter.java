package vn.edu.poly.qlsach.NguoiDung;

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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.poly.qlsach.R;

public class NguoiDungAdapter extends RecyclerView.Adapter<NguoiDungAdapter.NguoiDungHolder> {


    Context context;
    List<Nguoidung> nguoidungList;

    public NguoiDungAdapter(Context context, List<Nguoidung> nguoidungList) {
        this.context = context;
        this.nguoidungList = nguoidungList;
    }


    @NonNull
    @Override
    public NguoiDungHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_nguoidung, parent, false);

        return new NguoiDungHolder(view);
    }

    private NguoiDungDAO nguoiDungDAO;
    @Override
    public void onBindViewHolder(@NonNull NguoiDungHolder holder, final int position) {

        nguoiDungDAO = new NguoiDungDAO(context);
        holder.tvuserName.setText(nguoidungList.get(position).getId());
        holder.tvohoneNumber.setText(nguoidungList.get(position).getPhoneNumber());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Bạn có chắc chắn muốn xóa người dùng này?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nguoiDungDAO.deleteUser(nguoidungList.get(position).getId());
                        nguoidungList.remove(position);
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
                showInforUser(position);
            }
        });

    }
    public void showInforUser(int i){
        Intent intent = new Intent(context,ThongTinNguoiDungActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("id",nguoidungList.get(i).getId());
        bundle.putString("name",nguoidungList.get(i).getName());
        bundle.putString("phone",nguoidungList.get(i).getPhoneNumber());
        bundle.putString("address",nguoidungList.get(i).getAddress());
        bundle.putString("pass",nguoidungList.get(i).getPassword());
        intent.putExtra("User",bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return nguoidungList.size();
    }

    public class NguoiDungHolder extends RecyclerView.ViewHolder {
        TextView tvuserName, tvohoneNumber;
        ImageView imgDelete;

        public NguoiDungHolder(@NonNull View itemView) {
            super(itemView);
            tvohoneNumber = itemView.findViewById(R.id.tvphoneNumber);
            tvuserName = itemView.findViewById(R.id.tvuserName);
            imgDelete = itemView.findViewById(R.id.imgDeleteUser);

        }

    }
}
