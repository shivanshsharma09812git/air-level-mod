package com.aircul.mixin;

import com.aircul.client.CullingHelper;
import net.minecraft.client.render.chunk.ChunkBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChunkBuilder.class)
public class MixinChunkBuilder {

    @Inject(method = "build", at = @At("RETURN"), cancellable = false)
    private void onBuildReturn(CallbackInfoReturnable cir) {
        // Placeholder: adapt to your mappings to remove quads for enclosed blocks during mesh emission.
    }
}
