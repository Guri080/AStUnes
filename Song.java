//Assignment #: Arizona State University Spring 2023 CSE205 #9
//Name: Gursparsh Singh Sodhi
//StudentID: 1225873053
//Lecture: 10:30 Tuesdays/Thursday
//Description:Parts of the music distribution program AStUnes will be
//implemented in the code. AStUnes offers a variety of tools for creating 
//music playlists. Different methods can be used to add or remove songs 
//from a playlist, and different strategies can be used to combine two playlists.

public class Song {
	private String title;
	private String artist;
	public Song next;
	public static final Song END = new Song();

	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
		next = END;
	}

	// This is used to construct the END Table.
	private Song() {
		title = "";
		artist = "";
		next = this;
	}

	public Song getNext() {
		return this.next;
	}

	public boolean equals(Song other) {
		if (this.title.equals(other.title) && this.artist.equals(other.artist))
			return true;
		return false;
	}

	public String toString() {
		return "Title: " + title + "\tArtist: " + artist;
	}
}
