package com.progiizohari.ozdravi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
public class Employer {

    @Id
    @Pattern(regexp = "^[0-9]{5}$")
    @Column(length = 5)
    private String employerId;

    @NotNull
    private String nameEmployer;

    @Column(unique = true, nullable = false)
    @Email
    private String emailEmployer;

    @OneToMany(mappedBy = "employer")
    private List<Parent> parents;

    public Employer() {
    }

    public Employer(String employerId, String nameEmployer, String emailEmployer) {
        this.employerId = employerId;
        this.nameEmployer = nameEmployer;
        this.emailEmployer = emailEmployer;
    }

    public String getEmployerId() {
        return employerId;
    }

    public void setEmployerId(String employerId) {
        this.employerId = employerId;
    }

    public String getNameEmployer() {
        return nameEmployer;
    }

    public void setNameEmployer(String nameEmployer) {
        this.nameEmployer = nameEmployer;
    }

    public String getEmailEmployer() {
        return emailEmployer;
    }

    public void setEmailEmployer(String emailEmployer) {
        this.emailEmployer = emailEmployer;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "employerId='" + employerId + '\'' +
                ", nameEmployer='" + nameEmployer + '\'' +
                ", emailEmployer='" + emailEmployer + '\'' +
                ", parents=" + parents +
                '}';
    }
}
