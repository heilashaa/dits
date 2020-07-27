package com.dev_incubator.dits.persistence.entity;

import com.sun.javafx.fxml.PropertyNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
//@Proxy
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "middle_name", nullable = false)
    private String middleName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(name = "is_enabled", nullable = false)
    private boolean enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")}, foreignKey = @ForeignKey(name = "role_user_FK"),
            inverseJoinColumns = {@JoinColumn(name = "role_id")}, inverseForeignKey = @ForeignKey(name = "user_role_FK"))
    private Set<Role> roles = new HashSet<>();
}


//    @ManyToOne(fetch = FetchType.LAZY,  optional = false)
//    @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "campaign_category_FK"))
//    private Category category;
//

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "campaign")
//    private Set<Bonus> bonuses = new HashSet<>();
//
//
//    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
//    private Set<Campaign> campaigns = new HashSet<>();
//
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
//    private Set<Campaign> campaigns = new HashSet<>();
