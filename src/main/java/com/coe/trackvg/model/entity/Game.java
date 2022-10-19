package com.coe.trackvg.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "games")
public class Game {

  @Id
  @SequenceGenerator(name="games_id_seq",sequenceName="games_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="games_id_seq")
  @Column(name = "id", updatable = false, nullable = false)
  private int id;

  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="title_id", nullable=false)
  private Title title;

  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="platform_id", nullable=false)
  private Platform platform;

  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="genre_id", nullable=false)
  private Genre genre;

}
