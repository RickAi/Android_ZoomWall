package top.navyblue.zoomwall.managers;

/**
 * Created by CIR on 8/2/15.
 */
public class UrlManager {

    public static final String DOUBAN_API = "http://api.douban.com";
    public static final String NAVY_BLUE_BASE = "http://123.57.229.9";


    // Douban movie:
    // http://api.douban.com/v2/movie/top250
    public static String getTop250(){
        String url = DOUBAN_API + "/v2/movie/top250";
        return url;
    }

    // http://api.douban.com/v2/movie/weekly
    public static String getWeekly(){
        String url = DOUBAN_API + "/v2/movie/weekly";
        return url;
    }

    // http://api.douban.com/v2/movie/us_box
    public static String getUsbox(){
        String url = DOUBAN_API + "/v2/movie/us_box";
        return url;
    }

    // http://api.douban.com/v2/movie/new_movies
    public static String getNewmovies(){
        String url = DOUBAN_API + "/v2/movie/new_movies";
        return url;
    }

    // Pictures
    // 123.57.229.9/api/v1/pictures
    public static String getPictures(){
        return NAVY_BLUE_BASE + "/api/v1/pictures";
    }

}
