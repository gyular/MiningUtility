package me.luligabi.miningutility.mixin;

import me.luligabi.miningutility.hook.PlayerEntityHook;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "tick", at = @At("RETURN"), cancellable = true)
    public void injectTick(CallbackInfo info) {
        PlayerEntity playerEntity = ((PlayerEntity) (Object) this);
        PlayerEntityHook.tick(playerEntity, info);
    }
}
