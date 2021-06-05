package Student.IT.Faculties;


import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FacultiesRepository {


        Map<Long, Faculty> facultyList = new HashMap<>();


    public FacultiesRepository(Faculty...facultyToAdd) {
        for (Faculty faculty: facultyToAdd) {
            facultyList.put(faculty.getFacultyId(), faculty);
        }


            }

    public Faculty searchOne(long facultyId) {
        return facultyList.get(facultyId);
    }

    public Collection<Faculty> searchAll() {
        return facultyList.values();
    }


}