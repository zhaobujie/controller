/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.config.yang.md.sal.dom.impl;

import static com.google.common.base.Preconditions.checkArgument;

import org.opendaylight.controller.config.api.DependencyResolver;
import org.osgi.framework.BundleContext;

/**
 * Deprecated.
 *
 * @deprecated Replaced by blueprint wiring
 */
@Deprecated
public class SchemaServiceImplSingletonModuleFactory extends
        org.opendaylight.controller.config.yang.md.sal.dom.impl.AbstractSchemaServiceImplSingletonModuleFactory {

    public static final String SINGLETON_NAME = "yang-schema-service";

    @Override
    public SchemaServiceImplSingletonModule instantiateModule(String instanceName,
            DependencyResolver dependencyResolver, SchemaServiceImplSingletonModule oldModule,
            AutoCloseable oldInstance, BundleContext bundleContext) {
        checkArgument(SINGLETON_NAME.equals(instanceName),
                "Illegal instance name '" + instanceName + "', only allowed name is " + SINGLETON_NAME);
        SchemaServiceImplSingletonModule module = super.instantiateModule(instanceName, dependencyResolver, oldModule,
                oldInstance, bundleContext);
        // FIXME bundle context should not be passed around
        module.setBundleContext(bundleContext);
        return module;
    }

    @Override
    public SchemaServiceImplSingletonModule instantiateModule(String instanceName,
            DependencyResolver dependencyResolver, BundleContext bundleContext) {
        checkArgument(SINGLETON_NAME.equals(instanceName),
                "Illegal instance name '" + instanceName + "', only allowed name is " + SINGLETON_NAME);
        SchemaServiceImplSingletonModule module = super.instantiateModule(instanceName, dependencyResolver,
                bundleContext);
        // FIXME bundle context should not be passed around
        module.setBundleContext(bundleContext);
        return module;
    }
}
