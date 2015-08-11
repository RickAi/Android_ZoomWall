package top.navyblue.zoomwall.views.activites;

import android.app.Activity;
import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import top.navyblue.zoomwall.R;
import top.navyblue.zoomwall.utils.FormatUtils;
import uk.co.senab.photoview.PhotoViewAttacher;

public class PictureActivity extends Activity {

    static final String PHOTO_TAP_TOAST_STRING = "Photo Tap! X: %.2f %% Y:%.2f %% ID: %d";
    static final String SCALE_TOAST_STRING = "Scaled to: %.2ff";

    public static String PICTURE_URL = "picture";
    @Bind(R.id.sdv_picture)
    SimpleDraweeView mSdvPicture;
    private Toast mCurrentToast;


    private String mPictureUrl;
    private PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        Intent intent = getIntent();
        String previewUrl = intent.getStringExtra(PICTURE_URL);
        mPictureUrl = FormatUtils.getBigPicutreUrl(previewUrl);

        Uri uri = Uri.parse(mPictureUrl);
        mSdvPicture.setImageURI(uri);
        mAttacher = new PhotoViewAttacher(mSdvPicture);
        mAttacher.setOnMatrixChangeListener(new MatrixChangeListener());
        mAttacher.setOnPhotoTapListener(new PhotoTapListener());
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

    private class PhotoTapListener implements PhotoViewAttacher.OnPhotoTapListener {


        @Override
        public void onPhotoTap(View view, float x, float y) {
            float xPercentage = x * 100f;
            float yPercentage = y * 100f;

            showToast(String.format(PHOTO_TAP_TOAST_STRING, xPercentage, yPercentage, view == null ? 0 : view.getId()));
        }
    }

    private class MatrixChangeListener implements PhotoViewAttacher.OnMatrixChangedListener {


        @Override
        public void onMatrixChanged(RectF rect) {
        }
    }
}
