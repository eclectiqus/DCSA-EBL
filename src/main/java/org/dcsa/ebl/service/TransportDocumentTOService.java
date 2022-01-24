package org.dcsa.ebl.service;

import org.dcsa.core.events.model.TransportDocument;
import org.dcsa.core.extendedrequest.ExtendedRequest;
import org.dcsa.ebl.model.transferobjects.TransportDocumentTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransportDocumentTOService {
    Mono<TransportDocumentTO> create(TransportDocumentTO transportDocumentTO);
    Mono<TransportDocumentTO> findById(String transportDocumentReference);
    Flux<TransportDocument> findAllExtended(final ExtendedRequest<TransportDocument> extendedRequest);
}
