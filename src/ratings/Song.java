package ratings;

import ratings.datastructures.LinkedListNode;

public class Song {
  private String title;
  private String artist;
  private String ID;
  private LinkedListNode<Rating> ratings;

  public Song(String givenTitle, String givenArtist, String givenID) {
    this.setTitle(givenTitle);
    this.setArtist(givenArtist);
    this.setSongID(givenID);
  }

  public String getTitle() {
    return this.title;
  }

  public String getArtist() {
    return this.artist;
  }

  public String getSongID() {
    return this.ID;
  }

  public void setTitle(String givenTitle) {
    this.title = givenTitle;
  }

  public void setArtist(String givenArtist) {
    this.artist = givenArtist;
  }

  public void setSongID(String givenID) {
    this.ID = givenID;
  }

  public void addRating(Rating givenRating) {
    if (this.didReviewerRateSong(givenRating.getReviewerID())) {
      return;
    }
    if (this.ratings != null) {
      this.ratings.append(givenRating);
    } else {
      this.ratings = new LinkedListNode<Rating>(givenRating, null);
    }
  }

  public LinkedListNode<Rating> getRatings() {
    return this.ratings;
  }

  public void setRatings(LinkedListNode<Rating> ratings) {
    this.ratings = ratings;
  }

  public double averageRating() {
    if (this.ratings == null) {
      return 0.0;
    }
    double ret = 0.0;

    // Number of ratings
    int num = 0;
    LinkedListNode<Rating> root = this.ratings;
    while (root != null) {
      int rating = root.getValue().getRating();
      ret += rating;
      num += 1;
      root = root.getNext();
    }
    return ret / num;
  }

  public boolean didReviewerRateSong(String givenID) {
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

  public void removeRatingByReviewer(Reviewer reviewer) {
    LinkedListNode<Rating> root = this.ratings;
    LinkedListNode<Rating> prev = null;
    while (root != null) {
      String ID = root.getValue().getReviewerID();
      if (ID.equals(reviewer.getReviewerID())) {
        if (prev == null) {
          this.ratings = root.getNext();
        } else {
          prev.setNext(root.getNext());
        }
        break;
      }
      prev = root;
      root = root.getNext();
    }
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
