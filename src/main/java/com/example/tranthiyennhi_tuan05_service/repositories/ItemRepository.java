package com.example.tranthiyennhi_tuan05_service.repositories;

import com.example.tranthiyennhi_tuan05_service.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {

}
