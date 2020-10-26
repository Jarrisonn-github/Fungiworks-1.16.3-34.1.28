package net.minecraft.entity;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.EntityPredicates;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public interface IAngerable {
   int func_230256_F__();

   void func_230260_a__(int p_230260_1_);

   @Nullable
   UUID func_230257_G__();

   void func_230259_a_(@Nullable UUID p_230259_1_);

   void func_230258_H__();

   default void func_233682_c_(CompoundNBT p_233682_1_) {
      p_233682_1_.putInt("AngerTime", this.func_230256_F__());
      if (this.func_230257_G__() != null) {
         p_233682_1_.putUniqueId("AngryAt", this.func_230257_G__());
      }

   }

   default void func_241358_a_(ServerWorld p_241358_1_, CompoundNBT p_241358_2_) {
      this.func_230260_a__(p_241358_2_.getInt("AngerTime"));
      if (!p_241358_2_.hasUniqueId("AngryAt")) {
         this.func_230259_a_((UUID)null);
      } else {
         UUID uuid = p_241358_2_.getUniqueId("AngryAt");
         this.func_230259_a_(uuid);
         Entity entity = p_241358_1_.getEntityByUuid(uuid);
         if (entity != null) {
            if (entity instanceof MobEntity) {
               this.setReve