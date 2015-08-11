package top.navyblue.zoomwall.views.activites;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import top.navyblue.zoomwall.R;
import top.navyblue.zoomwall.models.bean.Pictures;
import top.navyblue.zoomwall.presenters.abs.PicturePresenter;
import top.navyblue.zoomwall.presenters.impl.PicturePresenterImpl;
import top.navyblue.zoomwall.views.adapters.PictureRecyclerAdapter;


public class MainActivity extends SwipeRefreshBaseActivity {

    @Bind(R.id.rv_pictures)
    RecyclerView mRvPictures;

    private PictureRecyclerAdapter mPictureAdapter;
    private Context mContext;
    private LinearLayoutManager mLayoutManager;

    private PicturePresenter mPicturePresenter;
    private int visibleItemCount;
    private int totalItemCount;
    private int pastVisiblesItems;


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        initComponents();
    }

    private void initComponents() {
        // init presenter
        mPicturePresenter = new PicturePresenterImpl(this);

        // init widgets
        mContext = this;
        mLayoutManager = new LinearLayoutManager(mContext);
        mPictureAdapter = new PictureRecyclerAdapter(mContext);
        mRvPictures.setLayoutManager(mLayoutManager);
        mRvPictures.setAdapter(mPictureAdapter);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mRvPictures.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                visibleItemCount = mLayoutManager.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

                if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {

                    // load next page's pics
                    mSwipeRefreshLayout.setRefreshing(true);
                    mPicturePresenter.loadNext();
                }
            }
        });

        mPictureAdapter.setOnPictureClickListener(new PictureRecyclerAdapter.OnPictureClickListener(){

            @Override
            public void onPictureClick(View pictureView, Pictures.Picture picture) {
                mPicturePresenter.loadPicture(pictureView, picture);
            }
        });
    }

    @Override
    public void requestFirstPage() {
        mSwipeRefreshLayout.setRefreshing(true);

        mPicturePresenter.loadFirst();

        mRvPictures.smoothScrollToPosition(0);
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

    public PictureRecyclerAdapter getAdapter(){
        return mPictureAdapter;
    }

    public SwipeRefreshLayout getRefreshLayout(){
        return mSwipeRefreshLayout;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }

    public void onFab(View view) {
        mRvPictures.smoothScrollToPosition(0);
        requestFirstPage();
    }
}
