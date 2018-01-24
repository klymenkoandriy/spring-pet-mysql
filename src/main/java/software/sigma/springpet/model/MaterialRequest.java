package software.sigma.springpet.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Material Request entity.
 *
 * @author Andriy Klymenko
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class MaterialRequest {

    /**
     * The unique technical key for the material request.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The request number represents the business key of a material request together with the order position.
     */
    @Column(name = "request_Number")
    private Integer requestNumber;

    /**
     * The name of the customer to which the material request refers.
     */
    @Column(name = "customer_Name")
    private String customerName;

    /**
     * Priority.
     */
    @Column
    private Integer priority = 0;

    /**
     * Invoice number (character-digital code).
     */
    @Column
    private String invoice;

    /**
     * Constructor for creation.
     *
     * @param requestNumber request number
     * @param customerName customer name
     * @param priority priority
     * @param invoice invoice
     */
    public MaterialRequest(Integer requestNumber, String customerName, Integer priority, String invoice) {
        this.requestNumber = requestNumber;
        this.customerName = customerName;
        this.priority = priority;
        this.invoice = invoice;
    }
}
