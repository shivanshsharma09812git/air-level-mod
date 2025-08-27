package com.aircul.client;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class CullingHelper {
    public static final int RADIUS = 5;

    public static boolean shouldRender(BlockView world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (!state.getFluidState().isEmpty()) {
            return true;
        }

        int r = RADIUS;
        int r2 = r * r;

        for (int dx = -r; dx <= r; dx++) {
            for (int dy = -r; dy <= r; dy++) {
                for (int dz = -r; dz <= r; dz++) {
                    int sq = dx*dx + dy*dy + dz*dz;
                    if (sq > r2) continue;
                    if (dx == 0 && dy == 0 && dz == 0) continue;
                    BlockPos p = pos.add(dx, dy, dz);
                    try {
                        if (world.getBlockState(p).isAir()) {
                            return true;
                        }
                    } catch (RuntimeException ex) {
                        // skip out-of-range positions
                    }
                }
            }
        }

        return false;
    }
}
