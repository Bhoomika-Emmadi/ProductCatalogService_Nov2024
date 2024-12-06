package org.example.productcatalogservice_nov2024.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_mentor")
@DiscriminatorValue(value="69")
public class Mentor extends User {
    private Double ratings;
}
