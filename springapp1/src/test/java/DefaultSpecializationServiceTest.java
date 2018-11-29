import com.netcracker.travnichev.config.SpecializationConfig;
import com.netcracker.travnichev.exception.SpecializationNotFoundException;
import com.netcracker.travnichev.service.SpecializationService;
import config.SpecializationServiceConfig;
import com.netcracker.travnichev.entity.Specialization;
import config.StudentServiceConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpecializationServiceConfig.class, StudentServiceConfig.class},
        loader = AnnotationConfigContextLoader.class)
public class DefaultSpecializationServiceTest {

    @Autowired
    private SpecializationService specializationService;
    private ApplicationContext specializationContext;
    private Specialization specialization;

    @BeforeEach
    void init() {
        specializationContext = new AnnotationConfigApplicationContext(SpecializationConfig.class);
        specialization = specializationContext.getBean("specialization", Specialization.class);
    }

    @Test
    void addSpecializationShouldWorkOnValidData() {
        Specialization resultSpecialization = specializationService.addSpecialization(specialization);
        assertEquals(resultSpecialization, specialization);
    }

    @Test
    void getSpecializationShouldWorkOnValidData() {
        Specialization result = specializationService.addSpecialization(specialization);
        Long id = result.getId();
        try {
            Specialization resultSpecialization = specializationService.getSpecialization(id);
            assertEquals(resultSpecialization.getId(), id);
        } catch (SpecializationNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getSpecializationShouldThrowSpecializationNotFound() {
        Specialization result = specializationService.addSpecialization(specialization);
        Long id = result.getId();
        Long newId;
        if (id < Long.MAX_VALUE) {
            newId = id + 1;
        }
        else {
            newId = id - 1;
        }
        assertThrows(SpecializationNotFoundException.class, () -> {specializationService.getSpecialization(newId);});
    }

    @Test
    void deleteSpecializationByIdShouldWorkOnValidData() {
        Specialization result = specializationService.addSpecialization(specialization);
        Specialization resultSpecialization = specializationService.deleteSpecializationById(result.getId());
        assertEquals(resultSpecialization, specialization);
    }
}