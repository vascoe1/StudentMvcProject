package Student.IT.Faculties;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FacultyController.class)
public class FacultyControllerMvcTest {


    @Autowired
      private MockMvc mockMvc;

    @Mock
    private Faculty firstFaculty;

   @MockBean
   private FacultiesRepository studentFacultyRepo;

   @Mock
    private Faculty secondFaculty;
    private Collection<Faculty> allFacultiesInModel;


    @Test
    public void shouldBeOkForAllFacultiesInTheFacultyTemplate() throws Exception {
        mockMvc.perform(post("/FACULTIES")).andExpect(status().isOk())
        .andExpect(view().name("facultiesTemplate"));

    }

    @Test
    public void shouldFindAllFacultiesInModel() throws Exception {
        Collection<Faculty> AllFacultiesInModel = Arrays.asList(firstFaculty, secondFaculty);
        when(studentFacultyRepo.searchAll()).thenReturn(allFacultiesInModel);
        mockMvc.perform(post("/faculties"))
                .andExpect((model().attribute("facultiesModel", allFacultiesInModel)));

    }


    @Test
    public void shouldBeOkForOneFacultiesInTheFacultySingularTemplate() throws Exception {
        mockMvc.perform(post("/faculty?id=1")).andExpect(status().isOk())
        .andExpect(view().name("facultyTemplate"));

    }



    @Test
    public void shouldSearchForFirstFacultyInModel() throws Exception {
        Long firstFacultyId = 1L;
        when(studentFacultyRepo.searchOne(firstFacultyId)).thenReturn(firstFaculty);
        mockMvc.perform(post("/faculty?id=1")).andExpect(model().attribute("facultyModel", firstFaculty));

    }
}