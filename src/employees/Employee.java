package employees;

import java.util.HashSet;
import java.util.Set;

/**
 * Employee's main abstract class representation.
 *
 * @author Matías J. Magni <matias.magni@globallogic.com>
 */
public abstract class Employee {
    // Employee's name.
    protected String name;
    // Employee's surname.
    protected String surname;
    // Employee's file number.
    protected int fileNumber;
    // Employee's age.
    protected int age;
    // Employee's genre.
    protected boolean male;
    // Employee's skillset.
    protected Set<Skill> skills;
    // Employee's brute annual salary in dollars.
    protected float salary;

    /**
     * Constructor.
     *
     * @param name The employee's name.
     * @param surname The employee's surname.
     */
    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.fileNumber = FileNumberGenerator.getInstance().getId();
        this.skills = new HashSet<>();
    }

    /**
     * Constructor.
     *
     * @param name The employee's name.
     * @param surname The employee's surname.
     * @param age The employee's age.
     * @param male The employee's genre. True if is male, otherwise false on female.
     * @param salary The employee's brute annual salary in dollars.
     */
    public Employee(String name, String surname, int age, boolean male, float salary) {
        this(name, surname);
        this.age = age;
        this.male = male;
        this.salary = salary;
    }

    /**
     * Gets the employee's name.
     *
     * @return The employee's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the employee's name.
     *
     * @param name The employee's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the employee's surname.
     *
     * @return The employee's surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the employee's surname.
     *
     * @param surname The employee's surname.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the employee's file number.
     *
     * @return String The employee's file number.
     */
    public int getFileNumber() {
        return fileNumber;
    }

    /**
     * Gets the employee's age.
     *
     * @return The employee's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the employee's age.
     *
     * @param age The employee's age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the employee's genre. True if is male, otherwise false on female.
     *
     * @return The employee's genre.
     */
    public boolean isMale() {
        return male;
    }

    /**
     * Sets the employee's genre.
     *
     * @param male The employee's genre. True if is male, otherwise false on female.
     */
    public void setMale(boolean male) {
        this.male = male;
    }

    /**
     * Gets the employee's skillset list.
     *
     * @return The employee's skillset list.
     */
    public Set<Skill> getSkills() {
        return skills;
    }

    /**
     * Sets the employee's skillset list.
     *
     * @param skills The employee's skillset list.
     */
    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    /**
     * Adds an employee's skill.
     *
     * @param skill The employee's skill to add.
     */
    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    /**
     * Gets the employee's brute annual salary in dollars.
     *
     * @return The employee's brute annual salary in dollars.
     */
    public float getSalary() {
        return salary;
    }

    /**
     * Set's the employee's brute annual salary.
     *
     * @param salary The employee's brute annual salary in dollars.
     */
    public void setSalary(float salary) {
        this.salary = salary;
    }
}