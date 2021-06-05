package Student.IT.Faculties;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentFacultiesRepositoryTest {

    Faculty firstFaculty = new Faculty(1L, "Cyber Security", "System Attacks");
    Faculty secondFaculty = new Faculty(2L, "MTA Networking", "Systems Connections");
    private FacultiesRepository underTest;

    @Test
             public void shouldCreateFirstFaculty() {
         underTest = new FacultiesRepository(firstFaculty);
         Faculty searchedFaculty = underTest.searchOne(1L);
         assertEquals(firstFaculty, searchedFaculty);
         }

     @Test
           public void shouldSearchForFirstFacultyAndSecondFaculty() {

         FacultiesRepository underTest = new FacultiesRepository(firstFaculty, secondFaculty);
         Collection<Faculty> searchedFaculty = underTest.searchAll();
         assertThat(searchedFaculty).contains(firstFaculty, secondFaculty);

     }
    }

