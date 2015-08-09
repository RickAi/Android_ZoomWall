package top.navyblue.zoomwall.models.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CIR on 8/9/15.
 */
public class Pictures {

    /**
     * to : 5
     * next_page_url : http://123.57.229.9/api/v1/pictures/?page=2
     * last_page : 6450
     * total : 32249
     * per_page : 5
     * data : [{"id":"2","created_at":"2015-08-06 00:00:00","url":"https://a.desktopprassets.com/wallpapers/be93c07d88bb1b54eec7fb8325b89c87e9b7c81e/preview_1c5el.jpg"},{"id":"3","created_at":"2015-08-06 00:00:00","url":"https://a.desktopprassets.com/wallpapers/4915b64e0bc4ad2c4e8d177633561264e10d5bd2/preview_wallpaper-07092012.png"},{"id":"4","created_at":"2015-08-06 00:00:00","url":"https://a.desktopprassets.com/wallpapers/25eb5349405b75f993002cecddf578d51df6e0f3/preview_epic-desktop-wallpapers-3.jpg"},{"id":"5","created_at":"2015-08-06 00:00:00","url":"https://a.desktopprassets.com/wallpapers/9b68b41c153a1032eb15167cc4e285094a231131/preview_sstst.jpg"},{"id":"6","created_at":"2015-08-06 00:00:00","url":"https://a.desktopprassets.com/wallpapers/3eccdfbada85da20842451c5eeba7176b10f4a36/preview_wallpaper-2227160.jpg"}]
     * from : 1
     * prev_page_url : null
     * current_page : 1
     */
    private int to;
    private String next_page_url;
    private int last_page;
    private int total;
    private int per_page;
    private List<Picture> data;
    private int from;
    private String prev_page_url;
    private int current_page;

    public Pictures(){
        data = new ArrayList<Picture>();
    }

    public void setTo(int to) {
        this.to = to;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public void setData(List<Picture> data) {
        this.data = data;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setPrev_page_url(String prev_page_url) {
        this.prev_page_url = prev_page_url;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getTo() {
        return to;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public int getLast_page() {
        return last_page;
    }

    public int getTotal() {
        return total;
    }

    public int getPer_page() {
        return per_page;
    }

    public List<Picture> getData() {
        return data;
    }

    public int getFrom() {
        return from;
    }

    public String getPrev_page_url() {
        return prev_page_url;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public static class Picture{
        /**
         * id : 2
         * created_at : 2015-08-06 00:00:00
         * url : https://a.desktopprassets.com/wallpapers/be93c07d88bb1b54eec7fb8325b89c87e9b7c81e/preview_1c5el.jpg
         */
        private String id;
        private String created_at;
        private String url;

        public void setId(String id) {
            this.id = id;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getId() {
            return id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUrl() {
            return url;
        }
    }
}
