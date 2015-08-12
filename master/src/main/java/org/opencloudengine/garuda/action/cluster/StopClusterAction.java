package org.opencloudengine.garuda.action.cluster;

import org.opencloudengine.garuda.action.RunnableAction;
import org.opencloudengine.garuda.cloud.ClusterService;
import org.opencloudengine.garuda.cloud.ClustersService;

/**
 * 클러스터를 정지한다.
 * Created by swsong on 2015. 8. 6..
 */
public class StopClusterAction extends RunnableAction<StopClusterActionRequest> {

    public StopClusterAction(StopClusterActionRequest actionRequest) {
        super(actionRequest);
        status.registerStep("stop cluster instances.");
    }

    @Override
    protected void doAction() throws Exception {
        String clusterId = getActionRequest().getClusterId();
        ClusterService clusterService = serviceManager.getService(ClustersService.class).getClusterService(clusterId);
        status.walkStep();
        clusterService.stop();
    }
}
