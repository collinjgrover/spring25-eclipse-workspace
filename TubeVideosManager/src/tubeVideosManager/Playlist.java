package tubeVideosManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A playlist keeps tracks of titles and it has a name. An ArrayList of string
 * references stores titles.
 * 
 * @author UMCP CS Department
 *
 */

public class Playlist {
	private String name;
	private ArrayList<String> videoTitles;

	/**
	 * Initializes playlist with the specified name and creates an empty
	 * ArrayList. If the parameter is null or is a blank string (according to
	 * String class isBlank() method) the method will throw an
	 * IllegalArgumentException (with any message) and perform no processing.
	 * 
	 * @param name
	 */
	public Playlist(String name) {
		if (isValidStr(name)) {
			this.name = new String(name);
			videoTitles = new ArrayList<>();
		} else {
			throw new IllegalArgumentException("Invalid parameter(s)");
		}
	}

	/**
	 * Get method for name
	 * 
	 * @return name string
	 */
	public String getName() {
		return new String(name);
	}

	/**
	 * Initializes the current object so changes to the current object will not
	 * affect the parameter object.
	 * 
	 * @param playlist
	 */
	public Playlist(Playlist playlist) {
		if (playlist != null) {
			this.name = new String(playlist.name);
			videoTitles = copyPlayList(playlist.videoTitles);
		}
	}

	/**
	 * Provided; please don't modify. toString for class
	 * 
	 * @return string with object info
	 */
	public String toString() {
		String answer = "Playlist Name: " + name + "\n";

		answer += "VideoTitles: " + videoTitles;

		return answer;
	}

	/**
	 * Adds the title to the Arraylist storing titles. We can add the same video
	 * title several times. If the parameter is null or is a blank string
	 * (according to String class isBlank() method) the method will throw an
	 * IllegalArgumentException (with any message) and perform no processing.
	 * 
	 * @param videoTitle
	 * @return true if title is added; false otherwise
	 */
	public boolean addToPlaylist(String videoTitle) {
		boolean out = false;
		if (isValidStr(videoTitle)) {
		
			
		} else {
			throw new IllegalArgumentException("Invalid paramater(s)");
		}
		return out;
	}

	/**
	 * Get method for the ArrayList of titles. You must avoid privacy leaks.
	 * 
	 * @return ArrayList with titles
	 */
	public ArrayList<String> getPlaylistVideosTitles() {
		throw new UnsupportedOperationException("Implement this method");
	}

	/**
	 * Removes all instances of the title parameter from the ArrayList of
	 * titles. If the parameter is null or is a blank string (according to
	 * String class isBlank() method) the method will throw an
	 * IllegalArgumentException (with any message) and perform no processing.
	 * 
	 * @param videoTitle
	 * @return true if the ArrayList (videoTitles) was changed as a result of
	 *         calling this method and false otherwise.
	 * 
	 */
	public boolean removeFromPlaylistAll(String videoTitle) {
		throw new UnsupportedOperationException("Implement this method");
	}

	/**
	 * Randomizes the list of titles using a random parameter and
	 * Collections.shuffle. If the parameter is null, call Collections.shuffle
	 * with just the ArrayList.
	 * 
	 * @param random
	 */
	public void shuffleVideoTitles(Random random) {
		throw new UnsupportedOperationException("Implement this method");
	}

	/*
	 * private helper method(s)
	 */

	// ensures the string input is valid in the senes that it is not a null
	// reference and is not blank
	private boolean isValidStr(String inputStr) {
		return (inputStr != null && !inputStr.isBlank());
	}
	
	private ArrayList<String> copyPlayList (ArrayList<String> in) {
		ArrayList<String> out = new ArrayList<String>();
		for (String currString : videoTitles) {
			out.add(new String(currString));
		}
		return out;
	}
}
