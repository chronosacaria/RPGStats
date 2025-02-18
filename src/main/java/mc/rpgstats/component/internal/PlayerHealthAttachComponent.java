package mc.rpgstats.component.internal;

import dev.onyxstudios.cca.api.v3.component.Component;
import mc.rpgstats.main.RPGStats;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerHealthAttachComponent implements Component {
    public PlayerEntity playerEntity;
    
    public PlayerHealthAttachComponent(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }
    
    @Override
    public void readFromNbt(NbtCompound compoundTag) {
        if (playerEntity instanceof ServerPlayerEntity) {
            RPGStats.needsStatFix.add((ServerPlayerEntity)playerEntity);
        }
    }
    
    @Override
    public void writeToNbt(NbtCompound compoundTag) {}
}