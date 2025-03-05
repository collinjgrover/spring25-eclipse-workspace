package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import tubeVideosManager.Genre;
import tubeVideosManager.Playlist;
import tubeVideosManager.TubeVideosManager;
import tubeVideosManager.Video;

/**
 * 
 * You need student tests if you are asking for help during office hours about
 * bugs in your code. Feel free to use tools available in TestingSupport.java
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests {

	// tests for Playlist.java
	@Test
	public void testConstructor() {
		Playlist playlist = new Playlist("MyPlaylist");
		assertEquals("MyPlaylist", playlist.getName());
		Playlist playlist1 = new Playlist("");
	}

	@Test
	public void testAddToPlaylistValidTitle() {
		Playlist playlist = new Playlist("Test");
		assertTrue(playlist.addToPlaylist("Video1"));
		assertTrue(playlist.getPlaylistVideosTitles().contains("Video1"));
	}

	@Test
	public void testAddToPlaylistEmptyTitle() {
		Playlist playlist = new Playlist("Test");
		playlist.addToPlaylist("");
	}

	@Test
	public void testAddToPlaylistBlankTitle() {
		Playlist playlist = new Playlist("Test");
		playlist.addToPlaylist("");
	}

	@Test
	public void testGetPlaylistVideosTitles() {
		Playlist playlist = new Playlist("Test");
		playlist.addToPlaylist("Video1");
		ArrayList<String> titles = playlist.getPlaylistVideosTitles();
		titles.add("FakeVideo");

		assertFalse(playlist.getPlaylistVideosTitles().contains("FakeVideo"));
	}

	@Test
	public void testRemoveFromPlaylistValidTitle() {
		Playlist playlist = new Playlist("Test");
		playlist.addToPlaylist("Video1");
		playlist.addToPlaylist("Video1");
		playlist.addToPlaylist("Video2");

		assertTrue(playlist.removeFromPlaylistAll("Video1"));
		assertFalse(playlist.getPlaylistVideosTitles().contains("Video1"));
		assertTrue(playlist.getPlaylistVideosTitles().contains("Video2"));
	}

	@Test
	public void testRemoveFromPlaylistAllNonExistentTitle() {
		Playlist playlist = new Playlist("Test");
		assertFalse(playlist.removeFromPlaylistAll("NonExistent"));
	}

	@Test
	public void testShuffleVideoTitles() {
		Playlist playlist = new Playlist("Test");
		playlist.addToPlaylist("A");
		playlist.addToPlaylist("B");
		playlist.addToPlaylist("C");

		ArrayList<String> originalOrder = new ArrayList<>(
				playlist.getPlaylistVideosTitles());

		playlist.shuffleVideoTitles(new Random());

		assertNotEquals(originalOrder, playlist.getPlaylistVideosTitles());
	}

	// tests for Video.java

	@Test
	public void testConstructorInvalidGenre() {
		new Video("Title", "https://realurl.com", 5, null);
	}

	@Test
	public void testGetTitle() {
		Video video = new Video("Title", "https://realurl.com", 5, Genre.Music);
		assertEquals("Title", video.getTitle());
	}

	@Test
	public void testGetUrl() {
		Video video = new Video("Title", "https://realurl.com", 5, Genre.Music);
		assertEquals("https://realurl.com", video.getUrl());
	}

	@Test
	public void testGetDuration() {
		Video video = new Video("Title", "https://realurl.com", 5,
				Genre.Comedy);
		assertEquals(5, video.getDurationInMinutes());
	}

	@Test
	public void testGetGenre() {
		Video video = new Video("Title", "https://realurl.com", 5,
				Genre.Comedy);
		assertEquals(Genre.Comedy, video.getGenre());
	}

	@Test
	public void testAddCommentsValid() {
		Video video = new Video("TitledVideo", "https://realurl.com", 5,
				Genre.Comedy);
		assertTrue(video.addComments("Sick video!"));
		assertEquals(1, video.getComments().size());
	}

	@Test
	public void testAddCommentsInvalid() {
		Video video = new Video("Title", "https://realurl.com", 5,
				Genre.Documentary);
		video.addComments("");
	}

	// Manager tests2

	@Test
	public void testAddPlaylist() {
		TubeVideosManager manager = new TubeVideosManager();
		assertTrue(manager.addPlaylist("realPlayList"));
		assertFalse(manager.addPlaylist("realerPlaylist"));
	}

	public void testAddPlaylistInvalid() {
		TubeVideosManager manager = new TubeVideosManager();
		manager.addPlaylist("");
	}

	@Test
	public void testGetPlaylistsNames() {
		TubeVideosManager manager = new TubeVideosManager();
		manager.addPlaylist("realPlayList");
		manager.addPlaylist("realerPlaylist");

		String[] names = manager.getPlaylistsNames();
		assertArrayEquals(new String[] { "realPlayList", "realerPlaylist" },
				names);
	}
	 
	@Test
	public void testAddCommets() {
		TubeVideosManager manager = new TubeVideosManager();
		manager.addVideoToDB("realVid", "https://google.com", 20, Genre.Comedy);
		System.out.println(manager.addComments("realVid", "sick"));
		System.out.println(	manager.findVideo("realVid").getComments().get(0));
	}

	@Test
	public void testClearDatabase() {
		TubeVideosManager manager = new TubeVideosManager();
		manager.addPlaylist("realPlayList");
		assertEquals(1, manager.getPlaylistsNames().length);
		manager.clearDatabase();
		assertEquals(0, manager.getPlaylistsNames().length);
	}

}
