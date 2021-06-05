package Student.IT.Faculties;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class FacultyController {

    @Resource
    private FacultiesRepository facultyRepo;
    private String facultiesModel;

    @RequestMapping("/faculties")
    public String searchAllFaculties(Model model) {
        model.addAttribute(facultiesModel, facultyRepo.searchAll());
        return "facultyTemplate";
    }

    @RequestMapping("/faculty")
    public String searchOneFaculty(@RequestParam(value = "facultyId") Long facultyId, Model model) {
        model.addAttribute("facultiesModel", facultyRepo.searchAll());
       return "facultyTemplate";

    }
}


