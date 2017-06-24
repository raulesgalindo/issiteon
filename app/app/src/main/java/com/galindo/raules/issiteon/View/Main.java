package com.galindo.raules.issiteon.View;

import android.app.SearchManager;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.galindo.raules.issiteon.Controller.DBController;
import com.galindo.raules.issiteon.Controller.SiteController;
import com.galindo.raules.issiteon.R;
import com.galindo.raules.issiteon.View.dummy.DummyContent;

public class Main extends AppCompatActivity implements SiteFragment.OnFragmentInteractionListener, LogFragment.OnListFragmentInteractionListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private FloatingActionButton fab;
    private int position;
    private SiteController siteController;

    //Fragments
    private SiteFragment siteFragment;
    private LogFragment logFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        setSiteController(new SiteController(Main.this));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                animateFab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
            int[] iconIntArray = {R.drawable.ic_add,R.drawable.ic_delete_forever};

            public void animateFab(final int position) {
                fab.clearAnimation();
                // Scale down animation
                ScaleAnimation shrink =  new ScaleAnimation(1f, 0.2f, 1f, 0.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                shrink.setDuration(150);     // animation duration in milliseconds
                shrink.setInterpolator(new DecelerateInterpolator());
                shrink.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // Change FAB color and icon
                        //fab.setBackgroundTintList(getResources().getColorStateList(colorIntArray[position]));
                        //fab.setImageDrawable(getResources().getDrawable(iconIntArray[position], null));
                        fab.setImageResource(iconIntArray[position]);

                        // Scale up animation
                        ScaleAnimation expand =  new ScaleAnimation(0.2f, 1f, 0.2f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        expand.setDuration(100);     // animation duration in milliseconds
                        expand.setInterpolator(new AccelerateInterpolator());
                        fab.startAnimation(expand);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                fab.startAnimation(shrink);
            }
        });
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getPosition() == 1){
                    //Creamos el adapter
                    setSiteController(new SiteController(Main.this));
                    SiteFragment siteFragment = getSiteFragment();
                    ListView lv_site = siteFragment.getLv_site();
                    lv_site.setAdapter(getSiteController().getSiteAdapter());
                    siteFragment.setLv_site(lv_site);
                    setSiteFragment(siteFragment);
                    Snackbar.make(view, "Item added", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else if(getPosition() == 0){
                    Snackbar.make(view, "Item deleted", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

        //Start SQLite
        DBController dbController = new DBController(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            setPosition(position);
            switch (position) {
                case 0:
                    setSiteFragment(new SiteFragment());
                    setSiteFragment(getSiteFragment().newInstance("hola","hola"));
                    return getSiteFragment();
                case 1:
                    setLogFragment(new LogFragment());
                    return getLogFragment().newInstance(position);
                default:
                    setSiteFragment(new SiteFragment());
                    return getSiteFragment().newInstance("hola","hola");
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return  getResources().getString(R.string.title_home) ;
                case 1:
                    return  getResources().getString(R.string.title_history);
            }
            return null;
        }

    }

    private int getPosition() {
        return position;
    }

    private void setPosition(int position) {
        this.position = position;
    }

    private SiteController getSiteController() {
        return siteController;
    }

    private void setSiteController(SiteController siteController) {
        this.siteController = siteController;
    }

    public SiteFragment getSiteFragment() {
        return siteFragment;
    }

    public void setSiteFragment(SiteFragment siteFragment) {
        this.siteFragment = siteFragment;
    }

    public LogFragment getLogFragment() {
        return logFragment;
    }

    public void setLogFragment(LogFragment logFragment) {
        this.logFragment = logFragment;
    }
}
