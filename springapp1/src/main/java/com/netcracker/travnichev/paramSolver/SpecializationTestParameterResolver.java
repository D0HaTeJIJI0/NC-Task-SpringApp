package com.netcracker.travnichev.paramSolver;

import com.netcracker.travnichev.dao.impl.DefaultSpecializationDao;
import com.netcracker.travnichev.entity.Specialization;
import com.netcracker.travnichev.service.impl.DefaultSpecializationService;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class SpecializationTestParameterResolver implements ParameterResolver {

    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == Specialization.class
                || parameterContext.getParameter().getType() == DefaultSpecializationService.class;
    }

    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        if (parameterContext.getParameter().getType() == Specialization.class) {
            Specialization spec = new Specialization();
            spec.setName("math");
            return spec;
        }
        if (parameterContext.getParameter().getType() == DefaultSpecializationService.class) {
            return new DefaultSpecializationService(new DefaultSpecializationDao());
        }
        else return null;
    }
}
