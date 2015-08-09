package top.navyblue.zoomwall.managers;


import top.navyblue.zoomwall.managers.volley.RequestListener;
import top.navyblue.zoomwall.managers.volley.RequestManager;
import top.navyblue.zoomwall.utils.Constants;

/**
 * Created by CIR on 8/9/15.
 */
public class DataLoader {

    private static final String TAG = "DataLoader";

    public static void loadPictures(String pictureType, String url, RequestListener listener) {
        if (pictureType.equals(Constants.LASTEST)) {
            loadLastestPictures(url, listener);
        } else if (pictureType.equals(Constants.RANDOM)) {
            loadRandomPictures(url, listener);
        } else if (pictureType.equals(Constants.OLDEST)) {
            loadOldestPictures(url, listener);
        }
    }

    public static void loadLastestPictures(String url, RequestListener listener) {
        // init the data
        if(url == null){
            url = UrlManager.getPictures();
        }

        // query the data from network
        RequestManager.get(url, Constants.LASTEST, listener);
    }

    public static void loadRandomPictures(String url, RequestListener listener) {
        // init the data
        if(url == null){
            url = UrlManager.getPictures();
        }

        // query the data from network
        RequestManager.get(url, Constants.RANDOM, listener);
    }

    public static void loadOldestPictures(String url, RequestListener listener) {
        // init the data
        if(url == null){
            url = UrlManager.getPictures();
        }

        // query the data from network
        RequestManager.get(url, Constants.OLDEST, listener);
    }



}
