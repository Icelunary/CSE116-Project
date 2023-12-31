package ratings;

public class Reviewer {
  private String ID;

  public Reviewer(String givenID) {
    this.setReviewerID(givenID);
  }

  public String getReviewerID() {
    return this.ID;
  }

  public void setReviewerID(String givenID) {
    this.ID = givenID;
  }

  public Rating rateSong(int score) {
    return new Rating(this.ID, score);
  }
}
