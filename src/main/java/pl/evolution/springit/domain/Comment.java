package pl.evolution.springit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
@Data
@NoArgsConstructor
public class Comment extends Auditable{

    @Id
    @GeneratedValue
    private Long id;
    private String body;

    @ManyToMany
    private Link link;

}
