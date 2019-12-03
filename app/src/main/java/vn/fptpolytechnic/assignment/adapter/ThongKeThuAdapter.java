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
import vn.fptpolytechnic.assignment.model.thongkethu;

public class ThongKeThuAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<thongkethu> list;

    public ThongKeThuAdapter(Context context, int layout, List<thongkethu> list) {
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
        TextView tvngaythang, tvkhoanthu, tvloaithu;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        ViewHolder holder;

        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder.tvngaythang = view.findViewById(R.id.tvngaythang);
            holder.tvkhoanthu = view.findViewById(R.id.tvkhoanthu);
            holder.tvloaithu = view.findViewById(R.id.tvloaithu);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        thongkethu tkc = list.get(i);
        holder.tvngaythang.setText(tkc.getNgaythang());
        holder.tvkhoanthu.setText(tkc.getKhoanthu());
        holder.tvloaithu.setText(tkc.getLoaithu());

        return view;
    }
}
