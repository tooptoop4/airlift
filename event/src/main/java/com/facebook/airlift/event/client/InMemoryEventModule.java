/*
 * Copyright 2010 Proofpoint, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.airlift.event.client;

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Scopes;

import static com.google.inject.multibindings.Multibinder.newSetBinder;

public class InMemoryEventModule
        implements Module
{
    @Override
    public void configure(Binder binder)
    {
        // for backwards compatibility
        binder.install(new EventModule());

        binder.bind(InMemoryEventClient.class).in(Scopes.SINGLETON);
        newSetBinder(binder, EventClient.class).addBinding().to(Key.get(InMemoryEventClient.class)).in(Scopes.SINGLETON);
    }
}