/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ambari.server.checks;

import org.apache.ambari.server.AmbariException;
import org.apache.ambari.server.controller.PrereqCheckRequest;
import org.apache.ambari.server.state.*;
import org.apache.ambari.server.state.stack.PrereqCheckType;
import org.apache.ambari.server.state.stack.PrerequisiteCheck;
import org.apache.ambari.server.state.stack.PrereqCheckStatus;

import java.util.Map;

/**
 * Checks that there are no services in decommission state.
 */
public class ServicesDecommissionCheck extends AbstractCheckDescriptor {

  /**
   * Constructor.
   */
  public ServicesDecommissionCheck() {
    super("SERVICES_DECOMMISSION", PrereqCheckType.SERVICE, "Services should not be in Decommission state");
  }

  @Override
  public void perform(PrerequisiteCheck prerequisiteCheck, PrereqCheckRequest request) throws AmbariException {
    final String clusterName = request.getClusterName();
    final Cluster cluster = clustersProvider.get().getCluster(clusterName);
    for (Map.Entry<String, Service> serviceEntry: cluster.getServices().entrySet()) {
      final Service service = serviceEntry.getValue();
      for (Map.Entry<String, ServiceComponent> serviceComponentEntry: service.getServiceComponents().entrySet()) {
        final ServiceComponent serviceComponent = serviceComponentEntry.getValue();
        for (String hostName : serviceComponent.getServiceComponentHosts().keySet()) {
          final ServiceComponentHost scHost = serviceComponent.getServiceComponentHost(hostName);
          if (scHost.getComponentAdminState() == HostComponentAdminState.DECOMMISSIONED || scHost.getComponentAdminState() == HostComponentAdminState.DECOMMISSIONING) {
            prerequisiteCheck.getFailedOn().add(serviceComponent.getName());
          }
        }
      }
    }
    if (!prerequisiteCheck.getFailedOn().isEmpty()) {
      prerequisiteCheck.setStatus(PrereqCheckStatus.FAIL);
      prerequisiteCheck.setFailReason(formatEntityList(prerequisiteCheck.getFailedOn()) + " must not be in decommissioned or decommissioning state");
    }
  }
}
