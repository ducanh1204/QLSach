package vn.edu.poly.qlsach.SachBanChay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import vn.edu.poly.qlsach.R;

public class SachBanChayAdapter extends RecyclerView.Adapter<SachBanChayAdapter.SachHolder> {


    private Context context;
    private List<SachBanChay> sachBanChayList;
    private SachBanChayDAO sachBanChayDAO;

    public SachBanChayAdapter(Context context, List<SachBanChay> sachBanChayList) {
        this.context = context;
        this.sachBanChayList = sachBanChayList;
    }

    @NonNull
    @Override
    public SachHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_sach_banchay, parent, false);
        return new SachHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull SachHolder holder, final int position) {
        sachBanChayDAO = new SachBanChayDAO(context);
        sachBanChayList = sachBanChayDAO.getAllSachBanChay();
        holder.tvmaSach.setText(sachBanChayList.get(position).getMaSach());
        holder.tvsumSL.setText(sachBanChayList.get(position).getSoLuong()+"");

    }

    @Override
    public int getItemCount() {
        return sachBanChayList.size();
    }

    public class SachHolder extends RecyclerView.ViewHolder {

        TextView tvmaSach,tvsumSL;
        public SachHolder(@NonNull View itemView) {
            super(itemView);
            tvmaSach = itemView.findViewById(R.id.tvMaSach);
            tvsumSL = itemView.findViewById(R.id.tvsumSL);
        }
    }

}
