package Student.IT.Faculties;

public class Faculty {


    private Long facultyId;
    private String faculty;
    private String details;

    public Long getFacultyId() {
        return facultyId;
    }
    public String getFaculty() {
        return faculty;
    }
    public String getDetails() {
        return details;
    }


    public Faculty(long facultyId, String faculty, String details) {
         this.facultyId = facultyId;
         this.faculty = faculty;
         this.details = details;

    }


}
