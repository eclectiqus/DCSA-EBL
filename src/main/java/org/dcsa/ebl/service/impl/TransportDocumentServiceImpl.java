package org.dcsa.ebl.service.impl;

import lombok.RequiredArgsConstructor;
import org.dcsa.core.service.impl.ExtendedBaseServiceImpl;
import org.dcsa.ebl.model.ShippingInstruction;
import org.dcsa.ebl.model.TransportDocument;
import org.dcsa.ebl.repository.TransportDocumentRepository;
import org.dcsa.ebl.service.TransportDocumentService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TransportDocumentServiceImpl extends ExtendedBaseServiceImpl<TransportDocumentRepository, TransportDocument, UUID> implements TransportDocumentService {
    private final TransportDocumentRepository transportDocumentRepository;


    @Override
    public TransportDocumentRepository getRepository() {
        return transportDocumentRepository;
    }

    @Override
    public Class<TransportDocument> getModelClass() {
        return TransportDocument.class;
    }

    @Override
    public Mono<TransportDocument> create(TransportDocument transportDocument) {
        // For now just return transportDocument
        return Mono.just(transportDocument);
    }
}
