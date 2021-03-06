/*
 * Copyright (c) 2020 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.apimgt.impl;

import org.osgi.service.component.annotations.Component;
import org.wso2.carbon.apimgt.api.model.ConfigurationDto;
import org.wso2.carbon.apimgt.api.model.KeyManagerConnectorConfiguration;
import org.wso2.carbon.apimgt.impl.jwt.JWTValidatorImpl;
import java.util.Collections;
import java.util.List;

@Component(
        name = "default.km.configuration.component",
        immediate = true,
        service = KeyManagerConnectorConfiguration.class,
        property = {"type=" + APIConstants.KeyManager.DEFAULT_KEY_MANAGER_TYPE}
)
/**
 *  This is to register default keymanager as connector
 */
public class DefaultKeyManagerConnectorConfiguration implements KeyManagerConnectorConfiguration {

    @Override
    public String getImplementation() {

        return AMDefaultKeyManagerImpl.class.getName();
    }

    @Override
    public String getJWTValidator() {

        return JWTValidatorImpl.class.getName();
    }

    @Override
    public List<ConfigurationDto> getConnectionConfigurations() {

        return Collections.emptyList();
    }

    @Override
    public List<ConfigurationDto> getApplicationConfigurations() {

        return Collections.emptyList();
    }
}
