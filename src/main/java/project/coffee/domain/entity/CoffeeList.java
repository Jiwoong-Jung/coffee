package project.coffee.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "b_booklist")
public class CoffeeList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long b_no;
    @Column(length = 50)
    private String author;
    @Column(length = 50)
    private String title;
}
