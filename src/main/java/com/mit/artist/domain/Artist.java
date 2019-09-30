package com.mit.artist.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "artist")
@Data
public class Artist {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String gender;

  @Column(nullable = false)
  private LocalDate birthday;

  @Column(nullable = false)
  private LocalDateTime updateTime;

}
