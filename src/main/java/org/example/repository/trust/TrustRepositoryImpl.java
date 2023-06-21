package org.example.repository.trust;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.Trust;

public class TrustRepositoryImpl extends BaseRepositoryImpl<Trust> implements TrustRepository {
    @Override
    public Class getClassName() {
        return Trust.class;
    }
}
