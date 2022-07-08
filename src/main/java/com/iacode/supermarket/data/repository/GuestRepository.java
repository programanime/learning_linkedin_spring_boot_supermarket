package com.iacode.supermarket.data.repository;
import com.iacode.supermarket.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
    
}