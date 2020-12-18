package org.dcsa.ebl.model.transferobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dcsa.ebl.model.base.AbstractShippingInstruction;
import org.dcsa.ebl.model.Reference;
import org.dcsa.ebl.model.ShipmentLocation;
import org.dcsa.ebl.model.ShippingInstruction;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class ShippingInstructionTO extends AbstractShippingInstruction {

    @NotNull
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CargoItemTO> cargoItems;

    @NotNull
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ShipmentEquipmentTO> shipmentEquipments;

    @NotNull
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Reference> references;

    @NotNull
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<DocumentPartyTO> documentParties;

    @NotNull
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ShipmentLocation> shipmentLocations;

    @NotNull
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String carrierBookingReference;

}


