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
import vn.fptpolytechnic.assignment.model.khoanchi;
import vn.fptpolytechnic.assignment.sqlite.Database;

public class KhoanChiAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<khoanchi> khoanchiList;

    public KhoanChiAdapter(Context context, int layout, List<khoanchi> khoanchiList) {
        this.context = context;
        this.layout = layout;
        this.khoanchiList = khoanchiList;
    }



    @Override
    public int getCount() { return khoanchiList.size(); }

    @Override
    public Object getItem(int i) { return null; }

    @Override
    public long getItemId(int i) { return 0; }

    public class ViewHolder{
        TextView tvkhoanchi;
        ImageView imgkhoanchisua,imgkhoanchixoa;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.tvkhoanchi = view.findViewById(R.id.tvkhoanchi);
            holder.imgkhoanchisua = view.findViewById(R.id.imgkhoanchisua);
            holder.imgkhoanchixoa = view.findViewById(R.id.imgkhoanchixoa);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        final khoanchi kc = khoanchiList.get(i);
        holder.tvkhoanchi.setText(kc.getKhoanchi());
        holder.imgkhoanchisua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua = dialog.findViewById(R.id.edt_sua);
                Button btnsua = dialog.findViewById(R.id.btn_sua);
                edtsua.setText(kc.getKhoanchi());
                btnsua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String a = edtsua.getText().toString();
                        int b = kc.getIdchi();
                        if (a.isEmpty()){
                            Toast.makeText(context, "Vui lòng không để trống khoản chi", Toast.LENGTH_SHORT).show();
                        } else {
                            Database database = new Database(context);
                            database.sendData("UPDATE CHI SET KHOANCHI = '"+a+"' WHERE IDCHI = "+b+" ");
                            Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            ((MainActivity)context).recreate();
                        }
                    }


                });
dialog.show();
            }
        });

        holder.imgkhoanchixoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_xoa);


                Button btnhuy = dialog.findViewById(R.id.btn_khongxoa);
                Button btnchapnhan = dialog.findViewById(R.id.btn_coxoa);
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btnchapnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int a = kc.getIdchi();

                            Database database = new Database(context);
                            database.sendData("DELETE FROM CHI WHERE IDCHI = "+a+" ");
                            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            ((MainActivity)context).recreate();
                    }
                });
                dialog.show();
            }
        });


        return view;
    }
}
