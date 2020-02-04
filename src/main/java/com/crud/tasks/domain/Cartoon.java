package com.crud.tasks.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@NamedNativeQuery(
        name = "Cartoon.retrieveNewCartoons",
        query = "SELECT * FROM CARTOONS" +
                "WHERE DATE <:DATE",
        resultClass = Cartoon.class
)



@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data


public class Cartoon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private int ageRestriction;

    @Column
    private Date date;
    @OneToMany(
            cascade = CascadeType.ALL
    )

    @JoinColumn(name = "cartoonId")
    private List<Season> seasons;
    @OneToMany(
            cascade = CascadeType.ALL
    )

    @JoinColumn(name = "cartoonId")
    private List<UserRating>userRatings;

    public double ratingAverage(){
          return userRatings.stream()
                .map(t -> t.getRating())
                .reduce(0,(sum, current) -> sum += current) * 1.0/userRatings.size();
    }
}
