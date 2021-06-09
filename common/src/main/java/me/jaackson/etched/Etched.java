package me.jaackson.etched;

import me.jaackson.etched.bridge.NetworkBridge;
import me.jaackson.etched.bridge.RegistryBridge;
import me.jaackson.etched.common.network.ClientboundPlayMusicPacket;
import me.jaackson.etched.common.network.handler.EtchedClientPlayHandler;
import net.minecraft.world.item.DyeableLeatherItem;

/**
 * @author Jackson
 */
public class Etched {
    public static final String MOD_ID = "etched";

    public static void commonInit() {
        EtchedRegistry.register();
        NetworkBridge.playToClient(ClientboundPlayMusicPacket.CHANNEL, ClientboundPlayMusicPacket.class, ClientboundPlayMusicPacket::new, EtchedClientPlayHandler::handlePlayMusicPacket);
    }

    public static void clientInit() {
        RegistryBridge.registerItemColor((stack, index) -> index > 0 ? -1 : ((DyeableLeatherItem) stack.getItem()).getColor(stack), EtchedRegistry.BLANK_MUSIC_DISC, EtchedRegistry.MUSIC_LABEL);
    }

    public static void commonPostInit() {
    }

    public static void clientPostInit() {
    }

}
