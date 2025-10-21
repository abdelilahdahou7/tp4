package ma.projet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.projet.entities.Salle;
import ma.projet.services.SalleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SalleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalleService salleService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateSalle() throws Exception {
        Salle salle = new Salle();
        salle.setCode("TestCode");

        when(salleService.save(any(Salle.class))).thenReturn(salle);

        mockMvc.perform(post("/api/salles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(salle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("TestCode"));
    }

    @Test
    public void testFindAllSalles() throws Exception {
        Salle salle1 = new Salle();
        salle1.setCode("Code1");
        Salle salle2 = new Salle();
        salle2.setCode("Code2");

        when(salleService.findAll()).thenReturn(Arrays.asList(salle1, salle2));

        mockMvc.perform(get("/api/salles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").value("Code1"))
                .andExpect(jsonPath("$[1].code").value("Code2"));
    }
}
