package com.practice.myhome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Boolean enabled;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) //orphanRemoval이 true이면 부모가 없는 데이터는 지운다는 의미
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY) // 기본값 => OneToMany, ManyToMany: LAZY / OneToOne, ManyToOne: EAGER
//    @JsonIgnore
    private List<Board> boards = new ArrayList<>();
}
