import java.time.LocalDate;

/**
 * This class stores information about a post in a social network news feed.
 * The main part of the post consists of a title, location and a date.
 * Other data, such as author and time, are also stored in the parent class.
 * 
 * @author Joel Henriksson
 */
public class EventPost extends Post {

    private String title; // the title.
    private String location; // the name of the location.
    private LocalDate date; // the date.

     /**
     * Constructor for objects of the EventPost class.
     * 
     * @param author The username of the author of this post.
     * @param title  The title of the post.
     * @param location The location of the post.
     * @param date The date of the post.
     */
    public EventPost(String author, String title, String location, LocalDate date)
    {
        super(author);
        this.title = title;
        this.location = location;
        this.date = date;
    }

    /**
     * Return the post's title.
     * 
     * @return The post's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return the post's location.
     * 
     * @return The post's location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Return the post's date.
     * 
     * @return The post's date.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Displays the details of this post.
     */
    public void display()
    {
        System.out.println("  " + getTitle());
        System.out.println("  (" + getLocation() + ")");
        System.out.println("  " + getDate().toString());
        System.out.println("*********************");
        super.display();
    }
}