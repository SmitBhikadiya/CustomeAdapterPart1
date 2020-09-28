package com.spatel.customeadapterpart1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private JSONArray jarr;

    public CustomAdapter(Context context, JSONArray jarr) {
        this.context = context;
        this.jarr = jarr;
    }

    @Override
    public int getCount() {
        return jarr.length();
    }

    @Override
    public Object getItem(int i) {
        /*try {
            return jarr.getJSONObject(i);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            LayoutInflater.from(context).inflate(R.layout.my_layout,viewGroup,false);
        }

        TextView headerText = (TextView) view.findViewById(R.id.txtHeading);
        TextView urlText = (TextView) view.findViewById(R.id.txtUrl);

        try {
            JSONObject jobj = jarr.getJSONObject(i);
            headerText.setText(jobj.getString("formula"));
            urlText.setText(jobj.getString("URL"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }
}
