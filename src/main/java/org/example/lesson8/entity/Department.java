package org.example.lesson8.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Department {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @NonNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Company company;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Employee> employee = new ArrayList<>();
}
