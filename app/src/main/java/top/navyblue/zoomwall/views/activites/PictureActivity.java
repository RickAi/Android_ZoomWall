package top.navyblue.zoomwall.views.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import top.navyblue.zoomwall.R;
import top.navyblue.zoomwall.utils.FormatUtils;
import uk.co.senab.photoview.PhotoViewAttacher;

public class PictureActivity extends ToolbarActivity {

    static final String PHOTO_TAP_TOAST_STRING = "Photo Tap! X: %.2f %% Y:%.2f %% ID: %d";
    static final String SCALE_TOAST_STRING = "Scaled to: %.2ff";

    public static String PICTURE_URL = "picture";
    public static String PICTURE_TITLE = "picture_title";


    @Bind(R.id.iv_picture)
    ImageView mIvPicture;
    private Toast mCurrentToast;

    private String mPictureTitle;
    private String mPictureUrl;
    private PhotoViewAttacher mAttacher;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_picture;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        initData();
        initComponent();
    }

    // init the data that needed in this activity
    private void initData() {
        Intent intent = getIntent();
        String previewUrl = intent.getStringExtra(PICTURE_URL);
        mPictureUrl = FormatUtils.getBigPicutreUrl(previewUrl);
        mPictureTitle = intent.getStringExtra(PICTURE_TITLE);
        mAttacher = new PhotoViewAttacher(mIvPicture);
    }

    // init the toolbar and imageview in this activity
    private void initComponent() {
        setAppBarAlpha(0.7f);
        setTitle(mPictureTitle);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ViewCompat.setTransitionName(mIvPicture, PICTURE_URL);
        mAttacher.setOnViewTapListener(
                new PhotoViewAttacher.OnViewTapListener() {
                    @Override
                    public void onViewTap(View view, float v, float v1) {
                        hideOrShowToolbar();
                    }
                }
        );

        Picasso.with(this).load(mPictureUrl).into(mIvPicture, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mAttacher.cleanup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_picture, menu);
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

    private void showToast(CharSequence text) {
        if (null != mCurrentToast) {
            mCurrentToast.cancel();
        }


        mCurrentToast = Toast.makeText(PictureActivity.this, text, Toast.LENGTH_SHORT);
        mCurrentToast.show();
    }

}
