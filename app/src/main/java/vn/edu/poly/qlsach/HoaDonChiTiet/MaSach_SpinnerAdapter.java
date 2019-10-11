package vn.edu.poly.qlsach.HoaDonChiTiet;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

import vn.edu.poly.qlsach.R;
import vn.edu.poly.qlsach.Sach.Sach;

public class MaSach_SpinnerAdapter implements SpinnerAdapter {

    private Context context;
    private List<Sach> sachList;

    public MaSach_SpinnerAdapter(Context context, List<Sach> sachList) {
        this.context = context;
        this.sachList = sachList;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.rowspinner_matl,parent,false);

        TextView tv_spn_maTL = convertView.findViewById(R.id.tv_spn);
        tv_spn_maTL.setText(sachList.get(position).getMaSach());

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.rowspinner_matl,parent,false);

        TextView tv_spn_maTL = convertView.findViewById(R.id.tv_spn);
        tv_spn_maTL.setText(sachList.get(position).getMaSach());

        return convertView;
    }
    @Override
    public Sach getItem(int position) {
        return sachList.get(position);
    }

    @Override
    public int getCount() {
        return sachList.size();
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }



    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
