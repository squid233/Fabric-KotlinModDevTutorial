package io.github.username.modid

import io.github.username.modid.item.*
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.block.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.potion.PotionUtil
import net.minecraft.potion.Potions
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

class ExampleMod {
    companion object {
        const val MODID = "modid"

        val ITEM_GROUP: ItemGroup = FabricItemGroupBuilder.build(
            Identifier(MODID, "general")
            ) { ItemStack(Blocks.COBBLESTONE) }

        val OTHER_GROUP: ItemGroup = FabricItemGroupBuilder.create(
            Identifier(MODID, "other"))
            .icon { ItemStack(Items.BOWL) }
            .appendItems {
                    s: MutableList<ItemStack>? ->
                s?.add(ItemStack(Blocks.BONE_BLOCK))
                s?.add(ItemStack(Items.APPLE))
                s?.add(PotionUtil.setPotion(ItemStack(Items.POTION), Potions.WATER))
                s?.add(ItemStack.EMPTY)
                s?.add(ItemStack(Items.IRON_SHOVEL))
            }
            .build()

        val FABRIC_ITEM = FabricItem(Item.Settings().group(ITEM_GROUP).maxCount(16))
    }
}

@Suppress("unused")
fun init() {
    Registry.register(Registry.ITEM, Identifier(ExampleMod.MODID, "fabric_item"), ExampleMod.FABRIC_ITEM)
}
