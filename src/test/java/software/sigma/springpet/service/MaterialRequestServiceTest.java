package software.sigma.springpet.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import software.sigma.springpet.domain.MaterialRequestRepository;
import software.sigma.springpet.model.MaterialRequest;
import software.sigma.springpet.service.impl.MaterialRequestServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Andriy Klymenko
 */
@RunWith(SpringRunner.class)
public class MaterialRequestServiceTest {

    private static final Long ID = 1L;
    private static final String CUSTOMER_NAME = "customerName";
    private static final String INVOICE = "invoice";

    private MaterialRequest materialRequest;

    private List<MaterialRequest> materialRequests;

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public MaterialRequestService materialRequestService() {
            return new MaterialRequestServiceImpl();
        }
    }

    @Autowired
    private MaterialRequestService service;

    @MockBean
    private MaterialRequestRepository repository;

    @Before
    public void init() {
        materialRequest = new MaterialRequest(1, CUSTOMER_NAME, 2, INVOICE);
        materialRequest.setId(ID);
        materialRequests = new ArrayList<>();
        materialRequests.add(materialRequest);
    }

    @Test
    public void shouldFindEntityById() {
        when(repository.findById(ID)).thenReturn(Optional.of(materialRequest));
        Optional<MaterialRequest> result = service.findById(ID);
        assertEquals(true, result.isPresent());
        assertEquals(materialRequest, result.get());
    }

    @Test
    public void shouldFindEntitiesByCustomerName() {
        when(repository.findByCustomerName(CUSTOMER_NAME)).thenReturn(materialRequests);
        assertEquals(materialRequests, service.findByCustomerName(CUSTOMER_NAME));
    }

    @Test
    public void shouldFindEntitiesByInvoice() {
        when(repository.findByInvoice(INVOICE)).thenReturn(materialRequests);
        assertEquals(materialRequests, service.findByInvoice(INVOICE));
    }

    @Test
    public void shouldFindAllEntities() {
        when(repository.findAll()).thenReturn(materialRequests);
        assertEquals(materialRequests, service.findAll());
    }

    @Test
    public void shouldSaveEntity() {
        when(repository.save(materialRequest)).thenReturn(materialRequest);
        assertEquals(materialRequest, service.save(materialRequest));
    }

    @Test
    public void shouldReturnTrueIfExists() {
        when(repository.existsById(ID)).thenReturn(true);
        assertTrue(service.exists(ID));
    }

    @Test
    public void shouldDeleteEntity() {
        doNothing().when(repository).deleteById(ID);
        service.delete(ID);
        verify(repository).deleteById(ID);
    }
}
