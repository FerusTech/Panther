/*
 * This file is part of Panther, licensed under the MIT License (MIT).
 *
 * Copyright (c) FerusTech LLC <https://ferus.tech>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package tech.ferus.panther.core.wallet;

import tech.ferus.panther.api.wallet.WalletOwner;

import javax.annotation.Nonnull;
import java.util.UUID;

public class GenericWalletOwner<T> implements WalletOwner<T> {

    @Nonnull private final UUID uuid;
    @Nonnull private final String name;
    @Nonnull private final T player;

    public GenericWalletOwner(@Nonnull final UUID uuid,
                              @Nonnull final String name,
                              @Nonnull final T player) {
        this.uuid = uuid;
        this.name = name;
        this.player = player;
    }

    @Nonnull
    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    @Nonnull
    @Override
    public String getName() {
        return this.name;
    }

    @Nonnull
    @Override
    public T getPlayer() {
        return this.player;
    }
}
