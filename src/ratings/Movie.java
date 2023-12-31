package ratings;

import java.util.ArrayList;

import ratings.datastructures.LinkedListNode;

public class Movie {
  private String title;
  private ArrayList<String> casters;
  private LinkedListNode<Rating> ratings;

  public Movie(String title, ArrayList<String> casters) {
    this.setTitle(title);
    this.setCaster(casters);
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCaster(ArrayList<String> casters) {
    this.casters = casters;
  }

  public String getTitle() {
    return this.title;
  }

  public ArrayList<String> getCast() {
    return this.casters;
  }

  public void addRating(Rating givenRating) {
    if (this.didReviewerRateMovie(givenRating.getReviewerID())) {
      return;
    }
    if (this.ratings != null) {
      this.ratings.append(givenRating);
    } else {
      this.ratings = new LinkedListNode<Rating>(givenRating, null);
    }
  }

  public boolean didReviewerRateMovie(String givenID) {
    LinkedListNode<Rating> root = this.ratings;
    while (root != null) {
      String ID = root.getValue().getReviewerID();
      if (ID.equals(givenID)) {
        return true;
      }
      root = root.getNext();
    }
    return false;
  }

  public double bayesianAverageRating(int number, int averageRating) {
    if (averageRating < 1 || averageRating > 5) {
      return 0.0;
    }
    if (this.ratings == null) {
      return averageRating; // return the prior if there are no ratings
    }
    double sumRatings = 0.0;
    int numRatings = 0;
    LinkedListNode<Rating> root = this.ratings;

    while (root != null) {
      int rating = root.getValue().getRating();
      sumRatings += rating;
      numRatings++;
      root = root.getNext();
    }

    return (averageRating * number + sumRatings) / (number + numRatings);
  }
}
