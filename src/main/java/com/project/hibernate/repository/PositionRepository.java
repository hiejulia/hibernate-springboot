package com.project.hibernate.repository;



import com.project.hibernate.entity.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {

    Position findById(int id);


}