package org.example.productcatalogservice_nov2024.TableInheritanceExamples.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity(name="msc_ta")
public class Ta extends User {
    private Long hours;
}
