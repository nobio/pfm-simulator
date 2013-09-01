package de.nobio.pfmsim.resource;

import java.util.ArrayList;
import java.util.List;

import de.nobio.pfmsim.TimeClock;
import de.nobio.pfmsim.project.Task;

public class Resource implements TimeClock {

    /**
     * List of assigner Tasks this resource is currently working on
     */
    private List<Task> aktualTasks = new ArrayList<Task>();

    /**
     * List of skills this resource can offer; might only be one skill
     */
    private List<Skill> skills = new ArrayList<Skill>();

    /**
     * general availability for projects; in real life this would be 0.7 for
     * example
     */
    private Double availability;

    /**
     * allocation for running tasks
     */
    private Double allocation;

    /**
     * reservation for future tasks
     */
    private Double reservation;

    public Resource(List<Task> aktualTasks, List<Skill> skills, Double availability, Double allocation, Double reservation) {
        super();
        this.aktualTasks = aktualTasks;
        this.skills = skills;
        this.availability = availability;
        this.allocation = allocation;
        this.reservation = reservation;
    }

    public Double getAvailability() {
        return availability;
    }

    public void setAvailability(Double availability) {
        this.availability = availability;
    }

    public Double getAllocation() {
        return allocation;
    }

    public void setAllocation(Double allocation) {
        this.allocation = allocation;
    }

    public Double getReservation() {
        return reservation;
    }

    public void setReservation(Double reservation) {
        this.reservation = reservation;
    }

    public List<Task> getAktualTasks() {
        return aktualTasks;
    }

    public void appendActualTask(Task task) {
        aktualTasks.add(task);
    }

    public void removeActualTask(Task task) {
        aktualTasks.remove(task);
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void appendSkill(Skill skill) {
        skills.add(skill);
    }

    public void removeSkill(Skill skill) {
        aktualTasks.remove(skill);
    }

    @Override
    public void tick(Long clock) {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return "Resource [aktualTasks=" + aktualTasks + ", skills=" + skills + ", availability=" + availability + ", allocation=" + allocation + ", reservation=" + reservation
                + "]";
    }

}
