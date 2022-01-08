package moee.henaknowledge.controller;




import moee.henaknowledge.dto.ExperienceDTO;
import moee.henaknowledge.dto.ExperienceOpinionDTO;
import moee.henaknowledge.module.Experience;
import moee.henaknowledge.module.ExperienceOpinion;
import moee.henaknowledge.service_interfaces.IExperienceOpinionService;
import moee.henaknowledge.service_interfaces.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/Experience")
@CrossOrigin("*")
public class ExperienceController {

    @Autowired
    private IExperienceService service;

    @Autowired
    private IExperienceOpinionService opinionService;


    @GetMapping()
    public List<Experience> GetAllExperiences() {
       return service.getAllExperiences();
    }

    @DeleteMapping()
    public void DeleteExperience(@RequestParam int experienceID) {
        service.DeleteExperienceByID(experienceID);
    }

    @PutMapping()
    public ResponseEntity<Experience> updateExperience(@RequestParam("ExperienceID") int experienceID, @RequestParam("title") String title,
                                                  @RequestParam("description") String description) {
        var a = service.getExperienceByExperienceID(experienceID);
        if (a.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else
        {
            service.SetExperienceById(experienceID,title,description);
            return ResponseEntity.ok().body(a.get());
        }
    }

    @PostMapping("/Add")
    public ResponseEntity<Experience> createExperience(@RequestBody ExperienceDTO eDTO) {
        if (eDTO == null)
        {
            return ResponseEntity.notFound().build();
        } else {

            Experience modifiedExperience = new Experience(eDTO.getTitle(),eDTO.getDescription(),0,0,
                    eDTO.getPersonID());
            service.AddExperience(modifiedExperience);
            return ResponseEntity.ok().body(modifiedExperience);
        }
    }

    @PostMapping("/like")
        public void like(@RequestParam("ExperienceID") int experienceID,  @RequestBody ExperienceOpinionDTO eoDTO) {
            service.like(experienceID,eoDTO.getPersonID());
        }

    @PostMapping("/dislike")
    public void dislike(@RequestParam("ExperienceID") int experienceID,   @RequestBody ExperienceOpinionDTO eoDTO) {
        service.dislike(experienceID,eoDTO.getPersonID());
    }

    @GetMapping("/getExperience")
    public ResponseEntity<Experience> getExperience(@RequestParam("ExperienceID") int ExperienceID) {
        var s = service.getExperienceByExperienceID(ExperienceID);
        if (s.isPresent()) {
            return ResponseEntity.ok().body(s.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

        @GetMapping("/getExperienceOpinon")
    public ResponseEntity<ExperienceOpinion>  getExperienceOpinonByEXPIDandPersonID(@RequestParam("ExperienceID") int ExperienceID
    ,@RequestParam("PersonID") int PersonID) {
        var s = opinionService.getExperienceOpinionByPersonIDAndExperienceID(
                PersonID,ExperienceID
        );
        if (s.isPresent()) {
            return ResponseEntity.ok().body(s.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
