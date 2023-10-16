package project.coffee.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "b_review")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(nullable = false,length = 10)
    private String nickname;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "m_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "b_no")
    private CoffeeList coffeeList;
}
