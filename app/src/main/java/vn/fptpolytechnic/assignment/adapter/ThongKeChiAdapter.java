package vn.fptpolytechnic.assignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.fptpolytechnic.assignment.R;
import vn.fptpolytechnic.assignment.model.thongkechi;

public class ThongKeChiAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<thongkechi> list;

    public ThongKeChiAdapter(Context context, int layout, List<thongkechi> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder{
        TextView tvngaythang1, tvkhoanchi, tvloaichi;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        ViewHolder holder;

        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder.tvngaythang1 = view.findViewById(R.id.tvngaythang1);
            holder.tvkhoanchi = view.findViewById(R.id.tvkhoanchi);
            holder.tvloaichi = view.findViewById(R.id.tvloaichi);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        thongkechi tkc = list.get(i);
        holder.tvngaythang1.setText(tkc.getNgaythang());
        holder.tvkhoanchi.setText(tkc.getKhoanchi());
        holder.tvloaichi.setText(tkc.getLoaichi());

        return view;
    }
}
