package com.tigerrobocop.liv.localpersistence;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tigerrobocop.liv.localpersistence.Adapters.CarAdapter;
import com.tigerrobocop.liv.localpersistence.Data.DAO;
import com.tigerrobocop.liv.localpersistence.Model.Car;

import java.util.List;

public class ListActivity extends android.app.ListActivity {

    DAO mDAO;
    List<Car> mList;
    ListView mLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_list);


        mDAO = new DAO(this);
        mList = mDAO.GetAll() ;
        setListAdapter(new CarAdapter(this, mList));

        mLV = this.getListView();

        mLV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {

              final Car p = (Car) arg0.getItemAtPosition(pos);

                mDAO.Delete(p);
                Toast.makeText(getApplicationContext(), "Item deleted", Toast.LENGTH_SHORT).show();


                ReloadList();

                /*
                // android.R.id.list;
                new AlertDialog.Builder(getApplicationContext())
                        .setTitle("Confirm")
                        .setMessage("Delete item?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {



                            }})
                        .setNegativeButton(android.R.string.no, null).show();

*/

                //Toast.makeText(, "Long Clicked : " + p.name, Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }


    void ReloadList() {


        mList.clear();
        mList.addAll(mDAO.GetAll());
        onContentChanged();
        //this.getAdapter().notifyDataSetChanged();
       // getListView().getAdapter().notifyDataSetChanged();



    }


    /*
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TextView txt = (TextView)v.findViewById(R.id.textView_name);
        String name =  txt.getText().toString();
        Toast.makeText(this, "Item clicked: " + name, Toast.LENGTH_LONG).show();
    }
*/

}
