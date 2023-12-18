package com.progiizohari.ozdravi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;

    @ManyToOne
    @JoinColumn(name = "parent_OIB")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "child_OIB")
    private Child child;

    @NotNull
    private String notificationTitle;
    @NotNull
    private String notificationInformation;

    public Notification(int notificationId, Parent parent, Child child, String notificationTitle, String notificationInformation) {
        this.notificationId = notificationId;
        this.parent = parent;
        this.child = child;
        this.notificationTitle = notificationTitle;
        this.notificationInformation = notificationInformation;
    }

    public Notification() {
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationInformation() {
        return notificationInformation;
    }

    public void setNotificationInformation(String notificationInformation) {
        this.notificationInformation = notificationInformation;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", parent=" + parent +
                ", child=" + child +
                ", notificationTitle='" + notificationTitle + '\'' +
                ", notificationInformation='" + notificationInformation + '\'' +
                '}';
    }
}
