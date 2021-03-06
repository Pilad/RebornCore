/*
 * Copyright (c) 2017 modmuss50 and Gigabit101
 *
 *
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 *
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 *
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package reborncore.common.network.packet;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.commons.lang3.tuple.Pair;
import reborncore.RebornCore;
import reborncore.common.network.INetworkPacket;
import reborncore.common.network.RegisterPacketEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by modmuss50 on 20/09/2016.
 */
public class RebornPackets {

	public static List<Pair<Side, Class<? extends INetworkPacket>>> packetList = new ArrayList<>();

	@SubscribeEvent
	public void loadPackets(RegisterPacketEvent event) {
		packetList.forEach(pair -> event.registerPacket(pair.getRight(), pair.getLeft()));
		event.registerPacket(CustomDescriptionPacket.class, Side.CLIENT);
		RebornCore.logHelper.info("Registered " + packetList.size() + " packet(s)");
	}

}
