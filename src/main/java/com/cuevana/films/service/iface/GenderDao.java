package com.cuevana.films.service.iface;

import com.cuevana.films.models.entity.Gender;
import java.sql.SQLException;
import java.util.List;

public interface GenderDao {
    
    Gender getGenderById(int id) throws SQLException;
}
