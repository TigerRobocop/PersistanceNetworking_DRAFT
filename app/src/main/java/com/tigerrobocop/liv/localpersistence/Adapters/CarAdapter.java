package com.tigerrobocop.liv.localpersistence.Adapters;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tigerrobocop.liv.localpersistence.Model.Car;
import com.tigerrobocop.liv.localpersistence.R;

import java.util.List;

/**
 * Created by Livia on 12/08/2017.
 */

public class CarAdapter extends ArrayAdapter<Car> {
    public CarAdapter(Context context, List<Car> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     //   return super.getView(position, convertView, parent);

        ViewHolder mVH ;

        if (convertView == null){
            convertView = LayoutInflater.from(
                    getContext()).inflate(R.layout.list_item, null);

            mVH = new ViewHolder();
            mVH.txtName= (TextView) convertView.findViewById(R.id.lbl_name);
            mVH.txtYear= (TextView) convertView.findViewById(R.id.lbl_year);

            convertView.setTag(mVH);
        }else   {
            mVH=(ViewHolder)convertView.getTag();
        }
        Car c = getItem(position);

        if(c != null){
            mVH.txtName.setText(c.name);
            mVH.txtYear.setText(c.year);
        }

        return convertView;
    }
}

class ViewHolder {
    TextView txtName;
    TextView txtYear;
}
