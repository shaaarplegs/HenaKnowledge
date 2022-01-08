package moee.henaknowledge.service;

import moee.henaknowledge.Exceptions.UserDoesNotExistException;
import moee.henaknowledge.dal_interfaces.ICommentDAL;
import moee.henaknowledge.dal_interfaces.IExperienceOpinionDAL;
import moee.henaknowledge.module.Comment;
import moee.henaknowledge.module.ExperienceOpinion;
import moee.henaknowledge.repository.CommentDalJPA;
import moee.henaknowledge.repository.ExperienceOpinionDalJPA;
import moee.henaknowledge.repository.ICommentRepository;
import moee.henaknowledge.repository.IExperienceOpinionRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
class ExperienceOpinionServiceTest {


    IExperienceOpinionDAL experienceOpinionDAL;
    ExperienceOpinionService service;

    //arange
    private ExperienceOpinion eo = new ExperienceOpinion(5,1,0,10,7);

    //arange
    private ExperienceOpinion eo2 = new ExperienceOpinion(6,1,0,10,9);


    Optional<ExperienceOpinion> oeo = Optional.of(eo);
    Optional<ExperienceOpinion> oeo2 = Optional.of(eo2);

    @BeforeEach
    public void init () {

        //mocking the DAL into the service instance
        experienceOpinionDAL = mock(IExperienceOpinionDAL.class);
        service = new ExperienceOpinionService(experienceOpinionDAL);

        //ACT
        when(experienceOpinionDAL.getExperienceOpinionByExperienceOpinionID(5)).thenReturn(oeo);
        when(experienceOpinionDAL.getExperienceOpinionByExperienceOpinionID(6)).thenReturn(oeo2);
        when(experienceOpinionDAL.getAllExperienceOpinions()).thenReturn(Arrays.asList(oeo.get(),oeo2.get()));
        when(experienceOpinionDAL.getExperienceOpinionByPersonIDAndExperienceID(9,6)).thenReturn(oeo2);
    }


    @Test
    public void TestGettingExperienceOpinionByPersonID5() {
        assertEquals(oeo, service.getExperienceOpinionByExperienceOpinionID(5));
    }

    @Test
    public void TestGettingExperienceOpinionByPersonID6() {
        assertEquals(oeo2, service.getExperienceOpinionByExperienceOpinionID(6));
    }

    @Test
    public void TestGettingExperienceOpinionByPersonIDDoesNotExists() {
        assertThrows(UserDoesNotExistException.class, () -> {
            when(service.getExperienceOpinionByExperienceOpinionID(anyInt())).thenThrow(UserDoesNotExistException.class);
            service.getExperienceOpinionByExperienceOpinionID(9);
        });
    }

    @Test
    public void TestGettingAllExperienceOpinions() {
        assertEquals(Arrays.asList(oeo.get(),oeo2.get()), service.getAllExperienceOpinions());
    }

    @Test
    public void TestGettingExperienceOpinionByPersoinIDAndExperienceID() {
        assertEquals(oeo2, service.getExperienceOpinionByPersonIDAndExperienceID(9,6));
    }

    @Test
    public void TestGettingExperienceOpinionByPersonIDAndExperienceIDDoesNotExists() {
        assertThrows(UserDoesNotExistException.class, () -> {
            when(service.getExperienceOpinionByPersonIDAndExperienceID(anyInt(), anyInt())).thenThrow(UserDoesNotExistException.class);
            service.getExperienceOpinionByPersonIDAndExperienceID(78,80);
        });
    }
}