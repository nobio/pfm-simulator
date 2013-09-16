package de.nobio.pfmsim.project;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "phase", propOrder = { "id", "ref", "name", "workload" })
public class Phase {

    @XmlAttribute(required = true)
    private String id;

    @XmlAttribute(required = true)
    private String ref;

    @XmlElement(required = true)
    private String name;

    @XmlElement(name = "workload", nillable = true, required = true)
    private Workload workload;

    @XmlTransient
    private List<Task> tasks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Workload getWorkload() {
        return workload;
    }

    public void setWorkload(Workload workload) {
        this.workload = workload;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        if (tasks == null) {
            tasks = new ArrayList<Task>();
        }
        tasks.add(task);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Phase phase = new Phase();
        phase.setId(id);
        phase.setName(name);
        phase.setRef(ref);
        phase.setWorkload(workload);
        phase.setWorkload(workload);
        phase.setTasks(tasks);
        return phase;
    }

    @Override
    public String toString() {
        return "\n\t\tPhase [id=" + id + ", ref=" + ref + ", name=" + name + ", workload=" + workload + "]";
    }

}
