package io.yukkuriproject.github.kendomod.item;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class SinaiItem extends Item {
    ArrayList<QueueRow> tickQueue = new ArrayList<>();

    public SinaiItem() {
        super(new Settings().maxCount(1).maxDamage(Integer.MAX_VALUE));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient()) {
            tickQueue.add(new QueueRow((ServerPlayerEntity) player, 20));
        }

        return TypedActionResult.pass(player.getStackInHand(hand));
    }

    public void tick(ServerWorld world) {
        for (QueueRow row : tickQueue) {
            row.tick -= 1;
            if (row.tick <= 0) {
                //new CommandDispatcher<CommandContext<ServerCommandSource>>().execute("/kill @e");
            }
        }
    }

    class QueueRow {
        public ServerPlayerEntity player;
        public Integer tick;
        public Integer attacks = 0;

        public QueueRow(ServerPlayerEntity player, Integer tick) {
            this.player = player;
            this.tick = tick;
        }
    }
}
