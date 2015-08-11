package top.navyblue.zoomwall.presenters.abs;

import android.view.View;

import top.navyblue.zoomwall.models.bean.Pictures;

/**
 * Created by CIR on 8/11/15.
 */
public interface PicturePresenter {

    void loadFirst();

    void loadNext();

    void loadPicture(View pictureView, Pictures.Picture picture);
}
