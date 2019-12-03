package vn.fptpolytechnic.assignment.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.fptpolytechnic.assignment.MainActivity;
import vn.fptpolytechnic.assignment.R;
import vn.fptpolytechnic.assignment.model.loaichi;
import vn.fptpolytechnic.assignment.model.loaichi;
import vn.fptpolytechnic.assignment.sqlite.Database;

public class LoaiChiAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<loaichi> loaichiList;

    public LoaiChiAdapter(Context context, int layout, List<loaichi> loaichiList) {
        this.context = context;
        this.layout = layout;
        this.loaichiList = loaichiList;
    }



    @Override
    public int getCount() { return loaichiList.size(); }

    @Override
    public Object getItem(int i) { return null; }

    @Override
    public long getItemId(int i) { return 0; }

    public class ViewHolder{
        TextView tvloaichi;
        ImageView imgloaichisua;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.tvloaichi = view.findViewById(R.id.tvloaichi);
            holder.imgloaichisua = view.findViewById(R.id.imgloaichisua);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }



        final loaichi lc = loaichiList.get(i);
        holder.tvloaichi.setText(lc.getLoaichi());

        holder.imgloaichisua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua = dialog.findViewById(R.id.edt_sua);
                edtsua.setText(lc.getLoaichi());
                Button btnsua = dialog.findViewById(R.id.btn_sua);

                btnsua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String a = edtsua.getText().toString();
                        int b = lc.getIdchi();

                        if (a.isEmpty()){
                            Toast.makeText(context, "Vui lòng không để trống loai chi", Toast.LENGTH_SHORT).show();
                        } else {
                            Database database = new Database(context);
                            database.sendData("UPDATE CHI SET LOAIchi = '"+a+"' WHERE IDCHI = "+b+" ");
                            Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            ((MainActivity)context).recreate();
                        }
                    }
                });
                dialog.show();
            }
        });

        return view;
    }
}
