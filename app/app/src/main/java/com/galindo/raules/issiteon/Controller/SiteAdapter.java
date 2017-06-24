package com.galindo.raules.issiteon.Controller;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.galindo.raules.issiteon.Model.SiteModel;
import com.galindo.raules.issiteon.R;

import java.util.ArrayList;

/**
 * Created by raul on 20/06/2017.
 */


public class SiteAdapter extends ArrayAdapter {
    ArrayList<SiteModel> modelItems = null;
    private ImageView iv_row_site;
    private ImageButton ib_row_site;
    private ToggleButton tb_row_site;
    private TextView tv_row_site;
    Context context;
    public SiteAdapter(Context context,  ArrayList<SiteModel> resource) {
        super(context, R.layout.row_site,resource);
        this.context = context;
        this.modelItems = resource;

    }
    @Override
    public View getView( View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row_site, parent, false);
        setIv_row_site((ImageView) convertView.findViewById(R.id.iv_row_site));
        return convertView;
    }

    public ImageView getIv_row_site() {
        return iv_row_site;
    }

    public void setIv_row_site(ImageView iv_row_site) {
        this.iv_row_site = iv_row_site;
    }

    public ImageButton getIb_row_site() {
        return ib_row_site;
    }

    public void setIb_row_site(ImageButton ib_row_site) {
        this.ib_row_site = ib_row_site;
    }

    public ToggleButton getTb_row_site() {
        return tb_row_site;
    }

    public void setTb_row_site(ToggleButton tb_row_site) {
        this.tb_row_site = tb_row_site;
    }

    public TextView getTv_row_site() {
        return tv_row_site;
    }

    public void setTv_row_site(TextView tv_row_site) {
        this.tv_row_site = tv_row_site;
    }
}
