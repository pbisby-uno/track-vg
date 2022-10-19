package com.coe.trackvg.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "platforms")
public class Platform {

  @Id
  @SequenceGenerator(name="platforms_id_seq",sequenceName="platforms_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="platforms_id_seq")
  @Column(name = "id", updatable = false, nullable = false)
  private int id;

  @Column(name = "description")
  private String description;

}
