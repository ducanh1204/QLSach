package vn.edu.poly.qlsach.Sach;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

import vn.edu.poly.qlsach.R;
import vn.edu.poly.qlsach.TheloaiSach.TheLoaiSach;

public class MaTL_SpinnerAdapter implements SpinnerAdapter {
    private Context context;
    private List<TheLoaiSach> theLoaiSachList;

    public MaTL_SpinnerAdapter(Context context, List<TheLoaiSach> theLoaiSachList) {
        this.context = context;
        this.theLoaiSachList = theLoaiSachList;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.rowspinner_matl,parent,false);

        TextView tv_spn_maTL = convertView.findViewById(R.id.tv_spn_maTL);
        tv_spn_maTL.setText(theLoaiSachList.get(position).getMaTheLoai());

        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.rowspinner_matl,parent,false);

        TextView tv_spn_maTL = convertView.findViewById(R.id.tv_spn_maTL);
        tv_spn_maTL.setText(theLoaiSachList.get(position).getMaTheLoai());

        return convertView;
    }
    @Override
    public TheLoaiSach getItem(int position) {
        return theLoaiSachList.get(position);
    }

    @Override
    public int getCount() {
        return theLoaiSachList.size();
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
