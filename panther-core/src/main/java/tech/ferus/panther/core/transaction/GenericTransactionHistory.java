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

import tech.ferus.panther.api.transaction.TransactionHistory;
import tech.ferus.panther.core.wallet.GenericWallet;

import com.google.common.collect.Sets;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class GenericTransactionHistory<T extends GenericTransaction> implements TransactionHistory<T> {

    @Nonnull private final GenericWallet wallet;
    @Nonnull private final Set<T> transactions;

    public GenericTransactionHistory(@Nonnull final GenericWallet wallet) {
        this.wallet = wallet;
        this.transactions = Sets.newHashSet();
    }

    public GenericTransactionHistory(@Nonnull final GenericWallet wallet,
                                     @Nonnull final Collection<T> transactions) {
        this.wallet = wallet;
        this.transactions = Sets.newHashSet(transactions);
    }

    @Nonnull
    @Override
    public GenericWallet getWallet() {
        return this.wallet;
    }

    @Nonnull
    @Override
    public Set<T> getTransactions() {
        return this.transactions;
    }

    @Nonnull
    @Override
    public Set<T> getTransactions(@Nonnull final UUID filter) {
        if (filter.equals(this.wallet.getOwner().getUuid())) {
            return this.transactions;
        }

        return this.transactions.stream()
                .filter(transaction -> filter.equals(transaction.getBuyerData().getPlayer().getUuid())
                        || filter.equals(transaction.getSellerData().getPlayer().getUuid()))
                .collect(Collectors.toSet());
    }

    @Nullable
    @Override
    public T getTransaction(final UUID transactionUuid) {
        return this.transactions.stream()
                .filter(transaction -> transaction.getTransactionUuid().equals(transactionUuid))
                .findFirst().orElse(null);
    }

    @Override
    public void addTransaction(@Nonnull final T transaction) {
        this.transactions.add(transaction);
    }

    @Nonnull
    @Override
    public Iterator<T> iterator() {
        return this.transactions.iterator();
    }

    @Override
    public void forEach(@Nonnull final Consumer<? super T> action) {
        this.transactions.iterator().forEachRemaining(action);
    }

    @Nonnull
    @Override
    public Spliterator<T> spliterator() {
        return this.transactions.spliterator();
    }
}
