/**
 * Created by WesleyLewis on 9/8/16.
 */
public class Review {
    private String restaurantName;
    private String experience;
    private int rating;
    private  String date;
    private String recommend;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String isRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return String.format(" Restaurant: %s\n Date of Experience:" +
                " %s\n Review: %s\n Rating 1-10: %s\n" +
                " Would You Recommend: %s", restaurantName, date, experience, rating, recommend );
    }
}
