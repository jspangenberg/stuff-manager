package com.heroesandfriends.stuffmanager.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author John Spangenberg
 */
@Entity
public class Project {

    @Id
    @Column(name = "PROJECT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    private String projectName;
    private String description;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="PROJECT_ID")
    private List<Stuff> stuff;

    /**
     * The default constructor only exists for the sake of JPA. You won’t use it directly, so it is
     * designated as protected.
     */
    protected Project() {}


    public Project(String projectNamwe, String description) {
        this.projectName = projectName;
        this.description = description;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDescription() {
        return description;
    }

    public List<Stuff> getStuff() {
        return stuff;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", stuff=" + stuff +
                '}';
    }
}
