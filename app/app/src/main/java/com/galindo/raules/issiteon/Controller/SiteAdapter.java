package com.galindo.raules.issiteon.Controller;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.galindo.raules.issiteon.Model.SiteModel;
import com.galindo.raules.issiteon.R;

import java.util.ArrayList;

/**
 * Created by raul on 20/06/2017.
 */


public class SiteAdapter extends ArrayAdapter {
    ArrayList<SiteModel> modelItems = null;
    Context context;
    public SiteAdapter(Context context,  ArrayList<SiteModel> resource) {
        super(context, R.layout.row_site,resource);
        this.context = context;
        this.modelItems = resource;
    }
}
