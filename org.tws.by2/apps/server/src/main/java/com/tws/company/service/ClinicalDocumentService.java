package com.tws.company.service;

import com.tws.company.domain.ClinicalDocument;
import com.tws.company.repository.ClinicalDocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class ClinicalDocumentService extends AbstractUuidCrudService<ClinicalDocument> {

    public ClinicalDocumentService(ClinicalDocumentRepository repository) {
        super(repository);
    }
}
