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
import vn.fptpolytechnic.assignment.model.loaithu;
import vn.fptpolytechnic.assignment.sqlite.Database;

public class LoaiThuAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<loaithu> loaithuList;

    public LoaiThuAdapter(Context context, int layout, List<loaithu> loaithuList) {
        this.context = context;
        this.layout = layout;
        this.loaithuList = loaithuList;
    }



    @Override
    public int getCount() { return loaithuList.size(); }

    @Override
    public Object getItem(int i) { return null; }

    @Override
    public long getItemId(int i) { return 0; }

    public class ViewHolder{
        TextView tvloaithu;
        ImageView imgloaithusua;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.tvloaithu = view.findViewById(R.id.tvloaithu);
            holder.imgloaithusua = view.findViewById(R.id.imgloaithusua);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }



        final loaithu lc = loaithuList.get(i);
        holder.tvloaithu.setText(lc.getLoaithu());

        holder.imgloaithusua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua = dialog.findViewById(R.id.edt_sua);
                edtsua.setText(lc.getLoaithu());
                Button btnsua = dialog.findViewById(R.id.btn_sua);

                btnsua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String a = edtsua.getText().toString();
                        int b = lc.getIdthu();

                        if (a.isEmpty()){
                            Toast.makeText(context, "Vui lòng không để trống loai thu", Toast.LENGTH_SHORT).show();
                        } else {
                            Database database = new Database(context);
                            database.sendData("UPDATE thu SET LOAITHU = '"+a+"' WHERE IDTHU = "+b+" ");
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
