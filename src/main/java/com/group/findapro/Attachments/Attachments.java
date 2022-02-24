package com.group.findapro.Attachments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "attachments")
public class Attachments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

}
/// ROZWIĄZANIE ZACHOWYWANIE LINKÓW ROBIE W WEEKEND

