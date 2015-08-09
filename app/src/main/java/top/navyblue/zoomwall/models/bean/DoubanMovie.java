package top.navyblue.zoomwall.models.bean;

import java.util.List;

/**
 * Created by CIR on 8/2/15.
 */
public class DoubanMovie {


    /**
     * id : 1292052
     * title : 肖申克的救赎
     * genres : ["犯罪","剧情"]
     * alt : http://movie.douban.com/subject/1292052/
     * subtype : movie
     * original_title : The Shawshank Redemption
     * images : {"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p480747492.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p480747492.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p480747492.jpg"}
     * year : 1994
     * casts : [{"id":"1054521","alt":"http://movie.douban.com/celebrity/1054521/","name":"蒂姆·罗宾斯","avatars":{"small":"http://img6.douban.com/img/celebrity/small/17525.jpg","medium":"http://img6.douban.com/img/celebrity/medium/17525.jpg","large":"http://img6.douban.com/img/celebrity/large/17525.jpg"}},{"id":"1054534","alt":"http://movie.douban.com/celebrity/1054534/","name":"摩根·弗里曼","avatars":{"small":"http://img6.douban.com/img/celebrity/small/34642.jpg","medium":"http://img6.douban.com/img/celebrity/medium/34642.jpg","large":"http://img6.douban.com/img/celebrity/large/34642.jpg"}},{"id":"1041179","alt":"http://movie.douban.com/celebrity/1041179/","name":"鲍勃·冈顿","avatars":{"small":"http://img6.douban.com/img/celebrity/small/5837.jpg","medium":"http://img6.douban.com/img/celebrity/medium/5837.jpg","large":"http://img6.douban.com/img/celebrity/large/5837.jpg"}}]
     * collect_count : 850250
     * rating : {"min":0,"max":10,"stars":"50","average":9.6}
     * directors : [{"id":"1047973","alt":"http://movie.douban.com/celebrity/1047973/","name":"弗兰克·德拉邦特","avatars":{"small":"http://img6.douban.com/img/celebrity/small/230.jpg","medium":"http://img6.douban.com/img/celebrity/medium/230.jpg","large":"http://img6.douban.com/img/celebrity/large/230.jpg"}}]
     */
    private String id;
    private String title;
    private List<String> genres;
    private String alt;
    private String subtype;
    private String original_title;
    private ImagesEntity images;
    private String year;
    private List<CastsEntity> casts;
    private int collect_count;
    private RatingEntity rating;
    private List<DirectorsEntity> directors;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setImages(ImagesEntity images) {
        this.images = images;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setCasts(List<CastsEntity> casts) {
        this.casts = casts;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public void setRating(RatingEntity rating) {
        this.rating = rating;
    }

    public void setDirectors(List<DirectorsEntity> directors) {
        this.directors = directors;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getAlt() {
        return alt;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public ImagesEntity getImages() {
        return images;
    }

    public String getYear() {
        return year;
    }

    public List<CastsEntity> getCasts() {
        return casts;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public RatingEntity getRating() {
        return rating;
    }

    public List<DirectorsEntity> getDirectors() {
        return directors;
    }

    public static class ImagesEntity {
        /**
         * small : http://img6.douban.com/view/movie_poster_cover/ipst/public/p480747492.jpg
         * medium : http://img6.douban.com/view/movie_poster_cover/spst/public/p480747492.jpg
         * large : http://img6.douban.com/view/movie_poster_cover/lpst/public/p480747492.jpg
         */
        private String small;
        private String medium;
        private String large;

        public void setSmall(String small) {
            this.small = small;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getSmall() {
            return small;
        }

        public String getMedium() {
            return medium;
        }

        public String getLarge() {
            return large;
        }
    }

    public static class CastsEntity {
        /**
         * id : 1054521
         * alt : http://movie.douban.com/celebrity/1054521/
         * name : 蒂姆·罗宾斯
         * avatars : {"small":"http://img6.douban.com/img/celebrity/small/17525.jpg","medium":"http://img6.douban.com/img/celebrity/medium/17525.jpg","large":"http://img6.douban.com/img/celebrity/large/17525.jpg"}
         */
        private String id;
        private String alt;
        private String name;
        private AvatarsEntity avatars;

        public void setId(String id) {
            this.id = id;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAvatars(AvatarsEntity avatars) {
            this.avatars = avatars;
        }

        public String getId() {
            return id;
        }

        public String getAlt() {
            return alt;
        }

        public String getName() {
            return name;
        }

        public AvatarsEntity getAvatars() {
            return avatars;
        }

        public static class AvatarsEntity {
            /**
             * small : http://img6.douban.com/img/celebrity/small/17525.jpg
             * medium : http://img6.douban.com/img/celebrity/medium/17525.jpg
             * large : http://img6.douban.com/img/celebrity/large/17525.jpg
             */
            private String small;
            private String medium;
            private String large;

            public void setSmall(String small) {
                this.small = small;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getSmall() {
                return small;
            }

            public String getMedium() {
                return medium;
            }

            public String getLarge() {
                return large;
            }
        }
    }

    public static class RatingEntity {
        /**
         * min : 0
         * max : 10
         * stars : 50
         * average : 9.6
         */
        private int min;
        private int max;
        private String stars;
        private double average;

        public void setMin(int min) {
            this.min = min;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public String getStars() {
            return stars;
        }

        public double getAverage() {
            return average;
        }
    }

    public static class DirectorsEntity {
        /**
         * id : 1047973
         * alt : http://movie.douban.com/celebrity/1047973/
         * name : 弗兰克·德拉邦特
         * avatars : {"small":"http://img6.douban.com/img/celebrity/small/230.jpg","medium":"http://img6.douban.com/img/celebrity/medium/230.jpg","large":"http://img6.douban.com/img/celebrity/large/230.jpg"}
         */
        private String id;
        private String alt;
        private String name;
        private AvatarsEntity avatars;

        public void setId(String id) {
            this.id = id;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAvatars(AvatarsEntity avatars) {
            this.avatars = avatars;
        }

        public String getId() {
            return id;
        }

        public String getAlt() {
            return alt;
        }

        public String getName() {
            return name;
        }

        public AvatarsEntity getAvatars() {
            return avatars;
        }

        public static class AvatarsEntity {
            /**
             * small : http://img6.douban.com/img/celebrity/small/230.jpg
             * medium : http://img6.douban.com/img/celebrity/medium/230.jpg
             * large : http://img6.douban.com/img/celebrity/large/230.jpg
             */
            private String small;
            private String medium;
            private String large;

            public void setSmall(String small) {
                this.small = small;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getSmall() {
                return small;
            }

            public String getMedium() {
                return medium;
            }

            public String getLarge() {
                return large;
            }
        }
    }
}
