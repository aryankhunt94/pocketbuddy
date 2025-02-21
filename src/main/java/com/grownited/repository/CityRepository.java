package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grownited.entity.NewCityEntity;

@Repository
public interface CityRepository extends JpaRepository<NewCityEntity, Integer> {

}
