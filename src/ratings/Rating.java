package ratings;

public class Rating {
  private String reviewerID;
  private int rating;

  public Rating(String givenReviewerID, int givenRating) {
    this.setReviewerID(givenReviewerID);
    this.setRating(givenRating);
  }

  public String getReviewerID() {
    return this.reviewerID;
  }

  public int getRating() {
    return this.rating;
  }

  public void setReviewerID(String givenID) {
    this.reviewerID = givenID;
  }

  public void setRating(int givenRating) {
    this.rating = (givenRating > 0 && givenRating <= 5) ? givenRating : -1;
  }

}
