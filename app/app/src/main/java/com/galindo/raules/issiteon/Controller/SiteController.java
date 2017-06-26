package com.galindo.raules.issiteon.Controller;

import android.content.Context;

import com.galindo.raules.issiteon.Model.SiteModel;
import com.galindo.raules.issiteon.R;

import java.util.ArrayList;

/**
 * Created by raul on 21/06/2017.
 */

public class SiteController {
    private SiteAdapter siteAdapter;
    private Context context;
    int counter = 0;
    public SiteController(Context context){
        setContext(context);
        setSiteAdapter(new SiteAdapter(getContext(), R.layout.row_site, getModelItems()));
    }
    public void updateSiteAdapter(){
        setSiteAdapter(new SiteAdapter(getContext(), R.layout.row_site , getModelItems()));
    }
    private ArrayList<SiteModel> getModelItems(){
        ArrayList<SiteModel> modelItems = null;
        if(siteAdapter == null){
            modelItems = new ArrayList<SiteModel>();
        }else{
            siteAdapter.getModelItems();
        }
        for(int index =0; index <= counter; index++){
            modelItems.add(new SiteModel());
        }
        counter++;
        return modelItems;
    }

    private Context getContext() {
        return context;
    }

    private void setContext(Context context) {
        this.context = context;
    }

    public SiteAdapter getSiteAdapter() {
        return siteAdapter;
    }

    private void setSiteAdapter(SiteAdapter siteAdapter) {
        this.siteAdapter = siteAdapter;
    }
}
