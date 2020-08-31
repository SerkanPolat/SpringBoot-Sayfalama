package com.sp.pgn.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Data
@EqualsAndHashCode(of="id")
@Table(name = "kisis")
public class Kisi {
    @Id
    private Long id;
    private String ad;
    private String soyad;
    private Date zaman;

}
