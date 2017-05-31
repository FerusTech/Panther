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

package tech.ferus.panther.core.transaction;

import tech.ferus.panther.api.transaction.Transaction;

import javax.annotation.Nonnull;
import java.util.UUID;

public class GenericTransaction implements Transaction {

    @Nonnull private final UUID transactionUuid;
    @Nonnull private final GenericTransactionData sellerData;
    @Nonnull private final GenericTransactionData buyerData;

    public GenericTransaction(@Nonnull final UUID transactionUuid,
                              @Nonnull final GenericTransactionData sellerData,
                              @Nonnull final GenericTransactionData buyerData) {
        this.transactionUuid = transactionUuid;
        this.sellerData = sellerData;
        this.buyerData = buyerData;
    }

    @Nonnull
    @Override
    public UUID getTransactionUuid() {
        return this.transactionUuid;
    }

    @Nonnull
    @Override
    public GenericTransactionData getSellerData() {
        return this.sellerData;
    }

    @Nonnull
    @Override
    public GenericTransactionData getBuyerData() {
        return this.buyerData;
    }
}
