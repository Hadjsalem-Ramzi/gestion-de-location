package com.example.appspring.Services;

import com.example.appspring.Entity.Location;
import com.example.appspring.Entity.Modele;

import java.util.List;

public interface LocationService {

    List<Location> getAllLocation();
    Location createLocation(Location location);

    Location getLocationByID(Long id);
    Location updateLocation(Location location);

    void deleteLocation(Long id);
}

