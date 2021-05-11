package edu.utdallas.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by asdha on 5/27/2017.
 */

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Role(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
