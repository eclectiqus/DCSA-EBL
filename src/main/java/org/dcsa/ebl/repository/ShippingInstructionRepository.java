package org.dcsa.ebl.repository;

import org.dcsa.core.events.model.ShippingInstruction;
import org.dcsa.core.repository.ExtendedRepository;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

public interface ShippingInstructionRepository
    extends ExtendedRepository<ShippingInstruction, String>, ShippingInstructionCustomRepository {

  @Modifying
  @Query("UPDATE shipping_instruction SET place_of_issue = :placeOfIssue where id = :id")
  Mono<Boolean> setPlaceOfIssueFor(String placeOfIssue, String id);

  @Query(
      "SELECT DISTINCT se.shipment_id FROM shipping_instruction si "
          + "JOIN cargo_item ci ON ci.shipping_instruction_id = si.id "
          + "JOIN shipment_equipment se ON se.id = ci.shipment_equipment_id "
          + "WHERE si.id = :shippingInstructionID")
  Flux<UUID> findShipmentIDsByShippingInstructionID(String shippingInstructionID);

  @Query(
      "SELECT DISTINCT s.carrier_booking_reference FROM shipping_instruction si "
          + "JOIN cargo_item ci ON ci.shipping_instruction_id = si.id "
          + "JOIN shipment_equipment se ON se.id = ci.shipment_equipment_id "
          + "JOIN shipment s ON s.id = se.shipment_id "
          + "WHERE si.id = :shippingInstructionID")
  Flux<String> findCarrierBookingReferenceByShippingInstructionID(String shippingInstructionID);
}
