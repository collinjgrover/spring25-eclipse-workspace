/*
 * Name: Collin Grover
 * UID: 121312136
 * UMD CMSC 132 - Project #1, 2/5
 * The Playlist class represents a collection of video titles with a specified 
 * 
. It allows for various operations upon the list such as adding and
 * removing video titles. Playlist.java also includes a shuffle method to randomize 
 * the order of titles. All inputs are ensured to be valid before any processing
 * takes place. 
 */
package tubeVideosManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Random;

import javax.print.attribute.standard.QueuedJobCount;

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
			videoTitles.add(new String(videoTitle));
			out = true;
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
		ArrayList<String> out = new ArrayList<>();
		for (String currString : videoTitles) {
			out.add(new String(currString)); // avoiding privacy leaks
		}
		return out;
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
		boolean out = false;
		if (isValidStr(videoTitle)) {
				out = videoTitles.remove(videoTitle);
		}
		return out;
	}

	/**
	 * Randomizes the list of titles using a random parameter and
	 * Collections.shuffle. If the parameter is null, call Collections.shuffle
	 * with just the ArrayList.
	 * 
	 * @param random
	 */
	public void shuffleVideoTitles(Random random) {
		if (random == null) {
			Collections.shuffle(videoTitles);
		} else {
			Collections.shuffle(videoTitles, random);
		}
	}

	/*
	 * private helper method(s)
	 */

	/*
	 * ensures the string input is valid in the sense that it is not a null
	 * reference and is not blank
	 */
	private boolean isValidStr(String inputStr) {
		return (inputStr != null && !inputStr.isBlank());
	}

	/*
	 * returns a copy of the input ArrayList representing a playlist ensuring no
	 * data leaks take place
	 */
	private ArrayList<String> copyPlayList(ArrayList<String> in) {
		ArrayList<String> out = new ArrayList<String>();
		for (String currString : in) {
			out.add(new String(currString));
		}
		return out;
	}
}
