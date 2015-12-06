package com.heroesandfriends.stuffmanager.dto;

import java.io.Serializable;

/**
 * @author John Spangenberg
 */
public class StuffDTO implements Serializable {

    private Long projectId;
    private Long stuffId;
    private String title;
    private String description;

    public StuffDTO() {}

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getStuffId() {
        return stuffId;
    }

    public void setStuffId(Long stuffId) {
        this.stuffId = stuffId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StuffDTO{" +
                "projectId=" + projectId +
                ", stuffId=" + stuffId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
