package pl.evolution.springit.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Comment extends Auditable{

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String body;

    @ManyToOne
    @NonNull
    private Link link;

}
