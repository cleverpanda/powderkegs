package cleverpanda.powderkegs;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

//Version 0.0.10

public class PacketHandler implements IPacketHandler {

        @Override
        public void onPacketData(INetworkManager manager,
                        Packet250CustomPayload packet, Player playerEntity) {
                // TODO Auto-generated method stub
        }

}
