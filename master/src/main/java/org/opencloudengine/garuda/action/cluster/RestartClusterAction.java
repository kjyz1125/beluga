package org.opencloudengine.garuda.action.cluster;

import org.opencloudengine.garuda.action.RunnableAction;
import org.opencloudengine.garuda.cloud.ClusterService;
import org.opencloudengine.garuda.cloud.ClustersService;

/**
 * 클러스터를 재시작한다.
 * Created by swsong on 2015. 8. 6..
 */
public class RestartClusterAction extends RunnableAction<RestartClusterActionRequest> {

    public RestartClusterAction(RestartClusterActionRequest actionRequest) {
        super(actionRequest);
        status.registerStep("restart cluster instances.");
    }

    @Override
    protected void doAction() throws Exception {
        String clusterId = getActionRequest().getClusterId();
        ClusterService clusterService = serviceManager.getService(ClustersService.class).getClusterService(clusterId);
        status.walkStep();
        clusterService.restart();
    }
}
