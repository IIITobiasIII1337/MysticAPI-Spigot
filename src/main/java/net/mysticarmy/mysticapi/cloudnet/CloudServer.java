/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.cloudnet;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;
import de.dytanic.cloudnet.driver.service.ServiceTask;

/**
 * Code by         / MysticArmy.net Owner
 * IIITobiasIII    / IIITobiasIII@mysticarmy.net
 * Created at 31.10.2020
 */
public class CloudServer {

    public void createService(String task){
        if (CloudNetDriver.getInstance().getServiceTaskProvider().isServiceTaskPresent(task)){
            ServiceTask serviceTask = CloudNetDriver.getInstance().getServiceTaskProvider().getServiceTask(task);
            ServiceInfoSnapshot serviceInfoSnapshot = CloudNetDriver.getInstance().getCloudServiceFactory().createCloudService(serviceTask);
            CloudNetDriver.getInstance().getCloudServiceProvider(serviceInfoSnapshot).start();
        }
    }

    public void startService(String service){
        ServiceInfoSnapshot serviceInfoSnapshot = getServiceInfoSnapshot(service);
        CloudNetDriver.getInstance().getCloudServiceProvider(serviceInfoSnapshot).start();
    }

    public void stopService(String service){
        ServiceInfoSnapshot serviceInfoSnapshot = getServiceInfoSnapshot(service);
        CloudNetDriver.getInstance().getCloudServiceProvider(serviceInfoSnapshot).stop();
    }

    public void restartService(String service){
        ServiceInfoSnapshot serviceInfoSnapshot = getServiceInfoSnapshot(service);
        CloudNetDriver.getInstance().getCloudServiceProvider(serviceInfoSnapshot).restart();
    }

    public void stopGroup(String group){
        CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServices(group).forEach(serviceInfoSnapshot -> {
            CloudNetDriver.getInstance().getCloudServiceProvider(serviceInfoSnapshot).stop();
        });
    }

    public void runCommand(String service, String command){
        if (isConnectedService(service)){
            ServiceInfoSnapshot serviceInfoSnapshot = getServiceInfoSnapshot(service);
            CloudNetDriver.getInstance().getCloudServiceProvider(serviceInfoSnapshot).runCommand(command);
        }
    }

    public ServiceInfoSnapshot getServiceInfoSnapshot(String service){
        return CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServiceByName(service);
    }

    public boolean isConnectedService(String service){
        return getServiceInfoSnapshot(service) != null || getServiceInfoSnapshot(service).isConnected();
    }
}
