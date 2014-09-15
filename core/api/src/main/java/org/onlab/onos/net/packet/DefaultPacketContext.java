package org.onlab.onos.net.packet;

import org.onlab.onos.net.flow.DefaultTrafficTreatment;
import org.onlab.onos.net.flow.TrafficTreatment;
import org.onlab.onos.net.flow.TrafficTreatment.Builder;


public abstract class DefaultPacketContext implements PacketContext {

    private final long time;
    private final InboundPacket inPkt;
    private final OutboundPacket outPkt;
    private final TrafficTreatment.Builder builder;

    private boolean block = false;


    protected DefaultPacketContext(long time, InboundPacket inPkt,
            OutboundPacket outPkt, boolean block) {
        super();
        this.time = time;
        this.inPkt = inPkt;
        this.outPkt = outPkt;
        this.block = block;
        this.builder = new DefaultTrafficTreatment.Builder();
    }

    @Override
    public long time() {
        return time;
    }

    @Override
    public InboundPacket inPacket() {
        return inPkt;
    }

    @Override
    public OutboundPacket outPacket() {
        return outPkt;
    }

    @Override
    public Builder treatmentBuilder() {
        return builder;
    }

    @Override
    public abstract void send();

    @Override
    public void block() {
        this.block = true;
    }

    @Override
    public boolean isHandled() {
        return this.block;
    }

}