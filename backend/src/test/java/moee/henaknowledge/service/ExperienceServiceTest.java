package moee.henaknowledge.service;

import moee.henaknowledge.Exceptions.UserDoesNotExistException;
import moee.henaknowledge.dal_interfaces.IExperienceDAL;
import moee.henaknowledge.dal_interfaces.IExperienceOpinionDAL;
import moee.henaknowledge.module.Experience;
import moee.henaknowledge.module.ExperienceOpinion;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class ExperienceServiceTest {

    IExperienceDAL experienceDAL;
    ExperienceService service;

    //arange
    private Experience exp = new Experience(15,"trip to the desert",
            "I went to the desert. thank you", 0,0,7);

    //arange
    private Experience exp2 = new Experience(16,"trip to the galaxy",
            "I went to the galaxy. thank you", 1,0,9);


    Optional<Experience> oexp = Optional.of(exp);
    Optional<Experience> oexp2 = Optional.of(exp2);

    @BeforeEach
    public void init () {

        //mocking the DAL into the service instance
        experienceDAL = mock(IExperienceDAL.class);
        service = new ExperienceService(experienceDAL);

        //ACT
        when(experienceDAL.getExperienceByExperienceID(15)).thenReturn(oexp);
        when(experienceDAL.getExperienceByExperienceID(16)).thenReturn(oexp2);
        when(experienceDAL.getAllExperiences()).thenReturn(Arrays.asList(oexp.get(),oexp2.get()));
    }


    @Test
    public void TestGettingExpeirenceByExperienceID15() {
        assertEquals(oexp, service.getExperienceByExperienceID(15));
    }

    @Test
    public void TestGettingExpeirenceByExperienceID16() {
        assertEquals(oexp2, service.getExperienceByExperienceID(16));
    }

    @Test
    public void TestGettingExperienceOpinionByPersonIDDoesNotExists() {
        assertThrows(UserDoesNotExistException.class, () -> {
            when(service.getExperienceByExperienceID(anyInt())).thenThrow(UserDoesNotExistException.class);
            service.getExperienceByExperienceID(90);
        });
    }

    @Test
    public void TestGettingAllExperienceOpinions() {
        assertEquals(Arrays.asList(oexp.get(),oexp2.get()), service.getAllExperiences());
    }

    @Test
    public void TestDeleteExperience() {
        service.DeleteExperienceByID(15);

        verify(experienceDAL, times(1)).DeleteExperienceByID(15);
    }

    @Test
    public void TestAddExperience() {
         Experience exp3 = new Experience(15,"trip to the sea",
                "I went to the sea. thank you", 0,0,10);
        service.AddExperience(exp3);

        verify(experienceDAL, times(1)).AddExperience(exp3);
    }

}