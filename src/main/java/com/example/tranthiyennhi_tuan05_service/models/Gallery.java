package com.example.tranthiyennhi_tuan05_service.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Gallery {
    private Integer id;
    private List<Object> items;

}
