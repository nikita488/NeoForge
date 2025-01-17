/*
 * Copyright (c) NeoForged and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.neoforged.neoforge.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

/**
 * Special {@link DeferredHolder} for {@link Item Items} that implements {@link ItemLike}.
 * 
 * @param <T> The specific {@link Item} type.
 */
public class DeferredItem<T extends Item> extends DeferredHolder<Item, T> implements ItemLike {
    /**
     * Creates a new {@link DeferredHolder} targeting the {@link Item} with the specified name.
     *
     * @param <T> The type of the target {@link Item}.
     * @param key The name of the target {@link Item}.
     */
    public static <T extends Item> DeferredItem<T> createItem(ResourceLocation key) {
        return createItem(ResourceKey.create(Registries.ITEM, key));
    }

    /**
     * Creates a new {@link DeferredHolder} targeting the specified {@link Item}.
     *
     * @param <T> The type of the target {@link Item}.
     * @param key The resource key of the target {@link Item}.
     */
    public static <T extends Item> DeferredItem<T> createItem(ResourceKey<Item> key) {
        return new DeferredItem<>(key);
    }

    protected DeferredItem(ResourceKey<Item> key) {
        super(key);
    }

    @Override
    public Item asItem() {
        return get();
    }
}
