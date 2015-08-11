package top.navyblue.zoomwall.utils;

/**
 * Created by CIR on 8/9/15.
 */
public class FormatUtils {

    public static String getBigPicutreUrl(String previewUrl){

        // the rule of the website
        String bigPictureUrl = previewUrl.replace("preview_", "");
        return bigPictureUrl;
    }
}
