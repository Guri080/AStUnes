//Assignment #: Arizona State University Spring 2023 CSE205 #9
//Name: Gursparsh Singh Sodhi
//StudentID: 1225873053
//Lecture: 10:30 Tuesdays/Thursday
//Description:Parts of the music distribution program AStUnes will be
//implemented in the code. AStUnes offers a variety of tools for creating 
//music playlists. Different methods can be used to add or remove songs 
//from a playlist, and different strategies can be used to combine two playlists.

public class Playlist {
	String name;
	Song first;

	public Playlist() {
		name = "library";
		first = Song.END;
	}

	public Playlist(String name) {
		this.name = name;
		first = Song.END;
	}

	public String getName() {
		return name;
	}

	// this method adds the song the user wants
	public void add(Song song) {
		if (size() == 0) { // if there are no songs in playlist this if statement is called
			first = Song.END.next = song;
		} else {
			Song.END.next.next = song; // if there are more than 0 songs in the playlist this else statement is called
			Song.END.next = song;
			song.next = Song.END;
		}

	}

	// this method returns the total number of songs in the playlsit
	public int size() {
		if (head() == Song.END) {
			return 0; // if the head of the list is equal to a new song that means no songs are in the
						// playlist
		}
		int size = 0;
		Song iter = first;

		while (iter != null) {
			size++; // otherwise the size will increment every time the iterator goes to the next
					// iteration
			if (iter.next != Song.END) {
				iter = iter.next;
			} else {
				break;
			}
		}
		return size;
	}

	// this method removes the very first song in the playlist
	public Song removeFirst() {
		Song size;
		size = head();
		first = head().getNext(); // sets the new head from the 1st to the 2nd position
		return size;
	}

	// this method removes any particular song the user wants
	public int remove(Song song) {
		Song iter = first;
		int index = 0;

		if (first.equals(song)) { // if the song is the first one in the playlist this if statement is called
			//first = first.next;
			removeFirst();
			return index;
		}
		while (iter != null) { // otherwise this while loop finds the particular song and removes it
			if (iter.next.equals(song)) {
				// remove song at index
				iter.next = iter.next.next;

				return index + 1;
			}
			if (iter.next != Song.END) {
				iter = iter.next;
				index++;
			} else {
				return -1;
			}
		}
		return -1;
	}

	public Song head() {
		return first;
	}

	// this method gives the position of the songs
	public int getPosition(Song song) {
		int index = 0;
		Song iter = first;

		while (iter != null) {
			if (iter.equals(song)) {
				return index;
			}
			if (iter.next != Song.END) {
				iter = iter.next;
				index++;
			} else {
				return -1;
			}
		}
		return -1;
	}

	// this method calls the toString method and lists all the songs in playlist
	public String listSongs() {
		String list = "";
		Song iter = first;

		for (int i = 0; i < size(); i++) {
			list = list + iter.toString() + "\n";
			if (iter.next != Song.END) {
				iter = iter.next;
			}
		}
		if (list.equals("")) {
			System.out.print("No songs in playlist.");
		}

		return list + "\n\nTotal songs: " + size() + ".";
	}
}
