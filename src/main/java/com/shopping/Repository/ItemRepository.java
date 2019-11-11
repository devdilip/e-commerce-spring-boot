package com.shopping.Repository;

import com.shopping.Model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository  extends JpaRepository<Items, Integer> {
}
