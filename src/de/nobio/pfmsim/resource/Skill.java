/**
 * 
 */
package de.nobio.pfmsim.resource;

/**
 * @author nobio
 * 
 */
public class Skill {
    private Long id;
    private String skill;

    public Skill(Long id, String skill) {
        super();
        this.id = id;
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Skill [id=" + id + ", skill=" + skill + "]";
    }

}
