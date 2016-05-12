package tejasvinareddyteju.deltabucketlist.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import tejasvinareddyteju.deltabucketlist.Fragment.BlankFragment;
import tejasvinareddyteju.deltabucketlist.R;

public class NavigationActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private MenuItem previousMI;

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        setTitle(previousMI.getTitle());
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // FIXME
        Class fragmentClass = null;
        if (id == R.id.nav_bucketlist) {
            fragmentClass = BlankFragment.class;
        } else if (id == R.id.nav_edit_destinations) {
            fragmentClass = BlankFragment.class;
        } else if (id == R.id.nav_settings) {
            fragmentClass = BlankFragment.class;
        } else if (id == R.id.nav_about) {
            // TODO
        }

        Fragment fragment;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            System.out.println("FRAGMENT NOT SET or NOT A PROPER FRAGMENT");
            Toast.makeText(this, "Fragment not set or not a proper fragment",
                    Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return false;
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFrameLayout,
                fragment).commit();

        previousMI.setChecked(false);
        previousMI = item;

        // Update the title, and close the drawer
        item.setChecked(true);
        setTitle(item.getTitle());
        drawer.closeDrawers();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R
                .string.navigation_drawer_close) {
            /**
             * Called when a drawer has settled in a completely open state.
             */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                setTitle(R.string.toolbar_app_name);
            }

            /**
             * Called when a drawer has settled in a completely closed state.
             */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                setTitle(previousMI.getTitle());
            }
        };
        drawer.setDrawerListener(toggle);
        drawer.setStatusBarBackgroundColor(Color.BLUE);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        previousMI = navigationView.getMenu().getItem(0);
        previousMI.setChecked(true);
        setTitle(previousMI.getTitle());

        // FIXME default fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFrameLayout,
                BlankFragment.newInstance()).commit();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams
                    .FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color
                    .primary_color_dark));
        }
    }
}