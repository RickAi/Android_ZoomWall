package top.navyblue.zoomwall.presenters.impl;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.List;

import top.navyblue.zoomwall.managers.DataLoader;
import top.navyblue.zoomwall.managers.volley.RequestListener;
import top.navyblue.zoomwall.models.bean.Pictures;
import top.navyblue.zoomwall.presenters.abs.PicturePresenter;
import top.navyblue.zoomwall.utils.Constants;
import top.navyblue.zoomwall.views.activites.MainActivity;

/**
 * Created by CIR on 8/11/15.
 */
public class PicturePresenterImpl implements PicturePresenter {

    private Pictures mCurrentPicture;
    private List<Pictures.Picture> mCurrentList;
    private Gson mGson;
    private String mNextPage;

    private MainActivity mActivity;


    public PicturePresenterImpl(MainActivity activity){
        mActivity = activity;

        init();
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

                mActivity.getAdapter().addNextPage(mCurrentList);
                mActivity.setRefreshing(false);
            }

            @Override
            public void requestError(VolleyError e) {

            }
        });
    }
}
