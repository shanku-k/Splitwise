package dev.shanku.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="groups")
public class Group extends BaseModel{
    private String name;
    @ManyToOne
    private User groupOwner;
    @ManyToMany
    private List<User> members;
    @OneToMany
    private List<Expense> expenses;

}

/*
Group-----owner (1 group 1 owner, 1 owner M groups)
 */