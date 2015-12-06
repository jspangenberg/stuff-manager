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

    @Column(name = "PROJECT_ID")
    private Long projectId;

    /**
     * The default constructor only exists for the sake of JPA. You won’t use it directly, so it is
     * designated as protected.
     */
    protected Stuff() {}

    public Stuff(Long projectId, String title, String description) {
        this.title = title;
        this.description = description;
        this.projectId = projectId;
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

    public Long getProjectId() {
        return projectId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
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
