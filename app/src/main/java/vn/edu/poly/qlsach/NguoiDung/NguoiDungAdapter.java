package vn.edu.poly.qlsach.NguoiDung;

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

    @Override
    public void onBindViewHolder(@NonNull NguoiDungHolder holder, final int position) {

        holder.tvuserName.setText(nguoidungList.get(position).getName());
        holder.tvohoneNumber.setText(nguoidungList.get(position).getPhoneNumber());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Bạn có chắc chắn muốn xóa người dùng này?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ThongTinNguoiDungActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return nguoidungList.size();
    }

    public class NguoiDungHolder extends RecyclerView.ViewHolder {
        TextView tvuserName, tvohoneNumber;
        ImageView imgEdit, imgDelete;
        CardView cardView;

        public NguoiDungHolder(@NonNull View itemView) {
            super(itemView);
            tvohoneNumber = itemView.findViewById(R.id.tvphoneNumber);
            tvuserName = itemView.findViewById(R.id.tvuserName);
            imgEdit = itemView.findViewById(R.id.imgEditUser);
            imgDelete = itemView.findViewById(R.id.imgDeleteUser);

        }

    }
}
