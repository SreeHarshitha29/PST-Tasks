
import java.util.*;

class Node {
    String song;
    Node next;

    Node(String song) {
        this.song = song;
        this.next = null;
    }
}

class Playlist {
    Node head;

    void addSong(String song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    void removeSong(String song) {
        if (head == null)
            return;

        if (head.song.equals(song)) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null &&
               !temp.next.song.equals(song)) {
            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;
        else
            System.out.println("Song not found");
    }

    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.song);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Playlist p = new Playlist();

        p.addSong("Song A");
        p.addSong("Song B");
        p.addSong("Song C");

        System.out.println("Playlist:");
        p.display();

        p.removeSong("Song B");

        System.out.println("After removing Song B:");
        p.display();
    }
}

#Output
Playlist:
Song A
Song B
Song C
After removing Song B:
Song A
Song C
