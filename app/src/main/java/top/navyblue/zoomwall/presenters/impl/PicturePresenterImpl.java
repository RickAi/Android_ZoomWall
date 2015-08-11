package top.navyblue.zoomwall.presenters.impl;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.List;

import top.navyblue.zoomwall.managers.DataLoader;
import top.navyblue.zoomwall.managers.volley.RequestListener;
import top.navyblue.zoomwall.models.bean.Pictures;
import top.navyblue.zoomwall.presenters.abs.PicturePresenter;
import top.navyblue.zoomwall.utils.Constants;
import top.navyblue.zoomwall.utils.FormatUtils;
import top.navyblue.zoomwall.views.activites.MainActivity;
import top.navyblue.zoomwall.views.activites.PictureActivity;

/**
 * Created by CIR on 8/11/15.
 */
public class PicturePresenterImpl implements PicturePresenter {

    private Pictures mCurrentPicture;
    private List<Pictures.Picture> mCurrentList;
    private Gson mGson;
    private String mNextPage;
    private String mNextPageCache;

    private MainActivity mActivity;


    public PicturePresenterImpl(MainActivity activity){
        mActivity = activity;

        init();
        mNextPage = "";
        mNextPageCache = "";
    }

    private void init() {
        mGson = new Gson();
    }


    @Override
    public void loadFirst() {
        DataLoader.loadPictures(Constants.LASTEST, null, new RequestListener() {
            @Override
            public void requestSuccess(String json) {
                // deal with data
                mCurrentPicture = mGson.fromJson(json, Pictures.class);
                mCurrentList = mCurrentPicture.getData();
                mNextPage = mCurrentPicture.getNext_page_url();

                // deal with view
                mActivity.getAdapter().setFirstPage(mCurrentList);
                mActivity.setRefreshing(false);
            }

            @Override
            public void requestError(VolleyError e) {

            }
        });
    }

    @Override
    public void loadNext() {
        if(mNextPage == null){
            return ;
        }

        DataLoader.loadPictures(Constants.LASTEST, mNextPage, new RequestListener() {
            @Override
            public void requestSuccess(String json) {
                mCurrentPicture = mGson.fromJson(json, Pictures.class);
                mCurrentList = mCurrentPicture.getData();
                mNextPage = mCurrentPicture.getNext_page_url();

                if(!mNextPageCache.equals(mNextPage)){
                    mActivity.getAdapter().addNextPage(mCurrentList);
                    mNextPageCache = mNextPage;
                }
                mActivity.setRefreshing(false);
            }

            @Override
            public void requestError(VolleyError e) {

            }
        });
    }

    @Override
    public void loadPicture(View pictureView, Pictures.Picture picture) {
        Intent intent = new Intent(mActivity, PictureActivity.class);
        intent.putExtra(PictureActivity.PICTURE_URL, FormatUtils.getBigPicutreUrl(picture.getUrl()));
        intent.putExtra(PictureActivity.PICTURE_TITLE, picture.getCreated_at());
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                mActivity, pictureView, PictureActivity.PICTURE_URL);
        ActivityCompat.startActivity(mActivity, intent, optionsCompat.toBundle());
    }

}
