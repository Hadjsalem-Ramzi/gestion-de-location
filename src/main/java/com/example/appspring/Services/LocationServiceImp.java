package com.example.appspring.Services;

import com.example.appspring.Entity.Location;
import com.example.appspring.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImp  implements LocationService{
  @Autowired
    private LocationRepository locationRepository;
    @Override
    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }


    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location getLocationByID(Long id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.saveAndFlush(location);
    }

    @Override
    public void deleteLocation(Long id) {
       locationRepository.deleteById(id);
    }
}
