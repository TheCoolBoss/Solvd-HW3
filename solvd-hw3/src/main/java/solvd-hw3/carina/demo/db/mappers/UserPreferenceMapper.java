package solvd-hw3.carina.demo.db.mappers;

import solvd-hw3.carina.demo.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);
}
