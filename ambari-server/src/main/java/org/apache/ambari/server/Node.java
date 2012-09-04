package org.apache.ambari.server;

import java.util.List;
import java.util.Map;

/**
 * Interface for Node of a Cluster. Encapsulates all the required information
 * about a given node.
 */
public interface Node {

  /**
   * @return the hostName
   */
  public String getHostName();

  /**
   * @param hostName the hostName to set
   */
  public void setHostName(String hostName);

  /**
   * IPv4 assigned to the Node
   * @return the ip or null if no IPv4 interface
   */
  public String getIPv4();

  /**
   * @param ip the ip to set
   */
  public void setIPv4(String ip);

  /**
   * IPv6 assigned to the Node
   * @return the ip or null if no IPv6 interface
   */
  public String getIPv6();

  /**
   * @param ip the ip to set
   */
  public void setIPv6(String ip);

  /**
   * @return the cpuCount
   */
  public int getCpuCount();

  /**
   * @param cpuCount the cpuCount to set
   */
  public void setCpuCount(int cpuCount);

  /**
   * Get the Amount of physical memory for the Node.
   * @return the totalMemBytes
   */
  public int getTotalMemBytes();

  /**
   * Set the Amount of physical memory for the Node.
   * @param totalMemBytes the totalMemBytes to set
   */
  public void setTotalMemBytes(int totalMemBytes);

  /**
   * Get the Amount of available memory for the Node.
   * In most cases, available should be same as total unless
   * the agent on the node is configured to not use all
   * available memory
   * @return the availableMemBytes
   */
  public int getAvailableMemBytes();

  /**
   * Set the Amount of available memory for the Node.
   * @param availableMemBytes the availableMemBytes to set
   */
  public void setAvailableMemBytes(int availableMemBytes);

  /**
   * Get the OS Architecture.
   * i386, x86_64, etc.
   * @return the osArch
   */
  public String getOsArch();

  /**
   * @param osArch the osArch to set
   */
  public void setOsArch(String osArch);

  /**
   * Get the General OS information.
   * uname -a, /etc/*-release dump
   * @return the osInfo
   */
  public String getOsInfo();

  /**
   * @param osInfo the osInfo to set
   */
  public void setOsInfo(String osInfo);

  /**
   * Get the OS Type: RHEL5/RHEL6/CentOS5/...
   * Defined and match-able OS type
   * @return the osType
   */
  public String getOsType();

  /**
   * @param osType the osType to set
   */
  public void setOsType(String osType);

  /**
   * Get information on disks available on the node.
   * @return the disksInfo
   */
  public List<DiskInfo> getDisksInfo();

  /**
   * @param disksInfo the disksInfo to set
   */
  public void setDisksInfo(List<DiskInfo> disksInfo);

  /**
   * @return the healthStatus
   */
  public NodeHealthStatus getHealthStatus();

  /**
   * @param healthStatus the healthStatus to set
   */
  public void setHealthStatus(NodeHealthStatus healthStatus);

  /**
   * Get additional host attributes
   * For example, public/hostname/IP for AWS
   * @return the hostAttributes
   */
  public Map<String, String> getHostAttributes();

  /**
   * @param hostAttributes the hostAttributes to set
   */
  public void setHostAttributes(Map<String, String> hostAttributes);
  /**
   * @return the rackInfo
   */
  public String getRackInfo();

  /**
   * @param rackInfo the rackInfo to set
   */
  public void setRackInfo(String rackInfo);

  /**
   * Last time the node registered with the Ambari Server
   * ( Unix timestamp )
   * @return the lastRegistrationTime
   */
  public int getLastRegistrationTime();

  /**
   * @param lastRegistrationTime the lastRegistrationTime to set
   */
  public void setLastRegistrationTime(int lastRegistrationTime);

  /**
   * Last time the Ambari Server received a heartbeat from the Node
   * ( Unix timestamp )
   * @return the lastHeartbeatTime
   */
  public int getLastHeartbeatTime();

  /**
   * @param lastHeartbeatTime the lastHeartbeatTime to set
   */
  public void setLastHeartbeatTime(int lastHeartbeatTime);

  /**
   * Version of the Ambari Agent running on the node
   * @return the agentVersion
   */
  public AgentVersion getAgentVersion();

  /**
   * @param agentVersion the agentVersion to set
   */
  public void setAgentVersion(AgentVersion agentVersion);

  /**
   * Get the current state of the Node
   * @return NodeState
   */
  public NodeState getNodeState();

  /**
   * Get the list of Actions that are currently being tracked at the
   * Node level
   * @return List of Actions
   */
  public List<Job> getActions();

}
