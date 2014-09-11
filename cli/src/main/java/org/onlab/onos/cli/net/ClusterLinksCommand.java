package org.onlab.onos.cli.net;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.onlab.onos.net.Link;
import org.onlab.onos.net.topology.TopologyCluster;

import static org.onlab.onos.cli.net.LinksListCommand.linkString;
import static org.onlab.onos.net.topology.ClusterId.clusterId;

/**
 * Lists links of the specified topology cluster in the current topology.
 */
@Command(scope = "onos", name = "cluster-links",
         description = "Lists links of the specified topology cluster in the current topology")
public class ClusterLinksCommand extends ClustersListCommand {

    @Argument(index = 0, name = "id", description = "Cluster ID",
              required = false, multiValued = false)
    String id = null;

    @Override
    protected Object doExecute() throws Exception {
        int cid = Integer.parseInt(id);
        init();
        TopologyCluster cluster = service.getCluster(topology, clusterId(cid));
        for (Link link : service.getClusterLinks(topology, cluster)) {
            print(linkString(link));
        }
        return null;
    }


}