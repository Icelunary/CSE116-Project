package tests;

import org.junit.Test;
import ratings.Movie;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

public class TestClasses2 {

  public void compareArrayListString(ArrayList<String> computed, ArrayList<String> expected) {
    assertTrue(computed.size() == expected.size());
    for (int i = 0; i < expected.size(); i++) {
      assertTrue(computed.get(i).equalsIgnoreCase(expected.get(i)));
    }
  }

  @Test
  public void testMovieClass() {
    ArrayList<String> expected = new ArrayList<>(
        Arrays.asList("Paul", "Joker", "Nirvana", "Test"));
    Movie movie = new Movie("The Boys", expected);

    assertTrue(movie.getTitle().equals("The Boys"));

    ArrayList<String> computed = movie.getCast();
    this.compareArrayListString(computed, expected);

  }

  // public boolean compareRatings()
}
