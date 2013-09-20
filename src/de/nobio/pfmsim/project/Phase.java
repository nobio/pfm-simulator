package de.nobio.pfmsim.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "phase")
public class Phase {

    // key=duration, value=numbers of Resources
    private static Map<Long, Long> taskDistribution = new HashMap<Long, Long>();
    static {
        taskDistribution.put(1L, 1L);
        taskDistribution.put(2L, 1L);
        taskDistribution.put(3L, 1L);
        taskDistribution.put(4L, 1L);
        taskDistribution.put(5L, 1L);
        taskDistribution.put(6L, 2L);
        taskDistribution.put(7L, 2L);
        taskDistribution.put(8L, 2L);
        taskDistribution.put(9L, 2L);
        taskDistribution.put(10L, 2L);
        taskDistribution.put(11L, 3L);
        taskDistribution.put(12L, 3L);
        taskDistribution.put(13L, 3L);
        taskDistribution.put(14L, 3L);
        taskDistribution.put(15L, 3L);
        taskDistribution.put(16L, 3L);
        taskDistribution.put(17L, 3L);
        taskDistribution.put(18L, 3L);
        taskDistribution.put(19L, 3L);
        taskDistribution.put(20L, 3L);
    }

    @XmlAttribute(required = true)
    private String id;

    @XmlAttribute(required = true)
    private String ref;

    @XmlElement(required = true)
    private String name;

    @XmlElement(name = "workload", nillable = true, required = true)
    private Workload workload;

    @XmlElement(name = "parallel", required = true)
    private Integer parallel;

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

    public Integer getParallel() {
        return parallel;
    }

    public void setParallel(Integer parallel) {
        this.parallel = parallel;
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

    public Double calculateWorkload() {
        Double weight = getWorkload().getDistribution().getRandomNumericValue();
        getWorkload().setWorkloadWeight(weight);
        return weight;
    }

    public Long getTaskDistribution(Long duration) {
        if (duration > 20) {
            return 4L;
        } else if (duration <= 0) {
            return 0L;
        } else {
            return taskDistribution.get(duration);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Phase phase = new Phase();
        phase.setId(id);
        phase.setName(name);
        phase.setRef(ref);
        phase.setWorkload(workload);
        phase.setParallel(parallel);
        phase.setTasks(tasks);
        return phase;
    }

    @Override
    public String toString() {
        return "\n\t\tPhase [id=" + id + ", ref=" + ref + ", name=" + name + ", workload=" + workload + ", parallel=" + parallel + ", tasks=" + tasks + "]";
    }

}
