package org.apache.ambari.server.fsm;

import org.apache.ambari.server.ServiceComponentNodeState;
import org.apache.ambari.server.fsm.StateMachineFactory;

public class ServiceComponentNodeFSMImpl implements ServiceComponentNodeFSM {

  private static final StateMachineFactory
  <ServiceComponentNodeFSMImpl, ServiceComponentNodeState,
  ServiceComponentNodeEventType, ServiceComponentNodeEvent>
    daemonStateMachineFactory
      = new StateMachineFactory<ServiceComponentNodeFSMImpl,
          ServiceComponentNodeState, ServiceComponentNodeEventType,
          ServiceComponentNodeEvent>
          (ServiceComponentNodeState.INIT)

  // define the state machine of a NodeServiceComponent

     .addTransition(ServiceComponentNodeState.INIT,
         ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_INSTALL)

     .addTransition(ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeState.INSTALLED,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_SUCCEEDED)
     .addTransition(ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_IN_PROGRESS)
     .addTransition(ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeState.INSTALL_FAILED,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_FAILED)

     .addTransition(ServiceComponentNodeState.INSTALL_FAILED,
         ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_RESTART)

     .addTransition(ServiceComponentNodeState.INSTALLED,
         ServiceComponentNodeState.STARTING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_START)
     .addTransition(ServiceComponentNodeState.INSTALLED,
         ServiceComponentNodeState.UNINSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_UNINSTALL)
     .addTransition(ServiceComponentNodeState.INSTALLED,
         ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_INSTALL)

     .addTransition(ServiceComponentNodeState.STARTING,
         ServiceComponentNodeState.STARTING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_IN_PROGRESS)
     .addTransition(ServiceComponentNodeState.STARTING,
         ServiceComponentNodeState.STARTED,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_SUCCEEDED)
     .addTransition(ServiceComponentNodeState.STARTING,
         ServiceComponentNodeState.START_FAILED,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_FAILED)

     .addTransition(ServiceComponentNodeState.START_FAILED,
         ServiceComponentNodeState.STARTING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_RESTART)

     .addTransition(ServiceComponentNodeState.STARTED,
         ServiceComponentNodeState.STOPPING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_STOP)

     .addTransition(ServiceComponentNodeState.STOPPING,
         ServiceComponentNodeState.STOPPING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_IN_PROGRESS)
     .addTransition(ServiceComponentNodeState.STOPPING,
         ServiceComponentNodeState.INSTALLED,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_SUCCEEDED)
     .addTransition(ServiceComponentNodeState.STOPPING,
         ServiceComponentNodeState.STOP_FAILED,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_FAILED)

     .addTransition(ServiceComponentNodeState.STOP_FAILED,
         ServiceComponentNodeState.STOPPING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_RESTART)

     .addTransition(ServiceComponentNodeState.UNINSTALLING,
         ServiceComponentNodeState.UNINSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_IN_PROGRESS)
     .addTransition(ServiceComponentNodeState.UNINSTALLING,
         ServiceComponentNodeState.UNINSTALLED,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_SUCCEEDED)
     .addTransition(ServiceComponentNodeState.UNINSTALLING,
         ServiceComponentNodeState.UNINSTALL_FAILED,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_FAILED)

     .addTransition(ServiceComponentNodeState.UNINSTALL_FAILED,
         ServiceComponentNodeState.UNINSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_RESTART)

     .addTransition(ServiceComponentNodeState.UNINSTALLED,
         ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_INSTALL)

     .addTransition(ServiceComponentNodeState.UNINSTALLED,
         ServiceComponentNodeState.INIT,
         ServiceComponentNodeEventType.NODE_SVCCOMP_WIPEOUT)

     .installTopology();

  private static final StateMachineFactory
  <ServiceComponentNodeFSMImpl, ServiceComponentNodeState,
  ServiceComponentNodeEventType, ServiceComponentNodeEvent>
    clientStateMachineFactory
      = new StateMachineFactory<ServiceComponentNodeFSMImpl,
          ServiceComponentNodeState, ServiceComponentNodeEventType,
          ServiceComponentNodeEvent>
          (ServiceComponentNodeState.INIT)

  // define the state machine of a NodeServiceComponent

     .addTransition(ServiceComponentNodeState.INIT,
         ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_INSTALL)

     .addTransition(ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeState.INSTALLED,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_SUCCEEDED)
     .addTransition(ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_IN_PROGRESS)
     .addTransition(ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeState.INSTALL_FAILED,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_FAILED)

     .addTransition(ServiceComponentNodeState.INSTALL_FAILED,
         ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_RESTART)

     .addTransition(ServiceComponentNodeState.INSTALLED,
         ServiceComponentNodeState.UNINSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_UNINSTALL)
     .addTransition(ServiceComponentNodeState.INSTALLED,
         ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_INSTALL)

     .addTransition(ServiceComponentNodeState.UNINSTALLING,
         ServiceComponentNodeState.UNINSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_IN_PROGRESS)
     .addTransition(ServiceComponentNodeState.UNINSTALLING,
         ServiceComponentNodeState.UNINSTALLED,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_SUCCEEDED)
     .addTransition(ServiceComponentNodeState.UNINSTALLING,
         ServiceComponentNodeState.UNINSTALL_FAILED,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_FAILED)

     .addTransition(ServiceComponentNodeState.UNINSTALL_FAILED,
         ServiceComponentNodeState.UNINSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_OP_RESTART)

     .addTransition(ServiceComponentNodeState.UNINSTALLED,
         ServiceComponentNodeState.INSTALLING,
         ServiceComponentNodeEventType.NODE_SVCCOMP_INSTALL)

     .addTransition(ServiceComponentNodeState.UNINSTALLED,
         ServiceComponentNodeState.INIT,
         ServiceComponentNodeEventType.NODE_SVCCOMP_WIPEOUT)

     .installTopology();


  private final StateMachine<ServiceComponentNodeState,
      ServiceComponentNodeEventType, ServiceComponentNodeEvent> stateMachine;

  public ServiceComponentNodeFSMImpl(boolean isClient) {
    super();
    if (isClient) {
      this.stateMachine = clientStateMachineFactory.make(this);
    } else {
      this.stateMachine = daemonStateMachineFactory.make(this);
    }
  }

  @Override
  public ServiceComponentNodeState getState() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setState(ServiceComponentNodeState state) {
    // TODO Auto-generated method stub
  }

  @Override
  public void handleEvent(ServiceComponentNodeEvent event)
      throws InvalidStateTransitonException {
    // TODO
    stateMachine.doTransition(event.getType(), event);
  }

}
