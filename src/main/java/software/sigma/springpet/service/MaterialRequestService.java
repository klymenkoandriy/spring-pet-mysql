package software.sigma.springpet.service;

import software.sigma.springpet.model.MaterialRequest;

import java.util.List;
import java.util.Optional;

/**
 * Material request access service.
 *
 * @author Andriy Klymenko
 */
public interface MaterialRequestService {

    /**
     * Returns the entity with the specified id.
     *
     * @param id id
     * @return material request
     */
    Optional<MaterialRequest> findById(Long id);

    /**
     * Returns the entity list with the specified customerName.
     *
     * @param customerName customer name
     * @return list of entities
     */
    List<MaterialRequest> findByCustomerName(String customerName);

    /**
     * Returns the entity list with the specified invoice.
     *
     * @param invoice invoice
     * @return list of entities
     */
    List<MaterialRequest> findByInvoice(String invoice);

    /**
     * Returns the list of all entities.
     *
     * @return list of material requests
     */
    List<MaterialRequest> findAll();

    /**
     * Saves the entity and returns it.
     *
     * @param entity material request
     * @return material request
     */
    MaterialRequest save(MaterialRequest entity);

    /**
     * Deletes the entity with the specified id.
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * Checks whether the entity exists or not.
     *
     * @param id id
     * @return <code>true</code> if the entity exists, otherwise <code>false</code>
     */
    boolean exists(Long id);
}
