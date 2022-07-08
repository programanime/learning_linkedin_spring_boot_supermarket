package com.iacode.supermarket.data.repository;
import com.iacode.supermarket.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    
}