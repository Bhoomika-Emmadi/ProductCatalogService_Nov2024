package org.example.productcatalogservice_nov2024.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_ta")
@DiscriminatorValue(value="70")
public class Ta extends User {
    private Long hours;
}
