package org.example.service.trust;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.Trust;
import org.example.repository.trust.TrustRepositoryImpl;

public class TrustServiceImpl extends BaseServiceImpl<Trust, TrustRepositoryImpl> implements TrustService {
    TrustRepositoryImpl repository1;
    public TrustServiceImpl(TrustRepositoryImpl repository) {
        super(repository);
        repository1=repository;
    }
}
