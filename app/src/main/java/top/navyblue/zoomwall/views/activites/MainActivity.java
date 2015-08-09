package top.navyblue.zoomwall.views.activites;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.Bind;
import butterknife.ButterKnife;
import top.navyblue.zoomwall.R;
import top.navyblue.zoomwall.utils.Constants;
import top.navyblue.zoomwall.views.fragments.MovieFragment;
import top.navyblue.zoomwall.views.fragments.PictureContentFragment;


public class MainActivity extends FragmentActivity {

    @Bind(R.id.viewpagertab)
    SmartTabLayout mViewpagertab;
    @Bind(R.id.viewpager)
    ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initComponents();
    }

    private void initComponents() {
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add(Constants.NAVIGATION_PICTURE, PictureContentFragment.class)
                        .add(Constants.NAVIGATION_MOVIE, MovieFragment.class)
                        .create()
                );

        mViewpager.setAdapter(adapter);
        mViewpagertab.setViewPager(mViewpager);
        mViewpager.setPageTransformer(true, new ForegroundToBackgroundTransformer());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
