package com.heroesandfriends.stuffmanager.entity;

import javax.persistence.*;

/**
 * @author John Spangenberg
 */

@Entity
public class Stuff {

    @Id
    @Column(name = "STUFF_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long stuffId;

    private String title;
    private String description;

    /**
     * The default constructor only exists for the sake of JPA. You won’t use it directly, so it is
     * designated as protected.
     */
    protected Stuff() {}

    public Stuff(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getStuffId() {
        return stuffId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "stuffId=" + stuffId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
