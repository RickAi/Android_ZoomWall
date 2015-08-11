package top.navyblue.zoomwall.presenters.abs;

import android.view.View;

import top.navyblue.zoomwall.views.adapters.PictureRecyclerAdapter;

/**
 * Created by CIR on 8/11/15.
 */
public interface PicturePresenter {

    void loadFirst();

    void loadNext();

    void loadPicture(View pictureView, View hiddenImage, PictureRecyclerAdapter.PictureViewHolder holder);
}